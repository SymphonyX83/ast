(ns sk.handlers.admin.dictamen_rp.view
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

(defn dictamen_rp-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/dictamen_rp"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo Resultado de las Pruebas"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start dictamen_rp-form
(defn build-dictamen_rp-fields
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
                 :error "La descripción de Resultado de las Pruebas"
                 :placeholder "Descripción de Resultado de las Pruebas..."
                 :value (:descripcion row)})))

(defn build-dictamen_rp-form
  [title row]
  (let [fields (build-dictamen_rp-fields row)
        href "/admin/dictamen_rp/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End dictamen_rp-form

(defn build-dictamen_rp-modal
  [title row]
  (build-modal title row (build-dictamen_rp-form title row)))

(defn dictamen_rp-edit-view
  [title row rows]
  (list
   (dictamen_rp-view "Mantenimiento de Resultado de las Pruebas" rows)
   (build-dictamen_rp-modal title row)))

(defn dictamen_rp-add-view
  [title row rows]
  (list
   (dictamen_rp-view "Mantenimiento de Resultado de las Pruebas" rows)
   (build-dictamen_rp-modal title row)))

(defn dictamen_rp-modal-script
  []
  (modal-script))
