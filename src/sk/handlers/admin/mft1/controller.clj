(ns sk.handlers.admin.mft1.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.mft1.model :refer [get-mft1
                                                  get-mft1-id
                                                  get-mft1-search]]
            [sk.handlers.admin.mft1.view :refer [mft1-view
                                                 mft1-edit-view
                                                 mft1-add-view
                                                 mft1-modal-script]]))

(defn mft1
  [_]
  (let [title "Tipos de Material de Fabricacion de Tapas (Hogar)"
        ok (get-session-id)
        js nil
        rows (get-mft1)
        content (mft1-view title rows)]
    (application title ok js content)))

(defn mft1-edit
  [id]
  (let [title "Modificar Material de Fabricacion de Tapas (Hogar)"
        ok (get-session-id)
        js (mft1-modal-script)
        row (get-mft1-id id)
        rows (get-mft1)
        content (mft1-edit-view title row rows)]
    (application title ok js content)))

(defn mft1-save
  [{params :params}]
  (let [table "mft1"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/mft1")
      (error-404 "No se pudo procesar el record!" "/admin/mft1"))))

(defn mft1-add
  [_]
  (let [title "Nuevo Material de Fabricacion de Tapas (Hogar)"
        ok (get-session-id)
        js (mft1-modal-script)
        row nil
        rows (get-mft1)
        content (mft1-add-view title row rows)]
    (application title ok js content)))

(defn mft1-delete
  [id]
  (let [table "mft1"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/mft1")
      (error-404 "No se pudo processar el record!" "/admin/mft1"))))

(defn mft1-search
  [{params :params}]
  (let [title "Mantenimiento de Material de Fabricacion de Tapas (Hogar)"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-mft1-search search-string)
        content (mft1-view title rows)]
    (application title ok js content)))
