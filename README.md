#`globus`: Making your app world-ready

A collection of utilities that will make it easier for your
JVM based software to be ready for the world's users.

Features:

- Worldwide postal code validation (data provided by [CLDR](http://cldr.unicode.org/))

```java
PostalCodes.isValid("DE", "10407");
```

- Translation of all countries/territories into all languages

```java
Countries.get("de"); //returns a map of <countryCode,nameOfCountry>
```

Planned features (pull requests welcome!):
- Phone number formatting
