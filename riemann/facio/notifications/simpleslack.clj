(ns facio.notifications.simpleslack
  (:require 
    [riemann.common :as common]
    [clj-http.client :as client]
    [cheshire.core :as json]))

; COnfig Slack API Bot for Riemann
(defn formatt_alarm_text [events] 
  (let [last_event (peek events)]
  (str "---\nHouston We have a problem!\n - Alarm Event - \n" 
       " Host: " (:host last_event) "\n"
       " Service: " (:service last_event) "\n"
       " Metric: " (:metric last_event) "\n"
       " Status:" (:state last_event) "\n"
       " Date:" (.format (java.text.SimpleDateFormat. "dd/MM/yyyy HH:mm:ss") (common/time-at (:time last_event))) " UTC \n"
       " Desc: " (:description last_event) "\n"
       )))

; Slack API
(defn simple_slack_api [alarm_msg] 
  (client/post "https://hooks.slack.com/services/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" 
    {:form-params 
      {:payload (json/generate-string 
        {:text alarm_msg 
        :channel "#alarms" :username "friemann-bot" :icon_emoji ":alarm_clock:"})}}))

