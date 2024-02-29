(ns sk.handlers.admin.ic_modelo.view
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

(defn ic_modelo-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/ic_modelo"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo Modelo"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start ic_modelo-form
(defn build-ic_modelo-fields
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
                 :error "La descripción de Modelo(Instrumento de Control)"
                 :placeholder "Descripción de Modelo(Instrumento de Control)..."
                 :value (:descripcion row)})))

(defn build-ic_modelo-form
  [title row]
  (let [fields (build-ic_modelo-fields row)
        href "/admin/ic_modelo/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End ic_modelo-form

(defn build-ic_modelo-modal
  [title row]
  (build-modal title row (build-ic_modelo-form title row)))

(defn ic_modelo-edit-view
  [title row rows]
  (list
   (ic_modelo-view "Mantenimiento de Modelo(Instrumento de Control)" rows)
   (build-ic_modelo-modal title row)))

(defn ic_modelo-add-view
  [title row rows]
  (list
   (ic_modelo-view "Mantenimiento de Modelo(Instrumento de Control)" rows)
   (build-ic_modelo-modal title row)))

(defn ic_modelo-modal-script
  []
  (modal-script))
