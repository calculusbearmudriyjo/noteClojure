(ns www.db
  (:use 
  	[korma.db]
  	[korma.core])
)

(defdb db (postgres {:db "note"
   :user  "test"
   :password "test"})
	)

(defentity note)

(defn getNote
	([] (into [] (select note)))
	([id] (into [] 
		(select note 
			(where {:id id})))))

(defn addNote [message]
	(insert note (values {:message message}))
	"true")

(defn removeNote [id] 
	(let [deleteRes 
		(select note 
			(where {:id id})
			)]

		(delete note 
			(where {:id id})
			)
		deleteRes
	))