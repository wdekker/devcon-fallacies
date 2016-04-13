#!/usr/bin/env bash
java -jar /vagrant/wiremock-1.57-standalone.jar --no-request-journal &
disown