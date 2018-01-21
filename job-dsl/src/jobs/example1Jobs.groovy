String basePath = 'jobs'
String repo = 'git@github.com:tylrd/jenkins-docker.git'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

pipelineJob("$basePath/example") {
    definition {
        cps {
            sandbox()
        }
        cpsScm {
            scm {
                git repo
                scriptPath "Jenkinsfile"
            }
        }
    }
}

