(ns karaktr.actions.users
  [:require [karaktr.view [layouts :as layouts]]
            [karaktr.view.templates [users :as tmpl]]
            [karaktr.models [users :as users]]
            [ring.util [response :as resp]]])

(defn neu
  []
  (layouts/application (tmpl/neu)))

(defn create
  [user-params session]
  (let [user (users/create-user user-params)]
    (if (:errors user)
      (layouts/application (tmpl/neu user))
      (assoc (resp/redirect-after-post "/") :session
             (assoc session :user-id (:id user))))))
