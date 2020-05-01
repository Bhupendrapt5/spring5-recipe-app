# #Use to run docker mysql db image, optional if you're not using local mysqlDB
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql

#create Databases
CREATE DATABASE recipeApp_pro;
CREATE DATABASE recipeApp_dev;

#create users
CREATE user 'bhu_pro'@'localhost' identified by 'sql@1234';
CREATE user 'bhu_dev'@'localhost' identified by 'sql@1234';
CREATE user 'bhu_pro'@'%' identified by 'sql@1234';
CREATE user 'bhu_dev'@'%' identified by 'sql@1234';

#Database privileges grants
grant select on recipeApp_pro.* to 'bhu_pro'@'%';
grant update on recipeApp_pro.* to 'bhu_pro'@'%';
grant delete on recipeApp_pro.* to 'bhu_pro'@'%';
grant insert on recipeApp_pro.* to 'bhu_pro'@'%';
grant select on recipeApp_pro.* to 'bhu_pro'@'localhost';
grant update on recipeApp_pro.* to 'bhu_pro'@'localhost';
grant delete on recipeApp_pro.* to 'bhu_pro'@'localhost';
grant insert on recipeApp_pro.* to 'bhu_pro'@'localhost';
grant select on recipeApp_dev.* to 'bhu_dev'@'%';
grant update on recipeApp_dev.* to 'bhu_dev'@'%';
grant delete on recipeApp_dev.* to 'bhu_dev'@'%';
grant insert on recipeApp_dev.* to 'bhu_dev'@'%';
grant select on recipeApp_dev.* to 'bhu_dev'@'localhost';
grant update on recipeApp_dev.* to 'bhu_dev'@'localhost';
grant delete on recipeApp_dev.* to 'bhu_dev'@'localhost';
grant insert on recipeApp_dev.* to 'bhu_dev'@'localhost';


