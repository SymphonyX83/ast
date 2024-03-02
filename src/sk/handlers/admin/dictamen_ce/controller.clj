(ns sk.handlers.admin.dictamen_ce.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.dictamen_ce.model :refer [get-dictamen_ce
                                                         get-dictamen_ce-id
                                                         get-dictamen_ce-search]]
            [sk.handlers.admin.dictamen_ce.view :refer [dictamen_ce-view
                                                        dictamen_ce-edit-view
                                                        dictamen_ce-add-view
                                                        dictamen_ce-modal-script]]))

(defn dictamen_ce
  [_]
  (let [title "Condiciones del Equipo"
        ok (get-session-id)
        js nil
        rows (get-dictamen_ce)
        content (dictamen_ce-view title rows)]
    (application title ok js content)))

(defn dictamen_ce-edit
  [id]
  (let [title "Modificar Condiciones del Equipo"
        ok (get-session-id)
        js (dictamen_ce-modal-script)
        row (get-dictamen_ce-id id)
        rows (get-dictamen_ce)
        content (dictamen_ce-edit-view title row rows)]
    (application title ok js content)))

(defn dictamen_ce-save
  [{params :params}]
  (let [table "dictamen_ce"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/dictamen_ce")
      (error-404 "No se pudo procesar el record!" "/admin/dictamen_ce"))))

(defn dictamen_ce-add
  [_]
  (let [title "Nueva Condiciones del Equipo"
        ok (get-session-id)
        js (dictamen_ce-modal-script)
        row nil
        rows (get-dictamen_ce)
        content (dictamen_ce-add-view title row rows)]
    (application title ok js content)))

(defn dictamen_ce-delete
  [id]
  (let [table "dictamen_ce"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/dictamen_ce")
      (error-404 "No se pudo processar el record!" "/admin/dictamen_ce"))))

(defn dictamen_ce-search
  [{params :params}]
  (let [title "Mantenimiento de Condiciones del Equipo"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-dictamen_ce-search search-string)
        content (dictamen_ce-view title rows)]
    (application title ok js content)))
