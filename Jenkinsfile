pipeline {
  agent any
  tools { jdk 'jdk21' }   // <-- هذا اللي يطلب جافا 21
  options { timestamps(); ansiColor('xterm') }

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
      steps {
        junit 'target/surefire-reports/*.xml'
      }
    }
  }

  post {
    success { echo '✅ All tests passed (JDK 21)' }
    failure { echo '❌ Some tests failed' }
  }
}
