(ns net.wikipunk.python.fastf1.events.EventSchedule
  "No documentation provided"
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.python.jvm-handle :refer [py-global-delay]]
            [libpython-clj2.python.bridge-as-jvm :as as-jvm])
  (:refer-clojure :exclude [+ - * / float double int long mod byte test char short take partition require max min identity empty mod repeat str load cast type sort conj map range list next hash eval bytes filter compile print set format compare reduce merge]))

(defonce ^:private src-obj* (py-global-delay (py/path->py-obj "fastf1.events.EventSchedule")))

(def ^{:doc "Get an :class:`Event` by its round number.

        Args:
            round (int): The round number
        Returns:
            :class:`Event`
        Raises:
            ValueError: The round does not exist in the event schedule
        " :arglists '[[self round]]} get_event_by_round (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_event_by_round"))))

(def ^{:doc ""} _constructor_sliced (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "_constructor_sliced"))))

(def ^{:doc "Built-in mutable sequence.

If no argument is given, the constructor creates a new empty list.
The argument must be an iterable if specified."} _internal_names (as-jvm/generic-python-as-list (py-global-delay (py/get-attr @src-obj* "_internal_names")))) 

(def ^{:doc "Get an :class:`Event` by its name.

        A fuzzy match is performed to find the event that best matches the
        given name. Fuzzy matching is performed using the country, location,
        name and officialName of each event. This is not guaranteed to return
        the correct result. You should therefore always check if the function
        actually returns the event you had wanted.

        .. warning:: You should avoid adding common words to ``name`` to avoid
            false string matches.
            For example, you should rather use \"Belgium\" instead of \"Belgian
            Grand Prix\" as ``name``.

        Args:
            name (str): The name of the event. For example,
                ``.get_event_by_name(\"british\")`` and
                ``.get_event_by_name(\"silverstone\")`` will both return the
                event for the British Grand Prix.
        Returns:
            :class:`Event`
        " :arglists '[[self name]]} get_event_by_name (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_event_by_name"))))

(def ^{:doc "For a nicer debugging experience; can view DataFrame through
        this property in various IDEs"} base_class_view (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "base_class_view"))))

(def ^{:doc             "Return `True` or `False`, depending on whether each event is a
        testing event." :arglists '[[self]]} is_testing (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "is_testing"))))
(def ^{:doc "dict() -> new empty dictionary
dict(mapping) -> new dictionary initialized from a mapping object's
    (key, value) pairs
dict(iterable) -> new dictionary initialized as if via:
    d = {}
    for k, v in iterable:
        d[k] = v
dict(**kwargs) -> new dictionary initialized with the name=value pairs
    in the keyword argument list.  For example:  dict(one=1, two=2)"} _COL_TYPES (as-jvm/generic-python-as-map (py-global-delay (py/get-attr @src-obj* "_COL_TYPES")))) 

(def ^{:doc "Built-in mutable sequence.

If no argument is given, the constructor creates a new empty list.
The argument must be an iterable if specified."} _metadata (as-jvm/generic-python-as-list (py-global-delay (py/get-attr @src-obj* "_metadata")))) 

(def ^{:doc "" :arglists '[[self]]} __repr__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__repr__"))))

(def ^{:doc ""} __module__ "fastf1.events")

(def ^{:doc ""} _constructor (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "_constructor"))))

(def ^{:doc ""} __doc__ "This class implements a per-season event schedule.

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
    ")

(def ^{:doc "" :arglists '[[self & [args {year :year, force_default_cols :force_default_cols, :as kwargs}]]]} __init__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__init__"))))
