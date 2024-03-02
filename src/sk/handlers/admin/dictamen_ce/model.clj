(ns sk.handlers.admin.dictamen_ce.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-dictamen_ce
(def get-dictamen_ce-sql
  (str
   "
    SELECT *
    FROM dictamen_ce
    ORDER BY descripcion
    "))

(defn get-dictamen_ce
  []
  (Query db get-dictamen_ce-sql))
;; End get-dictamen_ce

;; Start get-user
(def get-dictamen_ce-id-sql
  (str
   "
    SELECT *
    FROM dictamen_ce
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-dictamen_ce-id
  [id]
  (first (Query db [get-dictamen_ce-id-sql id])))
;; End get-user

;; Start search-user
(defn get-dictamen_ce-search-sql
  [search]
  (str
   "
  SELECT *
  FROM dictamen_ce
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-dictamen_ce-search
  [search]
  (Query db (get-dictamen_ce-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-dictamen_ce 2)
  (get-dictamen_ce))
