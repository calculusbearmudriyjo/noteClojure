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

(defn getNotes []
	(into [] (select note)))