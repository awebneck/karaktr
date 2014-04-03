(ns karaktr.actions.users
  [:require [karaktr.view [layouts :as layouts]]
            [karaktr.view.templates [users :as tmpl]]])

(defn neu
  []
  (layouts/application (tmpl/neu "Gaslight")))

(defn create
  []
  (let [user ]))
