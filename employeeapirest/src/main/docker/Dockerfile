FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD employee-api-0.1.0.jar SpringDockerEmployeeApi.jar
RUN sh -c 'touch /SpringDockerEmployeeApi.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /SpringDockerEmployeeApi.jar" ]