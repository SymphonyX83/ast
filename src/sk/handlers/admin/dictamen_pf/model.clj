(ns sk.handlers.admin.dictamen_pf.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-dictamen_pf
(def get-dictamen_pf-sql
  (str
   "
    SELECT *
    FROM dictamen_pf
    ORDER BY descripcion
    "))

(defn get-dictamen_pf
  []
  (Query db get-dictamen_pf-sql))
;; End get-dictamen_pf

;; Start get-user
(def get-dictamen_pf-id-sql
  (str
   "
    SELECT *
    FROM dictamen_pf
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-dictamen_pf-id
  [id]
  (first (Query db [get-dictamen_pf-id-sql id])))
;; End get-user

;; Start search-user
(defn get-dictamen_pf-search-sql
  [search]
  (str
   "
  SELECT *
  FROM dictamen_pf
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-dictamen_pf-search
  [search]
  (Query db (get-dictamen_pf-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-dictamen_pf 2)
  (get-dictamen_pf))
