FROM openjdk:11
COPY .java ./src
RUN mkdir ./out
RUN javac --sourcepath
CMD java org.example.Main