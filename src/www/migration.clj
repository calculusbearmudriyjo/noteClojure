(ns www.migration
  (:use 
  	[korma.db])
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

(defn removeExt [fileName] 
	(subs fileName 0 (- (count fileName) 4)))

(defn executeSqls [sqlCommands]
	(map korma.core/exec sqlCommands))

(defn migrateUp []
	(loop [migrations (getSortedMigrate)]
		(when (> (count migrations) 0)
		(when-let [nameSpace (first migrations)]
		(println nameSpace)	
		(load-file (clojure.string/join "/" [migrateProjectPath nameSpace]))
		(executeSqls (callFn (clojure.string/join "/" [(removeExt nameSpace) "migrateUp"]))))
		(recur (next migrations)))
		)
	)

(defn migrateDown []
	)