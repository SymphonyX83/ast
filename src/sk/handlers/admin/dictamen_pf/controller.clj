(ns sk.handlers.admin.dictamen_pf.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.dictamen_pf.model :refer [get-dictamen_pf
                                                         get-dictamen_pf-id
                                                         get-dictamen_pf-search]]
            [sk.handlers.admin.dictamen_pf.view :refer [dictamen_pf-view
                                                        dictamen_pf-edit-view
                                                        dictamen_pf-add-view
                                                        dictamen_pf-modal-script]]))

(defn dictamen_pf
  [_]
  (let [title "Prueba de Funcionamiento"
        ok (get-session-id)
        js nil
        rows (get-dictamen_pf)
        content (dictamen_pf-view title rows)]
    (application title ok js content)))

(defn dictamen_pf-edit
  [id]
  (let [title "Modificar Prueba de Funcionamiento"
        ok (get-session-id)
        js (dictamen_pf-modal-script)
        row (get-dictamen_pf-id id)
        rows (get-dictamen_pf)
        content (dictamen_pf-edit-view title row rows)]
    (application title ok js content)))

(defn dictamen_pf-save
  [{params :params}]
  (let [table "dictamen_pf"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/dictamen_pf")
      (error-404 "No se pudo procesar el record!" "/admin/dictamen_pf"))))

(defn dictamen_pf-add
  [_]
  (let [title "Nuevo Prueba de Funcionamiento"
        ok (get-session-id)
        js (dictamen_pf-modal-script)
        row nil
        rows (get-dictamen_pf)
        content (dictamen_pf-add-view title row rows)]
    (application title ok js content)))

(defn dictamen_pf-delete
  [id]
  (let [table "dictamen_pf"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/dictamen_pf")
      (error-404 "No se pudo processar el record!" "/admin/dictamen_pf"))))

(defn dictamen_pf-search
  [{params :params}]
  (let [title "Mantenimiento de Prueba de Funcionamiento"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-dictamen_pf-search search-string)
        content (dictamen_pf-view title rows)]
    (application title ok js content)))
