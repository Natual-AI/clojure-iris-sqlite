(ns clojure-iris-sqlite.core
  (:require [incanter.core :as i]
            [incanter.io :as io]
            [incanter.stats :as stats]
            [incanter.charts :as charts]
            [clojure.java.jdbc :as jdbc])
  (:gen-class))

(def db-spec {:classname "org.sqlite.JDBC"
              :subprotocol "sqlite"
              :subname "iris.db"})

(defn criar-tabela []
  (jdbc/execute! db-spec
    ["CREATE TABLE IF NOT EXISTS iris (
        sepal_length REAL,
        sepal_width REAL,
        petal_length REAL,
        petal_width REAL,
        species TEXT)"]))

(defn inserir-dados [dataset]
  (doseq [linha (i/to-list dataset)]
    (jdbc/insert! db-spec :iris
      {:sepal_length (nth linha 0)
       :sepal_width  (nth linha 1)
       :petal_length (nth linha 2)
       :petal_width  (nth linha 3)
       :species      (nth linha 4)})))

(defn carregar-dataset []
  (let [dados (io/read-dataset "resources/iris.csv" :header true)]
    dados))

(defn media-sepala [dataset]
  (stats/mean (i/$ :sepal_length dataset)))

(defn plotar-grafico [dataset]
  (let [grafico (charts/scatter-plot
                  (i/$ :sepal_length dataset)
                  (i/$ :sepal_width dataset)
                  :title "Comprimento vs Largura da Sépala"
                  :x-label "Comprimento da Sépala"
                  :y-label "Largura da Sépala")]
    (i/view grafico)))

(defn -main [& args]
  (criar-tabela)
  (let [dataset (carregar-dataset)]
    (inserir-dados dataset)
    (println "Média do comprimento da sépala:" (media-sepala dataset))
    (plotar-grafico dataset)))
