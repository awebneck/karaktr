(ns karaktr.schema)

(def schema [
             {:db/id #db/id[:db.part/db]
              :db/ident :user/email
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/fulltext true
              :db/doc "A user's email"
              :db/unique :db.unique/identity
              :db.install/_attribute :db.part/db}
             {:db/id #db/id[:db.part/db]
              :db/ident :user/encrypted-password
              :db/valueType :db.type/bytes
              :db/cardinality :db.cardinality/one
              :db/doc "A user's password hash"
              :db.install/_attribute :db.part/db}
             {:db/id #db/id[:db.part/db]
              :db/ident :user/password-salt
              :db/valueType :db.type/bytes
              :db/cardinality :db.cardinality/one
              :db/doc "Salt for the user's password hash"
              :db.install/_attribute :db.part/db}
             {:db/id #db/id[:db.part/db]
              :db/ident :user/first-name
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/fulltext true
              :db/doc "A user's first name"
              :db.install/_attribute :db.part/db}
             {:db/id #db/id[:db.part/db]
              :db/ident :user/last-name
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/fulltext true
              :db/doc "A user's last name"
              :db.install/_attribute :db.part/db}

             {:db/id #db/id[:db.part/db]
              :db/ident :character/name
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/fulltext true
              :db/doc "A character's email"
              :db.install/_attribute :db.part/db}
             {:db/id #db/id[:db.part/db]
              :db/ident :character/owner
              :db/valueType :db.type/ref
              :db/cardinality :db.cardinality/one
              :db/doc "A character's owner"
              :db.install/_attribute :db.part/db}
             ])
