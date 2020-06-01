# Spring Boot Hello World on Kubernetes

This project provides instructions for deploying
an example Spring Boot  application on a local kubernetes deployment.

These instructions have been tested on  
[minikube kubernetes](https://kubernetes.io/docs/setup/learning-environment/minikube/#minikube-features) running on a 
local mac OS X deployment.

## Local Minikub Setup

First you must [install minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/#installation).

Execute the following

    minikube start


Execute the following to verify that kubectl communicates correctly:

    kubectl cluster-info
    
    
 You can open the web dashboard to view the state of the cluster using the following;
  
  minikube dashboard
  
## Docker Build

Connect your local shell to point to the 
docker repository within minikube.

    eval $(minikube docker-env)


Build the docker image
        
    docker build --file=Dockerfile --tag=hello-world:latest --rm=true .
 
Start App in Minikube:

    kubectl run hello-world --image=hello-world:latest --port=8080 --image-pull-policy Never
 
 Exposed the application's 8080 port 
 
    kubectl expose deployment hello-world --type=NodePort --port=8080
  
Use the following to view the exposed URL 

    minikube service hello-world --url 
    

## Deployment Operations
 
Use the following to view deployment statuses:
    
    kubectl get deployments
 
 To view the application logs, first get the Pod ID:
 
    kubectl get pod
    
Use the Pod ID to view the application logs


    kubectl logs <pod id>
 
 Use the following to delete the application
 
    kubectl delete deployment hello-world

