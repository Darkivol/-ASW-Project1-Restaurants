#!/bin/bash

sudo docker build --rm -t swarm.inf.uniroma3.it:5000/servizio-9009/eureka-img ./eureka
sudo docker build --rm -t swarm.inf.uniroma3.it:5000/servizio‐9009/cities-img ./cities
sudo docker build --rm -t swarm.inf.uniroma3.it:5000/servizio‐9009/ratings-img ./ratings
sudo docker build --rm -t swarm.inf.uniroma3.it:5000/servizio‐9009/restaurants-img ./restaurants
sudo docker build --rm -t swarm.inf.uniroma3.it:5000/servizio‐9009/zuul-img ./zuul