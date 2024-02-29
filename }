(ns sk.handlers.admin.mfes.view
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

(defn mfes-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/mfes"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo MFE"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start mfes-form
(defn build-mfes-fields
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
                 :error "La descripción del 'Material de Fabricacion de Espejos' es requerida"
                 :placeholder "Descripción del mfes aqui..."
                 :value (:descripcion row)})))

(defn build-mfes-form
  [title row]
  (let [fields (build-mfes-fields row)
        href "/admin/mfes/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End mfes-form

(defn build-mfes-modal
  [title row]
  (build-modal title row (build-mfes-form title row)))

(defn mfes-edit-view
  [title row rows]
  (list
   (mfes-view "Mantenimiento de Material de Espejos" rows)
   (build-mfes-modal title row)))

(defn mfes-add-view
  [title row rows]
  (list
   (mfes-view "Mantenimiento de Material de Fabricacion de Espejos" rows)
   (build-mfes-modal title row)))

(defn mfes-modal-script
  []
  (modal-script))
