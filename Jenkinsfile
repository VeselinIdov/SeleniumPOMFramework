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
        stage('Generate Allure Report') {
            steps {
                script {
                    sh 'rm -rf target/allure-results'
                    sh 'mvn io.qameta.allure:allure-maven:2.27.0:report'
                }
            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
