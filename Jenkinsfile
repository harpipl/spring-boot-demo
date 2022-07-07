pipeline {
    agent {
        docker {
            image 'maven:3.8.5-openjdk-17'
        }
    }
    stages {
        stage('Merge') {
            steps {
                sh 'git merge origin/master'
            }
        }
        stage('Build & Unit Tests') {
            steps {
                sh 'mvn verify -T 1C -B'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker rm -f ci-ensys-application ci-ensys-keycloak ci-ensys-app-database ci-ensys-keycloak-database --volumes 1> /dev/null 2>&1'
                sh 'mvn clean install -Pdockerize -B'
                sh 'docker-compose -f ./docker-compose.ci.yaml -f ./docker-compose.override.ci.yaml up -d'

                sleep 100 // seconds
            }
        }
        stage('Integration Tests') {
            steps {
                sh 'mvn verify -DskipITs=false -Dserver.port=9493 -Dserver-db.port=9412 -Dkeycloak.port=9492 -T 1C -B'
                sh 'docker stop ci-ensys-application ci-ensys-keycloak ci-ensys-app-database ci-ensys-keycloak-database'
                sh 'docker rm ci-ensys-application ci-ensys-keycloak ci-ensys-app-database ci-ensys-keycloak-database --volumes'
            }
        }
        stage('Sonar') {
            steps {
                sleep 1 // second
            }
        }
    }
    post {
        cleanup {
            cleanWs()
        }
    }
}
