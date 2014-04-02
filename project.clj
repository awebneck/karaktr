(defproject karaktr "0.0.1-SNAPSHOT"
  :description "Cool new project to do things and stuff"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.6"]
                 [com.datomic/datomic-pro "0.9.4699"]]
  :profiles {:dev {:dependencies [[midje "1.5.1"]]}}
  :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                   :username "jeremy@jeremypholland.com"
                                   :password "1ad6f39b-9d31-45b9-b4b8-2c2ae29ee8f2"}})
