#!/usr/bin/env bash

#start grid using docker

docker pull selenium/hub
docker run -d -p 4545:4444 --name selenium-hub selenium/hub
docker pull selenium/node-chrome
docker pull selenium/node-firefox
docker run -d --link selenium-hub:hub selenium/node-firefox
docker run -d --link selenium-hub:hub selenium/node-chrome

./gradlew clean build

docker stop $(docker ps -q)
docker rm $(docker ps -aq)

#start grid using selenium compose

#docker-compose up
#docker-compose scale chrome=3
#docker-compose scale firefox=3

