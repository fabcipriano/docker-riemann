(ns facio.graph.elasticsearch
  (:require 
    [clojure.string :as string]))

; format ElasticSearch Index String
(defn makeindexstr [event] (string/lower-case (str "app.tst." (:service event))))

(defn formatindexes [event]
  (let [es_index (makeindexstr event)]
    
    (if (string/ends-with? es_index "/") 
      (string/join "" (drop-last es_index))
      es_index)))

    
