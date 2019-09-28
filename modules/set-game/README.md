# set-game #

A SET is three cards where each feature, when looked at individually, is either all the same OR all different. Each card
contains four features: colour (red, purple or green), shape (oval, squiggle or diamond), number (one, two or three) and
shading (solid, striped or outlined).

---

## Developer Instructions ##

### Pre-Requisites ###

1. Java 12 SDK, [available here](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html).
2. Apache Maven, [available here](http://maven.apache.org/download.cgi).

### How To Build ###

* Setup `JAVA_HOME`
```bash
$ export JAVA_HOME="path/to/Java/12/SDK"
```

* Setup `MAVEN_HOME`
```bash
$ export MAVEN_HOME="path/to/maven"
```

* Add `JAVA_HOME` and `MAVEN_HOME` to the terminal `PATH`
```bash
$ export PATH=${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${PATH}
```

* Use `mvn` to build the project
```bash
$ mvn clean package
```

* Output `jar` file appears under the `dist` folder
 
---

## User Instructions ##

### How To Run ###

**Command Line Interface**: After packaging the `jar` file, run the command line, as follows:
```bash
$ java -jar dist/mindsmine-set-game-1.0.3.jar
```

---

### Releases ###

**1.0.3**
* Java 12 compliant
* Maven 3.6.0 compliant

**1.0.1**
* Made it an executable `jar` file to play with
* Java 9 compliant

**1.0.0**
* Basic functionality for the SET game
* Java 8 compliant
