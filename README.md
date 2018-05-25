# spring-boot-jpa

## local environment

- virtualbox(vbox), docker, mysql
- windows 10, workbench
- eclipse, spring-boot, jpa

## troble shooting

- local에서 mysql 접속이 안됨.
  1. schema 생성 후, db 연결정보의 schema 명이 다른 경우, 
  2. vbox guest ip가 거부되는 경우,
  
  ~~~sql
  creamemberte user 'user'@'10.0.2.2' identified by 'password';
  grant all privileges on *.* to 'user'@'10.0.2.2' with grant option;
  flush privileges;
  ~~~
  
