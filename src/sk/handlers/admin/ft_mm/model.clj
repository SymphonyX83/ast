(ns sk.handlers.admin.ft_mm.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-ft_mm
(def get-ft_mm-sql
  (str
   "
    SELECT *
    FROM ft_mm
    ORDER BY descripcion
    "))

(defn get-ft_mm
  []
  (Query db get-ft_mm-sql))
;; End get-ft_mm

;; Start get-user
(def get-ft_mm-id-sql
  (str
   "
    SELECT *
    FROM ft_mm
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-ft_mm-id
  [id]
  (first (Query db [get-ft_mm-id-sql id])))
;; End get-user

;; Start search-user
(defn get-ft_mm-search-sql
  [search]
  (str
   "
  SELECT *
  FROM ft_mm
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-ft_mm-search
  [search]
  (Query db (get-ft_mm-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-ft_mm 2)
  (get-ft_mm))
