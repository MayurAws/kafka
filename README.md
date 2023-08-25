# kafka
Kafka related examples

Pre-Requisites

1. Download kafka from https://kafka.apache.org/downloads
2. Install on your local machine
3. Rename the folder from kafka_x.xx-x.x.x to kafka
4. Create data folder under kafka
5. Under data folder create "kafka"  and "zookeeper" folders
6. Update zookeeper.properties under kafka/config location with the new zookeeper data folder path 
   Make sure "\" are replaced with "/" for windows.
7. Start zookeeper 
    **zookeeper-server-start.bat ../../config/zookeeper.properties**
8. Start kafka
    **kafka-server-start.bat ../../config/server.properties**
