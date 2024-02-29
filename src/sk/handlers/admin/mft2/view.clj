(ns sk.handlers.admin.mft2.view
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

(defn mft2-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/mft2"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo MFE"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start mft2-form
(defn build-mft2-fields
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
                 :error "La descripción del 'Material de Fabricacion de Tapa (Tubos o Fluxes)' es requerida"
                 :placeholder "Descripción del mft2 aqui..."
                 :value (:descripcion row)})))

(defn build-mft2-form
  [title row]
  (let [fields (build-mft2-fields row)
        href "/admin/mft2/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End mft2-form

(defn build-mft2-modal
  [title row]
  (build-modal title row (build-mft2-form title row)))

(defn mft2-edit-view
  [title row rows]
  (list
   (mft2-view "Mantenimiento de Material de Fabricacion de Tapas (Tubos o Fluxes)" rows)
   (build-mft2-modal title row)))

(defn mft2-add-view
  [title row rows]
  (list
   (mft2-view "Mantenimiento de Material de Fabricacion de Tapas (Tubos o Fluxes)" rows)
   (build-mft2-modal title row)))

(defn mft2-modal-script
  []
  (modal-script))
