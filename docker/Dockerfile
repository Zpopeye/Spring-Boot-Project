FROM 10.8.55.149/library/openjdk:8u232-stretch_plus

#VOLUME /tmp

ADD files/* /apps/
RUN chmod +x /apps/start.sh && \
    echo "set time zone..." && \
    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > .etc/timezone

ENV LANG C.UTF-8

WORKDIR /apps/

EXPOSE 8090
#EXPOSE server port

ENTRYPOINT ["./start.sh"]
