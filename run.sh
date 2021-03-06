#!/usr/bin/env bash

set -eox

if [ "$1" == "build" ]; then
	docker build -t bc/jenkins .
fi

docker run --name jenkins \
	$(pinata-ssh-mount) \
	--rm \
	-v jenkins:/var/jenkins_home \
	-p 8080:8080 \
	--link dind:docker \
	-e JENKINS_USER=admin -e JENKINS_PASSWORD=admin \
	-e DOCKER_HOST='tcp://docker:2375' \
	-e SEED_JOB_NAME='seed' \
	-d bc/jenkins 

docker logs -f jenkins
