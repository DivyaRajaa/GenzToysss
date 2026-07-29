FROM tomcat:9-jdk21

COPY src/main/webapp /usr/local/tomcat/webapps/ROOT

EXPOSE 8080