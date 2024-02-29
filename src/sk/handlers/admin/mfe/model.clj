(ns sk.handlers.admin.mfe.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-mfe
(def get-mfe-sql
  (str
   "
    SELECT *
    FROM mfe
    ORDER BY descripcion
    "))

(defn get-mfe
  []
  (Query db get-mfe-sql))
;; End get-mfe

;; Start get-user
(def get-mfe-id-sql
  (str
   "
    SELECT *
    FROM mfe
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-mfe-id
  [id]
  (first (Query db [get-mfe-id-sql id])))
;; End get-user

;; Start search-user
(defn get-mfe-search-sql
  [search]
  (str
   "
  SELECT *
  FROM mfe
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-mfe-search
  [search]
  (Query db (get-mfe-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-mfe 2)
  (get-mfe))
