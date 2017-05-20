# Docker Riemann

[![Docker Pulls][pulls-badge]][docker-hub]

# Build container
docker build --rm -t facio/riemann ./riemann

# Run container
docker run --name myriemann -v /home/fabiano/dev/docker-riemann/riemann/riemann.config:/etc/riemann/riemann.config -p 5555:5555 -p 5556:5556 facio/riemann

docker run --name riemannmon --dns=8.8.8.8 -v /home/fabiano/dev/docker-riemann/riemann/riemann.config:/etc/riemann/riemann.config -p 5555:5555 -p 5556:5556 mon/riemann

# Connect to running docker container
docker exec -it myriemann /bin/bash

A Docker image for the [Riemann][riemann] monitoring tool.

[pulls-badge]: https://img.shields.io/docker/pulls/mnuessler/riemann.svg?maxAge=86400
[docker-hub]: https://hub.docker.com/r/mnuessler/riemann/
[riemann]: http://riemann.io
