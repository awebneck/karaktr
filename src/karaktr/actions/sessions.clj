(ns karaktr.actions.sessions
  [:require [karaktr.view [layouts :as layouts]]
            [karaktr.view.templates [sessions :as tmpl]]])

(defn neu
  []
  (layouts/application (tmpl/neu "Gaslight")))

(defn create
  []
  "TEST")
