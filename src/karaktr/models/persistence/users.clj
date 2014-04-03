(ns karaktr.models.persistence.users
  [:require [karaktr [config :refer [datomic-config]]]
            [datomic [api :only [q db] :as d]]
            [crypto [random :as rando]]
            [crypto.password [bcrypt :as passw]]
            [boron [persistence :refer :all]]])

(def attr-ent-keymap
  {:id :db/id
   :email :user/email
   :first-name :user/first-name
   :last-name :user/last-name
   :encrypted-password :user/encrypted-password})

(defn- encrypt-password
  [attrs]
  (if (:password attrs)
    (assoc attrs :encrypted-password (passw/encrypt (:password attrs)))
    attrs))

(defn create
  [attrs]
  (let [attrs (-> attrs (set-id) (encrypt-password))
        conn (d/connect (:uri datomic-config))
        trans @(d/transact conn [(map-attrs attrs attr-ent-keymap)])
        permid (d/resolve-tempid (d/db conn) (:tempids trans) (:id attrs))]
    (assoc attrs :id permid)))
