#!/bin/bash
ls /project
cd /project
mvn package
java -Djava.security.egd=file:/dev/./urandom -jar /project/target/demo-0.0.1-SNAPSHOT.jar
