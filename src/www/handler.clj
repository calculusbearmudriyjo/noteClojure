(ns www.handler
  (:require
   [www.routes :refer [main-routes]]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def app
  (wrap-defaults main-routes site-defaults))
