(ns sk.handlers.admin.ic_modelo.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.ic_modelo.model :refer [get-ic_modelo
                                                       get-ic_modelo-id
                                                       get-ic_modelo-search]]
            [sk.handlers.admin.ic_modelo.view :refer [ic_modelo-view
                                                      ic_modelo-edit-view
                                                      ic_modelo-add-view
                                                      ic_modelo-modal-script]]))

(defn ic_modelo
  [_]
  (let [title "Modelo(Instrumento de Control)"
        ok (get-session-id)
        js nil
        rows (get-ic_modelo)
        content (ic_modelo-view title rows)]
    (application title ok js content)))

(defn ic_modelo-edit
  [id]
  (let [title "Modificar Modelo(Instrumento de Control)"
        ok (get-session-id)
        js (ic_modelo-modal-script)
        row (get-ic_modelo-id id)
        rows (get-ic_modelo)
        content (ic_modelo-edit-view title row rows)]
    (application title ok js content)))

(defn ic_modelo-save
  [{params :params}]
  (let [table "ic_modelo"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/ic_modelo")
      (error-404 "No se pudo procesar el record!" "/admin/ic_modelo"))))

(defn ic_modelo-add
  [_]
  (let [title "Nuevo Modelo(Instrumento de Control)"
        ok (get-session-id)
        js (ic_modelo-modal-script)
        row nil
        rows (get-ic_modelo)
        content (ic_modelo-add-view title row rows)]
    (application title ok js content)))

(defn ic_modelo-delete
  [id]
  (let [table "ic_modelo"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/ic_modelo")
      (error-404 "No se pudo processar el record!" "/admin/ic_modelo"))))

(defn ic_modelo-search
  [{params :params}]
  (let [title "Mantenimiento de Modelo(Instrumento de Control)"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-ic_modelo-search search-string)
        content (ic_modelo-view title rows)]
    (application title ok js content)))
