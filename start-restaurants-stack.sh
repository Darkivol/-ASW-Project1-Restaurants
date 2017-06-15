#!/bin/bash

echo 'Starting Restaurants application as a stack' 

docker stack deploy --compose-file docker-stack.yml restaurants-9009