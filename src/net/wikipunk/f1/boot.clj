(ns net.wikipunk.f1.boot
  {:rdf/type :jsonld/Context}
  (:require
   [net.wikipunk.auto.boot]
   [net.wikipunk.rdf.auto-av]
   [net.wikipunk.rdf.auto-cc]
   [net.wikipunk.rdf.auto-ev]
   [net.wikipunk.rdf.auto-mo]
   [net.wikipunk.rdf.auto-ti]
   [net.wikipunk.rdf.auto-vc]
   [net.wikipunk.rdf.auto-vp]
   [net.wikipunk.rdf.auto-vs]))

(def f1
  {:rdf/type    :rdfa/PrefixMapping
   :rdfa/uri    "https://wikipunk.net/f1/"
   :rdfa/prefix "f1"})

(def ergast
  {:rdfa/uri    "https://redefer.rhizomik.net/xsd2owl?xsd=https://ergast.com/schemas/mrd-1.4.xsd#"
   :rdfa/prefix "ergast"
   :rdf/type    :rdfa/PrefixMapping})
