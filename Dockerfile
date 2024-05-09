FROM tomcat:latest
COPY ${WAR_FILE} /usr/local/tomcat/webapps/app.jar
EXPOSE 8084
CMD ["catalina.sh","run"]
