(ns www.routes
  (:require
   [compojure.core :refer [defroutes GET POST]]
   [compojure.route :as route]
   [www.controllers :as controllers]
   [www.views :as views]
   [www.db :as db]))

(defroutes main-routes
  (route/resources "/")

  (GET "/note"
      []
      (controllers/getNote))

  (GET "/list"
    []
    (controllers/getList))

  (GET "/note/:id"
      [id]
      (controllers/getNote id))

  (GET "/delete/note/:id"
    [id]
    (controllers/deleteNote id))

  (GET "/" []
    (views/note []))

  (GET "/add" [message]
    (controllers/addNote [message]))

  (route/not-found "Ничего не найдено")
  )
