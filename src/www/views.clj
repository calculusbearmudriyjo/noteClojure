(ns www.views
  (:require
   [joda-time :as time]
   [hiccup.page :as page]
   [selmer.parser :as parser]
   [ring.util.response :refer [content-type response]]
   [ring.util.anti-forgery :refer [anti-forgery-field]])
  (:use [hiccup.form]))

(parser/set-resource-path! (clojure.java.io/resource "public/templates"))

(defn head [title]
  [:head
    [:title (str title)]
    (page/include-css "/css/bootstrap.min.css")
    (page/include-css "/css/main.css")
    (page/include-js "/js/jquery-2.1.4.min.js")
    (page/include-js "/js/bootstrap.min.js")
    (page/include-js "/js/main.js")
    ])

(defn scripts []
  {
   :scripts ["/js/jquery-2.1.4.min.js" "/js/bootstrap.min.js" "/js/main.js"]
   :styles ["/css/bootstrap.min.css" "/css/main.css"]
   }
  )

(defn render [template & [params]]
  (-> template
      (parser/render-file
       (assoc params
         :title "Менеджер заметок"
         :page (str template)
         :scripts (get (scripts) :scripts)
         :styles (get (scripts) :styles)))
      response
      (content-type "text/html; charset=utf-8"))
  )

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

(defn note [notes]
  (render
     "base.html"
    {:notes notes
     :anti-forgery (anti-forgery-field)}))

(defn deleteNote [note]
  (render
     "delete.html"
     (let  [note (first note)]
     {:message (get note :message)
      :id (get note :id)
      :created_at (get note :created_at)}
      )))

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
