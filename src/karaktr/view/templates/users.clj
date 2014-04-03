(ns karaktr.view.templates.users
  [:require [hiccup [form :as form]]])

(defn neu
  [nam]
  (list [:h1 "LOGIN:"]
        (form/form-to [:post "/users"] [:input {:type "email" :placeholder "email" :name "user-session[email]"}]
                                       [:input {:type "password" :placeholder "password" :name "user-session[password]"}]
                                       [:button {:type "submit"} "Submit"])))
