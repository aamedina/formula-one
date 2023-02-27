(ns net.wikipunk.python.fastf1.events.Event
  "No documentation provided"
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.python.jvm-handle :refer [py-global-delay]]
            [libpython-clj2.python.bridge-as-jvm :as as-jvm])
  (:refer-clojure :exclude [+ - * / float double int long mod byte test char short take partition require max min identity empty mod repeat str load cast type sort conj map range list next hash eval bytes filter compile print set format compare reduce merge]))

(defonce ^:private src-obj* (py-global-delay (py/path->py-obj "fastf1.events.Event")))

(def ^{:doc "Built-in mutable sequence.

If no argument is given, the constructor creates a new empty list.
The argument must be an iterable if specified."} _internal_names (as-jvm/generic-python-as-list (py-global-delay (py/get-attr @src-obj* "_internal_names")))) 

(def ^{:doc "" :arglists '[[self name]]} __getattribute__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__getattribute__"))))

(def ^{:doc "Return the qualifying session.

        Returns:
            :class:`Session` instance
        " :arglists '[[self]]} get_qualifying (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_qualifying"))))

(def ^{:doc             "Return `True` or `False`, depending on whether this event is a
        testing event." :arglists '[[self]]} is_testing (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "is_testing"))))

(def ^{:doc "Return the full session name of a specific session from this event.

        Examples:

            >>> import fastf1
            >>> event = fastf1.get_event(2021, 1)
            >>> event.get_session_name(3)
            'Practice 3'
            >>> event.get_session_name('Q')
            'Qualifying'
            >>> event.get_session_name('praCtice 1')
            'Practice 1'

        Args:
            identifier (str or int): see :ref:`SessionIdentifier`

        Returns:
            :class:`str`

        Raises:
            ValueError: No matching session or invalid identifier
        " :arglists '[[self identifier]]} get_session_name (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_session_name"))))

(def ^{:doc "Built-in mutable sequence.

If no argument is given, the constructor creates a new empty list.
The argument must be an iterable if specified."} _metadata (as-jvm/generic-python-as-list (py-global-delay (py/get-attr @src-obj* "_metadata")))) 

(def ^{:doc "Return a session from this event.

        Args:
            identifier (str or int): see :ref:`SessionIdentifier`

        Returns:
            :class:`Session` instance

        Raises:
            ValueError: No matching session or invalid identifier
        " :arglists '[[self identifier]]} get_session (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_session"))))

(def ^{:doc "" :arglists '[[self]]} __repr__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__repr__"))))

(def ^{:doc ""} __module__ "fastf1.events")

(def ^{:doc "Return the sprint session.

        Returns:
            :class:`Session` instance
        " :arglists '[[self]]} get_sprint (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_sprint"))))

(def ^{:doc "Return the race session.

        Returns:
            :class:`Session` instance
        " :arglists '[[self]]} get_race (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_race"))))

(def ^{:doc "Event race date (YYYY-MM-DD)

        This wraps ``self['EventDate'].strftime('%Y-%m-%d')``

        .. deprecated:: 2.2
            use :attr:`Event.EventDate` or :attr:`Event['EventDate']` and
            use :func:`datetime.datetime.strftime` to format the desired
            string representation of the datetime object
        "} date (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "date"))))

(def ^{:doc ""} _constructor (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "_constructor"))))

(def ^{:doc "Return the specified practice session.
        Args:
            number: 1, 2 or 3 - Free practice session number
        Returns:
            :class:`Session` instance
        "   :arglists '[[self number]]} get_practice (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_practice"))))

(def ^{:doc ""} __doc__ "This class represents a single event (race weekend or testing event).

    Each event consists of one or multiple sessions, depending on the type
    of event and depending on the event format.

    This class is usually not instantiated directly. You should use
    :func:`get_event` or similar to get a specific event.

    Args:
          year (int): Championship year
    ")

(def ^{:doc "Return the date and time (if available) at which a specific session
        of this event is or was held.

        Args:
            identifier (str or int): see :ref:`SessionIdentifier`

        Returns:
            :class:`datetime.datetime`

        Raises:
            ValueError: No matching session or invalid identifier
        " :arglists '[[self identifier]]} get_session_date (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "get_session_date"))))

(def ^{:doc "Event round number

        .. deprecated:: 2.2
            use :attr:`Event.eventNumber` or :attr:`Event['eventNumber']`
        "} gp (as-jvm/generic-pyobject (py-global-delay (py/get-attr @src-obj* "gp"))))

(def ^{:doc "" :arglists '[[self & [args {year :year, :as kwargs}]]]} __init__ (as-jvm/generic-callable-pyobject (py-global-delay (py/get-attr @src-obj* "__init__"))))
