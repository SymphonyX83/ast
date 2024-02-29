(ns sk.handlers.admin.ft_mm.view
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

(defn ft_mm-view
  [title rows]
  (let [fields ["DESCRIPCIÓN"]
        db-fields [:descripcion]
        href "/admin/ft_mm"
        search-placeholder "Buscar aqui..."
        search-button "Buscar"
        all-button "Todos"
        new-button "Nuevo Metodos de Monitoreo (Ficha Técnica)"
        edit-button "Editar"
        delete-button "Borrar"]
    (build-grid title rows fields db-fields href search-placeholder search-button all-button new-button edit-button delete-button)))

;; Start ft_mm-form
(defn build-ft_mm-fields
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
                 :error "La descripción de Metodos de Monitoreo (Ficha Técnica)"
                 :placeholder "Descripción de Metodos de Monitoreo (Ficha Técnica)..."
                 :value (:descripcion row)})))

(defn build-ft_mm-form
  [title row]
  (let [fields (build-ft_mm-fields row)
        href "/admin/ft_mm/save"
        buttons (build-modal-buttons)]
    (form href fields buttons)))
;; End ft_mm-form

(defn build-ft_mm-modal
  [title row]
  (build-modal title row (build-ft_mm-form title row)))

(defn ft_mm-edit-view
  [title row rows]
  (list
   (ft_mm-view "Mantenimiento de Metodos de Monitoreo (Ficha Técnica)" rows)
   (build-ft_mm-modal title row)))

(defn ft_mm-add-view
  [title row rows]
  (list
   (ft_mm-view "Mantenimiento de Metodos de Monitoreo (Ficha Técnica)" rows)
   (build-ft_mm-modal title row)))

(defn ft_mm-modal-script
  []
  (modal-script))
