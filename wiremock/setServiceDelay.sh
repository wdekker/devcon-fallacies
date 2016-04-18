#!/usr/bin/env bash
curl -X POST -d "{ \"fixedDelay\": $1}" http://localhost:8080/__admin/settings --header "Content-Type:application/json"