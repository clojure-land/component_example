(ns component-example.components.endpoint
  (:require [com.stuartsierra.component :as component]))

(defrecord Endpoint [routes-fn]
  component/Lifecycle
  (start [component]
    (assoc component :routes (routes-fn component)))
  (stop [component]
    (dissoc component :routes)))

(defn new-endpoint [routes-fn]
  (map->Endpoint {:routes-fn routes-fn}))
