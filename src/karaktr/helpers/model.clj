(ns karaktr.helpers.model
  [:require [clojure [string :refer [join]]]])

(defn has-errors?
  [model error]
  (and (:errors model) (error (:errors model))))

(defn format-errors
  [model error]
  (when (has-errors? model error)
    (join (error (:errors model)))))
