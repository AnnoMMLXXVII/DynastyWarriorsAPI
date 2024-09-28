FROM amazoncorretto:8
VOLUME /tmp
COPY target/warriorsServiceAPI-24.09.27.01.jar warriorsServiceAPI-24.09.27.01.jar
ENTRYPOINT ["java","-jar","/warriorsServiceAPI-24.09.27.01.jar", "-DDB_USER=haku_wei","_DDB_KEY=KBexREIvnDIgNWYJsA5SyA","-DHOST=glum-faery-3346.g8z.gcp-us-east1.cockroachlabs.cloud"]