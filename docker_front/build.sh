#!.usr/bin/env bash

hub_host=30.23.4.134
hub_url=$hub_host/pasepd
#project_name=$(cat ../pom.xml | grep "<artifactId>" | sed -n '2p' | awk -F '>' '{print $2}' | awk -F '<' '{print $1}' |sed 's/ //g')
project_name=wfs-web
project_version=1.0.$BUILD_NUMBER-d

echo $hub_url/$project_name:$project_version

cd ../
npm install
npm run build

cd docker_front
rm -rf files/*
mkdir -p files/

cp -rf ../dist/ files/wfs-web
cp convert.sh files/wfs-web

#no-cache 目的是为了防止从缓存中获取过期资源
docker build --no-cache -t $hub_url/$project_name:$project_version .
docker push $hub_url/$project_name:$project_version

# docker run -p 8080:8080 30.99.140.208/pd/wfs-web:v1.0
