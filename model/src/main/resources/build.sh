#!/usr/bin/env bash
cd /home/ec2-user/club420
echo "Pullng from git"
git pull

echo "Building the war file"
gradle build

echo "cleaning webapps  directory"
rm -rf /home/ec2-user/software/apache-tomcat-7.0.79/webapps/*

echo "Stoping the tomcat"
kill -9 $(ps -ef | grep tomcat | grep -v grep | awk '{print $2}')

echo "Cleaning the log files and webapps folder"
rm -rf /home/ec2-user/software/apache-tomcat-7.0.79/logs/*
rm -rf /home/ec2-user/software/apache-tomcat-7.0.79/webapps/*

echo "copying war file into webapps"
cp /home/ec2-user/club420/build/libs/phantom.war /home/ec2-user/software/apache-tomcat-7.0.79/webapps/

#cp /home/ec2-user/temp/phantom.log /home/ec2-user/software/apache-tomcat-7.0.79/logs/

echo "Starting tomcat once again"
sh /home/ec2-user/software/apache-tomcat-7.0.79/bin/catalina.sh jpda start