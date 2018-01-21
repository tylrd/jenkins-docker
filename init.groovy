#!groovy

import jenkins.model.*
import hudson.security.*

def env = System.getenv()

println "--> creating local user 'admin'"
println "--> password for local user 'admin'"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(env.JENKINS_USER, env.JENKINS_PASSWORD)
Jenkins.instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
Jenkins.instance.setAuthorizationStrategy(strategy)
Jenkins.instance.save()
