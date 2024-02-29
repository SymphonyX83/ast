(ns sk.handlers.admin.ft_clasificacion.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.ft_clasificacion.model :refer [get-ft_clasificacion
                                                              get-ft_clasificacion-id
                                                              get-ft_clasificacion-search]]
            [sk.handlers.admin.ft_clasificacion.view :refer [ft_clasificacion-view
                                                             ft_clasificacion-edit-view
                                                             ft_clasificacion-add-view
                                                             ft_clasificacion-modal-script]]))

(defn ft_clasificacion
  [_]
  (let [title "Clasificacion (Ficha Técnica)"
        ok (get-session-id)
        js nil
        rows (get-ft_clasificacion)
        content (ft_clasificacion-view title rows)]
    (application title ok js content)))

(defn ft_clasificacion-edit
  [id]
  (let [title "Modificar Clasificacion"
        ok (get-session-id)
        js (ft_clasificacion-modal-script)
        row (get-ft_clasificacion-id id)
        rows (get-ft_clasificacion)
        content (ft_clasificacion-edit-view title row rows)]
    (application title ok js content)))

(defn ft_clasificacion-save
  [{params :params}]
  (let [table "ft_clasificacion"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/ft_clasificacion")
      (error-404 "No se pudo procesar el record!" "/admin/ft_clasificacion"))))

(defn ft_clasificacion-add
  [_]
  (let [title "Nueva Clasificacion"
        ok (get-session-id)
        js (ft_clasificacion-modal-script)
        row nil
        rows (get-ft_clasificacion)
        content (ft_clasificacion-add-view title row rows)]
    (application title ok js content)))

(defn ft_clasificacion-delete
  [id]
  (let [table "ft_clasificacion"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/ft_clasificacion")
      (error-404 "No se pudo processar el record!" "/admin/ft_clasificacion"))))

(defn ft_clasificacion-search
  [{params :params}]
  (let [title "Mantenimiento de Clasificacion (Ficha Técnica)"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-ft_clasificacion-search search-string)
        content (ft_clasificacion-view title rows)]
    (application title ok js content)))
