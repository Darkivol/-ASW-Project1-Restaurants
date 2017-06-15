#!/bin/bash

docker build --rm -t swarm.inf.uniroma3.it:5000/servizio-9009/eureka ./eureka
docker build --rm -t swarm.inf.uniroma3.it:5000/servizio-9009/cities ./cities
docker build --rm -t swarm.inf.uniroma3.it:5000/servizio-9009/ratings ./ratings
docker build --rm -t swarm.inf.uniroma3.it:5000/servizio-9009/restaurants ./restaurants
docker build --rm -t swarm.inf.uniroma3.it:5000/servizio-9009/zuul ./zuul