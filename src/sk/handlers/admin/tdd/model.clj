(ns sk.handlers.admin.tdd.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-tdd
(def get-tdd-sql
  (str
   "
    SELECT *
    FROM tdd
    ORDER BY descripcion
    "))

(defn get-tdd
  []
  (Query db get-tdd-sql))
;; End get-tdd

;; Start get-user
(def get-tdd-id-sql
  (str
   "
    SELECT *
    FROM tdd
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-tdd-id
  [id]
  (first (Query db [get-tdd-id-sql id])))
;; End get-user

;; Start search-user
(defn get-tdd-search-sql
  [search]
  (str
   "
  SELECT *
  FROM tdd
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-tdd-search
  [search]
  (Query db (get-tdd-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-tdd 2)
  (get-tdd))
