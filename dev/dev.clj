(ns dev
  "Tools for interactive development with the REPL. This file should
  not be included in a production build of the application.
  Call `(reset)` to reload modified code and (re)start the system.
  The system under development is `system`, referred from
  `com.stuartsierra.component.repl/system`.
  See also https://github.com/stuartsierra/component.repl"
  (:require
   [clojure.datafy :refer [datafy]]
   [clojure.edn :as edn]
   [clojure.java.io :as io]
   [clojure.java.javadoc :refer [javadoc]]
   [clojure.pprint :refer [pprint pp]]
   [clojure.reflect :refer [reflect]]
   [clojure.repl :refer [apropos dir find-doc pst source]]
   [clojure.set :as set]
   [clojure.string :as str]
   [clojure.tools.namespace.repl :refer [refresh refresh-all clear]]
   [com.stuartsierra.component :as com]
   [com.stuartsierra.component.repl :refer [reset set-init start stop system]]
   [com.walmartlabs.schematic :as sc]
   [libpython-clj2.require :refer [require-python]]
   [libpython-clj2.python :as py]
   [net.wikipunk.boot]
   [net.wikipunk.chat :as chat]   
   [net.wikipunk.mop :as mop :refer [isa? descendants parents ancestors]]
   [net.wikipunk.openai :as openai]
   [net.wikipunk.rdf :as rdf :refer [doc]]
   [net.wikipunk.temple :as temple]   
   [net.wikipunk.f1.boot :as boot]
   [net.wikipunk.f1.fastf1 :as fastf1]
   [net.wikipunk.rdf.f1]
   [net.wikipunk.rdf.ergast]
   [net.wikipunk.rdf.auto-av]
   [net.wikipunk.rdf.auto-cc]
   [net.wikipunk.rdf.auto-ev]
   [net.wikipunk.rdf.auto-mo]
   [net.wikipunk.rdf.auto-ti]
   [net.wikipunk.rdf.auto-vc]
   [net.wikipunk.rdf.auto-vp]
   [net.wikipunk.rdf.auto-vs]
   [zprint.core :as zprint])
  (:refer-clojure :exclude [isa? descendants parents ancestors]))

(require-python '[fastf1 :as ff1])

(set-init
  (fn [_]
    (if-let [r (io/resource "system.edn")]
      (-> (slurp r)
          (edn/read-string)
          (sc/assemble-system))
      (throw (ex-info "system.edn is not on classpath" {})))))

(defmacro inspect
  "Evaluate forms in an implicit do and inspect the value of the last
  expression using Reveal."
  [& body]
  `(do (@user/reveal (do ~@body))
       true))

(comment
  ;; fastf1.get_session_testing(2023, 1, 1)
  (get-in system [:fastf1 :testing [2023 1] 1])

  (let [df (py/get-attr @(get-in system [:fastf1 :testing [2023 1] 1]) "laps")]
    (into []
          (map #(zipmap (seq df) %))
          (numpy/array df))))
