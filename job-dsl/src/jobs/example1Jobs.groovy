String basePath = 'jobs'
String repo = 'git@github.com:tylrd/jenkins-docker.git'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

["1, 2"].each {num -> 
	pipelineJob("$basePath/example-$num") {
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
}


