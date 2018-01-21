#!/usr/bin/env bash

docker rm -f jenkins
docker rmi -f bc/jenkins
docker volume rm jenkins
