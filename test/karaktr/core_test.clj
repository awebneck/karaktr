(ns karaktr.core-test
  (:use midje.sweet)
  (:use [karaktr.core]))

(facts "about resources-routes"
  (fact "it should route requests to /resources/* to the /resources/public directory"
    (resources-routes {:request-method :get :uri "/resources/test/porkus.js"}) => (contains {:status 200})))

; (facts "about `first-element`"
;   (fact "it normally returns the first element"
;     (first-element [1 2 3] :default) => 1
;     (first-element '(1 2 3) :default) => 1)
;
;   ;; I'm a little unsure how Clojure types map onto the Lisp I'm used to.
;   (fact "default value is returned for empty sequences"
;     (first-element [] :default) => :default
;     (first-element '() :default) => :default
;     (first-element nil :default) => :default
;     (first-element (filter even? [1 3 5]) :default) => :default))
