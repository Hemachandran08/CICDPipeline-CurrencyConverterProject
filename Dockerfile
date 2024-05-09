FROM tomcat:latest
COPY ${WAR_FILE} /usr/local/tomcat/webapps/app.jar
EXPOSE 8001
CMD ["catalina.sh","run"]
