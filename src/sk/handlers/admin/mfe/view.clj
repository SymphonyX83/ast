(ns sk.handlers.admin.mfe.view
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

(defn mfe-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/mfe"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start mfe-form
(defn build-mfe-fields
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
                 :error "La descripción del 'Material de Fabricacion del Envolvente' es requerida"
                 :placeholder "Descripción del mfe aqui..."
                 :value (:descripcion row)})))

(defn build-mfe-form
  [title row]
  (let [fields (build-mfe-fields row)
        href "/admin/mfe/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End mfe-form

(defn build-mfe-modal
  [title row]
  (build-modal title row (build-mfe-form title row)))

(defn mfe-edit-view
  [title row rows]
  (list
   (mfe-view "Mantenimiento de Material de Fabricacion de Envolventes" rows)
   (build-mfe-modal title row)))

(defn mfe-add-view
  [title row rows]
  (list
   (mfe-view "Mantenimiento de Material de Fabricacion de Envolventes" rows)
   (build-mfe-modal title row)))

(defn mfe-modal-script
  []
  (modal-script))
