node {

   // Mark the code checkout 'stage'....
   stage 'Checkout'

   // Get some code from a GitHub repository
   git url: 'https://github.com/TangentSolutions/Spring-REST-Seed'

   // Get the maven tool.
   // ** NOTE: This 'M3' maven tool must be configured
   // **       in the global configuration.           
   def mvnHome = tool 'mvn'
   def javaHome = tool 'Java'

   // Mark the code build 'stage'....
   stage 'Build'
   // Run the maven build
   withEnv(["JAVA_HOME=${javaHome}", 'PATH=$PATH:$JAVA_HOME/bin']) {
     sh "${mvnHome}/bin/mvn clean package -Dmaven.test.skip=true"
   }
   
   stage 'Test'
   // Run the maven build
   withEnv(["JAVA_HOME=${javaHome}", 'PATH=$PATH:$JAVA_HOME/bin']) {
      parallel xunit: {
        sh "${mvnHome}/bin/mvn surefire-report:report"
      }, coverage: {
        sh "${mvnHome}/bin/mvn cobertura:cobertura"
      },
      failFast: false

      step([$class: 'ArtifactArchiver', artifacts: 'target/*.jar,target/*.war,target/site/**,target/surefire-reports/*', fingerprint: true])
      step([$class: 'JUnitResultArchiver', testResults: 'target/surefire-reports/TEST-*.xml'])
   }
   
   stage 'Load Test'
     withEnv(["JAVA_HOME=${javaHome}", 'PATH=$PATH:$JAVA_HOME/bin']) {
       sh "${mvnHome}/bin/mvn  gatling:execute -Dgatling.runMultipleSimulations=true"
     } 
     step([$class: 'ArtifactArchiver', artifacts: 'target/gatling/**', fingerprint: true])
     step([$class: 'io.gatling.jenkins.GatlingPublisher', enabled: true])

   
}
