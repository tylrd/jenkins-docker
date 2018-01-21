FROM jenkins/jenkins:2.76

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY --chown=jenkins:root init.groovy /usr/share/jenkins/ref/init.groovy.d/init.groovy
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

