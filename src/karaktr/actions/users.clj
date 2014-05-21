(ns karaktr.actions.users
  [:require [karaktr.view [layouts :as layouts]]
            [karaktr.view.templates [users :as tmpl]]
            [karaktr.models [user :as user]]
            [karaktr [config :as conf]]
            [datomic.api :as d]])

(defn neu
  []
  (layouts/application (tmpl/neu {})))

(defn create
  [email]
  (let [conn (d/connect (conf/datomic-uri))
        db (d/db conn)
        res (user/create email db)]
    (if (res :transdata)
      (let [trans (d/transact conn (res :transdata))]
        (create-respond req res trans))
      (create-respond req res))))

(defn- create-respond
  ([req res] (create-respond req res nil))
  ([req res trans]))
