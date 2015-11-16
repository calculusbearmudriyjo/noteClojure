(defproject www "0.1.0-SNAPSHOT"
  :description "sevice note"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [hiccup "1.0.5"]
                 [selmer "0.8.2"]
                 [clojure.joda-time "0.6.0"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [korma "0.4.2"]
                 [ring/ring-json "0.4.0"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler www.handler/app :auto-reload? true  :auto-refresh? true}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
