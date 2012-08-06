#`globus`: Making your app world-ready

A collection of utilities that will make it easier for your
JVM based software to be ready for the world's users.

Features:

- Worldwide postal code validation (data provided by [CLDR](http://cldr.unicode.org/))

```java
PostalCodeValidator.isValid("DE", "10407");
```

Planned features (pull requests welcome!):
- Phone number formatting
- Translation of all countries/territories into all languages
