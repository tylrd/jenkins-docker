String basePath = 'jobs'
String repo = 'git@github.com:tylrd/jenkins-docker.git'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

def jobs = readFileFromWorkspace('./jobs.json')
def jsonJobs = new groovy.json.JsonSlurper().parse(jobs)

jsonJobs.jobs.each { num ->
    pipelineJob("$basePath/example-$num") {
        definition {
            cpsScm {
                scm {
                    git repo
                    scriptPath "Jenkinsfile"
                }
            }
        }
    }
}


