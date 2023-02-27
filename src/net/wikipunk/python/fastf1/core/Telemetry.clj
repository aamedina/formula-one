(ns net.wikipunk.python.fastf1.core.Telemetry
  "No documentation provided"
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.python.jvm-handle :refer [py-global-delay]]
            [libpython-clj2.python.bridge-as-jvm :as as-jvm])
  (:refer-clojure :exclude [+ - * / float double int long mod byte test char short take partition require max min identity empty mod repeat str load cast type sort conj map range list next hash eval bytes filter compile print set format compare reduce merge]))

(defonce ^:private src-obj* (py-global-delay (py/path->py-obj "fastf1.core.Telemetry")))
(def ^{:doc "dict() -> new empty dictionary
dict(mapping) -> new dictionary initialized from a mapping object's
    (key, value) pairs
dict(iterable) -> new dictionary initialized as if via:
    d = {}
    for k, v in iterable:
        d[k] = v
dict(**kwargs) -> new dictionary initialized with the name=value pairs
    in the keyword argument list.  For example:  dict(one=1, two=2)"} _CHANNELS (as-jvm/generic-python-as-map (py-global-delay (py/get-attr @src-obj* "_CHANNELS")))) 

(def ^{:doc "Add column 'DifferentialDistance' to self.

        This column contains the distance driven between subsequent samples.

        Calls :meth:`calculate_differential_distance` and joins the result
        with self.

        Args:
            drop_existing (bool): Drop and recalculate column if it already exists
        Returns:
            :class:`Telemetry`: self joined with new column or self if column exists and `drop_existing` is False.
        " :arglists '[[self & [{drop_existing :drop_existing}]] [self]]} add_differential_distance (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "add_differential_distance"))))

(def ^{:doc "For a nicer debugging experience; can view DataFrame through this property in various IDEs"} base_class_view (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "base_class_view"))))

(def ^{:doc "Return the first index at which the 'Time' value is not zero or NA/NaT" :arglists '[[self]]} get_first_non_zero_time_index (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_first_non_zero_time_index"))))

(def ^{:doc "Calculate the distance between subsequent samples of self.

        Distance is in meters

        Returns:
            :class:`pandas.Series`
        " :arglists '[[self]]} calculate_differential_distance (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "calculate_differential_distance"))))

(def ^{:doc "Built-in mutable sequence.

If no argument is given, the constructor creates a new empty list.
The argument must be an iterable if specified."} _metadata (as-jvm/generic-python-as-list (py-global-delay (py/get-attr @src-obj* "_metadata")))) 

(def ^{:doc "Merge telemetry objects containing different telemetry channels.

        The two objects don't need to have a common time base. The data will be merged, optionally resampled and
        missing values will be interpolated.

        :attr:`Telemetry.TELEMETRY_FREQUENCY` determines if and how the data is resampled. This can be overridden using
        the `frequency` keyword fo this method.

        Merging and resampling:

            If the frequency is 'original', data will not be resampled. The two objects will be merged and all
            timestamps of both objects are kept. Values will be interpolated so that all telemetry channels contain
            valid data for all timestamps. This is the default and recommended option.

            If the frequency is specified as an integer in Hz the data will be merged as before. After that, the merged
            time base will be resampled from the first value on at the specified frequency. Afterwards, the data will
            be interpolated to fit the new time base. This means that usually most if not all values of the data will
            be interpolated values. This is detrimental for overall accuracy.

        Interpolation:

            Missing values after merging will be interpolated for all known telemetry channels using
            :meth:`fill_missing`. Different interpolation methods are used depending on what kind of data the channel
            contains. For example, forward fill is used to interpolated 'nGear' while linear interpolation is used
            for 'RPM' interpolation.

        .. note :: Unknown telemetry channels will be merged but missing values will not be interpolated. This can
            either be done manually or a custom telemetry channel can be added using :meth:`register_new_channel`.

        .. note :: Do not resample data multiple times. Always resample based on the original data
            to preserve accuracy

        Args:
            other (:class:`Telemetry` or :class:`pandas.DataFrame`): Object to be merged with self
            frequency (str or int): Optional frequency to overwrite global preset. (Either string 'original' or integer
                for a frequency in Hz)

        Returns:
            :class:`Telemetry`
        " :arglists '[[self other & [{frequency :frequency}]] [self other]]} merge_channels (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "merge_channels"))))

(def ^{:doc "Slice self to only include data in a specific time frame.

        .. note:: Self needs to contain a 'SessionTime' column. Slicing by time use the 'SessionTime' as its reference.

        Args:
            start_time (Timedelta): Start of the section
            end_time (Timedelta): End of the section
            pad (int): Number of samples used for padding the sliced data
            pad_side (str): Where to pad the data; possible options: 'both', 'before', 'after
            interpolate_edges (bool): Add an interpolated sample at the beginning and end to exactly
                match the provided time window.

        Returns:
            :class:`Telemetry`
        " :arglists '[[self start_time end_time & [{pad :pad, pad_side :pad_side, interpolate_edges :interpolate_edges}]] [self start_time end_time & [{pad :pad, pad_side :pad_side}]] [self start_time end_time & [{pad :pad}]] [self start_time end_time]]} slice_by_time (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "slice_by_time"))))

(def ^{:doc ""} __module__ "fastf1.core")

(def ^{:doc "Calculate driver ahead and distance to driver ahead.

        Driver ahead: Driver number of the driver ahead as string
        Distance to driver ahead: Distance to the car ahead in meters

        .. note:: This gives a smoother/cleaner result than the legacy implementation but WILL introduce
            integration error when used over long distances (more than one or two laps may sometimes be considered
            a long distance). If in doubt, do sanity checks (against the legacy version or in another way).

        Args:
            return_reference (bool): Additionally return the reference
                telemetry data slice that is used to calculate the new data.

        Returns:
            driver ahead (numpy.array), distance to driver ahead (numpy.array),
            [reference telemetry (optional, :class:`Telemetry`)]
        " :arglists '[[self & [{return_reference :return_reference}]] [self]]} calculate_driver_ahead (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "calculate_driver_ahead"))))

(def ^{:doc "Slice self using a boolean array as a mask.

        Args:
            mask (array-like): Array of boolean values with the same length as self
            pad (int): Number of samples used for padding the sliced data
            pad_side (str): Where to pad the data; possible options: 'both', 'before', 'after'

        Returns:
            :class:`Telemetry`
        " :arglists '[[self mask & [{pad :pad, pad_side :pad_side}]] [self mask & [{pad :pad}]] [self mask]]} slice_by_mask (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "slice_by_mask"))))

(def ^{:doc "Resample telemetry data.

        Convenience method for frequency conversion and resampling. Up and down sampling of data is supported.
        'Date' and 'SessionTime' need to exist in the data. 'Date' is used as the main time reference.

        There are two ways to use this method:

            - Usage like :meth:`pandas.DataFrame.resample`: In this case you need to specify the 'rule' for resampling
              and any additional keywords will be passed on to :meth:`pandas.Series.resample` to create a new time
              reference. See the pandas method to see which options are available.

            - using the 'new_date_ref' keyword a :class:`pandas.Series` containing new values for date
              (dtype :class:`pandas.Timestamp`) can be provided. The existing data will be resampled onto this new
              time reference.

        Args:
            rule (optional, str): Resampling rule for :meth:`pandas.Series.resample`
            new_date_ref (optional, pandas.Series): New custom Series of reference dates
            **kwargs (optional, any): Only in combination with 'rule'; additional parameters for
                :meth:`pandas.Series.resample`
        " :arglists '[[self & [{rule :rule, new_date_ref :new_date_ref, :as kwargs}]] [self & [{rule :rule, :as kwargs}]] [self & [{:as kwargs}]]]} resample_channels (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "resample_channels"))))

(def ^{:doc "Register a custom telemetry channel.

        Registered telemetry channels are automatically interpolated when merging or resampling data.

        Args:
            name (str): Telemetry channel/column name
            signal_type (str): One of three possible signal types:
                - 'continuous': Speed, RPM, Distance, ...
                - 'discrete': DRS, nGear, status values, ...
                - 'excluded': Data channel will be ignored during resampling
            interpolation_method (optional, str): The interpolation method
                which should be used. Can only be specified and is required
                in combination with ``signal_type='continuous'``. See
                :meth:`pandas.Series.interpolate` for possible interpolation
                methods.
        "} register_new_channel (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "register_new_channel"))))

(def ^{:doc "Wraps :mod:`pandas.DataFrame.join` and adds metadata propagation.

        When calling `self.join` metadata will be propagated from self to the joined dataframe.
        " :arglists '[[self & [args {:as kwargs}]]]} join (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "join"))))

(def ^{:doc ""} _constructor (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "_constructor"))))

(def ^{:doc "Add column 'DriverAhead' and 'DistanceToDriverAhead' to self.

        DriverAhead: Driver number of the driver ahead as string
        DistanceToDriverAhead: Distance to next car ahead in meters

        .. note:: Cars in the pit lane are currently not excluded from the data. They will show up when overtaken on
            pit straight even if they're not technically in front of the car. A fix for this is TBD with other
            improvements.

        This should only be applied to data of single laps or few laps at a time to reduce integration error.
        For longer time spans it should be applied per lap and the laps
        should be merged afterwards.
        If you absolutely need to apply it to a whole session, use the legacy implementation. Note that data of
        the legacy implementation will be considerably less smooth. (see :mod:`fastf1.legacy`)

        Calls :meth:`calculate_driver_ahead` and joins the result with self.

        Args:
            drop_existing (bool): Drop and recalculate column if it already exists
        Returns:
            :class:`Telemetry`: self joined with new column or self if column exists and `drop_existing` is False.
        " :arglists '[[self & [{drop_existing :drop_existing}]] [self]]} add_driver_ahead (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "add_driver_ahead"))))

(def ^{:doc ""} TELEMETRY_FREQUENCY "original")

(def ^{:doc "Add column 'RelativeDistance' to self.

        This column contains the distance driven since the first sample as
        a floating point number where ``0.0`` is the first sample of self
        and ``1.0`` is the last sample.

        This is calculated the same way as 'Distance' (see: :meth:`add_distance`). The same warnings apply.

        Args:
            drop_existing (bool): Drop and recalculate column if it already exists
        Returns:
            :class:`Telemetry`: self joined with new column or self if column exists and `drop_existing` is False.
        " :arglists '[[self & [{drop_existing :drop_existing}]] [self]]} add_relative_distance (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "add_relative_distance"))))

(def ^{:doc "Slice self to only include data from the provided lap or laps.

        .. note:: Self needs to contain a 'SessionTime' column.

        .. note:: When slicing with an instance of :class:`Laps` as a reference, the data will be sliced by first and
            last lap. Missing laps in between will not be considered and data for these will still be included in
            the sliced result.

        Args:
            ref_laps (Lap or Laps): The lap/laps by which to slice self
            pad (int): Number of samples used for padding the sliced data
            pad_side (str): Where to pad the data; possible options: 'both', 'before', 'after
            interpolate_edges (bool): Add an interpolated sample at the beginning and end to exactly
                match the provided time window.

        Returns:
            :class:`Telemetry`
        " :arglists '[[self ref_laps & [{pad :pad, pad_side :pad_side, interpolate_edges :interpolate_edges}]] [self ref_laps & [{pad :pad, pad_side :pad_side}]] [self ref_laps & [{pad :pad}]] [self ref_laps]]} slice_by_lap (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "slice_by_lap"))))

(def ^{:doc ""} __doc__ "Multi-channel time series telemetry data

    The object can contain multiple telemetry channels. Multiple telemetry
    objects with different channels can be merged on time. Each telemetry
    channel is one dataframe column. Partial telemetry (e.g. for one lap only)
    can be obtained through various methods for slicing the data. Additionally,
    methods for adding common computed data channels are available.

    The following telemetry channels existed in the original API data:

        - **Car data**:
            - `Speed` (float): Car speed [km/h]
            - `RPM` (int): Car RPM
            - `nGear` (int): Car gear number
            - `Throttle` (float): 0-100 Throttle pedal pressure [%]
            - `Brake` (bool): Brakes are applied or not.
            - `DRS` (int): DRS indicator (See :func:`fastf1.api.car_data`
              for more info)

        - **Position data**:
            - `X` (float): X position [1/10 m]
            - `Y` (float): Y position [1/10 m]
            - `Z` (float): Z position [1/10 m]
            - `Status` (string): Flag - OffTrack/OnTrack

        - **For both of the above**:
            - `Time` (timedelta): Time (0 is start of the data slice)
            - `SessionTime` (timedelta): Time elapsed since the start of the
              session
            - `Date` (datetime): The full date + time at which this sample
              was created
            - `Source` (str): Flag indicating how this sample was created:

                - 'car': sample from original api car data
                - 'pos': sample from original api position data
                - 'interpolated': this sample was artificially created; all
                  values are computed/interpolated

                Example:
                    A sample's source is indicated as 'car'. It contains
                    values for speed, rpm and x, y, z coordinates.
                    Originally, this sample (with its timestamp) was received
                    when loading car data.
                    This means that the speed and rpm value are original
                    values as received from the api. The coordinates are
                    interpolated for this sample.

                    All methods of :class:`Telemetry` which resample or
                    interpolate data will preserve and adjust the source flag
                    correctly when modifying data.

        Through merging/slicing it is possible to obtain any combination of
        telemetry channels!
        The following additional computed data channels can be added:

            - Distance driven between two samples:
              :meth:`add_differential_distance`
            - Distance driven since the first sample:
              :meth:`add_distance`
            - Relative distance driven since the first sample:
              :meth:`add_relative_distance`
            - Distance to driver ahead and car number of said driver:
              :meth:`add_driver_ahead`

        .. note:: See the separate explanation concerning the various
          definitions of 'Time' for more information on the three date and
          time related channels: :ref:`time-explanation`

    Slicing this class will return :class:`Telemetry` again for slices
    containing multiple rows. Single rows will be returned as
    :class:`pandas.Series`.

    Args:
        *args (any): passed through to `pandas.DataFrame` superclass
        session (:class:`Session`): Instance of associated session object.
            Required for full functionality!
        driver (str): Driver number as string. Required for full functionality!
        **kwargs (any): passed through to `pandas.DataFrame` superclass
    ")

(def ^{:doc "Add column 'Distance' to self.

        This column contains the distance driven since the first sample of self in meters.

        The data is produced by integrating the differential distance between subsequent laps.
        You should not apply this function to telemetry of many laps simultaneously to reduce integration error.
        Instead apply it only to single laps or few laps at a time!

        Calls :meth:`integrate_distance` and joins the result with self.

        Args:
            drop_existing (bool): Drop and recalculate column if it already exists
        Returns:
            :class:`Telemetry`: self joined with new column or self if column exists and `drop_existing` is False.
        " :arglists '[[self & [{drop_existing :drop_existing}]] [self]]} add_distance (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "add_distance"))))

(def ^{:doc "Return the distance driven since the first sample of self.

        Distance is in meters. The data is produce by integration. Integration error will stack up when used for
        long slices of data. This should therefore only be used for data of single laps or few laps at a time.

        Returns:
            :class:`pd.Series`
        " :arglists '[[self]]} integrate_distance (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "integrate_distance"))))

(def ^{:doc "Wraps :mod:`pandas.DataFrame.merge` and adds metadata propagation.

        When calling `self.merge` metadata will be propagated from self to the merged dataframe.
        " :arglists '[[self & [args {:as kwargs}]]]} merge (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "merge"))))

(def ^{:doc "" :arglists '[[self & [args {session :session, driver :driver, drop_unknown_channels :drop_unknown_channels, :as kwargs}]]]} __init__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__init__"))))

(def ^{:doc "Calculate missing values in self.

        Only known telemetry channels will be interpolated. Unknown channels are skipped and returned unmodified.
        Interpolation will be done according to the default mapping and according to options specified for
        registered custom channels. For example:
        | Linear interpolation will be used for continuous values (Speed, RPM)
        | Forward-fill will be used for discrete values (Gear, DRS, ...)

        See :meth:`register_new_channel` for adding custom channels.
        " :arglists '[[self]]} fill_missing (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "fill_missing"))))
