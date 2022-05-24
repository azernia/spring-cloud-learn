```shell
docker run --name mm -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 -v /usr/local/my-soft/mysql/conf/hmy.cnf:/etc/mysql/conf.d/hmy.cnf -v /usr/local/my-soft/mysql/data:/var/lib/mysql -d arm64v8/mysql:oracle
```
```shell
# $PWD 当前目录
```
