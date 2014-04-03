(ns karaktr.view.templates.users
  [:require [hiccup [form :as form]]
            [karaktr.helpers [model :refer :all]]])

(defn neu
  ([] (neu nil))
  ([user]
   (list [:h1 "LOGIN:"]
     (form/form-to [:post "/users"]
       [:div
         [:input {:type "text" :placeholder "first name" :name "user[first-name]" :value (:first-name user)}]]
         [:p (format-errors user :first-name)]
       [:div
         [:input {:type "text" :placeholder "last name" :name "user[last-name]" :value (:last-name user)}]]
         [:p (format-errors user :last-name)]
       [:div
         [:input {:type "email" :placeholder "email" :name "user[email]" :value (:email user)}]]
         [:p (format-errors user :email)]
       [:div
         [:input {:type "password" :placeholder "password" :name "user[password]"}]]
         [:p (format-errors user :password)]
       [:div
         [:input {:type "password" :placeholder "password confirmation" :name "user[password-confirmation]"}]]
         [:p (format-errors user :password-confirmation)]
       [:div [:button {:type "submit"} "Submit"]]))))
