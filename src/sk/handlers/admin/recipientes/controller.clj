(ns sk.handlers.admin.recipientes.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.recipientes.model :refer [get-recipientes
                                                         get-recipiente-id
                                                         get-recipientes-search]]
            [sk.handlers.admin.recipientes.view :refer [recipientes-view
                                                        recipientes-edit-view
                                                        recipientes-add-view
                                                        recipientes-modal-script]]))

(defn recipientes
  [_]
  (let [title "Tipos de recipientes"
        ok (get-session-id)
        js nil
        rows (get-recipientes)
        content (recipientes-view title rows)]
    (application title ok js content)))

(defn recipientes-edit
  [id]
  (let [title "Modificar Recipiente"
        ok (get-session-id)
        js (recipientes-modal-script)
        row (get-recipiente-id id)
        rows (get-recipientes)
        content (recipientes-edit-view title row rows)]
    (application title ok js content)))

(defn recipientes-save
  [{params :params}]
  (let [table "recipientes"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/recipientes")
      (error-404 "No se pudo procesar el record!" "/admin/recipientes"))))

(defn recipientes-add
  [_]
  (let [title "Nuevo tipo de recipiente"
        ok (get-session-id)
        js (recipientes-modal-script)
        row nil
        rows (get-recipientes)
        content (recipientes-add-view title row rows)]
    (application title ok js content)))

(defn recipientes-delete
  [id]
  (let [table "recipientes"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/recipientes")
      (error-404 "No se pudo processar el record!" "/admin/recipientes"))))

(defn recipientes-search
  [{params :params}]
  (let [title "Mantenimiento de recipientes"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-recipientes-search search-string)
        content (recipientes-view title rows)]
    (application title ok js content)))
