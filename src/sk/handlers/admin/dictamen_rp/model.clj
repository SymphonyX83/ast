(ns sk.handlers.admin.dictamen_rp.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-dictamen_rp
(def get-dictamen_rp-sql
  (str
   "
    SELECT *
    FROM dictamen_rp
    ORDER BY descripcion
    "))

(defn get-dictamen_rp
  []
  (Query db get-dictamen_rp-sql))
;; End get-dictamen_rp

;; Start get-user
(def get-dictamen_rp-id-sql
  (str
   "
    SELECT *
    FROM dictamen_rp
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-dictamen_rp-id
  [id]
  (first (Query db [get-dictamen_rp-id-sql id])))
;; End get-user

;; Start search-user
(defn get-dictamen_rp-search-sql
  [search]
  (str
   "
  SELECT *
  FROM dictamen_rp
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-dictamen_rp-search
  [search]
  (Query db (get-dictamen_rp-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-dictamen_rp 2)
  (get-dictamen_rp))
