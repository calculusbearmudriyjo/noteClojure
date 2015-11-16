(ns www.controllers
  (:require
   [ring.util.response :refer [response]]
   [ring.middleware.json :refer [wrap-json-params]]
   [ring.util.response :refer [redirect]]
   [www.db :as db]
   [www.views :as views]))

(defn deleteNote [id]
    (let [note (db/removeNote (Integer/parseInt id))]
    	(views/deleteNote note)))

(defn createNote [message]
	(redirect "/"))

(defn addNote [message]
	(db/addNote message))

(defn editNote [id]
	(redirect "/"))

(defn getList []
	 (into [] (db/getNote)))
		; (wrap-json-response (response {:data "data"})))

(defn getNote
	([id] 
		(let [note (db/getNote (Integer/parseInt id))]
		(views/note note))))
	; (wrap-json-response (response	([](let [note (db/getNote)])))))
	; (wrap-json-params (response 'load')))