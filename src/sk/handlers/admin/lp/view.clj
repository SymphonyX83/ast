(ns sk.handlers.admin.lp.view
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

(defn lp-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/lp"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo Lugar de Prueba"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start lp-form
(defn build-lp-fields
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
                 :error "La descripción del Lugar de Prueba es requerida"
                 :placeholder "Descripción del lugar de prueba aqui..."
                 :value (:descripcion row)})))

(defn build-lp-form
  [title row]
  (let [fields (build-lp-fields row)
        href "/admin/lp/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End lp-form

(defn build-lp-modal
  [title row]
  (build-modal title row (build-lp-form title row)))

(defn lp-edit-view
  [title row rows]
  (list
   (lp-view "Mantenimiento de Lugares de Prueba" rows)
   (build-lp-modal title row)))

(defn lp-add-view
  [title row rows]
  (list
   (lp-view "Mantenimiento de Lugares de Prueba" rows)
   (build-lp-modal title row)))

(defn lp-modal-script
  []
  (modal-script))
