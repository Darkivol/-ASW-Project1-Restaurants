#!/bin/bash

echo 'Starting Restaurants application as a stack' 

sudo docker stack deploy --compose-file docker-stack.yml applicazione-9009