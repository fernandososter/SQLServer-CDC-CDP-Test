# SQLServer-CDC-CDP-Test

# Maven Build command: 
mvn clean install

# After built please use the following command to test it: 
cd target/ 
java -cp sqlserver-cdc-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar TestIt "host do sql server" 1433 "databasename" "table name" "username" "password"

 

