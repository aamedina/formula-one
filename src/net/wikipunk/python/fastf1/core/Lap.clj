(ns net.wikipunk.python.fastf1.core.Lap
  "No documentation provided"
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.python.jvm-handle :refer [py-global-delay]]
            [libpython-clj2.python.bridge-as-jvm :as as-jvm])
  (:refer-clojure :exclude [+ - * / float double int long mod byte test char short take partition require max min identity empty mod repeat str load cast type sort conj map range list next hash eval bytes filter compile print set format compare reduce merge]))

(defonce ^:private src-obj* (py-global-delay (py/path->py-obj "fastf1.core.Lap")))

(def ^{:doc "Telemetry data for this lap

        This is a cached (!) property for :meth:`get_telemetry`. It will return the same value as `get_telemetry`
        but cache the result so that the involved processing is only done once.

        This is mainly provided for convenience and backwards compatibility.

        See :meth:`get_telemetry` for more information.

        Returns:
            instance of :class:`Telemetry`"} telemetry (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "telemetry"))))

(def ^{:doc "Telemetry data for this lap

        Telemetry data is the result of merging the returned data from :meth:`get_car_data` and :meth:`get_pos_data`.
        This means that telemetry data at least partially contains interpolated values! Telemetry data additionally
        already has computed channels added (e.g. Distance).

        This method is provided for convenience and compatibility reasons. But using it does usually not produce
        the most accurate possible result.
        It is recommended to use :meth:`get_car_data` or :meth:`get_pos_data` when possible. This is also faster if
        merging of car and position data is not necessary and if not all computed channels are needed.

        Resampling during merging is done according to the frequency set by :attr:`TELEMETRY_FREQUENCY`.

        Returns:
            instance of :class:`Telemetry`
        " :arglists '[[self]]} get_telemetry (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_telemetry"))))

(def ^{:doc "Pos data for all laps in `self`

        Slices the position data in :attr:`Session.pos_data` using this lap and returns the result.

        Args:
            **kwargs: Keyword arguments are passed to :meth:`Telemetry.slice_by_lap`

        Returns:
            instance of :class:`Telemetry`
        " :arglists '[[self & [{:as kwargs}]]]} get_pos_data (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_pos_data"))))

(def ^{:doc "Built-in mutable sequence.

If no argument is given, the constructor creates a new empty list.
The argument must be an iterable if specified."} _metadata (as-jvm/generic-python-as-list (py-global-delay (py/get-attr @src-obj* "_metadata")))) 

(def ^{:doc ""} __module__ "fastf1.core")

(def ^{:doc "Return weather data for this lap.

        Weather data is updated once per minute. This means that there are
        usually one or two data points per lap. This function will always
        return only one data point:

            - The first value within the duration of a lap

        or

            - the last known value before the end of the lap if there are
              no values within the duration of a lap

        See :func:`fastf1.api.weather_data` for available data
        channels.

        If you wish to have more control over the data, you can access the
        weather data directly in :attr:`Session.weather_data`.

        Returns:
            pandas.Series

        .. doctest::

            >>> session = fastf1.get_session(2019, 'Monza', 'Q')
            >>> session.load(telemetry=False)
            >>> lap = session.laps.pick_fastest()
            >>> lap['LapStartTime']
            Timedelta('0 days 01:09:55.561000')
            >>> lap.get_weather_data()
            Time             0 days 01:10:15.292000
            AirTemp                            23.0
            Humidity                           51.9
            Pressure                          992.4
            Rainfall                          False
            TrackTemp                          37.8
            WindDirection                       166
            WindSpeed                           0.8
            Name: 70, dtype: object
        " :arglists '[[self]]} get_weather_data (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_weather_data"))))

(def ^{:doc ""} _constructor (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "_constructor"))))

(def ^{:doc ""} __doc__ "Object for accessing lap (timing) data of a single lap.

    This class wraps :class:`pandas.Series`. It provides extra functionality for accessing a lap's associated
    telemetry data.
    ")

(def ^{:doc "Car data for this lap

        Slices the car data in :attr:`Session.car_data` using this lap and returns the result.

        The data returned by this method does not contain computed telemetry channels. The can be added by calling the
        appropriate `add_*()` method on the returned telemetry object.

        Args:
            **kwargs: Keyword arguments are passed to :meth:`Telemetry.slice_by_lap`

        Returns:
            instance of :class:`Telemetry`
        " :arglists '[[self & [{:as kwargs}]]]} get_car_data (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_car_data"))))

(def ^{:doc "" :arglists '[[self & [args {:as kwargs}]]]} __init__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__init__"))))
