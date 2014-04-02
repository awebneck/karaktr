(ns karaktr.actions.site
  [:require [karaktr.view [layouts :as layouts]]
            [karaktr.view.templates [site :as tmpl]]])

(defn home
  []
  (layouts/application (tmpl/home "Gaslight")))
