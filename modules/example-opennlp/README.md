# funstuff-example-opennlp #

## Apache OpenNLP ##

The [Apache OpenNLP](https://opennlp.apache.org) library is a machine learning based toolkit for the processing of
natural language text. It supports the most common NLP tasks, such as tokenization, sentence segmentation, part-of-speech
tagging, named entity extraction, chunking, parsing, and coreference resolution. These tasks are usually required to
build more advanced text processing services. OpenNLP also included maximum entropy and perceptron based machine
learning. OpenNLP needs pre-trained models to work.

The models are language dependent and only perform well if the model language matches the language of the input text.
Also the input text needs to be decoded correctly, depending on the input file encoding this can only be done by
explicitly specifying the character encoding. For all the pre-trained model files,
[click here](http://opennlp.sourceforge.net/models-1.5).

## Example ##

Concordance is an alphabetical list of all word occurrences, labeled with word frequencies. The most important task is
the ability to split the text into sentences which are logically and grammatically accurate for the language under
consideration, which is a natural language processing (NLP) problem.

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

### Pre-Requisites ###

Two files are needed to run the application:
1. A training model file specific to the language under consideration. Download the appropriate model file from
[here](http://opennlp.sourceforge.net/models-1.5). For English, that would be `en-sent.bin`. 
2. A text file specific to the language under consideration. E.g., `input.txt`.

**NOTE**: As an example, for English, the pre-trained model file and an example input file are available under the
`example` folder.

### How To Run ###

* **Graphical User Interface**: After packaging the `jar` file, double-click on the runnable `jar` file and follow the
on-screen instructions.
* **Command Line Interface**: After packaging the `jar` file, pass the necessary files via the command line, as follows:
```bash
$ java -jar dist/mindsmine-exampleOpenNLP-1.0.3.jar example/en-sent.bin example/en-input.txt
```

---

## Releases ##

**1.0.3**
* Upgraded to OpenNLP 1.9.1
* Java 12 compliant
* Maven 3.6.0 compliant

**1.0.2**
* Upgraded to OpenNLP 1.9.0
* Java 10 compliant

**1.0.1**
* Upgraded to OpenNLP 1.8.4
* Java 9 compliant

**1.0.0**
* Basic functionality for using OpenNLP library
* Java 8 compliant
