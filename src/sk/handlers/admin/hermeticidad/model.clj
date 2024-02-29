(ns sk.handlers.admin.hermeticidad.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-hermeticidad
(def get-hermeticidad-sql
  (str
   "
    SELECT *
    FROM hermeticidad
    ORDER BY descripcion
    "))

(defn get-hermeticidad
  []
  (Query db get-hermeticidad-sql))
;; End get-hermeticidad

;; Start get-user
(def get-hermeticidad-id-sql
  (str
   "
    SELECT *
    FROM hermeticidad
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-hermeticidad-id
  [id]
  (first (Query db [get-hermeticidad-id-sql id])))
;; End get-user

;; Start search-user
(defn get-hermeticidad-search-sql
  [search]
  (str
   "
  SELECT *
  FROM hermeticidad
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-hermeticidad-search
  [search]
  (Query db (get-hermeticidad-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-hermeticidad 2)
  (get-hermeticidad))
