(ns net.wikipunk.f1.fastf1
  "https://github.com/theOehrly/Fast-F1"
  (:require
   [clojure.java.io :as io]
   [com.stuartsierra.component :as com]
   [libpython-clj2.require :refer [require-python]]
   [libpython-clj2.python :as py]
   [libpython-clj2.python.np-array]))

(require-python '[fastf1 :as ff1])
(require-python '[fastf1.Cache :as cache])
(require-python '[fastf1.core.Session :as session])
(require-python 'pandas)
(require-python 'numpy)

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
                                                     (doto (ff1/get_session year gp session-number)
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
                                                      (doto (ff1/get_testing_session year test-number session-number)
                                                        (session/load)))))
                                           {}
                                           (range 1 4))))
                          {} testing)]
      (assoc this
             :events events
             :testing testing)))
  (stop [this]
    this))


