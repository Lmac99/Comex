docker network create --driver bridge comex-network

docker build -t comex/comexws .


docker run -d -p 8080:8080 comex/comexws