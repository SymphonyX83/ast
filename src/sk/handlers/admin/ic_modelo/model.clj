(ns sk.handlers.admin.ic_modelo.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-ic_modelo
(def get-ic_modelo-sql
  (str
   "
    SELECT *
    FROM ic_modelo
    ORDER BY descripcion
    "))

(defn get-ic_modelo
  []
  (Query db get-ic_modelo-sql))
;; End get-ic_modelo

;; Start get-user
(def get-ic_modelo-id-sql
  (str
   "
    SELECT *
    FROM ic_modelo
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-ic_modelo-id
  [id]
  (first (Query db [get-ic_modelo-id-sql id])))
;; End get-user

;; Start search-user
(defn get-ic_modelo-search-sql
  [search]
  (str
   "
  SELECT *
  FROM ic_modelo
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-ic_modelo-search
  [search]
  (Query db (get-ic_modelo-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-ic_modelo 2)
  (get-ic_modelo))
