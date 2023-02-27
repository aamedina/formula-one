(ns net.wikipunk.rdf.fastf1
  "RDF vocabulary for FastF1"
  {:rdf/type :owl/Ontology}
  (:refer-clojure :exclude [name time]))

(def ObjectClass
  {:db/ident :fastf1/Object
   :rdf/type :owl/Class})

(def PandasDataFrame
  {:db/ident     :fastf1/PandasDataFrame
   :rdf/type     :owl/Class
   :rdfs/comment "pandas.core.frame.DataFrame"})

(def PandasSeries
  {:db/ident     :fastf1/Series
   :rdf/type     :owl/Class
   :rdfs/comment "pandas.core.series.Series"})

(def PandasDatetime
  {:db/ident     :fastf1/PandasDatetime
   :rdf/type     :owl/Class
   :rdfs/comment "pandas.Datetime"})

(def PandasTimedelta
  {:db/ident     :fastf1/PandasTimedelta
   :rdf/type     :owl/Class
   :rdfs/comment "pandas.Timedelta"})

(def Session
  {:db/ident        :fastf1/Session
   :rdf/type        :owl/Class
   :rdfs/subClassOf [:fastf1/Object]
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#session"})

(def Laps
  {:db/ident        :fastf1/Laps
   :rdf/type        :owl/Class
   :rdfs/subClassOf [:fastf1/PandasDataFrame]
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#laps"})

(def Lap
  {:db/ident        :fastf1/Lap
   :rdf/type        :owl/Class
   :rdfs/subClassOf [:fastf1/PandasSeries]
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#lap"})

(def Telemetry
  {:db/ident        :fastf1/Telemetry
   :rdf/type        :owl/Class
   :rdfs/subClassOf [:fastf1/PandasDataFrame]
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#telemetry"})

(def Results
  {:db/ident        :fastf1/Results
   :rdf/type        :owl/Class
   :rdfs/subClassOf [:fastf1/PandasDataFrame]
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/core.html#results"})

(def Event
  {:db/ident        :fastf1/Event
   :rdf/type        :owl/Class
   :rdfs/subClassOf [:fastf1/PandasSeries
                     {:owl/minCardinality 1
                      :owl/onProperty     :fastf1/date
                      :rdf/type           :owl/Restriction}
                     {:owl/maxCardinality 1
                      :owl/onProperty     :fastf1/date
                      :rdf/type           :owl/Restriction}
                     {:owl/minCardinality 1
                      :owl/onProperty     :fastf1/gp
                      :rdf/type           :owl/Restriction}
                     {:owl/maxCardinality 1
                      :owl/onProperty     :fastf1/gp
                      :rdf/type           :owl/Restriction}]
   :rdfs/seeAlso    "https://theoehrly.github.io/Fast-F1/events.html#fastf1.events.Event"})

(def event
  {:db/ident   :fastf1/event
   :rdf/type   :owl/ObjectProperty
   :rdfs/range :fastf1/Event})

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
   :rdfs/domain :fastf1/Session
   :rdfs/range :rdf/List})

(def laps
  "All laps from all drivers driven in this session."
  {:db/ident   :fastf1/laps
   :rdf/type   :owl/ObjectProperty
   :rdfs/domain :fastf1/Session
   :rdfs/range :fastf1/Laps})

(def weather_data
  "Dataframe containing weather data for this session as received from
  the api. See :func:`fastf1.api.weather_data` for available data
  channels. Each data channel is one row of the dataframe."
  {:db/ident   :fastf1/weather_data
   :rdf/type   :owl/ObjectProperty
   :rdfs/domain :fastf1/Session
   :rdfs/range :fastf1/PandasDataFrame})

(def car_data
  "Dictionary of car telemetry (Speed, RPM, etc.) as received from the
  api by car number (where car number is a string and the telemetry is
  an instance of :class:`Telemetry`)"
  {:db/ident :fastf1/car_data
   :rdf/type :owl/ObjectProperty
   :rdfs/domain :fastf1/Session
   :rdfs/range :fastf1/Telemetry})

(def pos_data
  "Dictionary of car position data as received from the api by car
  number (where car number is a string and the telemetry is an
  instance of :class:`Telemetry`)"
  {:db/ident :fastf1/pos_data
   :rdf/type :owl/ObjectProperty
   :rdfs/domain :fastf1/Session
   :rdfs/range :fastf1/Telemetry})

(def session_status
  "Session status data as returned by
  `fastf1.api.session_status_data`"
  {:db/ident   :fastf1/session_status
   :rdf/type   :owl/ObjectProperty
   :rdfs/domain :fastf1/Session
   :rdfs/range :fastf1/Laps})

(def race_control_messages
  "Race Control messages as returned by
  `fastf1.api.race_control_messages`"
  {:db/ident   :fastf1/race_control_messages
   :rdf/type   :owl/ObjectProperty
   :rdfs/domain :fastf1/Session
   :rdfs/range :fastf1/DataFrame})

(def session_start_time
  "Session time at which the session was started according to the
  session status data. This is not the time at which the session is
  scheduled to be started!"
  {:db/ident   :fastf1/session_start_time
   :rdf/type   :owl/ObjectProperty
   :rdfs/domain :fastf1/Session
   :rdfs/range :fastf1/PandasTimedelta})

(def t0_date
  "Date timestamp which marks the beginning of the data stream (the
  moment at which the session time is zero)."
  {:db/ident   :fastf1/t0_date
   :rdf/type   :owl/ObjectProperty
   :rdfs/domain :fastf1/Session
   :rdfs/range :fastf1/PandasDatetime})

;; Lap

(def compound
  "Compound"
  {:db/ident   :fastf1/compound,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Compound",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/Object})

(def driver
  "Driver"
  {:db/ident   :fastf1/driver,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Driver",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/Object})

(def driverNumber
  "DriverNumber"
  {:db/ident   :fastf1/driverNumber,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "DriverNumber",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/Object})

(def freshTyre
  "FreshTyre"
  {:db/ident   :fastf1/freshTyre,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "FreshTyre",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/Object})

(def isAccurate
  "IsAccurate"
  {:db/ident   :fastf1/isAccurate,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "IsAccurate",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/Object})

(def isPersonalBest
  "IsPersonalBest"
  {:db/ident   :fastf1/isPersonalBest,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "IsPersonalBest",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :xsd/boolean})

(def lapNumber
  "LapNumber"
  {:db/ident   :fastf1/lapNumber,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "LapNumber",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :xsd/integer})

(def lapStartDate
  "LapStartDate"
  {:db/ident   :fastf1/lapStartDate,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "LapStartDate",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasDatetime})

(def lapStartTime
  "LapStartTime"
  {:db/ident   :fastf1/lapStartTime,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "LapStartTime",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def lapTime
  "LapTime"
  {:db/ident   :fastf1/lapTime,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "LapTime",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def pitInTime
  "PitInTime"
  {:db/ident   :fastf1/pitInTime,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "PitInTime",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def pitOutTime
  "PitOutTime"
  {:db/ident   :fastf1/pitOutTime,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "PitOutTime",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def sector1SessionTime
  "Sector1SessionTime"
  {:db/ident   :fastf1/sector1SessionTime,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Sector1SessionTime",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def sector1Time
  "Sector1Time"
  {:db/ident   :fastf1/sector1Time,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Sector1Time",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def sector2SessionTime
  "Sector2SessionTime"
  {:db/ident   :fastf1/sector2SessionTime,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Sector2SessionTime",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def sector2Time
  "Sector2Time"
  {:db/ident   :fastf1/sector2Time,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Sector2Time",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def sector3SessionTime
  "Sector3SessionTime"
  {:db/ident   :fastf1/sector3SessionTime,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Sector3SessionTime",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def sector3Time
  "Sector3Time"
  {:db/ident   :fastf1/sector3Time,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Sector3Time",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/PandasTimedelta})

(def speedFL
  "SpeedFL"
  {:db/ident   :fastf1/speedFL,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "SpeedFL",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :xsd/float})

(def speedI1
  "SpeedI1"
  {:db/ident   :fastf1/speedI1,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "SpeedI1",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :xsd/float})

(def speedI2
  "SpeedI2"
  {:db/ident   :fastf1/speedI2,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "SpeedI2",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :xsd/float})

(def speedST
  "SpeedST"
  {:db/ident   :fastf1/speedST,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "SpeedST",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :xsd/float})

(def stint
  "Stint"
  {:db/ident   :fastf1/stint,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Stint",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :xsd/integer})

(def team
  "Team"
  {:db/ident   :fastf1/team,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Team",
   :rdfs/domain :fastf1/Object
   :rdfs/range :xsd/string})

(def time
  "Time"
  {:db/ident   :fastf1/time,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Time",
   :rdfs/domain :fastf1/Telemetry
   :rdfs/range :fastf1/PandasTimedelta})

(def trackStatus
  "TrackStatus"
  {:db/ident   :fastf1/trackStatus,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "TrackStatus",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :fastf1/Object})

(def tyreLife
  "TyreLife"
  {:db/ident   :fastf1/tyreLife,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "TyreLife",
   :rdfs/domain :fastf1/Lap
   :rdfs/range :xsd/float})

;; car_data

(def CarData
  "car_data"
  {:db/ident :fastf1/CarData
   :rdf/type :owl/Class
   :rdfs/subClassOf :fastf1/Telemetry})

(def brake
  "Brake"
  {:db/ident   :fastf1/brake,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Brake",
   :rdfs/domain :fastf1/CarData
   :rdfs/range :xsd/boolean})

(def drs
  "DRS"
  {:db/ident   :fastf1/drs,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "DRS",
   :rdfs/domain :fastf1/CarData
   :rdfs/range :xsd/integer})

(def nGear
  "nGear"
  {:db/ident   :fastf1/nGear,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "nGear",
   :rdfs/domain :fastf1/CarData
   :rdfs/range :xsd/integer})

(def rpm
  "RPM"
  {:db/ident   :fastf1/rpm,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "RPM",
   :rdfs/domain :fastf1/CarData
   :rdfs/range :xsd/integer})

(def sessionTime
  "SessionTime"
  {:db/ident   :fastf1/sessionTime,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "SessionTime",
   :rdfs/domain :fastf1/CarData
   :rdfs/range :fastf1/PandasTimedelta})

(def source
  "Source"
  {:db/ident   :fastf1/source,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Source",
   :rdfs/domain :fastf1/CarData
   :rdfs/range :fastf1/Object})

(def speed
  "Speed"
  {:db/ident   :fastf1/speed,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Speed",
   :rdfs/domain :fastf1/CarData
   :rdfs/range :xsd/integer})

(def throttle
  "Throttle"
  {:db/ident   :fastf1/throttle,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Throttle",
   :rdfs/domain :fastf1/CarData
   :rdfs/range :xsd/integer})

;; pos_data

(def PositionData
  "pos_data"
  {:db/ident :fastf1/PositionData
   :rdf/type :owl/Class
   :rdfs/subClassOf :fastf1/CarData})

(def status
  "Status"
  {:db/ident   :fastf1/status,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Status",
   :rdfs/domain :fastf1/PositionData
   :rdfs/range :fastf1/Object})

(def x
  "X"
  {:db/ident   :fastf1/x,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "X",
   :rdfs/domain :fastf1/PositionData
   :rdfs/range :xsd/integer})

(def y
  "Y"
  {:db/ident   :fastf1/y,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Y",
   :rdfs/domain :fastf1/PositionData
   :rdfs/range :xsd/integer})

(def z
  "Z"
  {:db/ident   :fastf1/z,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Z",
   :rdfs/domain :fastf1/PositionData
   :rdfs/range :xsd/integer})

;; weather_data

(def WeatherData
  {:db/ident :fastf1/WeatherData
   :rdf/type :owl/Class
   :rdfs/subClassOf :fastf1/Telemetry})

(def airTemp
  "AirTemp"
  {:db/ident   :fastf1/airTemp,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "AirTemp",
   :rdfs/domain :fastf1/WeatherData
   :rdfs/range :xsd/float})

(def humidity
  "Humidity"
  {:db/ident   :fastf1/humidity,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Humidity",
   :rdfs/domain :fastf1/WeatherData
   :rdfs/range :xsd/float})

(def pressure
  "Pressure"
  {:db/ident   :fastf1/pressure,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Pressure",
   :rdfs/domain :fastf1/WeatherData
   :rdfs/range :xsd/float})

(def rainfall
  "Rainfall"
  {:db/ident   :fastf1/rainfall,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "Rainfall",
   :rdfs/domain :fastf1/WeatherData
   :rdfs/range :xsd/boolean})

(def trackTemp
  "TrackTemp"
  {:db/ident   :fastf1/trackTemp,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "TrackTemp",
   :rdfs/domain :fastf1/WeatherData
   :rdfs/range :xsd/float})

(def windDirection
  "WindDirection"
  {:db/ident   :fastf1/windDirection,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "WindDirection",
   :rdfs/domain :fastf1/WeatherData
   :rdfs/range :xsd/integer})

(def windSpeed
  "WindSpeed"
  {:db/ident   :fastf1/windSpeed,
   :rdf/type   :owl/ObjectProperty,
   :rdfs/label "WindSpeed",
   :rdfs/domain :fastf1/WeatherData
   :rdfs/range :xsd/float})
