(ns sk.handlers.admin.dictamen_end.model
  (:require [sk.models.crud :refer [Query db]]
            [clojure.string :as st]))

;; Start get-dictamen_end
(def get-dictamen_end-sql
  (str
   "
    SELECT *
    FROM dictamen_end
    ORDER BY descripcion
    "))

(defn get-dictamen_end
  []
  (Query db get-dictamen_end-sql))
;; End get-dictamen_end

;; Start get-user
(def get-dictamen_end-id-sql
  (str
   "
    SELECT *
    FROM dictamen_end
    WHERE id = ?
    ORDER BY descripcion
    "))

(defn get-dictamen_end-id
  [id]
  (first (Query db [get-dictamen_end-id-sql id])))
;; End get-user

;; Start search-user
(defn get-dictamen_end-search-sql
  [search]
  (str
   "
  SELECT *
  FROM dictamen_end
  WHERE
  "
   "LOWER(descripcion) LIKE '%" search "%'"))

(defn get-dictamen_end-search
  [search]
  (Query db (get-dictamen_end-search-sql (st/lower-case search))))
;; End search-user

(comment
  (get-dictamen_end 2)
  (get-dictamen_end))
