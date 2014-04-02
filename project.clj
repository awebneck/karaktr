(defproject karaktr "0.0.1-SNAPSHOT"
  :description "Cool new project to do things and stuff"
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [compojure "1.1.6"]
                 [com.datomic/datomic-pro "0.9.4699"]
                 [environ "0.4.0"]]
  :profiles {:dev {:dependencies [[midje "1.5.1"]]
                   :env {:datomic-uri "datomic:dev://localhost:4334/karaktr"}
                   :datomic {:db-uri "datomic:dev://localhost:4334/karaktr"}}}
  :datomic {:schemas ["resources/schema" ["schema.edn"]]}
  :plugins [[lein-environ "0.4.0"]
            [lein-datomic "0.2.0"]]
  :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                   :username "jeremy@jeremypholland.com"
                                   :password "1ad6f39b-9d31-45b9-b4b8-2c2ae29ee8f2"}})
