#!/bin/bash

# Script per avviare il servizio S1

echo Running City Restaurants Service S1

java -Xms64m -Xmx128m -jar dist/cities-0.0.1-SNAPSHOT.jar
