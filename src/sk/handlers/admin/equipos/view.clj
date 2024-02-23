(ns sk.handlers.admin.equipos.view
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

(defn equipos-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/equipos"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo Equipo"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start equipos-form
(defn build-equipos-fields
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
                 :error "La descripción del equipo es requerida"
                 :placeholder "Descripción del equipo aqui..."
                 :value (:descripcion row)})))

(defn build-equipos-form
  [title row]
  (let [fields (build-equipos-fields row)
        href "/admin/equipos/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End equipos-form

(defn build-equipos-modal
  [title row]
  (build-modal title row (build-equipos-form title row)))

(defn equipos-edit-view
  [title row rows]
  (list
   (equipos-view "Mantenimiento de equipos" rows)
   (build-equipos-modal title row)))

(defn equipos-add-view
  [title row rows]
  (list
   (equipos-view "Mantenimiento de equipos" rows)
   (build-equipos-modal title row)))

(defn equipos-modal-script
  []
  (modal-script))
