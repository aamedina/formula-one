(ns net.wikipunk.f1.fastf1
  "https://github.com/theOehrly/Fast-F1"
  (:require
   [clojure.java.io :as io]
   [com.stuartsierra.component :as com]
   [libpython-clj2.require :refer [require-python]]
   [libpython-clj2.python :as py]
   [libpython-clj2.python.np-array]
   [libpython-clj2.codegen :as codegen]
   [net.wikipunk.rdf :as rdf]
   [net.wikipunk.python.fastf1 :as fastf1]
   [net.wikipunk.python.fastf1.core.Session :as session]))

(require-python '[fastf1.Cache :as cache])

(defrecord FastF1 [cache-dir events testing]
  com/Lifecycle
  (start [this]
    (cache/enable_cache (.getPath (doto (io/file cache-dir) (.mkdirs))))
    (let [events (reduce (fn [events [year gp]]
                           (assoc events
                                  [year gp]
                                  (reduce (fn [sessions session-number]
                                            (assoc sessions session-number
                                                   (delay
                                                     (doto (fastf1/get_session year gp session-number)
                                                       (session/load)))))
                                          {}
                                          (range 1 6))))
                         {} events)
          testing (reduce (fn [events [year test-number]]
                            (assoc events
                                   [year test-number]
                                   (reduce (fn [sessions session-number]
                                             (assoc sessions session-number
                                                    (delay
                                                      (doto (fastf1/get_testing_session year test-number session-number)
                                                        (session/load)))))
                                           {}
                                           (range 1 4))))
                          {} testing)]
      (assoc this
             :events events
             :testing testing)))
  (stop [this]
    this)

  rdf/NamespaceSpitter
  (emit [_ arg-map]
    (codegen/write-namespace! "fastf1" {:ns-prefix "net.wikipunk.python"})
    (codegen/write-namespace! "fastf1.core" {:ns-prefix "net.wikipunk.python"})
    (codegen/write-namespace! "fastf1.core.Session" {:ns-prefix "net.wikipunk.python"})
    (codegen/write-namespace! "fastf1.core.Laps" {:ns-prefix "net.wikipunk.python"})
    (codegen/write-namespace! "fastf1.core.Lap" {:ns-prefix "net.wikipunk.python"})
    (codegen/write-namespace! "fastf1.core.Telemetry" {:ns-prefix "net.wikipunk.python"})
    (codegen/write-namespace! "fastf1.core.SessionResults" {:ns-prefix "net.wikipunk.python"})
    (codegen/write-namespace! "fastf1.events" {:ns-prefix "net.wikipunk.python"})
    (codegen/write-namespace! "fastf1.events.Event" {:ns-prefix "net.wikipunk.python"})
    (codegen/write-namespace! "fastf1.events.EventSchedule" {:ns-prefix "net.wikipunk.python"})))

