(ns boron.validation)

(defmacro defvalidator
  [naym condit ki error]
  `(defn ~naym
     [attrs# errors#]
     (if (~condit attrs#)
       errors#
       (assoc errors# ~ki (conj (or (~ki errors#) []) ~error)))))

(defmacro defvalbattery
  [naym & validators]
  `(def ~naym (memoize (fn
     [attrs#]
     (reduce #(%2 attrs# %1) {} ~(vec validators))))))

(defn valid?
  [battery attrs]
  (empty? (battery attrs)))
