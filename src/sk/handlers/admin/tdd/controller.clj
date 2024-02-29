(ns sk.handlers.admin.tdd.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.tdd.model :refer [get-tdd
                                                 get-tdd-id
                                                 get-tdd-search]]
            [sk.handlers.admin.tdd.view :refer [tdd-view
                                                tdd-edit-view
                                                tdd-add-view
                                                tdd-modal-script]]))

(defn tdd
  [_]
  (let [title "Tipo de Dispositivo"
        ok (get-session-id)
        js nil
        rows (get-tdd)
        content (tdd-view title rows)]
    (application title ok js content)))

(defn tdd-edit
  [id]
  (let [title "Modificar Tipo de Dispositivo"
        ok (get-session-id)
        js (tdd-modal-script)
        row (get-tdd-id id)
        rows (get-tdd)
        content (tdd-edit-view title row rows)]
    (application title ok js content)))

(defn tdd-save
  [{params :params}]
  (let [table "tdd"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/tdd")
      (error-404 "No se pudo procesar el record!" "/admin/tdd"))))

(defn tdd-add
  [_]
  (let [title "Nuevo Tipo de Dispositivo"
        ok (get-session-id)
        js (tdd-modal-script)
        row nil
        rows (get-tdd)
        content (tdd-add-view title row rows)]
    (application title ok js content)))

(defn tdd-delete
  [id]
  (let [table "tdd"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/tdd")
      (error-404 "No se pudo processar el record!" "/admin/tdd"))))

(defn tdd-search
  [{params :params}]
  (let [title "Mantenimiento de Tipo de Dispositivo"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-tdd-search search-string)
        content (tdd-view title rows)]
    (application title ok js content)))
