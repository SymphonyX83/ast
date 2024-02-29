(ns sk.handlers.admin.tdd.view
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

(defn tdd-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/tdd"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo LP"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start tdd-form
(defn build-tdd-fields
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
                 :error "La descripción de Tipo de Dispositivo"
                 :placeholder "Descripción de Tipo de Dispositivo..."
                 :value (:descripcion row)})))

(defn build-tdd-form
  [title row]
  (let [fields (build-tdd-fields row)
        href "/admin/tdd/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End tdd-form

(defn build-tdd-modal
  [title row]
  (build-modal title row (build-tdd-form title row)))

(defn tdd-edit-view
  [title row rows]
  (list
   (tdd-view "Mantenimiento de Tipo de Dispositivo" rows)
   (build-tdd-modal title row)))

(defn tdd-add-view
  [title row rows]
  (list
   (tdd-view "Mantenimiento de Tipo de Dispositivo" rows)
   (build-tdd-modal title row)))

(defn tdd-modal-script
  []
  (modal-script))
