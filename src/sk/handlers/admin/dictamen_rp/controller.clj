(ns sk.handlers.admin.dictamen_rp.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.dictamen_rp.model :refer [get-dictamen_rp
                                                         get-dictamen_rp-id
                                                         get-dictamen_rp-search]]
            [sk.handlers.admin.dictamen_rp.view :refer [dictamen_rp-view
                                                        dictamen_rp-edit-view
                                                        dictamen_rp-add-view
                                                        dictamen_rp-modal-script]]))

(defn dictamen_rp
  [_]
  (let [title "Resultado de las Pruebas"
        ok (get-session-id)
        js nil
        rows (get-dictamen_rp)
        content (dictamen_rp-view title rows)]
    (application title ok js content)))

(defn dictamen_rp-edit
  [id]
  (let [title "Modificar Resultado de las Pruebas"
        ok (get-session-id)
        js (dictamen_rp-modal-script)
        row (get-dictamen_rp-id id)
        rows (get-dictamen_rp)
        content (dictamen_rp-edit-view title row rows)]
    (application title ok js content)))

(defn dictamen_rp-save
  [{params :params}]
  (let [table "dictamen_rp"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/dictamen_rp")
      (error-404 "No se pudo procesar el record!" "/admin/dictamen_rp"))))

(defn dictamen_rp-add
  [_]
  (let [title "Nuevo Resultado de las Pruebas"
        ok (get-session-id)
        js (dictamen_rp-modal-script)
        row nil
        rows (get-dictamen_rp)
        content (dictamen_rp-add-view title row rows)]
    (application title ok js content)))

(defn dictamen_rp-delete
  [id]
  (let [table "dictamen_rp"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/dictamen_rp")
      (error-404 "No se pudo processar el record!" "/admin/dictamen_rp"))))

(defn dictamen_rp-search
  [{params :params}]
  (let [title "Mantenimiento de Resultado de las Pruebas"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-dictamen_rp-search search-string)
        content (dictamen_rp-view title rows)]
    (application title ok js content)))
