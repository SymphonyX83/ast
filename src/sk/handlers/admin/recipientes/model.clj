(ns sk.handlers.admin.recipientes.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-recipientes
(def get-recipientes-sql
  (str
   "
    SELECT *
    FROM recipientes
    ORDER BY descripcion
    "))

(defn get-recipientes
  []
  (Query db get-recipientes-sql))
;; End get-recipientes

;; Start get-user
(def get-recipiente-id-sql
  (str
   "
    SELECT *
    FROM recipientes
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-recipiente-id
  [id]
  (first (Query db [get-recipiente-id-sql id])))
;; End get-user

;; Start search-user
(defn get-recipientes-search-sql
  [search]
  (str
   "
  SELECT *
  FROM recipientes
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-recipientes-search
  [search]
  (Query db (get-recipientes-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-recipiente 2)
  (get-recipientes))
