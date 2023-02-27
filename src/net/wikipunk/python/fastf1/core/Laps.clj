(ns net.wikipunk.python.fastf1.core.Laps
  "No documentation provided"
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.python.jvm-handle :refer [py-global-delay]]
            [libpython-clj2.python.bridge-as-jvm :as as-jvm])
  (:refer-clojure :exclude [+ - * / float double int long mod byte test char short take partition require max min identity empty mod repeat str load cast type sort conj map range list next hash eval bytes filter compile print set format compare reduce merge]))

(defonce ^:private src-obj* (py-global-delay (py/path->py-obj "fastf1.core.Laps")))

(def ^{:doc "Telemetry data for all laps in `self`

        This is a cached (!) property for :meth:`get_telemetry`. It will return the same value as `get_telemetry`
        but cache the result so that the involved processing is only done once.

        This is mainly provided for convenience and backwards compatibility.

        See :meth:`get_telemetry` for more information.

        .. note:: Telemetry can only be returned if `self` contains laps of one driver only.

        Returns:
            instance of :class:`Telemetry`"} telemetry (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "telemetry"))))

(def ^{:doc ""} _constructor_sliced (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "_constructor_sliced"))))

(def ^{:doc "Iterator for iterating over all laps in self.

        This method wraps :meth:`pandas.DataFrame.iterrows`.
        It additionally provides the `require` keyword argument.

        Args:
             require (optional, iterable): Require is a list of column/telemetry channel names. All names listed in
               `require` must exist in the data and have a non-null value (tested with :func:`pandas.is_null`). The
               iterator only yields laps for which this is true. If require is left empty, the iterator will yield
               all laps.
        Yields:
            (index, instance of :class:`Lap`)
        " :arglists '[[self & [{require :require}]] [self]]} iterlaps (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "iterlaps"))))

(def ^{:doc "Return all laps of a specific team in self based on the
        team's name ::

            mercedes = ff1.pick_team('Mercedes')
            alfa_romeo = ff1.pick_team('Alfa Romeo')

        Have a look to :attr:`fastf1.plotting.TEAM_COLORS` for a quick reference on team names.

        Args:
            name (str): Team name

        Returns:
            instance of :class:`Laps`
        " :arglists '[[self name]]} pick_team (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_team"))))

(def ^{:doc "For a nicer debugging experience; can now view as
        dataframe in various IDEs"} base_class_view (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "base_class_view"))))

(def ^{:doc "Telemetry data for all laps in `self`

        Telemetry data is the result of merging the returned data from :meth:`get_car_data` and :meth:`get_pos_data`.
        This means that telemetry data at least partially contains interpolated values! Telemetry data additionally
        already has computed channels added (e.g. Distance).

        This method is provided for convenience and compatibility reasons. But using it does usually not produce
        the most accurate possible result.
        It is recommended to use :meth:`get_car_data` or :meth:`get_pos_data` when possible. This is also faster if
        merging of car and position data is not necessary and if not all computed channels are needed.

        Resampling during merging is done according to the frequency set by :attr:`TELEMETRY_FREQUENCY`.

        .. note:: Telemetry can only be returned if `self` contains laps of one driver only.

        Returns:
            instance of :class:`Telemetry`
        " :arglists '[[self]]} get_telemetry (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_telemetry"))))

(def ^{:doc "Pos data for all laps in `self`

        Slices the position data in :attr:`Session.pos_data` using this set of laps and returns the result.

        .. note:: Position data can only be returned if `self` contains laps of one driver only.

        Args:
            **kwargs: Keyword arguments are passed to :meth:`Telemetry.slice_by_lap`

        Returns:
            instance of :class:`Telemetry`
        " :arglists '[[self & [{:as kwargs}]]]} get_pos_data (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_pos_data"))))

(def ^{:doc "Return all laps in self which were done on a specific compound.

        Args:
            compound (string): may be \"SOFT\", \"MEDIUM\", \"HARD\", \"INTERMEDIATE\" or \"WET\"

        Returns:
            instance of :class:`Laps`
        " :arglists '[[self compound]]} pick_tyre (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_tyre"))))

(def ^{:doc "Return the lap with the fastest lap time.

        This method will by default return the quickest lap out of self, that
        is also marked as personal best lap of a driver.

        If the quickest lap by lap time is not marked as personal best, this
        means that it was not counted. This can be the case for example, if
        the driver exceeded track limits and the lap time was deleted.

        If no lap is marked as personal best lap or self contains no laps,
        an empty Lap object will be returned.

        The check for personal best lap can be disabled, so that any quickest
        lap will be returned.

        Args:
            only_by_time (bool): Ignore whether any laps are marked as
                personal best laps and simply return the lap that has the
                lowest lap time.

        Returns:
            instance of :class:`Lap`
        " :arglists '[[self & [{only_by_time :only_by_time}]] [self]]} pick_fastest (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_fastest"))))

(def ^{:doc ""} QUICKLAP_THRESHOLD 1.07)

(def ^{:doc "Return all laps of the specified drivers in self based on the
        drivers' three letters identifier or based on the driver number. This
        is the same as :meth:`Laps.pick_driver` but for multiple drivers
        at once. ::

            some_drivers_laps = ff1.pick_drivers([5, 'BOT', 7])

        Args:
            identifiers (iterable): Multiple driver abbreviations or driver numbers (can be mixed)

        Returns:
            instance of :class:`Laps`
        " :arglists '[[self identifiers]]} pick_drivers (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_drivers"))))

(def ^{:doc "Built-in mutable sequence.

If no argument is given, the constructor creates a new empty list.
The argument must be an iterable if specified."} _metadata (as-jvm/generic-python-as-list (py-global-delay (py/get-attr @src-obj* "_metadata")))) 

(def ^{:doc "Return all laps which pass the accuracy validation check
        (lap['IsAccurate'] is True).

        Returns:
            instance of :class:`Laps`
        " :arglists '[[self]]} pick_accurate (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_accurate"))))

(def ^{:doc ""} __module__ "fastf1.core")

(def ^{:doc "Return all laps which are NOT in laps or out laps.

        Returns:
            instance of :class:`Laps`
        " :arglists '[[self]]} pick_wo_box (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_wo_box"))))

(def ^{:doc "Return all laps with `LapTime` faster than a certain limit. By
        default the threshold is 107% of the best `LapTime` of all laps
        in self.

        Args:
            threshold (optional, float): custom threshold coefficent
                (e.g. 1.05 for 105%)

        Returns:
            instance of :class:`Laps`
        " :arglists '[[self & [{threshold :threshold}]] [self]]} pick_quicklaps (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_quicklaps"))))

(def ^{:doc "Return weather data for each lap in self.

        Weather data is updated once per minute. This means that there are
        usually one or two data points per lap. This function will always
        return only one data point per lap:

           - The first value within the duration of a lap

        or

            - the last known value before the end of the lap if there are
              no values within the duration of a lap

        See :func:`fastf1.api.weather_data` for available data
        channels.

        If you wish to have more control over the data, you can access the
        weather data directly in :attr:`Session.weather_data`.

        Returns:
            pandas.DataFrame

        .. doctest::

            >>> session = fastf1.get_session(2019, 'Monza', 'Q')
            >>> session.load(telemetry=False)
            >>> weather_data = session.laps.get_weather_data()
            >>> print(weather_data)
                                 Time AirTemp Humidity  ... TrackTemp WindDirection WindSpeed
            20 0 days 00:20:14.613000    22.5     52.0  ...      35.8           212       2.0
            21 0 days 00:21:15.001000    22.5     52.2  ...      36.1           207       2.7
            23 0 days 00:23:14.854000    22.7     52.5  ...      37.4           210       2.3
            24 0 days 00:24:14.430000    23.2     51.5  ...      37.4           207       3.2
            26 0 days 00:26:14.315000    23.6     50.2  ...      37.2           238       1.8
            ..                    ...     ...      ...  ...       ...           ...       ...
            36 0 days 00:36:14.426000    23.0     51.1  ...      38.3           192       0.9
            37 0 days 00:37:14.391000    23.3     50.0  ...      38.7           213       0.9
            28 0 days 00:28:14.324000    23.5     49.9  ...      37.5           183       1.3
            34 0 days 00:34:14.385000    23.0     51.7  ...      37.7           272       0.8
            35 0 days 00:35:14.460000    23.2     50.3  ...      38.0           339       1.1
            <BLANKLINE>
            [275 rows x 8 columns]

        Joining weather data with lap timing data:

        .. doctest::

            >>> import pandas as pd  # needed additionally to fastf1

            # prepare the data for joining
            >>> laps = session.laps
            >>> laps = laps.reset_index(drop=True)
            >>> weather_data = weather_data.reset_index(drop=True)

            # exclude the 'Time' column from weather data when joining
            >>> joined = pd.concat([laps, weather_data.loc[:, ~(weather_data.columns == 'Time')]], axis=1)
            >>> print(joined)
                                  Time DriverNumber  ... WindDirection  WindSpeed
            0   0 days 00:21:01.358000           16  ...           212        2.0
            1   0 days 00:22:21.775000           16  ...           207        2.7
            2   0 days 00:24:03.991000           16  ...           210        2.3
            3   0 days 00:25:24.117000           16  ...           207        3.2
            4   0 days 00:27:09.461000           16  ...           238        1.8
            ..                     ...          ...  ...           ...        ...
            270 0 days 00:36:38.150000           88  ...           192        0.9
            271 0 days 00:38:37.508000           88  ...           213        0.9
            272 0 days 00:33:27.227000           33  ...           183        1.3
            273 0 days 00:35:05.865000           33  ...           272        0.8
            274 0 days 00:36:47.787000           33  ...           339        1.1
            <BLANKLINE>
            [275 rows x 33 columns]
        " :arglists '[[self]]} get_weather_data (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_weather_data"))))

(def ^{:doc "Return all laps of a specific driver in self based on the driver's
        three letters identifier or based on the driver number ::

            perez_laps = ff1.pick_driver('PER')
            bottas_laps = ff1.pick_driver(77)
            kimi_laps = ff1.pick_driver('RAI')

        Args:
            identifier (str or int): Driver abbreviation or number

        Returns:
            instance of :class:`Laps`
        " :arglists '[[self identifier]]} pick_driver (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_driver"))))

(def ^{:doc ""} _constructor (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "_constructor"))))

(def ^{:doc "Return all laps of the specified teams in self based on the teams'
        name. This is the same as :meth:`Laps.pick_team` but for multiple
        teams at once. ::

            some_drivers_laps = ff1.pick_teams(['Mercedes', 'Williams'])

        Args:
            names (iterable): Multiple team names

        Returns:
            instance of :class:`Laps`
        " :arglists '[[self names]]} pick_teams (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_teams"))))

(def ^{:doc ""} __doc__ "Object for accessing lap (timing) data of multiple laps.

    Args:
        *args (any): passed through to :class:`pandas.DataFrame` super class
        session (:class:`Session`): instance of session class; required for
          full functionality
        **kwargs (any): passed through to :class:`pandas.DataFrame`
          super class

    This class allows for easily picking specific laps from all laps in a
    session. It implements some additional functionality on top off the usual
    `pandas.DataFrame` functionality. Among others, the laps' associated
    telemetry data can be accessed.

    If for example you want to get the fastest lap of Bottas you can narrow
    it down like this::

        import fastf1

        session = fastf1.get_session(2019, 'Bahrain', 'Q')
        session.load()
        best_bottas = session.laps.pick_driver('BOT').pick_fastest()

        print(best_bottas['LapTime'])
        # Timedelta('0 days 00:01:28.256000')

    Slicing this class will return :class:`Laps` again for slices containing
    multiple rows. Single rows will be returned as :class:`Lap`.

    The following information is available per lap (one DataFrame column
    for each):

        - **Time** (pandas.Timedelta): Session time when the lap time was
          set (end of lap)
        - **Driver** (string): Three letter driver identifier
        - **DriverNumber** (str): Driver number
        - **LapTime** (pandas.Timedelta): Recorded lap time.
          Officially deleted lap times will *not* be deleted here.
          Deleting laps is currently not supported.
        - **LapNumber** (int): Recorded lap number
        - **Stint** (int): Stint number
        - **PitOutTime** (pandas.Timedelta): Session time when car exited
          the pit
        - **PitInTime** (pandas.Timedelta): Session time when car entered
          the pit
        - **Sector1Time** (pandas.Timedelta): Sector 1 recorded time
        - **Sector2Time** (pandas.Timedelta): Sector 2 recorded time
        - **Sector3Time** (pandas.Timedelta): Sector 3 recorded time
        - **Sector1SessionTime** (pandas.Timedelta): Session time when the
          Sector 1 time was set
        - **Sector2SessionTime** (pandas.Timedelta): Session time when the
          Sector 2 time was set
        - **Sector3SessionTime** (pandas.Timedelta): Session time when the
          Sector 3 time was set
        - **SpeedI1** (float): Speedtrap sector 1 [km/h]
        - **SpeedI2** (float): Speedtrap sector 2 [km/h]
        - **SpeedFL** (float): Speedtrap at finish line [km/h]
        - **SpeedST** (float): Speedtrap on longest straight (Not sure) [km/h]
        - **IsPersonalBest** (bool): Flag that indicates whether this lap is
          the official personal best lap of a driver. If any lap of a driver
          is quicker than their respective personal best lap, this means that
          the quicker lap is invalid and not counted. This can happen it the
          track limits were execeeded, for example.
        - **Compound** (str): Tyres event specific compound name: SOFT, MEDIUM,
          HARD, INTERMEDIATE, WET (the actual underlying compounds C1 to C5 are
          not differentiated).
        - **TyreLife** (float): Laps driven on this tire (includes laps in
          other sessions for used sets of tires)
        - **FreshTyre** (bool): Tyre had TyreLife=0 at stint start, i.e.
          was a new tire
        - **Team** (str): Team name
        - **LapStartTime** (pandas.Timedelta): Session time at the start of
          the lap
        - **LapStartDate** (pandas.Timestamp): Timestamp at the start of
          the lap
        - **TrackStatus** (str): A string that contains track status numbers
          for all track status that occurred
          during this lap. The meaning of the track status numbers is
          explained in :func:`fastf1.api.track_status_data`.
          For filtering laps by track status, you may want to use
          :func:`Laps.pick_track_status`.
        - **IsAccurate** (bool): Indicates that the lap start and end time are
          synced correctly with other laps. Do not confuse this with the
          accuracy of the lap time or sector times. They are always considered
          to be accurate if they exist!
          If this value is True, the lap has passed as basic accuracy check
          for timing data. This does not guarantee accuracy but laps marked
          as inaccurate need to be handled with caution. They might contain
          errors which can not be spotted easily.
          Laps need to satisfy the following criteria to be marked
          as accurate:

            - not an inlap or outlap
            - set under green or yellow flag (the api sometimes has issues
              with data from SC/VSC laps)
            - is not the first lap after a safety car period
              (issues with SC/VSC might still appear on the first lap
              after it has ended)
            - has a value for lap time and all sector times
            - the sum of the sector times matches the lap time
              (If this were to ever occur, it would also be logged separately
              as a data integrity error. You usually don't need to worry about
              this.)
    ")

(def ^{:doc "Car data for all laps in `self`

        Slices the car data in :attr:`Session.car_data` using this set of laps and returns the result.

        The data returned by this method does not contain computed telemetry channels. The can be added by calling the
        appropriate `add_*()` method on the returned telemetry object..

        .. note:: Car data can only be returned if `self` contains laps of one driver only.

        Args:
            **kwargs: Keyword arguments are passed to :meth:`Telemetry.slice_by_lap`

        Returns:
            instance of :class:`Telemetry`
        " :arglists '[[self & [{:as kwargs}]]]} get_car_data (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_car_data"))))

(def ^{:doc "" :arglists '[[self & [args {session :session, :as kwargs}]]]} __init__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__init__"))))

(def ^{:doc "Return all laps set under a specific track status.

        Args:
            status (str): The track status as a string, e.g. '1'
            how (str): one of 'equals'/'contains'
                For example, if how='equals', status='2' will only match '2'.
                If how='contains', status='2' will also match '267' and similar
        Returns:
            instance of :class:`Laps`
        " :arglists '[[self status & [{how :how}]] [self status]]} pick_track_status (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "pick_track_status"))))
