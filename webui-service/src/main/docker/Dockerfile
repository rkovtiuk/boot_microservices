FROM java:8
VOLUME /tmp
RUN mkdir /app
ADD webui-service-1.0-SNAPSHOT.jar /app/app.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/app.jar'
WORKDIR /app
#RUN chmod a+x runboot.sh
EXPOSE 9004
#CMD /app/runboot.sh
