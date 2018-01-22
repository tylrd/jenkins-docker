node {
  
  checkout scm

  jobDsl targets: 'job-dsl/src/jobs/*.groovy',
           removedJobAction: 'DELETE',
           removedViewAction: 'DELETE',
           lookupStrategy: 'SEED_JOB',
		   sandbox: true

}
