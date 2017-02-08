(ns hello-seymore.core
  (:require [sablono.core :as sab]
            [hello-seymore.components :refer [like-seymore]]
            [cljsjs.rot]
            [enfocus.core :as ef]
            [enfocus.events :as ev]
            [enfocus.effects :as ee]))

(def display (js/ROT.Display.))

(defonce app-state (atom { :likes 0 }))

(defn render! []
  (.render js/ReactDOM
           (like-seymore app-state)
           (.getElementById js/document "app")))

(add-watch app-state :on-change (fn [_ _ _ _] (render!)))

(render!)
