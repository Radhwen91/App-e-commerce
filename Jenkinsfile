pipeline {
       environment { 
        EMAIL_RECIPIENTS = "fares.moalla@esprit.tn"
       
    
    }

    agent any
    stages {
    
            
     
             stage('Checkout GIT') {
            steps {
             script {
             checkout([$class: 'GitSCM',
         branches: [[name: '*/fares']],
         userRemoteConfigs: [[url: 'https://github.com/Radhwen91/tpAchatProject.git']]])
             
             }
             
                
                    }
                }
	stage('Cleaning the project and artifact construction') {
            steps {
                script{
		timestamps {
                    sh 'mvn clean install -DskipTests package'
                     sh 'mvn compile'
                    } }
                }
            }



		stage("Code Quality with SonarQube"){
			steps{
			sh """ mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar"""
			}
			}
                  stage('Run Unit Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                script{
                    timestamps {
                        sh 'mvn test'
                            }
                    }
                }
            }
        }




            
       
    } }