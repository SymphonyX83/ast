(ns sk.handlers.admin.dictamen_pf.view
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

(defn dictamen_pf-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/dictamen_pf"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nueva Prueba de Funcionamiento"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start dictamen_pf-form
(defn build-dictamen_pf-fields
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
                 :error "La descripción de Pruebas de Funcionamiento"
                 :placeholder "Descripción de Pruebas de Funcionamiento..."
                 :value (:descripcion row)})))

(defn build-dictamen_pf-form
  [title row]
  (let [fields (build-dictamen_pf-fields row)
        href "/admin/dictamen_pf/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End dictamen_pf-form

(defn build-dictamen_pf-modal
  [title row]
  (build-modal title row (build-dictamen_pf-form title row)))

(defn dictamen_pf-edit-view
  [title row rows]
  (list
   (dictamen_pf-view "Mantenimiento de Pruebas de Funcionamiento" rows)
   (build-dictamen_pf-modal title row)))

(defn dictamen_pf-add-view
  [title row rows]
  (list
   (dictamen_pf-view "Mantenimiento de Pruebas de Funcionamiento" rows)
   (build-dictamen_pf-modal title row)))

(defn dictamen_pf-modal-script
  []
  (modal-script))
