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
  (GET "/" [] (a-site/home))

  ; User session routes
  (GET "/user-sessions/new" [] (a-sessions/neu))
  (POST "/user-sessions" [] (a-sessions/create))

  ; User routes
  (GET "/users/new" [] (a-users/neu))
  (POST "/users" [] (a-users/create)))

(defroutes api-routes
  (GET "/users" [] "smeggit!!!"))

(defn app
  [request]
  (case (second (strng/split (:uri request) #"/"))
    "api" ((handler/api api-routes) (assoc request :uri (strng/replace (:uri request) #"/api/v\d" "")))
    "resources" ((handler/site resources-routes) request)
    ((handler/site app-routes) request)))
