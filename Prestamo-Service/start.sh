mvn clean package
docker build -t prestamo-service .
docker run -d -p 7071:8080 --name prestamo-service prestamo-service