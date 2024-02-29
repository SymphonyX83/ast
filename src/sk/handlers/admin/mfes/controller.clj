(ns sk.handlers.admin.mfes.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.mfes.model :refer [get-mfes
                                                  get-mfes-id
                                                  get-mfes-search]]
            [sk.handlers.admin.mfes.view :refer [mfes-view
                                                 mfes-edit-view
                                                 mfes-add-view
                                                 mfes-modal-script]]))

(defn mfes
  [_]
  (let [title "Tipos de Material de Fabricacion de Espejos"
        ok (get-session-id)
        js nil
        rows (get-mfes)
        content (mfes-view title rows)]
    (application title ok js content)))

(defn mfes-edit
  [id]
  (let [title "Modificar Material de Fabricacion de Espejos"
        ok (get-session-id)
        js (mfes-modal-script)
        row (get-mfes-id id)
        rows (get-mfes)
        content (mfes-edit-view title row rows)]
    (application title ok js content)))

(defn mfes-save
  [{params :params}]
  (let [table "mfes"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/mfes")
      (error-404 "No se pudo procesar el record!" "/admin/mfes"))))

(defn mfes-add
  [_]
  (let [title "Nuevo Material de Fabricacion de Espejos"
        ok (get-session-id)
        js (mfes-modal-script)
        row nil
        rows (get-mfes)
        content (mfes-add-view title row rows)]
    (application title ok js content)))

(defn mfes-delete
  [id]
  (let [table "mfes"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/mfes")
      (error-404 "No se pudo processar el record!" "/admin/mfes"))))

(defn mfes-search
  [{params :params}]
  (let [title "Mantenimiento de Material de Fabricacion de Espejos"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-mfes-search search-string)
        content (mfes-view title rows)]
    (application title ok js content)))
