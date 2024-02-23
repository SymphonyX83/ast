(ns sk.routes.proutes
  (:require [compojure.core :refer [defroutes GET POST]]
            [sk.handlers.admin.users.controller :as users-controller]
            [sk.handlers.admin.equipos.controller :as equipos-controller]
            [sk.handlers.users.controller :as users-dashboard]))

(defroutes proutes
  (GET "/admin/users" params users-controller/users)
  (GET "/admin/users/edit/:id" [id] (users-controller/users-edit id))
  (POST "/admin/users/save" params [] (users-controller/users-save params))
  (GET "/admin/users/add" params [] (users-controller/users-add params))
  (GET "/admin/users/delete/:id" [id] (users-controller/users-delete id))
  (POST "/admin/users/search" params [] (users-controller/users-search params))

  (GET "/admin/equipos" params equipos-controller/equipos)
  (GET "/admin/equipos/edit/:id" [id] (equipos-controller/equipos-edit id))
  (POST "/admin/equipos/save" params [] (equipos-controller/equipos-save params))
  (GET "/admin/equipos/add" params [] (equipos-controller/equipos-add params))
  (GET "/admin/equipos/delete/:id" [id] (equipos-controller/equipos-delete id))
  (POST "/admin/equipos/search" params [] (equipos-controller/equipos-search params))

  (GET "/users" params [] (users-dashboard/users params))
  (POST "/users/search" params [] (users-dashboard/users-search params)))
