#!groovy

import jenkins.model.*
import hudson.security.*

def env = System.getenv()

println "--> user: ${env.JENKINS_USER}"
println "--> password: ${env.JENKINS_PASSWORD}"

def jenkins = Jenkins.getInstance()
def realm = new HudsonPrivateSecurityRealm(false) 
realm.createAccount(env.JENKINS_USER, env.JENKINS_PASSWORD)
jenkins.setSecurityRealm(realm)
jenkins.save()

jenkins.setAuthorizationStrategy(new FullControlOnceLoggedInAuthorizationStrategy())
jenkins.save()
