#!.usr/bin/env bash

hub_host=30.23.4.134
hub_url=$hub_host/pasepd
project_name=$(cat ../pom.xml | grep "<artifactId>" | sed -n '2p' | awk -F '>' '{print $2}' | awk -F '<' '{print $1}' |sed 's/ //g')
#project_name=project_name
project_version=1.0.$BUILD_NUMBER-b
echo $hub_url/$project_name:$project_version

rm -rf files/*.jar
cp ../target/$project_name.jar  ./files/app.jar

#no-cache 目的是为了防止从缓存中获取过期资源
docker build --no-cache -t $hub_url/$project_name:$project_version
docker push $hub_url/$project_name:$project_version

