(ns poker-cards.db
    (:require [matchbox.core :as m]))

;; -- REPLACE with your own DB location ---------
(def firebase-io-root "https://poker-cards.firebaseio.com/")
;; ----------------------------------------------

;; Connection to Firebase
(defonce fb-root (m/connect firebase-io-root))

(def default-db
  {:name "re-frame"})
