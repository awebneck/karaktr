(def config (read-string (slurp "resources/config.clj")))

(defproject karaktr "0.0.1-SNAPSHOT"
  :description "Cool new project to do things and stuff"
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [compojure "1.1.6"]
                 [com.datomic/datomic-pro "0.9.4699"]
                 [environ "0.4.0"]
                 [hiccup "1.0.5"]
                 [crypto-random "1.2.0"]
                 [crypto-password "0.1.3"]
                 [ring "1.2.1"]]
  :datomic {:schemas ["resources/schema" ["schema.edn"]]}
  :profiles {:dev {:dependencies [[midje "1.5.1"]]
                   :datomic {:db-uri ((config :datomic) :uri)
                             :config "resources/dev-transactor.properties"}}}
  :plugins [[lein-environ "0.4.0"]
            [lein-datomic "0.2.0"]
            [lein-ring "0.8.10"]]
  :ring {:handler karaktr.core/app
         :reload-paths "src"}
  :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                   :username "jeremy@jeremypholland.com"
                                   :password "1ad6f39b-9d31-45b9-b4b8-2c2ae29ee8f2"}})
