(ns net.wikipunk.python.fastf1.core.Session
  "No documentation provided"
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.python.jvm-handle :refer [py-global-delay]]
            [libpython-clj2.python.bridge-as-jvm :as as-jvm])
  (:refer-clojure :exclude [+ - * / float double int long mod byte test char short take partition require max min identity empty mod repeat str load cast type sort conj map range list next hash eval bytes filter compile print set format compare reduce merge]))

(defonce ^:private src-obj* (py-global-delay (py/path->py-obj "fastf1.core.Session")))

(def ^{:doc "" :arglists '[[self df]]} _Session__fix_tyre_info (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_Session__fix_tyre_info"))))

(def ^{:doc ":class:`pandas.Timedelta`: Session time at which the session was
        started according to the session status data. This is not the
        time at which the session is scheduled to be started!

        Data is available after calling `Session.load` with ``laps=True``
        "} session_start_time (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "session_start_time"))))

(def ^{:doc "Deprecated: use :attr:`Session.event` instead"} weekend (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "weekend"))))

(def ^{:doc "" :arglists '[[self livedata]]} _load_laps_data (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_load_laps_data"))))

(def ^{:doc "Load telemetry data from the API.

        This method can only be called after :meth:`load_laps` has been
        called. You will usually just want to call :meth:`load_laps` with
        the optional ``with_telemetry=True`` argument instead of calling this
        method separately. The result will be the same.

        The raw data is divided into car data (Speed, RPM, ...) and position data (coordinates, on/off track). For each
        of the two types an instance of :class:`Telemetry` is created per driver. The properties
        :attr:`Session.car_data` and :attr:`Session.pos_data` are dictionaries which hold the the `Telemetry` objects
        keyed by driver number.

        The telemetry data can either be accessed through the above mentioned attributes or conveniently on a per
        lap basis through :class:`Lap` and :class:`Laps`. See :class:`Telemetry` on how to work with the telemetry
        data.

        Note that this method additionally calculates :attr:`Session.t0_date` and adds a `LapStartDate` column to
        :attr:`Session.laps`.

        Args:
            livedata (:class:`fastf1.livetiming.data.LiveTimingData`, optional) :
                instead of requesting the data from the api, locally saved
                livetiming data can be used as a data source
        " :arglists '[[self & [{livedata :livedata}]] [self]]} _load_telemetry (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_load_telemetry"))))

(def ^{:doc "Load session data from the supported APIs.

        This method allows to flexibly load some or all data that FastF1 can
        give you access to. Without specifying any further options, all data
        is loaded by default.

        Downloading and parsing of the data takes a considerable amount of
        time. Therefore, it is highly recommended to enable caching so that
        most of the data processing needs to be done only once.

        .. note:: **Lap data: drivers crashing and retiring**

            *During a session:*
            An additional last lap is added for a driver if the last timed
            lap of a driver is not an inlap and the session is aborted next.
            The `Time` for when this lap was \"set\" will be set to the time at
            which the session was aborted.

            *First lap in a race:*
            A single lap with minimal information will be added in race
            sessions if a driver does not complete at least one timed lap.
            The `LapStartTime` for this lap will be set to the start time
            of the session as with all other laps in a race. The `Time` at
            which this lap was \"set\" will be set to the time at which the
            first driver completes their first lap.


        .. note:: Absolute time is not super accurate. The moment a lap
            is logged is not always the same and there will be some
            jitter. At the moment lap time reference is synchronised
            on the sector time triggered with lowest latency.
            Expect an error of around ±10m when overlapping telemetry
            data of different laps.

        Args:
            laps (bool): Load laps and session status data.
            telemetry (bool): Load telemetry data.
            weather (bool): Load weather data.
            messages (bool): Load race control messages for the session
            livedata (:class:`fastf1.livetiming.data.LiveTimingData`, optional):
                instead of requesting the data from the api, locally saved
                livetiming data can be used as a data source
        " :arglists '[[self & [{laps :laps, telemetry :telemetry, weather :weather, messages :messages, livedata :livedata}]]]} load (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "load"))))

(def ^{:doc "" :arglists '[[self & [{livedata :livedata}]] [self]]} _load_weather_data (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_load_weather_data"))))

(def ^{:doc "
        Get a driver object which contains additional information about a driver.

        Args:
            identifier (str): driver's three letter identifier (for
                example 'VER') or driver number as string

        Returns:
            instance of :class:`Driver`
        " :arglists '[[self identifier]]} get_driver (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_driver"))))

(def ^{:doc "
        .. deprecated:: 2.2
            use :func:`Session.load` instead
        "   :arglists '[[self & [{with_telemetry :with_telemetry, livedata :livedata}]] [self & [{with_telemetry :with_telemetry}]] [self]]} load_laps (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "load_laps"))))

(def ^{:doc "" :arglists '[[self & [{load_drivers :load_drivers, load_results :load_results}]]]} _drivers_results_from_ergast (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_drivers_results_from_ergast"))))

(def ^{:doc ":class:`SessionResults`: Session result with driver information.

        Data is available after calling `Session.load`
        "} results (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "results"))))

(def ^{:doc ":class:`pandas.Datetime`: Date timestamp which marks the beginning
        of the data stream (the moment at which the session time is zero).

        Data is available after calling `Session.load` with ``telemetry=True``
        "} t0_date (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "t0_date"))))

(def ^{:doc "Calculate the date timestamp at which data for this session is starting.

        This does not mark the start of a race (or other sessions). This marks the start of the data which is sometimes
        far before.

        This function sets :attr:`self.t0_date` which is an internally required offset for some calculations.

        The current assumption is that the latest date which can be calculated is correct. (Based on the timestamp with
        the least delay.)

        Args:
            car_data: Car telemetry; should contain all samples and only original ones
            pos_data: Car position data; should contain all samples and only original ones
        " :arglists '[[self car_data pos_data]]} _calculate_t0_date (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_calculate_t0_date"))))

(def ^{:doc "
        .. deprecated:: 2.2
            use :func:`Session.load` instead
        "   :arglists '[[self & [{livedata :livedata}]] [self]]} load_telemetry (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "load_telemetry"))))

(def ^{:doc ":class:`Laps`: All laps from all drivers driven in this session.

        Data is available after calling `Session.load` with ``laps=True``
        "} laps (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "laps"))))

(def ^{:doc ":class:`pandas.Dataframe`: Session status data as returned by
        :func:`fastf1.api.session_status_data`

        Data is available after calling `Session.load` with ``laps=True``
        "} session_status (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "session_status"))))

(def ^{:doc "dictionary for instance variables (if defined)"} __dict__ (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "__dict__"))))

(def ^{:doc "" :arglists '[[self & [{livedata :livedata}]]]} _load_drivers_results (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_load_drivers_results"))))

(def ^{:doc ""} __module__ "fastf1.core")

(def ^{:doc "" :arglists '[[self & [{livedata :livedata}]] [self]]} _load_race_control_messages (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_load_race_control_messages"))))

(def ^{:doc                                                                           "Accuracy validation; simples yes/no validation
        Currently only relies on provided information which can't catch all problems" :arglists '[[self]]} _check_lap_accuracy (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_check_lap_accuracy"))))

(def ^{:doc ":class:`list`: List of all drivers that took part in this
        session; contains driver numbers as string.

        Data is available after calling `Session.load`
        "} drivers (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "drivers"))))

(def ^{:doc "list of weak references to the object (if defined)"} __weakref__ (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "__weakref__"))))

(def ^{:doc "Dictionary of car position data as received from the api by car
        number (where car number is a string and the telemetry
        is an instance of :class:`Telemetry`)

        Data is available after calling `Session.load` with ``telemetry=True``
        "} pos_data (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "pos_data"))))

(def ^{:doc "" :arglists '[[self name]]} _get_property_warn_not_loaded (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_get_property_warn_not_loaded"))))

(def ^{:doc "Dataframe containing weather data for this session as received
        from the api. See :func:`fastf1.api.weather_data` for available data
        channels. Each data channel is one row of the dataframe.

        Data is available after calling `Session.load` with ``weather=True``
        "} weather_data (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "weather_data"))))

(def ^{:doc ":class:`pandas.Dataframe`: Race Control messages as returned by
        :func:`fastf1.api.race_control_messages`

        Data is available after calling `Session.load` with ``messages=True``
        "} race_control_messages (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "race_control_messages"))))

(def ^{:doc ""} __doc__ "Object for accessing session specific data.

    The session class will usually be your starting point. This object will
    have various information about the session.

    .. note:: Most of the data is only available after calling
        :func:`Session.load`
    ")

(def ^{:doc "" :arglists '[[self & [{livedata :livedata}]]]} _drivers_from_f1_api (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_drivers_from_f1_api"))))

(def ^{:doc "" :arglists '[[self event session_name & [{f1_api_support :f1_api_support}]] [self event session_name]]} __init__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__init__"))))

(def ^{:doc "Dictionary of car telemetry (Speed, RPM, etc.) as received from
        the api by car number (where car number is a string and the telemetry
        is an instance of :class:`Telemetry`)

        Data is available after calling `Session.load` with ``telemetry=True``
        "} car_data (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "car_data"))))
