rm ../assetpriceservice.tar.gz 
mvn clean compile install
docker build -t assetpriceservice .
docker save assetpriceservice:latest | gzip > ../assetpriceservice.tar.gz
pscp -pw 1359 ../assetpriceservice.tar.gz  pops@10.0.0.33:/home/pops/docker/deploys
#pscp -pw 1359 ../assetpriceservice.tar.gz  pops@10.0.0.24:/home/pops/docker/deploys

