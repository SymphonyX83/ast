(ns sk.handlers.admin.mft2.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.mft2.model :refer [get-mft2
                                                  get-mft2-id
                                                  get-mft2-search]]
            [sk.handlers.admin.mft2.view :refer [mft2-view
                                                 mft2-edit-view
                                                 mft2-add-view
                                                 mft2-modal-script]]))

(defn mft2
  [_]
  (let [title "Tipos de Material de Fabricacion de Tapas (Tubos o Fluxes)"
        ok (get-session-id)
        js nil
        rows (get-mft2)
        content (mft2-view title rows)]
    (application title ok js content)))

(defn mft2-edit
  [id]
  (let [title "Modificar Material de Fabricacion de Tapas (Tubos o Fluxes)"
        ok (get-session-id)
        js (mft2-modal-script)
        row (get-mft2-id id)
        rows (get-mft2)
        content (mft2-edit-view title row rows)]
    (application title ok js content)))

(defn mft2-save
  [{params :params}]
  (let [table "mft2"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/mft2")
      (error-404 "No se pudo procesar el record!" "/admin/mft2"))))

(defn mft2-add
  [_]
  (let [title "Nuevo Material de Fabricacion de Tapas (Tubos o Fluxes)"
        ok (get-session-id)
        js (mft2-modal-script)
        row nil
        rows (get-mft2)
        content (mft2-add-view title row rows)]
    (application title ok js content)))

(defn mft2-delete
  [id]
  (let [table "mft2"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/mft2")
      (error-404 "No se pudo processar el record!" "/admin/mft2"))))

(defn mft2-search
  [{params :params}]
  (let [title "Mantenimiento de Material de Fabricacion de Tapas (Tubos o Fluxes)"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-mft2-search search-string)
        content (mft2-view title rows)]
    (application title ok js content)))
