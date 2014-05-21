(ns karaktr.models.user)

(defn create
  [email db]
  (if (empty? email)
    {:aux {:errors {:email "Can't be blank"}}}
    {:transdata {:email email}}))
