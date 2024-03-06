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
            stage('Generate Allure Report') {
                steps {
                    script {
                        sh 'mkdir -p target/allure-results'
                        sh 'mvn io.qameta.allure:allure-maven:2.11.2:report'
                    }
                }
            }
            stage('Publish Allure Report') {
                steps {
                    script {
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
}