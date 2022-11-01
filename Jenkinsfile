pipeline {
       environment { 
       
         registry = "moallafares/tpachatproject" 
        registryCredential = 'dockerhub' 
        dockerImage = ''
        
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL= "http"
        NEXUS_URL= "192.168.100.158:8081"
        NEXUS_REPOSITORY = "nexus-repo-devops"
        NEXUS_CREDENTIALS_ID = "nexus-user-credentials"
       credentialsId='02e92f42-fe3d-496b-bfdb-3176ca1764e0';
    
    }

    agent any

    
    
    
    stages {
    
            
     
             stage('Checkout GIT') {
            steps {
             script {
             checkout([$class: 'GitSCM',
         branches: [[name: 'fares']],
         userRemoteConfigs: [[url: 'https://github.com/Radhwen91/tpAchatProject.git',credentialsId:'7fac694d-f31d-414e-bbed-741a919effb4']]])
             
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
              


 stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }
	stage("Nexus"){
			steps{
			sh """ mvn deploy"""
			}
			}
              

  stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 

         stage('Cleaning up') { 
            steps { 
                sh "docker rmi $registry:$BUILD_NUMBER" 
            }
        }
       
   

       
    }
   
    
     }
    
      
    
