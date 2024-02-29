(ns sk.handlers.admin.hermeticidad.view
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

(defn hermeticidad-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/hermeticidad"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nueva Hermeticidad"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start hermeticidad-form
(defn build-hermeticidad-fields
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

(defn build-hermeticidad-form
  [title row]
  (let [fields (build-hermeticidad-fields row)
        href "/admin/hermeticidad/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End hermeticidad-form

(defn build-hermeticidad-modal
  [title row]
  (build-modal title row (build-hermeticidad-form title row)))

(defn hermeticidad-edit-view
  [title row rows]
  (list
   (hermeticidad-view "Mantenimiento de Hermeticidad" rows)
   (build-hermeticidad-modal title row)))

(defn hermeticidad-add-view
  [title row rows]
  (list
   (hermeticidad-view "Mantenimiento de Hermeticidad" rows)
   (build-hermeticidad-modal title row)))

(defn hermeticidad-modal-script
  []
  (modal-script))
