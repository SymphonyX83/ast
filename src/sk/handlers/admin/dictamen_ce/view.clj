(ns sk.handlers.admin.dictamen_ce.view
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

(defn dictamen_ce-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/dictamen_ce"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nueva Condicion de Equipo"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start dictamen_ce-form
(defn build-dictamen_ce-fields
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
                 :error "La descripción de Hermeticidad"
                 :placeholder "Descripción de Hermeticidad..."
                 :value (:descripcion row)})))

(defn build-dictamen_ce-form
  [title row]
  (let [fields (build-dictamen_ce-fields row)
        href "/admin/dictamen_ce/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End dictamen_ce-form

(defn build-dictamen_ce-modal
  [title row]
  (build-modal title row (build-dictamen_ce-form title row)))

(defn dictamen_ce-edit-view
  [title row rows]
  (list
   (dictamen_ce-view "Mantenimiento de Hermeticidad" rows)
   (build-dictamen_ce-modal title row)))

(defn dictamen_ce-add-view
  [title row rows]
  (list
   (dictamen_ce-view "Mantenimiento de Hermeticidad" rows)
   (build-dictamen_ce-modal title row)))

(defn dictamen_ce-modal-script
  []
  (modal-script))
