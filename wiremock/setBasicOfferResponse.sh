#!/usr/bin/env bash
curl -X POST -d @/vagrant/basic-offer.json http://localhost:8080/__admin/mappings/new --header "Content-Type:application/json"