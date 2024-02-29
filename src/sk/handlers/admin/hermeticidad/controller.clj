(ns sk.handlers.admin.hermeticidad.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.hermeticidad.model :refer [get-hermeticidad
                                                          get-hermeticidad-id
                                                          get-hermeticidad-search]]
            [sk.handlers.admin.hermeticidad.view :refer [hermeticidad-view
                                                         hermeticidad-edit-view
                                                         hermeticidad-add-view
                                                         hermeticidad-modal-script]]))

(defn hermeticidad
  [_]
  (let [title "Hermeticidad"
        ok (get-session-id)
        js nil
        rows (get-hermeticidad)
        content (hermeticidad-view title rows)]
    (application title ok js content)))

(defn hermeticidad-edit
  [id]
  (let [title "Modificar Hermeticidad"
        ok (get-session-id)
        js (hermeticidad-modal-script)
        row (get-hermeticidad-id id)
        rows (get-hermeticidad)
        content (hermeticidad-edit-view title row rows)]
    (application title ok js content)))

(defn hermeticidad-save
  [{params :params}]
  (let [table "hermeticidad"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/hermeticidad")
      (error-404 "No se pudo procesar el record!" "/admin/hermeticidad"))))

(defn hermeticidad-add
  [_]
  (let [title "Nueva Hermeticidad"
        ok (get-session-id)
        js (hermeticidad-modal-script)
        row nil
        rows (get-hermeticidad)
        content (hermeticidad-add-view title row rows)]
    (application title ok js content)))

(defn hermeticidad-delete
  [id]
  (let [table "hermeticidad"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/hermeticidad")
      (error-404 "No se pudo processar el record!" "/admin/hermeticidad"))))

(defn hermeticidad-search
  [{params :params}]
  (let [title "Mantenimiento de Hermeticidad"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-hermeticidad-search search-string)
        content (hermeticidad-view title rows)]
    (application title ok js content)))
