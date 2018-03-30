FROM projectriff/java-function-invoker:latest
ARG FUNCTION_JAR=/functions/riff-0.0.1-SNAPSHOT.jar
ARG FUNCTION_CLASS=lowercase&main=com.example.riff.RiffApplication
ADD target/riff-0.0.1-SNAPSHOT.jar $FUNCTION_JAR
ENV FUNCTION_URI file://${FUNCTION_JAR}?handler=${FUNCTION_CLASS}
