(ns sk.handlers.admin.ft_clasificacion.view
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

(defn ft_clasificacion-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/ft_clasificacion"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nueva Clasificacion (Ficha Técnica)"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start ft_clasificacion-form
(defn build-ft_clasificacion-fields
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
                 :error "La descripción de Clasificacion (Ficha Técnica)"
                 :placeholder "Descripción de Clasificacion (Ficha Técnica)..."
                 :value (:descripcion row)})))

(defn build-ft_clasificacion-form
  [title row]
  (let [fields (build-ft_clasificacion-fields row)
        href "/admin/ft_clasificacion/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End ft_clasificacion-form

(defn build-ft_clasificacion-modal
  [title row]
  (build-modal title row (build-ft_clasificacion-form title row)))

(defn ft_clasificacion-edit-view
  [title row rows]
  (list
   (ft_clasificacion-view "Mantenimiento de Clasificacion (Ficha Técnica)" rows)
   (build-ft_clasificacion-modal title row)))

(defn ft_clasificacion-add-view
  [title row rows]
  (list
   (ft_clasificacion-view "Mantenimiento de Clasificacion (Ficha Técnica)" rows)
   (build-ft_clasificacion-modal title row)))

(defn ft_clasificacion-modal-script
  []
  (modal-script))
