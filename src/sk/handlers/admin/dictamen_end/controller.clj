(ns sk.handlers.admin.dictamen_end.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.dictamen_end.model :refer [get-dictamen_end
                                                          get-dictamen_end-id
                                                          get-dictamen_end-search]]
            [sk.handlers.admin.dictamen_end.view :refer [dictamen_end-view
                                                         dictamen_end-edit-view
                                                         dictamen_end-add-view
                                                         dictamen_end-modal-script]]))

(defn dictamen_end
  [_]
  (let [title "Examen no Destructivo"
        ok (get-session-id)
        js nil
        rows (get-dictamen_end)
        content (dictamen_end-view title rows)]
    (application title ok js content)))

(defn dictamen_end-edit
  [id]
  (let [title "Modificar Examen no Destructivo"
        ok (get-session-id)
        js (dictamen_end-modal-script)
        row (get-dictamen_end-id id)
        rows (get-dictamen_end)
        content (dictamen_end-edit-view title row rows)]
    (application title ok js content)))

(defn dictamen_end-save
  [{params :params}]
  (let [table "dictamen_end"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/dictamen_end")
      (error-404 "No se pudo procesar el record!" "/admin/dictamen_end"))))

(defn dictamen_end-add
  [_]
  (let [title "Nuevo Examen no Destructivo"
        ok (get-session-id)
        js (dictamen_end-modal-script)
        row nil
        rows (get-dictamen_end)
        content (dictamen_end-add-view title row rows)]
    (application title ok js content)))

(defn dictamen_end-delete
  [id]
  (let [table "dictamen_end"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/dictamen_end")
      (error-404 "No se pudo processar el record!" "/admin/dictamen_end"))))

(defn dictamen_end-search
  [{params :params}]
  (let [title "Mantenimiento de Examen no Destructivo"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-dictamen_end-search search-string)
        content (dictamen_end-view title rows)]
    (application title ok js content)))
