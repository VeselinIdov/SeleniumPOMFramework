pipeline {
    agent any
    tools {
        maven 'MavenInstallation' // Replace 'MavenInstallationName' with the name you provided in Global Tool Configuration
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Generate Allure Report') {
            steps {
                sh 'mvn io.qameta.allure:allure-maven:2.10.0:report -Dallure.results_pattern=target/allure-results'
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

