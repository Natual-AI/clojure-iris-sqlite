(defproject clojure-iris-sqlite "0.1.0-SNAPSHOT"
  :description "Projeto Clojure para análise do dataset Iris com SQLite"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [incanter "1.9.3"]
                 [org.xerial/sqlite-jdbc "3.36.0.3"]
                 [org.clojure/java.jdbc "0.7.12"]]
  :main clojure-iris-sqlite.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
