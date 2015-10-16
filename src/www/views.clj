(ns www.views
  (:require
   [joda-time :as time]
   [hiccup.page :as page]
   [ring.util.response :refer [content-type response]]
   [ring.util.anti-forgery :refer [anti-forgery-field]])
  (:use [hiccup.form]))

(defn head [title]
  [:head
    [:title (str title)]
    (page/include-css "/css/bootstrap.min.css")
    (page/include-css "/css/main.css")
    (page/include-js "/js/jquery-2.1.4.min.js")
    (page/include-js "/js/bootstrap.min.js")
    (page/include-js "/js/main.js")
    ])

(defn index [notes]
  (page/html5
   (head "Main page")
   [:body
    [:p "My notes"]
    [:ul
     (for [note notes]
       [:li note])
     ]
    ]
   )
  )

(defn note [note]
  (page/html5
    (head note)))

(defn addNote []
  (page/html5
   (head "Form add note")
   [:body
    (form-to {:enctype "multipart/form-data"} [:post "/addNote"]
    (text-field {:name "message"} "message")
    (submit-button {:name "submit"} "save")
    (anti-forgery-field))
    ]
   ))

(defn dump [message]
  (page/html5
   (head "dump")
   [:body
    [:p (apply str message)]])
  )
