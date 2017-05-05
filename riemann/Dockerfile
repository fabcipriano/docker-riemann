FROM java:8

MAINTAINER Matthias Nüßler <m.nuessler@web.de>
MAINTAINER Fabiano C. de Oliveira <fabcipriano@yahoo.com.br>

ENV RIEMANN_VERSION 0.2.13

ADD https://github.com/riemann/riemann/releases/download/${RIEMANN_VERSION}/riemann_${RIEMANN_VERSION}_all.deb /tmp/
RUN echo "819c161693e879009dd0d7d739fbc01e /tmp/riemann_${RIEMANN_VERSION}_all.deb" \
    > /tmp/riemann_${RIEMANN_VERSION}.md5 && \
    md5sum -c /tmp/riemann_${RIEMANN_VERSION}.md5 && \
    dpkg -i /tmp/riemann_${RIEMANN_VERSION}_all.deb && \
    rm /tmp/riemann* && \
    mkdir -p /etc/riemann/conf.d

COPY riemann.config /etc/riemann/

EXPOSE 5555 5556

CMD ["start"]
ENTRYPOINT ["/usr/bin/riemann"]
