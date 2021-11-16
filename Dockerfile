FROM centos:centos7
FROM java:8
FROM tomcat:9.0.54-jdk8-temurin-focal
ADD library.war /usr/local/tomcat/webapps/library.war
EXPOSE 80