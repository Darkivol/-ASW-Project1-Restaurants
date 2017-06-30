#!/bin/bash

docker build --rm -t swarm.inf.uniroma3.it:5000/eureka-9009 ./eureka
docker build --rm -t swarm.inf.uniroma3.it:5000/cities-9009 ./cities
docker build --rm -t swarm.inf.uniroma3.it:5000/ratings-9009 ./ratings
docker build --rm -t swarm.inf.uniroma3.it:5000/restaurants-9009 ./restaurants
docker build --rm -t swarm.inf.uniroma3.it:5000/zuul-9009 ./zuul