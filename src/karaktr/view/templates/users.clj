(ns karaktr.view.templates.users
  [:require [hiccup [form :refer :all]]])

(defn neu
  [user]
  (form-to [:post "/users"] [:h1 "Create New User"]
        [:div
         [:div [:label "Email"]]
         [:div (email-field "email")]]
        [:div (submit-button "Save")]))
