(ns poker-cards.handlers
    (:require [re-frame.core :refer [reg-event-db]]
              [poker-cards.db :as db]
              [matchbox.core :as m]))

(reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(reg-event-db
 :set-active-panel
 (fn [db [_ v]]
   (assoc db :active-panel v)))

(reg-evenr-db
  :set-session
  (fn [db [_ v]]
    (assoc db :session v)))

(reg-event-db
  :join-session
  (fn [db [_ session-id]]
    ;; listen to chat room on firebase
    (let [id  (-> session-id (str/lower-case) (keyword))]
      (-> fb-root
          (m/get-in [id :messages])
          (m/take-last 30)
          (m/listen-to :value
                       (fn [[_ v]] 
                         (println v) 
                         (dispatch [:set-session v])))))
    ;; update current room id
    (assoc db :chat-room room-id)))
