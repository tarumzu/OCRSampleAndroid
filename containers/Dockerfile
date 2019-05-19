FROM python:latest

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

RUN apt-get update && apt-get install -y \
      tesseract-ocr libtesseract-dev libleptonica-dev \
      vim wget && \
      apt-get clean

ENTRYPOINT ["/usr/bin/tail", "-f", "/dev/null"]
