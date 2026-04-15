FROM ubuntu:latest
LABEL authors="Pongo"

ENTRYPOINT ["top", "-b"]