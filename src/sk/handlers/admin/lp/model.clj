(ns sk.handlers.admin.lp.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-lp
(def get-lp-sql
  (str
   "
    SELECT *
    FROM lp
    ORDER BY descripcion
    "))

(defn get-lp
  []
  (Query db get-lp-sql))
;; End get-lp

;; Start get-user
(def get-lp-id-sql
  (str
   "
    SELECT *
    FROM lp
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-lp-id
  [id]
  (first (Query db [get-lp-id-sql id])))
;; End get-user

;; Start search-user
(defn get-lp-search-sql
  [search]
  (str
   "
  SELECT *
  FROM lp
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-lp-search
  [search]
  (Query db (get-lp-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-lp 2)
  (get-lp))
