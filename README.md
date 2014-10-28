This is Inventory table consolidation

sh run.sh will run the main script

It will first call create_inventory.sh which will drop the external table then DO update the DDL on consolidated Inventory table

Then it will execute java code that generate insert SQL for highjump and infor, which later will get executed.
If there is an error or log look at output.log