FROM maven:3.3.9-jdk-8
RUN mkdir /code
WORKDIR /code
ADD . /code/
RUN mvn package
