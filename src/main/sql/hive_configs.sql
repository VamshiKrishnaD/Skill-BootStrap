-- Basic performance configs 
SET hive.optimize.sort.dynamic.partition=true;
SET hive.exec.max.created.files=500000;
SET hive.exec.parallel=true;
SET hive.exec.parallel.thread.number=32;
SET hive.vectorized.execution.enabled=false;
SET hive.tez.container.size=12256;
SET hive.tez.auto.reducer.parallelism=true;
SET hive.exec.reducers.bytes.per.reducer=1073741824;
SET hive.tez.java.opts=-Xmx12256m;
SET hive.tez.auto.reducer.parallelism=true;

