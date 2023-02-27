(ns net.wikipunk.python.fastf1.core.SessionResults
  "No documentation provided"
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.python.jvm-handle :refer [py-global-delay]]
            [libpython-clj2.python.bridge-as-jvm :as as-jvm])
  (:refer-clojure :exclude [+ - * / float double int long mod byte test char short take partition require max min identity empty mod repeat str load cast type sort conj map range list next hash eval bytes filter compile print set format compare reduce merge]))

(defonce ^:private src-obj* (py-global-delay (py/path->py-obj "fastf1.core.SessionResults")))

(def ^{:doc ""} _constructor_sliced (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "_constructor_sliced"))))

(def ^{:doc "Built-in mutable sequence.

If no argument is given, the constructor creates a new empty list.
The argument must be an iterable if specified."} _internal_names (as-jvm/generic-python-as-list (py-global-delay (py/get-attr @src-obj* "_internal_names")))) 

(def ^{:doc "For a nicer debugging experience; can view DataFrame through
        this property in various IDEs"} base_class_view (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "base_class_view"))))
(def ^{:doc "dict() -> new empty dictionary
dict(mapping) -> new dictionary initialized from a mapping object's
    (key, value) pairs
dict(iterable) -> new dictionary initialized as if via:
    d = {}
    for k, v in iterable:
        d[k] = v
dict(**kwargs) -> new dictionary initialized with the name=value pairs
    in the keyword argument list.  For example:  dict(one=1, two=2)"} _COL_TYPES (as-jvm/generic-python-as-map (py-global-delay (py/get-attr @src-obj* "_COL_TYPES")))) 

(def ^{:doc "" :arglists '[[self]]} __repr__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__repr__"))))

(def ^{:doc ""} __module__ "fastf1.core")

(def ^{:doc ""} _constructor (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "_constructor"))))

(def ^{:doc ""} __doc__ "This class provides driver and result information for all drivers that
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
    ")

(def ^{:doc "" :arglists '[[self & [args {force_default_cols :force_default_cols, :as kwargs}]]]} __init__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__init__"))))
