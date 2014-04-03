(ns karaktr.models.users
  [:require [karaktr.models.persistence [users :as pers]]
            [boron [validation :refer :all]]])

(defvalidator email-formatted?
  #(and (not (empty? (:email %))) (re-matches #"[\w.-]+@\w+(?:\.\w+)+" (:email %)))
  :email
  "Invalid email")

(defvalidator first-name-present?
  #(not (empty? (:first-name %)))
  :first-name
  "Invalid first name")

(defvalidator last-name-present?
  #(not (empty? (:last-name %)))
  :last-name
  "Invalid last name")

(defvalidator password-present?
  #(not (empty? (:password %)))
  :password
  "Password cannot be empty")

(defvalidator password-matches-confirmation?
  #(= (:password-confirmation %) (:password %))
  :password-confirmation
  "Password doesn't match confirmation")

(defvalbattery creation-battery
  email-formatted? first-name-present? last-name-present? password-present? password-matches-confirmation?)

(defn create-user
  [attrs]
  (if (valid? creation-battery attrs)
    (do (pers/transact attrs) attrs)
    (assoc attrs :errors (creation-battery attrs))))
