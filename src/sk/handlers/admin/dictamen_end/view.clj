(ns sk.handlers.admin.dictamen_end.view
  (:require [ring.util.anti-forgery :refer [anti-forgery-field]]
            [sk.models.form :refer [form
                                    build-hidden-field
                                    build-field
                                    build-select
                                    build-radio
                                    build-modal-buttons]]
            [sk.models.grid :refer [build-grid
                                    build-modal
                                    modal-script]]))

(defn dictamen_end-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/dictamen_end"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo Examen no Destructivo"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start dictamen_end-form
(defn build-dictamen_end-fields
  [row]
  (list
   (build-hidden-field {:id "id"
                        :name "id"
                        :value (:id row)})
   (build-field {:label "Descripción:"
                 :type "text"
                 :id "descripcion"
                 :name "descripcion"
                 :required "true"
                 :error "La descripción de Examen no Destructivo"
                 :placeholder "Descripción de Examen no Destructivo..."
                 :value (:descripcion row)})))

(defn build-dictamen_end-form
  [title row]
  (let [fields (build-dictamen_end-fields row)
        href "/admin/dictamen_end/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End dictamen_end-form

(defn build-dictamen_end-modal
  [title row]
  (build-modal title row (build-dictamen_end-form title row)))

(defn dictamen_end-edit-view
  [title row rows]
  (list
   (dictamen_end-view "Mantenimiento de Examen no Destructivo" rows)
   (build-dictamen_end-modal title row)))

(defn dictamen_end-add-view
  [title row rows]
  (list
   (dictamen_end-view "Mantenimiento de Examen no Destructivo" rows)
   (build-dictamen_end-modal title row)))

(defn dictamen_end-modal-script
  []
  (modal-script))
