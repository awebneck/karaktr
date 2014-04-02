(ns karaktr.config
  [:require [environ.core :refer :all]])

(def datomic-config
  {:uri (env :datomic-uri)})
