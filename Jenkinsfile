pipeline {
       environment { 
        EMAIL_RECIPIENTS = "mohamed.bourguiba1@esprit.tn"
         registry = "mohamedbourguiba/tpachatproject" 
        registryCredential = 'dockerhub' 
        dockerImage = ''
        
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL= "http"
        NEXUS_URL= "192.168.1.183:8081"
        NEXUS_REPOSITORY = "nexus-repo-devops"
        NEXUS_CREDENTIALS_ID = "nexus-user-credentials"
        credentialsId='0bad5840-2f90-4b6a-9ff8-d77cddd9c19d';
    
    }

    agent any

    
    
    
    stages {
    
            
     
             stage('Checkout GIT') {
            steps {
             script {
             checkout([$class: 'GitSCM',
         branches: [[name: 'mohamedbourguiba']],
         userRemoteConfigs: [[url: 'https://github.com/Radhwen91/tpAchatProject.git',credentialsId:'0bad5840-2f90-4b6a-9ff8-d77cddd9c19d']]])
             
             }
             
                
                    }
                }
	stage('Cleaning the project and artifact construction') {
            steps {
                script{
		timestamps {
                    sh 'mvn clean install -DskipTests package'
                    
                    } }
                }
            }
stage("Nexus"){
			steps{
			sh """ mvn deploy"""
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
                    }  } }}
              
       
   
/*stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }*/
	
              

 /* stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        }*/
 	/*stage('Start container') { 
            steps { 
                sh "docker-compose up" 
            }
        } */

         stage('Cleaning up') { 
            steps { 
                sh "docker rmi $registry:$BUILD_NUMBER" 
            }
        }
       
    } }
    
