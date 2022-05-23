

/usr/share/spark-tgt-2.3.1.tgt.17/jars

/usr/local/bin/spark-submit-2.3 --class com.target.loyalty.LoyaltyAccountSummary \
--conf spark.driver.maxResultSize=10G \
--conf spark.driver.memory=12g \
--conf spark.sql.shuffle.partitions=100 \
--conf spark.executor.memoryOverhead=4096 \
--conf spark.shuffle.blockTransferService="nio" \
--conf spark.dynamicAllocation.enabled=true \
--conf spark.dynamicAllocation.minExecutors=1 \
--conf spark.dynamicAllocation.maxExecutors=100 \
--conf spark.port.maxRetries=50 \
--conf spark.scheduler.mode=FAIR \
--deploy-mode client \
--queue SVMKGTHDP \
--executor-cores 5 \
--executor-memory 24G \
--master yarn /home_dir/zxxxx/Target-Circle.jar prz_innovation

/usr/local/bin/


spark-submit --class com.target.loyalty.CircleGuests \
--principal SVLLTYHDP@CORP.TARGET.COM  \
--keytab SVLLTYHDP.keytab \
--conf spark.sql.shuffle.partitions=100 \
--conf spark.executor.memoryOverhead=4096 \
--conf spark.shuffle.blockTransferService="nio" \
--conf spark.dynamicAllocation.enabled=true \
--conf yarn.nodemanager.vmem-check-enabled=false \
--conf spark.port.maxRetries=50 \
--conf spark.scheduler.mode=FAIR \
--driver-memory 25g \
--deploy-mode cluster \
--queue default \
--executor-cores 7 \
--executor-memory 24G \
--master yarn projects/Target-Circle/src/main/jar/Target-Circle.jar prd_gst_fnd prd_gst_lzn prd_prz_stg prd_prz_fnd 


            <argument>/usr/local/bin/spark-submit</argument>
            <argument>--class com.target.loyalty.CircleGuests</argument>
            <argument>--principal SVLLTYHDP@CORP.TARGET.COM</argument>
            <argument>--keytab ${edge_dir}/SVLLTYHDP.keytab</argument>
            <argument>--conf spark.driver.maxResultSize=10G</argument>
            <argument>--conf spark.driver.memory=12g</argument>
            <argument>--conf spark.sql.shuffle.partitions=100</argument>
            <argument>--conf spark.executor.memoryOverhead=4096</argument>
            <argument>--conf spark.shuffle.blockTransferService="nio"</argument>
            <argument>--conf spark.dynamicAllocation.enabled=true</argument>
            <argument>--conf spark.dynamicAllocation.minExecutors=1</argument>
            <argument>--conf spark.dynamicAllocation.maxExecutors=100</argument>
            <argument>--conf spark.port.maxRetries=50</argument>
            <argument>--conf spark.scheduler.mode=FAIR</argument>
            <argument>--deploy-mode client</argument>
            <argument>--queue ${queue}</argument>
            <argument>--executor-cores 5</argument>
            <argument>--executor-memory 24G</argument>
            <argument>--master yarn</argument>


        val sparkSession = SparkSession.builder().appName(appName)
          .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
          .config("spark.rpc.netty.dispatcher.numThreads", "2")
          .config("spark.shuffle.compress", "true")
          .config("spark.rdd.compress", "true")
          .config("spark.sql.codegen","true")
          .config("spark.sql.inMemoryColumnarStorage.compressed", "true")
          .config("spark.io.compression.codec", "snappy")
          .config("spark.broadcast.compress", "true")
          .config("spark.sql.hive.thriftServer.singleSession", "true")
          .config("hive.exec.dynamic.partition", "true")
          .config("hive.exec.dynamic.partition.mode", "nonstrict")
          .config("spark.sql.shuffle.partitions","100")
          .config("spark.debug.maxToStringFields","100")
          .config("spark.driver.maxResultSize","10G")
          .config("spark.driver.memory","12g")
          .config("spark.executor.memoryOverhead","4096")
          .config("spark.sql.crossJoin.enabled","true")
          .config("spark.sql.sources.partitionOverwriteMode","dynamic")
          .config("spark.sql.tungsten.enabled", "false")
          .enableHiveSupport()
          .getOrCreate()

--class process --master yarn --deploy-mode client --jars ${msrmntjar} 
--executor-memory 24g 
--executor-cores 7 
--driver-memory 250g 
--conf spark.sql.shuffle.partitions=1000 
--conf spark.dynamicAllocation.enabled=true

            <argument>--conf yarn.nodemanager.vmem-check-enabled=false</argument>


LoyaltyAccountSummary

spark.driver.extraJavaOptions
spark.yarn.am.extraJavaOptions


/usr/local/bin/spark-submit-2.3 --class com.target.loyalty.CircleGuests \
--conf spark.driver.maxResultSize=10G \
--conf spark.driver.memory=12g \
--conf spark.sql.shuffle.partitions=100 \
--conf spark.executor.memoryOverhead=4096 \
--conf spark.shuffle.blockTransferService="nio" \
--conf spark.dynamicAllocation.enabled=true \
--conf spark.dynamicAllocation.minExecutors=1 \
--conf spark.dynamicAllocation.maxExecutors=100 \
--conf spark.port.maxRetries=50 \
--conf spark.scheduler.mode=FAIR \
--deploy-mode client \
--queue default \
--executor-cores 5 \
--executor-memory 24G \
--master yarn /home_dir/zxxxx/spark/Target-Circle.jar prz_innovation
