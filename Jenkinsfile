pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test' // This will run TestNG tests using Maven
            }
            post {
                always {
                    // Publish TestNG results
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
