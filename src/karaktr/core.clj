(ns karaktr.core
  [:require [compojure.core :refer :all]
            [compojure.route :as route]
            [karaktr.actions [site :as a-site]]])

(defroutes resources-routes
  (route/resources "/resources/"))

(defroutes app-routes
  (GET "/" [] (a-site/home)))

(def app
  (routes resources-routes app-routes))
