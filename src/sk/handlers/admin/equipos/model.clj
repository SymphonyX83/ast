(ns sk.handlers.admin.equipos.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-equipos
(def get-equipos-sql
  (str
   "
    SELECT *
    FROM equipos
    ORDER BY descripcion
    "))

(defn get-equipos
  []
  (Query db get-equipos-sql))
;; End get-equipos

;; Start get-user
(def get-equipo-id-sql
  (str
   "
    SELECT *
    FROM equipos
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-equipo-id
  [id]
  (first (Query db [get-equipo-id-sql id])))
;; End get-user

;; Start search-user
(defn get-equipos-search-sql
  [search]
  (str
   "
  SELECT *
  FROM equipos
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-equipos-search
  [search]
  (Query db (get-equipos-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-equipo 2)
  (get-equipos))
