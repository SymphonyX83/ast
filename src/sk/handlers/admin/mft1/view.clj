(ns sk.handlers.admin.mft1.view
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

(defn mft1-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/mft1"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo MFE"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start mft1-form
(defn build-mft1-fields
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
                 :error "La descripción del 'Material de Fabricacion de Tapa (Hogar)' es requerida"
                 :placeholder "Descripción del mft1 aqui..."
                 :value (:descripcion row)})))

(defn build-mft1-form
  [title row]
  (let [fields (build-mft1-fields row)
        href "/admin/mft1/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End mft1-form

(defn build-mft1-modal
  [title row]
  (build-modal title row (build-mft1-form title row)))

(defn mft1-edit-view
  [title row rows]
  (list
   (mft1-view "Mantenimiento de Material de Fabricacion de Tapa (Hogar)" rows)
   (build-mft1-modal title row)))

(defn mft1-add-view
  [title row rows]
  (list
   (mft1-view "Mantenimiento de Material de Fabricacion de Tapa (Hogar)" rows)
   (build-mft1-modal title row)))

(defn mft1-modal-script
  []
  (modal-script))
