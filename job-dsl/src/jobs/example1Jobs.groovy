String basePath = 'jobs'
String repo = 'https://github.com/tylrd/jenkins-docker'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

pipelineJob("$basePath/example") {
    definition {
        cpsScm {
            scm {
                git repo
                scriptPath "Jenkinsfile"
            }
        }
    }
}

