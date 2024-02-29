(ns sk.handlers.admin.lp.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.lp.model :refer [get-lp
                                                get-lp-id
                                                get-lp-search]]
            [sk.handlers.admin.lp.view :refer [lp-view
                                               lp-edit-view
                                               lp-add-view
                                               lp-modal-script]]))

(defn lp
  [_]
  (let [title "Lugares de Prueba"
        ok (get-session-id)
        js nil
        rows (get-lp)
        content (lp-view title rows)]
    (application title ok js content)))

(defn lp-edit
  [id]
  (let [title "Modificar Lugar de Prueba"
        ok (get-session-id)
        js (lp-modal-script)
        row (get-lp-id id)
        rows (get-lp)
        content (lp-edit-view title row rows)]
    (application title ok js content)))

(defn lp-save
  [{params :params}]
  (let [table "lp"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/lp")
      (error-404 "No se pudo procesar el record!" "/admin/lp"))))

(defn lp-add
  [_]
  (let [title "Nuevo Lugar de Prueba"
        ok (get-session-id)
        js (lp-modal-script)
        row nil
        rows (get-lp)
        content (lp-add-view title row rows)]
    (application title ok js content)))

(defn lp-delete
  [id]
  (let [table "lp"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/lp")
      (error-404 "No se pudo processar el record!" "/admin/lp"))))

(defn lp-search
  [{params :params}]
  (let [title "Mantenimiento de Lugar de Prueba"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-lp-search search-string)
        content (lp-view title rows)]
    (application title ok js content)))
