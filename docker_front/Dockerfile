#FROM 30.99.140.208/library/tomcat:8.5.43-jdk8-adoptopenjdk-hotspot
#
#ADD files webapps/
#
#RUN echo "set time zone..." && \
#    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
#    rm -rf webapps/doc && \
#    rm -rf webapps/examples && \
#    rm -rf webapps/host-manager && \
#    rm -rf webapps/ROOT && \
#    echo "Asia/Shanghai" > .etc/timezone
#ENV LANG en_US.UTF-8
#ENV LANGUAGE en_US:en
#
#EXPOSE 8080
#
FROM 30.99.140.208/library/nginx:1.0
RUN mkdir /usr/share/nginx/html/wfs-web/
COPY files/wfs-web/ /usr/share/nginx/html/wfs-web/
COPY nginx/nginx.conf /etc/nginx/nginx.conf
RUN chomx -R 777 /usr/share/nginx/html
ENV RELEASE=""
ENV NAMESPACE=""
ENV PORT=""
EXPOSE 80
CMD ["bash", "/usr/share/nginx/html/wfs-web/convert.sh"]
