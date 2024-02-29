(ns sk.handlers.admin.mft2.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-mft2
(def get-mft2-sql
  (str
   "
    SELECT *
    FROM mft2
    ORDER BY descripcion
    "))

(defn get-mft2
  []
  (Query db get-mft2-sql))
;; End get-mft2

;; Start get-user
(def get-mft2-id-sql
  (str
   "
    SELECT *
    FROM mft2
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-mft2-id
  [id]
  (first (Query db [get-mft2-id-sql id])))
;; End get-user

;; Start search-user
(defn get-mft2-search-sql
  [search]
  (str
   "
  SELECT *
  FROM mft2
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-mft2-search
  [search]
  (Query db (get-mft2-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-mft2 2)
  (get-mft2))
