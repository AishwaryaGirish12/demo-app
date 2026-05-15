pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/AishwaryaGirish12/demo-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            mail to: 'aishwaryagirish1211@gmail.com',
                 subject: "✅ BUILD SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: """
Hello,

The Jenkins build was SUCCESSFUL.

Job      : ${env.JOB_NAME}
Build No : ${env.BUILD_NUMBER}
Status   : SUCCESS
URL      : ${env.BUILD_URL}

Regards,
Jenkins CI
"""
        }

        failure {
            mail to: 'aishwaryagirish1211@gmail.com',
                 subject: "❌ BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: """
Hello,

The Jenkins build has FAILED.

Job      : ${env.JOB_NAME}
Build No : ${env.BUILD_NUMBER}
Status   : FAILED
URL      : ${env.BUILD_URL}

Please check the logs at the above URL.

Regards,
Jenkins CI
"""
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}
