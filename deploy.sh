rm assetpriceservice.tar.gz
mvn clean compile install
docker build -t assetpriceservice:latest .
docker save assetpriceservice:latest | gzip > assetpriceservice.tar.gz