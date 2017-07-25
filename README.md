# apache-semtech

<a href="http://wiki.esipfed.org/index.php/Semantic_Technologies">![](http://badge.esipfed.org/semanticweb.svg?display=logo)</a>

This is an example code repository for the workshop '[Insight into Open Source Semantic Technlogies at The Apache Software Foundation](http://sched.co/As6X)' presented at [ESIP Summer 2017 Meeting](http://www.esipfed.org/meetings/upcoming-meetings/esip-summer-meeting-2017) on Tuesday, July 25 9:30am - 11:00am Georgian Room 900 E 7th St, Bloomington, IN 47405.

# Introduction
The workshop will introduce people to two key open source semantic technologies ([Apache CommonsRDF](https://commons.apache.org/proper/commons-rdf/) and [Apache Any23]()) developed and maintained at the [Apache Software Foundation](http://apache.org); a software foundation fostering software development upon which billions of users depend on free, community-driven software.

This workshop will cover both

 * [Apache Commons RDF](https://commons.apache.org/proper/commons-rdf/); Commons RDF aims to provide a common library for [RDF 1.1](http://www.w3.org/TR/rdf11-concepts/) that could be implemented by systems on the Java Virtual Machine, and
 * [Apache Any23](http://any23.apache.org/); a library, a web service and a command line tool that extracts structured data in RDF format from a variety of Web documents.

This workshop will furnish attendees with everything required to generate Earth Science data in RDF and then use that data in a wide variety of applications and scenarios.
The session will begin by introducing how to generate RDF data with CommonsRDF including Introduction, API’s, implementations and then a worked example/code examples for generating Earth Sciences RDF data.
The second half of the session will show how RDF data can be embedded in Webpages, e.g. Dataset Landing Pages, and then interpreted using the Any23 Library. This will cover an Any23 Introduction, API’s and then a worked example/code examples for working with RDF data.

# Installation

The prerequisites are
 * [Java SE Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
 * [Apache Maven 3.X](http://maven.apache.org/)
Once installed, you should be able to confirm using the following command
```
$ mvn -version

...

Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T08:41:47-08:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.11.6", arch: "x86_64", family: "mac"
```
As you can see from above the output displays JDK 1.8.0_131 and Maven 3.3.9.
You should also download and install this code
```
$ git clone https://github.com/ESIPFed/apache-semtech.git && cd apache-semtech
$ mvn clean install
```
The above task will install the code locally so you can try out the examples

# Running the Examples
There are two examples
 * [CommonsRDFTest.java](https://github.com/ESIPFed/apache-semtech/blob/master/src/test/java/org/esipfed/CommonsRDFTest.java); some examples of how one would write a client using the Commons RDF API. This example is based off of the core [CommonsRDF Examples](https://github.com/apache/commons-rdf/tree/master/examples) but adapted for an Earth Science audience. The subject matter is aimed specifically at demonstrating how the [Aquarius CAP Level 3 Sea Surface Salinity Standard Mapped Image 7-Day Data V4.0](https://podaac.jpl.nasa.gov/dataset/AQUARIUS_L3_SSS_CAP_7DAY_V4) dataset hosted at [NASA JPL's](https://www.jpl.nasa.gov/) [PO.DAAC](https://podaac.jpl.nasa.gov) can be described and modeled in [RDF 1.1](http://www.w3.org/TR/rdf11-concepts/), and
 * [Any23Test.java](https://github.com/ESIPFed/apache-semtech/blob/master/src/test/java/org/esipfed/Any23Test.java); some examples of how one would utilize the Any23 API for parsing and extracting explicit, embeddd structured markup from dataset landing pages... again using the aboce Aquarius dataset landing page as an example.

# Help
Please ping Lewis John McGibbney with any issues
 * @ lewismc on Github,
 * lewis dot j dot mcgibbney at jpl dot nasa dot gov,
 * additionally please reach out to either the [CommonsRDF mailing lists](https://commons.apache.org/proper/commons-rdf/mail-lists.html) or [Any23 mailing lists](http://any23.apache.org/mail-lists.html) 

# License
This code is licensed permissively under the [Apache License v2.0](https://www.apache.org/licenses/LICENSE-2.0) a copy of which ships with this project.