(ns boron.persistence
  [:require [clojure [set :as sett]]])

(defn set-id
  [attrs]
  (if (:id attrs)
    attrs
    (assoc attrs :id #db/id[:db.part/user])))

(defn map-attrs
  [attrs kmap]
  (sett/rename-keys (select-keys attrs (keys kmap)) kmap))

(defn map-ent
  [ent kmap]
  (map-attrs ent (sett/map-invert kmap)))
