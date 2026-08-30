FROM tomcat:10.1-jdk17

RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY web/index.html /usr/local/tomcat/webapps/ROOT/index.html
COPY web/style.css /usr/local/tomcat/webapps/ROOT/style.css
COPY src/StudentResultServlet.java /tmp/StudentResultServlet.java

RUN mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/classes && \
    javac -cp /usr/local/tomcat/lib/servlet-api.jar \
    -d /usr/local/tomcat/webapps/ROOT/WEB-INF/classes \
    /tmp/StudentResultServlet.java

EXPOSE 8080

CMD ["catalina.sh", "run"]
