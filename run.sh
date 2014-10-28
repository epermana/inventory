HADOOP_CLIENT_DIR=/opt/cloudera/parcels/CDH/lib/hadoop/client/
HIVE_LIB_DIR=/opt/cloudera/parcels/CDH/lib/hive/lib
IMPALA_LIB_DIR=/opt/cloudera/parcels/CDH/lib/impala/lib



CLASSPATH=$CLASSPATH:./cloudera-impala-1.0.jar
sh drop_table.sh
sh create_table.sh
java -cp $CLASSPATH com.linage.transform.ClouderaImpala
sh hj_transform.sh > hj_output.log
sh in_transform.sh > in_output.log
