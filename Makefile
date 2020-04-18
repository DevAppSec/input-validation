docker-build:
    docker build -t input-validation:latest .
docker-run:
    docker run -d -p 8080:8080 input-validation