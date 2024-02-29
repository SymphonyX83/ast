(ns sk.handlers.admin.ft_clasificacion.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-ft_clasificacion
(def get-ft_clasificacion-sql
  (str
   "
    SELECT *
    FROM ft_clasificacion
    ORDER BY descripcion
    "))

(defn get-ft_clasificacion
  []
  (Query db get-ft_clasificacion-sql))
;; End get-ft_clasificacion

;; Start get-user
(def get-ft_clasificacion-id-sql
  (str
   "
    SELECT *
    FROM ft_clasificacion
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-ft_clasificacion-id
  [id]
  (first (Query db [get-ft_clasificacion-id-sql id])))
;; End get-user

;; Start search-user
(defn get-ft_clasificacion-search-sql
  [search]
  (str
   "
  SELECT *
  FROM ft_clasificacion
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-ft_clasificacion-search
  [search]
  (Query db (get-ft_clasificacion-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-ft_clasificacion 2)
  (get-ft_clasificacion))
