(ns net.wikipunk.python.fastf1.core
  "
  .. _GeneralFunctions:

  General Functions - :mod:`fastf1`
  =================================

  .. currentmodule:: fastf1


  Accessing Events and Sessions
  -----------------------------

  When using FastF1, you usually start by loading an event or a
  session. This can be done with one of the following functions:

  .. autosummary::
    fastf1.get_session
    fastf1.get_testing_session
    fastf1.get_event
    fastf1.get_events_remaining
    fastf1.get_testing_session
    fastf1.get_event_schedule


  Caching
  -------

  Caching should almost always be enabled to speed up the runtime of your
  scripts and to prevent exceeding the rate limit of api servers.
  FastF1 will print an annoyingly obnoxious warning message if you do not
  enable caching.

  The following class-level functions are used to setup, enable and
  (temporarily) disable caching.

  .. autosummary::
    fastf1.Cache.enable_cache
    fastf1.Cache.clear_cache
    fastf1.Cache.disabled
    fastf1.Cache.set_disabled
    fastf1.Cache.set_enabled


  General Functions - API Reference
  ---------------------------------

  Events API
  ..........

  .. autofunction:: get_session
  .. autofunction:: get_testing_session
  .. autofunction:: get_event
  .. autofunction:: get_events_remaining
  .. autofunction:: get_testing_event
  .. autofunction:: get_event_schedule

  Cache API
  .........

  .. autoclass:: Cache
    :members: enable_cache, clear_cache, disabled, set_disabled, set_enabled
    :autosummary:

  "
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.python.jvm-handle :refer [py-global-delay]]
            [libpython-clj2.python.bridge-as-jvm :as as-jvm])
  (:refer-clojure :exclude [+ - * / float double int long mod byte test char short take partition require max min identity empty mod repeat str load cast type sort conj map range list next hash eval bytes filter compile print set format compare reduce merge]))

(defonce ^:private src-obj* (py-global-delay (py/path->py-obj "fastf1.core")))

(def ^{:doc "
Logging package for Python. Based on PEP 282 and comments thereto in
comp.lang.python.

Copyright (C) 2001-2019 Vinay Sajip. All Rights Reserved.

To use, simply 'import logging' and log away!
"} logging (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "logging"))))

(def ^{:doc "This class provides driver and result information for all drivers that
    participated in a session.

    This class subclasses a :class:`pandas.DataFrame` and the usual methods
    provided by pandas can be used to work with the data.

    **All dataframe columns will always exist even if they are not relevant
    for the current session!**

    The following information is provided for each driver as a column of the
    dataframe:

        - ``DriverNumber`` | :class:`str` |
          The number associated with this driver in this session (usually the
          drivers permanent number)

        - ``BroadcastName`` | :class:`str` |
          First letter of the drivers first name plus the drivers full last name
          in all capital letters. (e.g. 'P GASLY')

        - ``FullName`` | :class:`str` |
          The drivers full name (e.g. \"Pierre Gasly\")

        - ``Abbreviation`` | :class:`str` |
          The drivers three letter abbreviation (e.g. \"GAS\")

        - ``TeamName`` | :class:`str` |
          The team name (short version without title sponsors)

        - ``TeamColor`` | :class:`str` |
          The color commonly associated with this team (hex value)

        - ``FirstName`` | :class:`str` |
          The drivers first name

        - ``LastName`` | :class:`str` |
          The drivers last name

        - ``Position`` | :class:`float` |
          The drivers finishing position (values only given if session is
          'Race', 'Qualifying' or 'Sprint Qualifying')

        - ``GridPosition`` | :class:`float` |
          The drivers starting position (values only given if session is
          'Race' or 'Sprint Qualifying')

        - ``Q1`` | :class:`pd.Timedelta` |
          The drivers best Q1 time (values only given if session is
          'Qualifying')

        - ``Q2`` | :class:`pd.Timedelta` |
          The drivers best Q2 time (values only given if session is
          'Qualifying')

        - ``Q3`` | :class:`pd.Timedelta` |
          The drivers best Q3 time (values only given if session is
          'Qualifying')

        - ``Time`` | :class:`pd.Timedelta` |
          The drivers total race time (values only given if session is
          'Race' or 'Sprint Qualifying' and the driver was not more than one
          lap behind the leader)

        - ``Status`` | :class:`str` |
          A status message to indicate if and how the driver finished the race
          or to indicate the cause of a DNF. Possible values include but are
          not limited to 'Finished', '+ 1 Lap', 'Crash', 'Gearbox', ...
          (values only given if session is 'Race' or 'Sprint Qualifying')

        - ``Status`` | :class:`float` |
          The number of points received by each driver for their finishing
          result.

    By default, the session results are indexed by driver number and sorted by
    finishing position.

    .. note:: This class is usually not instantiated directly. You should
        create a session and access the session result through the
        :attr:`Session.results` property.

    Args:
        *args: passed on to :class:`pandas.DataFrame` superclass
        force_default_cols (bool): Enforce that all default columns and only
            the default columns exist
        **kwargs: passed on to :class:`pandas.DataFrame` superclass
            (except 'columns' which is unsupported for this object)

    .. versionadded:: 2.2
    " :arglists '[[self & [args {force_default_cols :force_default_cols, :as kwargs}]]]} SessionResults (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "SessionResults"))))

(def ^{:doc ""} ergast (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "ergast"))))
(def ^{:doc "dict() -> new empty dictionary
dict(mapping) -> new dictionary initialized from a mapping object's
    (key, value) pairs
dict(iterable) -> new dictionary initialized as if via:
    d = {}
    for k, v in iterable:
        d[k] = v
dict(**kwargs) -> new dictionary initialized with the name=value pairs
    in the keyword argument list.  For example:  dict(one=1, two=2)"} __warningregistry__ (as-jvm/generic-python-as-map (py-global-delay (py/get-attr @src-obj* "__warningregistry__")))) 

(def ^{:doc                               "Recursive dict get. Can take an arbitrary number of keys and returns an empty
    dict if any key does not exist.
    https://stackoverflow.com/a/28225747" :arglists '[[d & [keys {default_none :default_none}]]]} recursive_dict_get (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "recursive_dict_get"))))

(def ^{:doc "Concrete implementation of SourceLoader using the file system."} __loader__ (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "__loader__"))))

(def ^{:doc "
pandas - a powerful data analysis and manipulation library for Python
=====================================================================

**pandas** is a Python package providing fast, flexible, and expressive data
structures designed to make working with \"relational\" or \"labeled\" data both
easy and intuitive. It aims to be the fundamental high-level building block for
doing practical, **real world** data analysis in Python. Additionally, it has
the broader goal of becoming **the most powerful and flexible open source data
analysis / manipulation tool available in any language**. It is already well on
its way toward this goal.

Main Features
-------------
Here are just a few of the things that pandas does well:

  - Easy handling of missing data in floating point as well as non-floating
    point data.
  - Size mutability: columns can be inserted and deleted from DataFrame and
    higher dimensional objects
  - Automatic and explicit data alignment: objects can be explicitly aligned
    to a set of labels, or the user can simply ignore the labels and let
    `Series`, `DataFrame`, etc. automatically align the data for you in
    computations.
  - Powerful, flexible group by functionality to perform split-apply-combine
    operations on data sets, for both aggregating and transforming data.
  - Make it easy to convert ragged, differently-indexed data in other Python
    and NumPy data structures into DataFrame objects.
  - Intelligent label-based slicing, fancy indexing, and subsetting of large
    data sets.
  - Intuitive merging and joining data sets.
  - Flexible reshaping and pivoting of data sets.
  - Hierarchical labeling of axes (possible to have multiple labels per tick).
  - Robust IO tools for loading data from flat files (CSV and delimited),
    Excel files, databases, and saving/loading data from the ultrafast HDF5
    format.
  - Time series-specific functionality: date range generation and frequency
    conversion, moving window statistics, date shifting and lagging.
"} pd (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "pd"))))

(def ^{:doc "Raised if an attempt is made to access data that has not been loaded
    yet."   :arglists '[[self & [args {:as kwargs}]]]} DataNotLoadedError (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "DataNotLoadedError"))))

(def ^{:doc "Fast timedelta object creation from a time string

    Permissible string formats:

        For example: `13:24:46.320215` with:

            - optional hours and minutes
            - optional microseconds and milliseconds with
              arbitrary precision (1 to 6 digits)

        Examples of valid formats:

            - `24.3564` (seconds + milli/microseconds)
            - `36:54` (minutes + seconds)
            - `8:45:46` (hours, minutes, seconds)

    Args:
        x (str or timedelta):
    Returns:
        datetime.timedelta
    " :arglists '[[x]]} to_timedelta (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "to_timedelta"))))

(def ^{:doc "Object for accessing lap (timing) data of multiple laps.

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
    " :arglists '[[self & [args {session :session, :as kwargs}]]]} Laps (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "Laps"))))

(def ^{:doc ""} __file__ "/home/adrian/.local/lib/python3.10/site-packages/fastf1/core.py")

(def ^{:doc "This module implements specialized container datatypes providing
alternatives to Python's general purpose built-in containers, dict,
list, set, and tuple.

* namedtuple   factory function for creating tuple subclasses with named fields
* deque        list-like container with fast appends and pops on either end
* ChainMap     dict-like class for creating a single view of multiple mappings
* Counter      dict subclass for counting hashable objects
* OrderedDict  dict subclass that remembers the order entries were added
* defaultdict  dict subclass that calls a factory function to supply missing values
* UserDict     wrapper around dictionary objects for easier dict subclassing
* UserList     wrapper around list objects for easier list subclassing
* UserString   wrapper around string objects for easier string subclassing

"} collections (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "collections"))))

(def ^{:doc "
    .. deprecated:: 2.2
        replaced by :func:`fastf1.get_session`
    "       :arglists '[[& [args {:as kwargs}]]]} get_session (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_session"))))

(def ^{:doc "Built-in mutable sequence.

If no argument is given, the constructor creates a new empty list.
The argument must be an iterable if specified."} D_LOOKUP (as-jvm/generic-python-as-list (py-global-delay (py/get-attr @src-obj* "D_LOOKUP")))) 

(def ^{:doc "The specification for a module, used for loading.

    A module's spec is the source for information about the module.  For
    data associated with the module, including source, use the spec's
    loader.

    `name` is the absolute name of the module.  `loader` is the loader
    to use when loading the module.  `parent` is the name of the
    package the module is in.  The parent is derived from the name.

    `is_package` determines if the module is considered a package or
    not.  On modules this is reflected by the `__path__` attribute.

    `origin` is the specific location used by the loader from which to
    load the module, if that information is available.  When filename is
    set, origin will match.

    `has_location` indicates that a spec's \"origin\" reflects a location.
    When this is True, `__file__` attribute of the module is set.

    `cached` is the location of the cached bytecode file, if any.  It
    corresponds to the `__cached__` attribute.

    `submodule_search_locations` is the sequence of path entries to
    search when importing submodules.  If set, is_package should be
    True--and False otherwise.

    Packages are simply modules that (may) have submodules.  If a spec
    has a non-None value in `submodule_search_locations`, the import
    system will consider modules loaded from the spec as packages.

    Only finders (see importlib.abc.MetaPathFinder and
    importlib.abc.PathEntryFinder) should modify ModuleSpec instances.

    "} __spec__ (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "__spec__"))))

(def ^{:doc "This class provides driver and result information for a single driver.

    This class subclasses a :class:`pandas.Series` and the usual methods
    provided by pandas can be used to work with the data.

    For information on which data is available, see :class:`SessionResult`.

    .. note:: This class is usually not instantiated directly. You should
        create a session and access the driver result through
        :func:`Session.get_driver` or by slicing the session result.

    Args:
        *args: passed on to :class:`pandas.Series` superclass
        **kwargs: passed on to :class:`pandas.Series` superclass

    .. versionadded:: 2.2
    " :arglists '[[self & [args {:as kwargs}]]]} DriverResult (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "DriverResult"))))

(def ^{:doc        "Raised if no session for the specified event name, type and year
    can be found." :arglists '[[self & [args]]]} InvalidSessionError (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "InvalidSessionError"))))

(def ^{:doc "
    .. deprecated:: 2.2
        Use :class:`fastf1.events.Event` instead
    "       :arglists '[[self & [args {:as kwargs}]]]} Weekend (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "Weekend"))))

(def ^{:doc "
NumPy
=====

Provides
  1. An array object of arbitrary homogeneous items
  2. Fast mathematical operations over arrays
  3. Linear Algebra, Fourier Transforms, Random Number Generation

How to use the documentation
----------------------------
Documentation is available in two forms: docstrings provided
with the code, and a loose standing reference guide, available from
`the NumPy homepage <https://numpy.org>`_.

We recommend exploring the docstrings using
`IPython <https://ipython.org>`_, an advanced Python shell with
TAB-completion and introspection capabilities.  See below for further
instructions.

The docstring examples assume that `numpy` has been imported as ``np``::

  >>> import numpy as np

Code snippets are indicated by three greater-than signs::

  >>> x = 42
  >>> x = x + 1

Use the built-in ``help`` function to view a function's docstring::

  >>> help(np.sort)
  ... # doctest: +SKIP

For some objects, ``np.info(obj)`` may provide additional help.  This is
particularly true if you see the line \"Help on ufunc object:\" at the top
of the help() page.  Ufuncs are implemented in C, not Python, for speed.
The native Python help() does not know how to view their help, but our
np.info() function does.

To search for documents containing a keyword, do::

  >>> np.lookfor('keyword')
  ... # doctest: +SKIP

General-purpose documents like a glossary and help on the basic concepts
of numpy are available under the ``doc`` sub-module::

  >>> from numpy import doc
  >>> help(doc)
  ... # doctest: +SKIP

Available subpackages
---------------------
lib
    Basic functions used by several sub-packages.
random
    Core Random Tools
linalg
    Core Linear Algebra Tools
fft
    Core FFT routines
polynomial
    Polynomial tools
testing
    NumPy testing tools
distutils
    Enhancements to distutils with support for
    Fortran compilers support and more.

Utilities
---------
test
    Run numpy unittests
show_config
    Show numpy build configuration
dual
    Overwrite certain functions with high-performance SciPy tools.
    Note: `numpy.dual` is deprecated.  Use the functions from NumPy or Scipy
    directly instead of importing them from `numpy.dual`.
matlib
    Make everything matrices.
__version__
    NumPy version string

Viewing documentation using IPython
-----------------------------------

Start IPython and import `numpy` usually under the alias ``np``: `import
numpy as np`.  Then, directly past or use the ``%cpaste`` magic to paste
examples into the shell.  To see which functions are available in `numpy`,
type ``np.<TAB>`` (where ``<TAB>`` refers to the TAB key), or use
``np.*cos*?<ENTER>`` (where ``<ENTER>`` refers to the ENTER key) to narrow
down the list.  To view the docstring for a function, use
``np.cos?<ENTER>`` (to view the docstring) and ``np.cos??<ENTER>`` (to view
the source code).

Copies vs. in-place operation
-----------------------------
Most of the functions in `numpy` return a copy of the array argument
(e.g., `np.sort`).  In-place versions of these functions are often
available as array methods, i.e. ``x = np.array([1,2,3]); x.sort()``.
Exceptions to this rule are documented.

"} np (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "np"))))
(def ^{:doc "dict() -> new empty dictionary
dict(mapping) -> new dictionary initialized from a mapping object's
    (key, value) pairs
dict(iterable) -> new dictionary initialized as if via:
    d = {}
    for k, v in iterable:
        d[k] = v
dict(**kwargs) -> new dictionary initialized with the name=value pairs
    in the keyword argument list.  For example:  dict(one=1, two=2)"} __builtins__ (as-jvm/generic-python-as-map (py-global-delay (py/get-attr @src-obj* "__builtins__")))) 

(def ^{:doc "
Api Functions - :mod:`fastf1.api`
=================================

.. note:: The functions listed here are primarily for internal use within
    FastF1. While you can use these functions directly, it is usually
    better to use the functionality provided by the data objects
    in :mod:`fastf1.core` instead.

A collection of functions to interface with the F1 web api.

.. autosummary::
   :nosignatures:

   timing_data
   timing_app_data
   car_data
   position_data
   track_status_data
   session_status_data
   race_control_messages
   driver_info
   weather_data
   fetch_page
   parse

"} api (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "api"))))

(def ^{:doc "
.. _GeneralFunctions:

General Functions - :mod:`fastf1`
=================================

.. currentmodule:: fastf1


Accessing Events and Sessions
-----------------------------

When using FastF1, you usually start by loading an event or a
session. This can be done with one of the following functions:

.. autosummary::
    fastf1.get_session
    fastf1.get_testing_session
    fastf1.get_event
    fastf1.get_events_remaining
    fastf1.get_testing_session
    fastf1.get_event_schedule


Caching
-------

Caching should almost always be enabled to speed up the runtime of your
scripts and to prevent exceeding the rate limit of api servers.
FastF1 will print an annoyingly obnoxious warning message if you do not
enable caching.

The following class-level functions are used to setup, enable and
(temporarily) disable caching.

.. autosummary::
    fastf1.Cache.enable_cache
    fastf1.Cache.clear_cache
    fastf1.Cache.disabled
    fastf1.Cache.set_disabled
    fastf1.Cache.set_enabled


General Functions - API Reference
---------------------------------

Events API
..........

.. autofunction:: get_session
.. autofunction:: get_testing_session
.. autofunction:: get_event
.. autofunction:: get_events_remaining
.. autofunction:: get_testing_event
.. autofunction:: get_event_schedule

Cache API
.........

.. autoclass:: Cache
    :members: enable_cache, clear_cache, disabled, set_disabled, set_enabled
    :autosummary:

"} fastf1 (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "fastf1"))))

(def ^{:doc "
    .. deprecated:: 2.2
        Use :class:`fastf1.core.DriverResult` instead
    "       :arglists '[[self & [args {:as kwargs}]]]} Driver (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "Driver"))))

(def ^{:doc "" :arglists '[[self func]]} cached_property (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "cached_property"))))

(def ^{:doc "Raised if the API request does not fail but there is no usable data after processing the result." :arglists '[[self & [args]]]} NoLapDataError (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "NoLapDataError"))))

(def ^{:doc "Multi-channel time series telemetry data

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
    " :arglists '[[self & [args {session :session, driver :driver, drop_unknown_channels :drop_unknown_channels, :as kwargs}]]]} Telemetry (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "Telemetry"))))

(def ^{:doc "Python part of the warnings subsystem."} warnings (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "warnings"))))

(def ^{:doc ""} __doc__ "
Timing and Telemetry Data - :mod:`fastf1.core`
==============================================

The Fast-F1 core is a collection of functions and data objects for accessing
and analyzing F1 timing and telemetry data.

Data Objects
------------

All data is provided through the following data objects:

    .. autosummary::
       :nosignatures:

       Weekend
       Session
       Laps
       Lap
       Telemetry
       SessionResults
       DriverResult


The :class:`Session` object is mainly used as an entry point for loading
timing data and telemetry data. The :class:`Session` can create a
:class:`Laps` object which contains all timing, track and session status
data for a whole session.

Usually you will be using :func:`get_session` to get a :class:`Session`
object.

The :class:`Laps` object holds detailed information about multiples laps.

The :class:`Lap` object holds the same information as :class:`Laps` but only
for one single lap. When selecting a single lap from a :class:`Laps` object,
an object of type :class:`Lap` will be returned.

Apart from only providing data, the :class:`Laps`, :class:`Lap` and
:class:`Telemetry` objects implement various methods for selecting and
analyzing specific parts of the data.


Functions
---------

.. autosummary::
   :nosignatures:

    get_session
    get_round

")

(def ^{:doc "
    .. deprecated:: 2.2
        will be removed without replacement;
        Use :func:`fastf1.get_event` instead to get an
        :class:`~fastf1.events.Event` object which provides
        information including the round number for the event.
    "       :arglists '[[year match]]} get_round (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_round"))))

(def ^{:doc "Object for accessing session specific data.

    The session class will usually be your starting point. This object will
    have various information about the session.

    .. note:: Most of the data is only available after calling
        :func:`Session.load`
    " :arglists '[[self event session_name & [{f1_api_support :f1_api_support}]] [self event session_name]]} Session (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "Session"))))

(def ^{:doc "Object for accessing lap (timing) data of a single lap.

    This class wraps :class:`pandas.Series`. It provides extra functionality for accessing a lap's associated
    telemetry data.
    " :arglists '[[self & [args {:as kwargs}]]]} Lap (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "Lap"))))

(def ^{:doc ""} __name__ "fastf1.core")

(def ^{:doc ""} __package__ "fastf1")
