(ns www.controllers
  (:require
   [ring.util.response :refer [redirect]]
   [www.db :as db]
   [www.views :as views]))

(defn deleteNote
  "delete note"
  [id]
    (let [note (db/removeNote (Integer/parseInt id))]
    	(views/deleteNote note)))

(defn createNote
	"create note"
	[message]
	(redirect "/"))

(defn addNote
	"add note"
	[message]
	(db/addNote message))

(defn editNote
	"edit note"
	[id]
	(redirect "/"))

(defn getList
	 (into [] (db/getNote)))

(defn getNote
	"get Note"
	
	([id] 
		(let [note (db/getNote (Integer/parseInt id))]
		(views/note note)))
	
	([]		(let [note (db/getNote)]
		(views/note note))))