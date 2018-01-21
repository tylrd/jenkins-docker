FROM jenkins/jenkins:2.102

USER root

ENV DOCKER_CHANNEL stable
ENV DOCKER_VERSION 17.12.0-ce

RUN set -ex; \
curl -fL -o docker.tgz "https://download.docker.com/linux/static/${DOCKER_CHANNEL}/x86_64/docker-${DOCKER_VERSION}.tgz"; \
tar --extract --file docker.tgz --strip-components 1 --directory /usr/local/bin; \
rm docker.tgz; \
dockerd -v; \
docker -v

USER jenkins

COPY --chown=jenkins gitconfig.txt $JENKINS_HOME/.gitconfig
COPY --chown=jenkins ssh-config $JENKINS_HOME/.ssh/config

ENV JAVA_OPTS "-Djenkins.install.runSetupWizard=false -Djava.util.logging.config.file=/var/jenkins_home/log.properties"
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
COPY --chown=jenkins log.properties /var/jenkins_home/log.properties
COPY init.groovy /usr/share/jenkins/ref/init.groovy.d/init.groovy
COPY bootstrap.xml /usr/share/jenkins/ref/jobs/seed/config.xml
