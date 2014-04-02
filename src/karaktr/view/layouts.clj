(ns karaktr.view.layouts
  [:require [hiccup [page :refer :all]]])

(defn application
  [content]
  (html5 [:head (include-css "/resources/bootstrap/css/bootstrap.min.css")
                (include-js "/resources/bootstrap/js/bootstrap.min.js")]
         [:body content]))
