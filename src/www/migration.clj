(ns www.db
  (:use 
  	[korma.db]
  	[korma.core])
)

(defdb db (postgres {:db "note"
   :user  "test"
   :password "test"})
	)

(def migrateProjectPath (clojure.java.io/file "/home/mudriyjo/noteClojure/src/www/migrate"))

(defn getSortedMigrate [] 
	(sort sortMigrate (into [] (.list migrateProjectPath)))
	)

(defn sortMigrate [element1 element2]
	(< (migrateNametoInt element1) (migrateNametoInt element2))
	)

(defn migrateNametoInt [string]
	(Integer. (subs string 0 10)))

(defn migrateUp []
	)

(defn migrateDown []
	)