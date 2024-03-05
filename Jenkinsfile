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
                sh 'mvn test'
            }
            post {
                always {
                    // Publish TestNG results
                    step([$class: 'TestNGResultArchiver', testngReportsPattern: 'target/surefire-reports/testng-results.xml'])
                }
            }
        }
    }
}
