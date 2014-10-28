impala-shell -q "USE STAGING;
CREATE EXTERNAL TABLE inventory_consol(
palletID string,
itemNo string,
customerNo string,
whID string,
locationID string,
lotNo string,
locatonType string,
dateIn string,
dateLastMove string)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\001'
STORED AS PARQUET
LOCATION '/staging/consolidated/inventory_consol';"
