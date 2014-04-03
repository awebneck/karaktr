(ns karaktr.core
  [:require [compojure [core :refer :all]
                       [route :as route]
                       [handler :as handler]]
            [clojure [string :as strng]]
            [karaktr.actions [site :as a-site]
                             [sessions :as a-sessions]
                             [users :as a-users]]])

(defroutes resources-routes
  (route/resources "/resources/"))

(defroutes app-routes
  (GET "/" [x :as {session :session}] (a-site/home))

  ; User session routes
  (GET "/user-sessions/new" [] (a-sessions/neu))
  (POST "/user-sessions" [] (a-sessions/create))

  ; User routes
  (GET "/users/new" [] (a-users/neu))
  (POST "/users" [user :as {sess :session}] (a-users/create user sess)))

(defroutes api-routes
  (GET "/api/v1/users" [] "smeggit!!!"))

(def all-routes
  (routes app-routes resources-routes api-routes))

(def app
  (handler/site all-routes))
