(ns net.wikipunk.python.fastf1.events
"No documentation provided"
(:require [libpython-clj2.python :as py]
          [libpython-clj2.python.jvm-handle :refer [py-global-delay]]
          [libpython-clj2.python.bridge-as-jvm :as as-jvm])
(:refer-clojure :exclude [+ - * / float double int long mod byte test char short take partition require max min identity empty mod repeat str load cast type sort conj map range list next hash eval bytes filter compile print set format compare reduce merge]))

(defonce ^:private src-obj* (py-global-delay (py/path->py-obj "fastf1.events")))

(def ^{:doc "
Logging package for Python. Based on PEP 282 and comments thereto in
comp.lang.python.

Copyright (C) 2001-2019 Vinay Sajip. All Rights Reserved.

To use, simply 'import logging' and log away!
"} logging (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "logging"))))

(def ^{:doc "Create a :class:`~fastf1.core.Session` object for testing sessions
    based on year, test  event number and session number.

    Args:
        year (int): Championship year
        test_number (int): Number of the testing event (usually at most two)
        session_number (int): Number of the session withing a specific testing
            event. Each testing event usually has three sessions.

    Returns:
        :class:`~fastf1.core.Session`

    .. versionadded:: 2.2
    " :arglists '[[year test_number session_number]]} get_testing_session (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_testing_session"))))

(def ^{:doc "Recursive dict get. Can take an arbitrary number of keys and returns an empty
    dict if any key does not exist.
    https://stackoverflow.com/a/28225747" :arglists '[[d & [keys {default_none :default_none}]]]} recursive_dict_get (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "recursive_dict_get"))))

(def ^{:doc ""} _SCHEDULE_BASE_URL "https://raw.githubusercontent.com/theOehrly/f1schedule/master/")

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

(def ^{:doc "" :arglists '[[year]]} _get_schedule_from_ergast (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_get_schedule_from_ergast"))))

(def ^{:doc ""} dateutil (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "dateutil"))))

(def ^{:doc "This class represents a single event (race weekend or testing event).

    Each event consists of one or multiple sessions, depending on the type
    of event and depending on the event format.

    This class is usually not instantiated directly. You should use
    :func:`get_event` or similar to get a specific event.

    Args:
          year (int): Championship year
    " :arglists '[[self & [args {year :year, :as kwargs}]]]} Event (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "Event"))))
(def ^{:doc "dict() -> new empty dictionary
dict(mapping) -> new dictionary initialized from a mapping object's
    (key, value) pairs
dict(iterable) -> new dictionary initialized as if via:
    d = {}
    for k, v in iterable:
        d[k] = v
dict(**kwargs) -> new dictionary initialized with the name=value pairs
    in the keyword argument list.  For example:  dict(one=1, two=2)"} _SESSION_TYPE_ABBREVIATIONS (as-jvm/generic-python-as-map (py-global-delay (py/get-attr @src-obj* "_SESSION_TYPE_ABBREVIATIONS")))) 

(def ^{:doc ""} __file__ "/home/adrian/.local/lib/python3.10/site-packages/fastf1/events.py")

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

(def ^{:doc "" :arglists '[[year]]} _get_schedule (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "_get_schedule"))))

(def ^{:doc "Create a :class:`~fastf1.core.Session` object based on year, event name
    and session identifier.

    .. note:: This function will return a :class:`~fastf1.core.Session`
        object, but it will not load any session specific data like lap timing,
        telemetry, ... yet. For this, you will need to call
        :func:`~fastf1.core.Session.load` on the returned object.

    .. deprecated:: 2.2
        Creating :class:`~fastf1.events.Event` objects (previously
        :class:`fastf1.core.Weekend`) by not specifying an ``identifier`` has
        been deprecated. Use :func:`get_event` instead.

    .. deprecated:: 2.2
        The argument ``event`` has been replaced with ``identifier`` to adhere
        to new naming conventions.

    .. deprecated:: 2.2
        Testing sessions can no longer be created by specifying
        ``gp='testing'``. Use :func:`get_testing_session` instead. There is
        **no grace period** for this change. This will stop working immediately
        with the release of v2.2!

    To get a testing session, use :func:`get_testing_session`.

    Examples:

        Get the second free practice of the first race of 2021 by its session
        name abbreviation::

            >>> get_session(2021, 1, 'FP2')

        Get the qualifying of the 2020 Austrian Grand Prix by full session
        name::

            >>> get_session(2020, 'Austria', 'Qualifying')

        Get the 3rd session if the 5th Grand Prix in 2021::

            >>> get_session(2021, 5, 3)

    Args:
        year (int): Championship year
        gp (number or string): Name as str or round number as int. If gp is
            a string, a fuzzy match will be performed on all events and the
            closest match will be selected.
            Fuzzy matching uses country, location, name and officialName of
            each event as reference.

            Some examples that will be correctly interpreted: 'bahrain',
            'australia', 'abudabi', 'monza'.

            See :func:`get_event_by_name` for some further remarks on the
            fuzzy matching.

        identifier (str or int): see :ref:`SessionIdentifier`

        force_ergast (bool): Always use data from the ergast database to
            create the event schedule

        event: deprecated; use identifier instead

    Returns:
        :class:`~fastf1.core.Session`:
    " :arglists '[[year gp & [{identifier :identifier, force_ergast :force_ergast, event :event}]] [year gp & [{force_ergast :force_ergast, event :event}]]]} get_session (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_session"))))

(def ^{:doc "Create an :class:`~fastf1.events.Event` object for a specific
    season and gp.

    To get a testing event, use :func:`get_testing_event`.

    Args:
        year (int): Championship year
        gp (int or str): Name as str or round number as int. If gp is
            a string, a fuzzy match will be performed on all events and the
            closest match will be selected.
            Fuzzy matching uses country, location, name and officialName of
            each event as reference.
            Note that the round number cannot be used to get a testing event,
            as all testing event are round 0!
        force_ergast (bool): Always use data from the ergast database to
            create the event schedule

    Returns:
        :class:`~fastf1.events.Event`

    .. versionadded:: 2.2
    " :arglists '[[year gp & [{force_ergast :force_ergast}]]]} get_event (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_event"))))

(def ^{:doc "Create an :class:`~fastf1.events.EventSchedule` object for a specific
    season.

    Args:
        year (int): Championship year
        include_testing (bool): Include or exclude testing sessions from the
            event schedule.
        force_ergast (bool): Always use data from the ergast database to
            create the event schedule

    Returns:
        :class:`~fastf1.events.EventSchedule`

    .. versionadded:: 2.2
    " :arglists '[[year & [{include_testing :include_testing, force_ergast :force_ergast}]]]} get_event_schedule (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_event_schedule"))))

(def ^{:doc "Create a :class:`fastf1.events.Event` object for testing sessions
    based on year and test event number.

    Args:
        year (int): Championship year
        test_number (int): Number of the testing event (usually at most two)

    Returns:
        :class:`~fastf1.events.Event`

    .. versionadded:: 2.2
    " :arglists '[[year test_number]]} get_testing_event (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_testing_event"))))

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

(def ^{:doc "Fast implementation of the datetime type."} datetime (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "datetime"))))

(def ^{:doc ""} fuzz (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "fuzz"))))
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

(def ^{:doc "Python part of the warnings subsystem."} warnings (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "warnings"))))

(def ^{:doc ""} __doc__ "
Event Schedule - :mod:`fastf1.events`
=====================================

The :class:`EventSchedule` provides information about past and upcoming
Formula 1 events.

An :class:`Event` can be a race weekend or a testing event. Each event
consists of multiple :class:`~fastf1.core.Session`.

The event schedule objects are built on top of pandas'
:class:`pandas.DataFrame` (event schedule) and :class:`pandas.Series` (event).
Therefore, the usual methods of these pandas objects can be used in addition
to the special methods described here.

Event Schedule Data
-------------------

The event schedule and each event provide the following information as
DataFrame columns or Series values:

  - ``RoundNumber`` | :class:`int` |
    The number of the championship round. This is unique for race
    weekends, while testing events all share the round number zero.

  - ``Country`` | :class:`str` | The country in which the event is held.

  - ``Location`` | :class:`str` |
    The event location; usually the city or region in which the track is
    situated.

  - ``OfficialEventName`` | :class:`str` |
    The official event name as advertised, including sponsor names and stuff.

  - ``EventName`` | :class:`str` |
    A shorter event name usually containing the country or location but no
    no sponsor names. This name is required internally for proper api access.

  - ``EventDate`` | :class:`datetime` |
    The events reference date and time. This is used mainly internally.
    Usually, this is the same as the date of the last session.

  - ``EventFormat`` | :class:`str` |
    The format of the event. One of 'conventional', 'sprint', 'testing'.

  - ``Session*`` | :class:`str` |
    The name of the session. One of 'Practice 1', 'Practice 2', 'Practice 3',
    'Qualifying', 'Sprint Qualifying' or 'Race'.
    Testing sessions are considered practice.
    ``*`` denotes the number of
    the session (1, 2, 3, 4, 5).

  - ``Session*Date`` | :class:`datetime` |
    The date and time at which the session is scheduled to start or was
    scheduled to start.
    ``*`` denotes the number of the session (1, 2, 3, 4, 5).

  - ``F1ApiSupport`` | :class:`bool` |
    Denotes whether this session is supported by the official F1 API.
    Lap timing data and telemetry data can only be loaded if this is true.


Supported Seasons
.................

FastF1 provides its own event schedule for the 2018 season and all later
seasons. The schedule for the all seasons before 2018 is built using data from
the Ergast API. Only limited data is available for these seasons. Usage of the
Ergast API can be enforced for all seasons, in which case the same limitations
apply for the more recent seasons too.

**Exact scheduled starting times for all sessions**:
Supported starting with the 2018 season.
Starting dates for sessions before 2018 (or when enforcing usage of the Ergast
API) assume that each race weekend was held according to the 'conventional'
schedule (Practice 1/2 on friday, Practice 3/Qualifying on Saturday, Race on
Sunday). A starting date and time can only be provided for the race session.
All other sessions are calculated from this and no starting times can be
provided for these. These assumptions will be incorrect for certain events!

**Testing events**: Supported for the 2020 season and later seasons. Not
supported if usage of the Ergast API is enforced.


Event Schedule
..............

- 'conventional': Practice 1, Practice 2, Practice 3, Qualifying, Race
- 'sprint': Practice 1, Qualifying, Practice 2, Sprint, Race
- 'testing': no fixed session order; usually three practice sessions on
  three separate days


.. _SessionIdentifier:

Session identifiers
-------------------

Multiple event (schedule) related functions and methods make use of a session
identifier to differentiate between the various sessions of one event.
This identifier can currently be one of the following:

    - session name abbreviation: ``'FP1', 'FP2', 'FP3', 'Q', 'S',
      'SQ', 'R'``
    - full session name: ``'Practice 1', 'Practice 2',
      'Practice 3', 'Sprint Qualifying', 'Sprint', 'Qualifying', 'Race'``;
      provided names will be normalized, so that the name is
      case-insensitive
    - number of the session: ``1, 2, 3, 4, 5``

Note that 'Sprint' is called 'Sprint Qualifying' only in the 2021 season.
The event name will silently be corrected if you use 'Sprint'/'S' for the 2021
season or 'Sprint Qualifying'/'SQ' for the subsequent seasons.


Functions for accessing schedule data
-------------------------------------

The functions for accessing event schedule data are documented in
:ref:`GeneralFunctions`.


Data Objects
------------


Overview
........


.. autosummary::
    EventSchedule
    Event


API Reference
.............


.. autoclass:: EventSchedule
    :members:
    :undoc-members:
    :show-inheritance:
    :autosummary:


.. autoclass:: Event
    :members:
    :undoc-members:
    :show-inheritance:
    :autosummary:

")

(def ^{:doc "This class implements a per-season event schedule.

    This class is usually not instantiated directly. You should use
    :func:`get_event_schedule` to get an event schedule for a specific
    season.

    Args:
        *args: passed on to :class:`pandas.DataFrame` superclass
        year (int): Championship year
        force_default_cols (bool): Enforce that all default columns and only
            the default columns exist
        **kwargs: passed on to :class:`pandas.DataFrame` superclass
            (except 'columns' which is unsupported for the event schedule)

    .. versionadded:: 2.2
    " :arglists '[[self & [args {year :year, force_default_cols :force_default_cols, :as kwargs}]]]} EventSchedule (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "EventSchedule"))))

(def ^{:doc "Object for accessing session specific data.

    The session class will usually be your starting point. This object will
    have various information about the session.

    .. note:: Most of the data is only available after calling
        :func:`Session.load`
    " :arglists '[[self event session_name & [{f1_api_support :f1_api_support}]] [self event session_name]]} Session (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "Session"))))

(def ^{:doc ""} __name__ "fastf1.events")

(def ^{:doc "Pickle and requests based API cache.

    The parsed API data will be saved as a pickled object.
    Raw GET requests are cached in a sqlite db using the 'requests-cache'
    module.

    Caching should almost always be enabled to speed up the runtime of your
    scripts and to prevent exceeding the rate limit of api servers.
    FastF1 will print an annoyingly obnoxious warning message if you do not
    enable caching.

    The cache has two \"stages\".

        - Stage 1: Caching of raw GET requests. This works for all requests.
          Cache control is employed to refresh the cached data periodically.
        - Stage 2: Caching of the parsed data. This saves a lot of time when
          running your scripts,  as parsing of the data is computationally
          expensive. Stage 2 caching is only used for some api functions.

    Most commonly, you will enable caching right at the beginning of your script:

        >>> import fastf1
        >>> fastf1.Cache.enable_cache('path/to/cache')  # doctest: +SKIP
        # change cache directory to an exisitng empty directory on your machine
        >>> session = fastf1.get_session(2021, 5, 'Q')
        >>> # ...

    Note that you should always enable caching except for very rare
    circumstances which are usually limited to doing core developement
    on FastF1.
    " :arglists '[[self & [args {:as kwargs}]]]} Cache (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "Cache"))))

(def ^{:doc "Create an :class:`~fastf1.events.EventSchedule` object for remaining season.

    Args:
        dt (datetime): Optional DateTime to get events after.
        include_testing (bool): Include or exclude testing sessions from the
            event schedule.
        force_ergast (bool): Always use data from the ergast database to
            create the event schedule

    Returns:
        :class:`~fastf1.events.EventSchedule`

    .. versionadded:: 2.3
    " :arglists '[[& [{dt :dt, include_testing :include_testing, force_ergast :force_ergast}]] [& [{include_testing :include_testing, force_ergast :force_ergast}]]]} get_events_remaining (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_events_remaining"))))

(def ^{:doc ""} __package__ "fastf1")