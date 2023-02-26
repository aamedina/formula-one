(ns net.wikipunk.rdf.fastf1
  "RDF vocabulary for FastF1"
  {:rdf/type :owl/Ontology}
  (:refer-clojure :exclude [name]))

(def ObjectClass
  {:db/ident :fastf1/Object
   :rdf/type :owl/Class})

(def PandasDataFrame
  {:db/ident :fastf1/PandasDataFrame
   :rdf/type :owl/Class
   :rdfs/comment "pandas.core.frame.DataFrame"})

(def PandasSeries
  {:db/ident :fastf1/Series
   :rdf/type :owl/Class
   :rdfs/comment "pandas.core.series.Series"})

(def PandasDatetime
  {:db/ident :fastf1/PandasDatetime
   :rdf/type :owl/Class
   :rdfs/comment "pandas.Datetime"})

(def PandasTimedelta
  {:db/ident :fastf1/PandasTimedelta
   :rdf/type :owl/Class
   :rdfs/comment "pandas.Timedelta"})

(def Session
  {:db/ident        :fastf1/Session
   :rdf/type        :owl/Class
   :rdfs/subClassOf :fastf1/Object
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#session"})

(def Laps
  {:db/ident        :fastf1/Laps
   :rdf/type        :owl/Class
   :rdfs/subClassOf :fastf1/Object
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#laps"})

(def Lap
  {:db/ident        :fastf1/Lap
   :rdf/type        :owl/Class
   :rdfs/subClassOf :fastf1/PandasSeries
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#lap"})

(def Telemetry
  {:db/ident        :fastf1/Telemetry
   :rdf/type        :owl/Class
   :rdfs/subClassOf :fastf1/PandasDataFrame
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#telemetry"})

(def Results
  {:db/ident        :fastf1/Results
   :rdf/type        :owl/Class
   :rdfs/subClassOf :fastf1/PandasDataFrame
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#results"})

(def Event
  {:db/ident        :fastf1/Event
   :rdf/type        :owl/Class
   :rdfs/subClassOf :fastf1/PandasSeries
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/events.html#fastf1.events.Event"})

(def event
  {:db/ident        :fastf1/event
   :rdf/type        :owl/ObjectProperty
   :rdfs/range      :fastf1/Event})

(def name
  {:db/ident   :fastf1/name
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :xsd/string})

(def date
  {:db/ident   :fastf1/event
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :xsd/date})

(def gp
  {:db/ident   :fastf1/gp
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :xsd/integer})

(def api_path
  {:db/ident   :fastf1/api_path
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :xsd/string})

(def drivers
  "List of all drivers that took part in this session; contains driver
  numbers as string."
  {:db/ident   :fastf1/drivers
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :rdf/List})

(def laps
  "All laps from all drivers driven in this session."
  {:db/ident   :fastf1/laps
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :fastf1/Laps})

(def weather_data
  "Dataframe containing weather data for this session as received from
  the api. See :func:`fastf1.api.weather_data` for available data
  channels. Each data channel is one row of the dataframe."
  {:db/ident   :fastf1/weather_data
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :fastf1/PandasDataFrame})

(def car_data
  "Dictionary of car telemetry (Speed, RPM, etc.) as received from the
  api by car number (where car number is a string and the telemetry is
  an instance of :class:`Telemetry`)"
  {:db/ident   :fastf1/car_data
   :rdf/type   :owl/ObjectProperty})

(def pos_data
  "Dictionary of car position data as received from the api by car
  number (where car number is a string and the telemetry is an
  instance of :class:`Telemetry`)"
  {:db/ident   :fastf1/pos_data
   :rdf/type   :owl/ObjectProperty})

(def session_status
  "Session status data as returned by
  `fastf1.api.session_status_data`"
  {:db/ident   :fastf1/session_status
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :fastf1/Laps})

(def race_control_messages
  "Race Control messages as returned by
  `fastf1.api.race_control_messages`"
  {:db/ident   :fastf1/race_control_messages
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :fastf1/DataFrame})

(def session_start_time
  "Session time at which the session was started according to the
  session status data. This is not the time at which the session is
  scheduled to be started!"
  {:db/ident   :fastf1/session_start_time
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :fastf1/PandasTimedelta})

(def t0_date
  "Date timestamp which marks the beginning of the data stream (the
  moment at which the session time is zero)."
  {:db/ident   :fastf1/session_start_time
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :fastf1/PandasDatetime})
