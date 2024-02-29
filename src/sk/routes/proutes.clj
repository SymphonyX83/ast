(ns sk.routes.proutes
  (:require [compojure.core :refer [defroutes GET POST]]
            [sk.handlers.admin.users.controller :as users-controller]
            [sk.handlers.admin.equipos.controller :as equipos-controller]
            [sk.handlers.admin.recipientes.controller :as recipientes-controller]
            [sk.handlers.admin.mfe.controller :as mfe-controller]
            [sk.handlers.admin.mft1.controller :as mft1-controller]
            [sk.handlers.admin.mft2.controller :as mft2-controller]
            [sk.handlers.admin.mfes.controller :as mfes-controller]
            [sk.handlers.admin.lp.controller :as lp-controller]
            [sk.handlers.admin.tdd.controller :as tdd-controller]
            [sk.handlers.admin.hermeticidad.controller :as hermeticidad-controller]
            [sk.handlers.admin.ft_clasificacion.controller :as ft_clasificacion-controller]
            [sk.handlers.admin.ft_mm.controller :as ft_mm-controller]
            [sk.handlers.admin.ic_modelo.controller :as ic_modelo-controller]
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

  (GET "/admin/recipientes" params recipientes-controller/recipientes)
  (GET "/admin/recipientes/edit/:id" [id] (recipientes-controller/recipientes-edit id))
  (POST "/admin/recipientes/save" params [] (recipientes-controller/recipientes-save params))
  (GET "/admin/recipientes/add" params [] (recipientes-controller/recipientes-add params))
  (GET "/admin/recipientes/delete/:id" [id] (recipientes-controller/recipientes-delete id))
  (POST "/admin/recipientes/search" params [] (recipientes-controller/recipientes-search params))

  (GET "/admin/mfe" params mfe-controller/mfe)
  (GET "/admin/mfe/edit/:id" [id] (mfe-controller/mfe-edit id))
  (POST "/admin/mfe/save" params [] (mfe-controller/mfe-save params))
  (GET "/admin/mfe/add" params [] (mfe-controller/mfe-add params))
  (GET "/admin/mfe/delete/:id" [id] (mfe-controller/mfe-delete id))
  (POST "/admin/mfe/search" params [] (mfe-controller/mfe-search params))

  (GET "/admin/mft1" params mft1-controller/mft1)
  (GET "/admin/mft1/edit/:id" [id] (mft1-controller/mft1-edit id))
  (POST "/admin/mft1/save" params [] (mft1-controller/mft1-save params))
  (GET "/admin/mft1/add" params [] (mft1-controller/mft1-add params))
  (GET "/admin/mft1/delete/:id" [id] (mft1-controller/mft1-delete id))
  (POST "/admin/mft1/search" params [] (mft1-controller/mft1-search params))

  (GET "/admin/mft2" params mft2-controller/mft2)
  (GET "/admin/mft2/edit/:id" [id] (mft2-controller/mft2-edit id))
  (POST "/admin/mft2/save" params [] (mft2-controller/mft2-save params))
  (GET "/admin/mft2/add" params [] (mft2-controller/mft2-add params))
  (GET "/admin/mft2/delete/:id" [id] (mft2-controller/mft2-delete id))
  (POST "/admin/mft2/search" params [] (mft2-controller/mft2-search params))

  (GET "/admin/mfes" params mfes-controller/mfes)
  (GET "/admin/mfes/edit/:id" [id] (mfes-controller/mfes-edit id))
  (POST "/admin/mfes/save" params [] (mfes-controller/mfes-save params))
  (GET "/admin/mfes/add" params [] (mfes-controller/mfes-add params))
  (GET "/admin/mfes/delete/:id" [id] (mfes-controller/mfes-delete id))
  (POST "/admin/mfes/search" params [] (mfes-controller/mfes-search params))

  (GET "/admin/lp" params lp-controller/lp)
  (GET "/admin/lp/edit/:id" [id] (lp-controller/lp-edit id))
  (POST "/admin/lp/save" params [] (lp-controller/lp-save params))
  (GET "/admin/lp/add" params [] (lp-controller/lp-add params))
  (GET "/admin/lp/delete/:id" [id] (lp-controller/lp-delete id))
  (POST "/admin/lp/search" params [] (lp-controller/lp-search params))

  (GET "/admin/hermeticidad" params hermeticidad-controller/hermeticidad)
  (GET "/admin/hermeticidad/edit/:id" [id] (hermeticidad-controller/hermeticidad-edit id))
  (POST "/admin/hermeticidad/save" params [] (hermeticidad-controller/hermeticidad-save params))
  (GET "/admin/hermeticidad/add" params [] (hermeticidad-controller/hermeticidad-add params))
  (GET "/admin/hermeticidad/delete/:id" [id] (hermeticidad-controller/hermeticidad-delete id))
  (POST "/admin/hermeticidad/search" params [] (hermeticidad-controller/hermeticidad-search params))

  (GET "/admin/tdd" params tdd-controller/tdd)
  (GET "/admin/tdd/edit/:id" [id] (tdd-controller/tdd-edit id))
  (POST "/admin/tdd/save" params [] (tdd-controller/tdd-save params))
  (GET "/admin/tdd/add" params [] (tdd-controller/tdd-add params))
  (GET "/admin/tdd/delete/:id" [id] (tdd-controller/tdd-delete id))
  (POST "/admin/tdd/search" params [] (tdd-controller/tdd-search params))

  (GET "/admin/ic_modelo" params ic_modelo-controller/ic_modelo)
  (GET "/admin/ic_modelo/edit/:id" [id] (ic_modelo-controller/ic_modelo-edit id))
  (POST "/admin/ic_modelo/save" params [] (ic_modelo-controller/ic_modelo-save params))
  (GET "/admin/ic_modelo/add" params [] (ic_modelo-controller/ic_modelo-add params))
  (GET "/admin/ic_modelo/delete/:id" [id] (ic_modelo-controller/ic_modelo-delete id))
  (POST "/admin/ic_modelo/search" params [] (ic_modelo-controller/ic_modelo-search params))

  (GET "/admin/ft_clasificacion" params ft_clasificacion-controller/ft_clasificacion)
  (GET "/admin/ft_clasificacion/edit/:id" [id] (ft_clasificacion-controller/ft_clasificacion-edit id))
  (POST "/admin/ft_clasificacion/save" params [] (ft_clasificacion-controller/ft_clasificacion-save params))
  (GET "/admin/ft_clasificacion/add" params [] (ft_clasificacion-controller/ft_clasificacion-add params))
  (GET "/admin/ft_clasificacion/delete/:id" [id] (ft_clasificacion-controller/ft_clasificacion-delete id))
  (POST "/admin/ft_clasificacion/search" params [] (ft_clasificacion-controller/ft_clasificacion-search params))

  (GET "/admin/ft_mm" params ft_mm-controller/ft_mm)
  (GET "/admin/ft_mm/edit/:id" [id] (ft_mm-controller/ft_mm-edit id))
  (POST "/admin/ft_mm/save" params [] (ft_mm-controller/ft_mm-save params))
  (GET "/admin/ft_mm/add" params [] (ft_mm-controller/ft_mm-add params))
  (GET "/admin/ft_mm/delete/:id" [id] (ft_mm-controller/ft_mm-delete id))
  (POST "/admin/ft_mm/search" params [] (ft_mm-controller/ft_mm-search params))

  (GET "/users" params [] (users-dashboard/users params))
  (POST "/users/search" params [] (users-dashboard/users-search params)))
