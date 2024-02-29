(ns sk.handlers.admin.mft1.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-mft1
(def get-mft1-sql
  (str
   "
    SELECT *
    FROM mft1
    ORDER BY descripcion
    "))

(defn get-mft1
  []
  (Query db get-mft1-sql))
;; End get-mft1

;; Start get-user
(def get-mft1-id-sql
  (str
   "
    SELECT *
    FROM mft1
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-mft1-id
  [id]
  (first (Query db [get-mft1-id-sql id])))
;; End get-user

;; Start search-user
(defn get-mft1-search-sql
  [search]
  (str
   "
  SELECT *
  FROM mft1
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-mft1-search
  [search]
  (Query db (get-mft1-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-mft1 2)
  (get-mft1))
