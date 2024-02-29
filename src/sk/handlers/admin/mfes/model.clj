(ns sk.handlers.admin.mfes.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-mfes
(def get-mfes-sql
  (str
   "
    SELECT *
    FROM mfes
    ORDER BY descripcion
    "))

(defn get-mfes
  []
  (Query db get-mfes-sql))
;; End get-mfes

;; Start get-user
(def get-mfes-id-sql
  (str
   "
    SELECT *
    FROM mfes
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-mfes-id
  [id]
  (first (Query db [get-mfes-id-sql id])))
;; End get-user

;; Start search-user
(defn get-mfes-search-sql
  [search]
  (str
   "
  SELECT *
  FROM mfes
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-mfes-search
  [search]
  (Query db (get-mfes-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-mfes 2)
  (get-mfes))
