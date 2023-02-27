(ns dev
  "Tools for interactive development with the REPL. This file should
  not be included in a production build of the application.
  Call `(reset)` to reload modified code and (re)start the system.
  The system under development is `system`, referred from
  `com.stuartsierra.component.repl/system`.
  See also https://github.com/stuartsierra/component.repl"
  (:require
   [camel-snake-kebab.core :as csk]
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
   [libpython-clj2.codegen :as codegen]
   [net.wikipunk.boot]
   [net.wikipunk.chat :as chat]   
   [net.wikipunk.mop :as mop :refer [isa? descendants parents ancestors]]
   [net.wikipunk.openai :as openai]
   [net.wikipunk.rdf :as rdf :refer [doc]]
   [net.wikipunk.temple :as temple]   
   [net.wikipunk.f1.boot :as boot]
   [net.wikipunk.f1.fastf1 :as ff1]
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
   [net.wikipunk.python.fastf1 :as fastf1]
   [net.wikipunk.python.fastf1.core.Session :as session]
   [zprint.core :as zprint])
  (:refer-clojure :exclude [isa? descendants parents ancestors]))

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

(comment
  (->> (vals (ns-publics 'net.wikipunk.python.fastf1.core.Session))
       (remove (comp ifn? deref))
       (remove (comp #(str/starts-with? % "_") :name meta))
       (map (comp :name meta)))

  (->> (vals (ns-publics 'net.wikipunk.python.fastf1.events.Event))
       (remove (comp ifn? deref))
       (remove (comp #(str/starts-with? % "_") :name meta))
       (map (comp :name meta))))

(comment
  (run! (fn [[k v]]
             (zprint/zprint (list 'def (csk/->camelCaseSymbol k) k
                                  {:db/ident (keyword "fastf1" (csk/->camelCase k))
                                   :rdf/type :owl/ObjectProperty
                                   :rdfs/range (case (str (py/get-attr v :dtype))
                                                 "datetime64[ns]"  :fastf1/PandasDatetime
                                                 "timedelta64[ns]" :fastf1/PandasTimedelta
                                                 "object"          :fastf1/Object
                                                 "int64"           :xsd/integer
                                                 "float64"         :xsd/float
                                                 "bool"            :xsd/boolean)
                                   :rdfs/label k})
                            {:map    {:justify?      true
                                      :nl-separator? false
                                      :hang?         true
                                      :indent        0
                                      :sort-in-code? true
                                      :force-nl?     true}
                             :vector {:wrap? false}})
             (newline))
           (py/as-map (py/get-attr @(get-in system [:fastf1 :testing [2023 1] 1]) :laps))))
