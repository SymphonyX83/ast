(ns sk.handlers.admin.mfe.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.mfe.model :refer [get-mfe
                                                 get-mfe-id
                                                 get-mfe-search]]
            [sk.handlers.admin.mfe.view :refer [mfe-view
                                                mfe-edit-view
                                                mfe-add-view
                                                mfe-modal-script]]))

(defn mfe
  [_]
  (let [title "Tipos de Material de Fabricacion de Envolventes"
        ok (get-session-id)
        js nil
        rows (get-mfe)
        content (mfe-view title rows)]
    (application title ok js content)))

(defn mfe-edit
  [id]
  (let [title "Modificar Material de Fabricacion de Envolventes"
        ok (get-session-id)
        js (mfe-modal-script)
        row (get-mfe-id id)
        rows (get-mfe)
        content (mfe-edit-view title row rows)]
    (application title ok js content)))

(defn mfe-save
  [{params :params}]
  (let [table "mfe"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/mfe")
      (error-404 "No se pudo procesar el record!" "/admin/mfe"))))

(defn mfe-add
  [_]
  (let [title "Nuevo Material de Fabricacion de Envolventes"
        ok (get-session-id)
        js (mfe-modal-script)
        row nil
        rows (get-mfe)
        content (mfe-add-view title row rows)]
    (application title ok js content)))

(defn mfe-delete
  [id]
  (let [table "mfe"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/mfe")
      (error-404 "No se pudo processar el record!" "/admin/mfe"))))

(defn mfe-search
  [{params :params}]
  (let [title "Mantenimiento de Material de Fabricacion de Envolventes"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-mfe-search search-string)
        content (mfe-view title rows)]
    (application title ok js content)))
