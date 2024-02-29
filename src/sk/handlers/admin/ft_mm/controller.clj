(ns sk.handlers.admin.ft_mm.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.ft_mm.model :refer [get-ft_mm
                                                   get-ft_mm-id
                                                   get-ft_mm-search]]
            [sk.handlers.admin.ft_mm.view :refer [ft_mm-view
                                                  ft_mm-edit-view
                                                  ft_mm-add-view
                                                  ft_mm-modal-script]]))

(defn ft_mm
  [_]
  (let [title "Métodos de Monitoreo (Ficha Técnica)"
        ok (get-session-id)
        js nil
        rows (get-ft_mm)
        content (ft_mm-view title rows)]
    (application title ok js content)))

(defn ft_mm-edit
  [id]
  (let [title "Modificar Clasificacion"
        ok (get-session-id)
        js (ft_mm-modal-script)
        row (get-ft_mm-id id)
        rows (get-ft_mm)
        content (ft_mm-edit-view title row rows)]
    (application title ok js content)))

(defn ft_mm-save
  [{params :params}]
  (let [table "ft_mm"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/ft_mm")
      (error-404 "No se pudo procesar el record!" "/admin/ft_mm"))))

(defn ft_mm-add
  [_]
  (let [title "Nueva Clasificacion"
        ok (get-session-id)
        js (ft_mm-modal-script)
        row nil
        rows (get-ft_mm)
        content (ft_mm-add-view title row rows)]
    (application title ok js content)))

(defn ft_mm-delete
  [id]
  (let [table "ft_mm"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/ft_mm")
      (error-404 "No se pudo processar el record!" "/admin/ft_mm"))))

(defn ft_mm-search
  [{params :params}]
  (let [title "Mantenimiento de Métodos de Monitoreo (Ficha Técnica)"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-ft_mm-search search-string)
        content (ft_mm-view title rows)]
    (application title ok js content)))
