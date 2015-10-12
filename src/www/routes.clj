(ns www.routes
  (:require

   [compojure.core :refer [defroutes GET POST]]
   [compojure.route :as route]

   [www.controllers :as controllers]

   [www.views :as views]

   [www.db :as db]
   )
  )

(defroutes main-routes

  (GET "/note/:id"
       [id]
       ;(let [note (db/getNote id)]
       (let [note [1]]
         (views/note note)))

  (GET "/" []
       (let [notes [1 2 3 4 5]]
         (views/index notes)))

  (GET "/note" []
       (views/addNote))

  (POST "/addNote" [message]
    (views/dump [message]))

  (route/not-found "Ничего не найдено")
  )
