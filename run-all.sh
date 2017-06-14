#!/bin/bash

# Script per avviare tutti i servizi

echo Running All Services

./run-eureka-server.sh & ./run-zuul-gateway.sh & ./run-cities-service.sh & ./run-ratings-service.sh & ./run-restaurants-service.sh &
