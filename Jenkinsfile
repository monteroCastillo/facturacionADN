pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas preinstaladas en Jenkins
  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master
  }

  //Aquí comienzan los items del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
			$class: 'GitSCM', 
			branches: [[name: '*/main']],
			doGenerateSubmoduleConfigurations: false, 
			extensions: [], 
			gitTool: 'Git_Centos', 
			submoduleCfg: [], 
			userRemoteConfigs: [[
				credentialsId: 'GITHUB_monterocastillo',
				url:'https://github.com/monteroCastillo/facturacionADN.git'
			]]
		])
        
      }
    }
    
	stage('Clean & Compile') {
      steps{
      	sh 'gradle --b ./facturaVivero/build.gradle clean compileJava'
      }
    }
	
	 stage('Build') {
      steps {
        echo "------------>Build<------------"
        //Construir sin tarea test que se ejecutó previamente
		sh 'gradle --b ./facturaVivero/build.gradle build -x test'
                
      }
    } 
	
    stage('Unit Tests') {
      steps{
      //	sh 'gradle --b ./facturaVivero/build.gradle clean'
        echo "------------>Unit Tests<------------"
		sh 'gradle --b ./facturaVivero/build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
			sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
        }
      }
    }

    
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
		echo 'This will run only if successful'
		junit 'facturaVivero/build/test-results/test/*.xml'
	}

    failure {
		echo 'This will run only if failed'
		mail (to: 'rodrigo.montero@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")

	}
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}