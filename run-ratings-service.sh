#!/bin/bash

# Script per avviare il servizio S2

echo Running Ratings Service S2

java -Xms64m -Xmx128m -jar dist/ratings-0.0.1-SNAPSHOT.jar
