#!/bin/bash

# Script per avviare tutti i servizi

echo Running All Services

./run-cities-service.sh & ./run-ratings-service.sh & ./run-restaurants-service.sh &
