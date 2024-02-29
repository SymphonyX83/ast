(ns sk.handlers.admin.equipos.controller
  (:require [sk.layout :refer [application
                               error-404]]
            [sk.models.util :refer [get-session-id]]
            [sk.models.crud :refer [build-form-save
                                    build-form-delete]]
            [sk.handlers.admin.equipos.model :refer [get-equipos
                                                     get-equipo-id
                                                     get-equipos-search]]
            [sk.handlers.admin.equipos.view :refer [equipos-view
                                                    equipos-edit-view
                                                    equipos-add-view
                                                    equipos-modal-script]]))

(defn equipos
  [_]
  (let [title "Mantenimiento de Equipos"
        ok (get-session-id)
        js nil
        rows (get-equipos)
        content (equipos-view title rows)]
    (application title ok js content)))

(defn equipos-edit
  [id]
  (let [title "Modificar Equipo"
        ok (get-session-id)
        js (equipos-modal-script)
        row (get-equipo-id id)
        rows (get-equipos)
        content (equipos-edit-view title row rows)]
    (application title ok js content)))

(defn equipos-save
  [{params :params}]
  (let [table "equipos"
        result (build-form-save params table)]
    (if (= result true)
      (error-404  "Record se processo correctamente!" "/admin/equipos")
      (error-404 "No se pudo procesar el record!" "/admin/equipos"))))

(defn equipos-add
  [_]
  (let [title "Nuevo Equipo"
        ok (get-session-id)
        js (equipos-modal-script)
        row nil
        rows (get-equipos)
        content (equipos-add-view title row rows)]
    (application title ok js content)))

(defn equipos-delete
  [id]
  (let [table "equipos"
        result (build-form-delete table id)]
    (if (= result true)
      (error-404 "Record se processo correctamente!" "/admin/equipos")
      (error-404 "No se pudo processar el record!" "/admin/equipos"))))

(defn equipos-search
  [{params :params}]
  (let [title "Mantenimiento de Equipos"
        ok (get-session-id)
        js nil
        search-string (:search params)
        rows (get-equipos-search search-string)
        content (equipos-view title rows)]
    (application title ok js content)))
