(ns www.controllers
  (:require
   [ring.util.response :refer [redirect]]
   [www.db :as db]))

(defn delete
  "Контролер удаления заметки"
  [id]
  (do
    ;    (db/remove-note id)
    (redirect "/")))

