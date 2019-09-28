# tree-traversal #

In computer science, [tree traversal](https://en.wikipedia.org/wiki/Tree_traversal) (also known as tree search) is a form
of graph traversal and refers to the process of visiting (checking and/or updating) each node in a tree data structure,
exactly once. Such traversals are classified by the order in which the nodes are visited. The following algorithms are
described for a binary tree, but they may be generalized to other trees as well.

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
$ java -jar dist/mindsmine-tree-traversal-1.1.0.jar
```

---

### Releases ###

**1.1.0**
* Java 12 compliant
* Maven 3.6.0 compliant
