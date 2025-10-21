// --- GitHub 연동 및 systemd 배포용 Jenkinsfile ---

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building on this server using REAL gradle...'
                sh 'gradle clean build'
            }
        }
        
        stage('Deploy (Copy and Restart Service)') {
            steps {
                echo 'Stopping old service (if running)...'
                sh 'sudo systemctl stop my-app.service || true' 
                
                echo 'Copying new .jar file to /opt/my-app/'
                // build.gradle에서 고정한 이름과 일치시킴
                sh "cp $WORKSPACE/build/libs/my-project-0.0.1.jar /opt/my-app/my-project-0.0.1.jar"
                
                echo 'Starting new application via systemd...'
                sh 'sudo systemctl restart my-app.service'
                
                echo 'Deploy Finished!'
            }
        }
    }
}
