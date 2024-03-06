pipeline {
    agent any
    tools {
        maven 'MavenInstallation'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            script {
                // Generate Allure report
                sh 'mkdir -p target/allure-results'
                sh 'mvn io.qameta.allure:allure-maven:2.11.2:report'

                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
