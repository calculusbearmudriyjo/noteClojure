(ns www.views
  (:require
   [joda-time :as time]
   [hiccup.page :as page]
   [ring.util.response :refer [content-type response]]
   [ring.util.anti-forgery :refer [anti-forgery-field]])
  (:use [hiccup.form]))

(defn index [notes]
  (page/html5
   [:head
    [:title "My Notes"]
    ]
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
   [:head
    [:title (str note)]]))

(defn addNote []
  (page/html5
   [:head
    [:title "Form add note"]]
   [:body
    (form-to {:enctype "multipart/form-data"} [:post "/addNote"]
    (text-field {:name "message"} "message")
    (submit-button {:name "submit"} "save"))
    ]
   ))
