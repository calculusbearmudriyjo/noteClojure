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

(defn migrateNametoInt [string]
	(Integer. (subs string (- (count string) 14) (- (count string) 4))))

(defn sortMigrate [element1 element2]
	(< (migrateNametoInt element1) (migrateNametoInt element2))
	)

(defn getSortedMigrate [] 
	(sort sortMigrate (into [] (.list migrateProjectPath)))
	)

(defn callFn [nsWithFn] (let [func (ns-resolve *ns* (symbol nsWithFn))] (apply func [])))


(defn migrateUp []
	(loop [migrations (getSortedMigrate)]
		(when (> (count migrations) 0)
		(when-let [nameSpace (first migrations)]
		(println nameSpace)	
		(load-file (clojure.string/join "/" [migrateProjectPath nameSpace]))
		(callFn (clojure.string/join "/" [(subs nameSpace 0 (- (count nameSpace) 4)) "migrateUp"])))
		(recur (next migrations)))
		)
	)

(defn migrateDown []
	)