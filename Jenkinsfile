pipeline {
    agent any
        stages {
            //stage("checkout"){
	//        steps{
	//            sh "ls"
	//            git branch: 'main', url: 'https://github.com/smwemeke/amigosservices.git'
	//            sh "ls"
	//        }
	//    }
             stage("build"){
                steps{
                sh  "./mvnw package"
                    }
                }
        
            stage("capture"){
                 steps{
                archiveArtifacts '**/target/*.jar'
                jacoco()
                    }
             }
        }
        post{
            always{
                emailext body: "${env.BUILD_URL}\n${currentBuild.absoluteUrl}",
                to: "always@foo.bar",
                recipientProviders: [previous()], 
                subject: "${currentBuild.currentResult}: Job_Name ${env.JOB_NAME} [${env.BUILD_NUMBER}]"
            }    
        }

}