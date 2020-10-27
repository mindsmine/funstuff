# funstuff #

[![Build Status](https://travis-ci.org/mindsmine/funstuff.svg?branch=master)](https://travis-ci.org/mindsmine/funstuff)

Collection of fun examples gathered over time.

## Modules ##
1. [Concordance](modules/example-opennlp)
2. [Set Game](modules/set-game)
3. [Tree Traversal](modules/tree-traversal)

---

## Developer Instructions ##

### Pre-Requisites ###

1. Java JDK, [available here](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html).
2. Apache Maven, [available here](http://maven.apache.org/download.cgi).

### How To Build ###

* Setup `JAVA_HOME`
```bash
$ export JAVA_HOME="path/to/Java/JDK"
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
