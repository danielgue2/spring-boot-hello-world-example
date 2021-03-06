pipeline {
    agent { 
		docker { 
			image 'maven:3.3.3' 
			args '-v /root/.m2:/root/.m2'
		} 
	}
    stages {
        stage('Init') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
		}
		stage('Deploy - Staging') {
            steps {
                echo '### deploying staging'
            }
        }

        stage('Sanity check') {
            steps {
                input "Does the staging environment look ok?"
            }
        }

        stage('Deploy - Production') {
            steps {
                echo '### deploying production'
            }
        }		
    }
    post {
        always {
            echo 'This will always run'
			// archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
			// deleteDir() /* clean up our workspace */
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
			// mail to: 'danielgue2@jtc-ufo.com', subject: "Failed Pipeline: ${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}"
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
	
}
