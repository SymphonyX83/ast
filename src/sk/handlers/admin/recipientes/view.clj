(ns sk.handlers.admin.recipientes.view
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

(defn recipientes-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/recipientes"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo Recipiente"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start recipientes-form
(defn build-recipientes-fields
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
                 :error "La descripción del recipiente es requerida"
                 :placeholder "Descripción del recipiente aqui..."
                 :value (:descripcion row)})))

(defn build-recipientes-form
  [title row]
  (let [fields (build-recipientes-fields row)
        href "/admin/recipientes/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End recipientes-form

(defn build-recipientes-modal
  [title row]
  (build-modal title row (build-recipientes-form title row)))

(defn recipientes-edit-view
  [title row rows]
  (list
   (recipientes-view "Mantenimiento de recipientes" rows)
   (build-recipientes-modal title row)))

(defn recipientes-add-view
  [title row rows]
  (list
   (recipientes-view "Mantenimiento de recipientes" rows)
   (build-recipientes-modal title row)))

(defn recipientes-modal-script
  []
  (modal-script))
