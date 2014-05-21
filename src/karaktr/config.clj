(ns karaktr.config)

(def config (read-string (slurp "resources/config.clj")))

(defn datomic-uri
  ((config :datomic) :uri))
