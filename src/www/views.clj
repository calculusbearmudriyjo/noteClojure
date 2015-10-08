(ns www.views
  (:require
   [joda-time :as time]
   [hiccup.page :as page]
   [ring.util.response :refer [content-type response]]
   [ring.util.anti-forgery :refer [anti-forgery-field]]))

(defn index [notes]
  (page/html5
   [:head
    [:title "My Notes"]
    ]
   [:body
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
