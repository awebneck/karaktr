(ns karaktr.core
  [:require [compojure [core :refer :all]
                       [route :as route]
                       [handler :as handler]]
            [clojure [string :as strng]]
            [karaktr.actions [site :as a-site]
                             [users :as a-users]]])

(defroutes resources-routes
  (route/resources "/resources/"))

(defroutes app-routes
  (GET "/" [] (a-site/home))
  (GET "/users/new" [] (a-users/neu))
  (POST "/users" [email] (a-users/create email)))

(defroutes api-routes
  (GET "/api/v1/users" [] "smeggit!!!"))

(def all-routes
  (routes app-routes resources-routes api-routes))

(def app
  (handler/site all-routes))
