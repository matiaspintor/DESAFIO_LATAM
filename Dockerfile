# Dockerfile
FROM openjdk:13
LABEL authors="Matias Pinto Ramirez"

RUN useradd --user-group --create-home --shell /bin/false app

WORKDIR /usr/src/app/

# Se abre el puerto 4200
EXPOSE 8080