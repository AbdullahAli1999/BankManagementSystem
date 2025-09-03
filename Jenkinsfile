pipeline {
  agent any
  tools { jdk 'jdk21' }   // تأكد أنك عرّفت jdk21 في Manage Jenkins -> Tools

  options { timestamps() } // شِل ansiColor لأنها سبب الخطأ

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Run Tests') {
      steps {
        sh 'chmod +x mvnw'
        sh './mvnw -B -q test'
      }
    }
    stage('Publish Results') {
      steps { junit 'target/surefire-reports/*.xml' }
    }
  }

  post {
    success { echo '✅ All tests passed (JDK 21)' }
    failure { echo '❌ Some tests failed' }
  }
}
