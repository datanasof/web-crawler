CREATE DATABASE IF NOT EXISTS webcrawlerdb;
CREATE TABLE IF NOT EXISTS listing (id int NOT NULL AUTO_INCREMENT, productID int, dealerID int, price float, currency varchar(5), rating int, position int, url varchar(255), date timestamp, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS dealer (dealerID int NOT NULL AUTO_INCREMENT, dealerName varchar(255), pvmonthly int, pvyearly int, PRIMARY KEY (dealerID));
CREATE TABLE IF NOT EXISTS pricelist (id int NOT NULL AUTO_INCREMENT, productID int, price int, currency varchar(5), PRIMARY KEY (id));
DROP TABLE IF EXISTS product;
CREATE TABLE product (productID int NOT NULL AUTO_INCREMENT, productName varchar(255), PRIMARY KEY (productID));




