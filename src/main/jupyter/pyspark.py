"""  Reading json files w/ and w/o schema in pyspark  """

# read json file into dataframe
val df = spark.read.json("src/main/resources/zipcodes.json")
df.printSchema()
df.show(false)
"""
When you use format("json") method, 
you can also specify the Data sources by their fully qualified name (i.e., org.apache.spark.sql.json),
for built-in sources, you can also use short name “json”. 
"""



# Read JSON file from multiline Using spark.read.option("multiline","true")
val multiline_df = spark.read.option("multiline","true").json("src/main/resources/multiline-zipcode.json")
multiline_df.show(false)   



#Reading Multiple Files at a Time
val df2 = spark.read.json(
     "src/main/resources/zipcodes_streaming/zipcode1.json",
     "src/main/resources/zipcodes_streaming/zipcode2.json")
df2.show(false)


# Reading files with a user-specified custom schema
val schema = new StructType()
      .add("RecordNumber",IntegerType,true)
      .add("Zipcode",IntegerType,true)
      .add("ZipCodeType",StringType,true)
      .add("City",StringType,true)
      .add("State",StringType,true)
      .add("LocationType",StringType,true)
      .add("Lat",DoubleType,true)
      .add("Long",DoubleType,true)
      .add("Xaxis",IntegerType,true)
      .add("Yaxis",DoubleType,true)
      .add("Zaxis",DoubleType,true)
      .add("WorldRegion",StringType,true)
      .add("Country",StringType,true)
      .add("LocationText",StringType,true)
      .add("Location",StringType,true)
      .add("Decommisioned",BooleanType,true)
      .add("TaxReturnsFiled",StringType,true)
      .add("EstimatedPopulation",IntegerType,true)
      .add("TotalWages",IntegerType,true)
      .add("Notes",StringType,true)
val df_with_schema = spark.read.schema(schema)
        .json("src/main/resources/zipcodes.json")
df_with_schema.printSchema()
df_with_schema.show(false)


# Read JSON file using Spark SQL
spark.sqlContext.sql("CREATE TEMPORARY VIEW zipcode USING json OPTIONS" + " (path 'src/main/resources/zipcodes.json')")
spark.sqlContext.sql("select * from zipcodes").show(false)

# Writing files back into folder
df2.write.json("/tmp/spark_output/zipcodes.json")
df2.write.mode(SaveMode.Overwrite).json("/tmp/spark_output/zipcodes.json")

 
 
 
 
 """ Reference code with few tweaks"""
 
 package com.sparkbyexamples.spark.dataframe
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
object FromJsonFile {
  def main(args:Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[3]")
      .appName("SparkByExample")
      .getOrCreate()
    val sc = spark.sparkContext
    //read json file into dataframe
    val df = spark.read.json("src/main/resources/zipcodes.json")
    df.printSchema()
    df.show(false)
    //read multiline json file
    val multiline_df = spark.read.option("multiline", "true")
      .json("src/main/resources/multiline-zipcode.json")
    multiline_df.printSchema()
    multiline_df.show(false)
    //read multiple files
    val df2 = spark.read.json(
      "src/main/resources/zipcodes_streaming/zipcode1.json",
      "src/main/resources/zipcodes_streaming/zipcode2.json")
    df2.show(false)
    //read all files from a folder
    val df3 = spark.read.json("src/main/resources/zipcodes_streaming/*")
    df3.show(false)
    //Define custom schema
    val schema = new StructType()
      .add("City", StringType, true)
      .add("Country", StringType, true)
      .add("Decommisioned", BooleanType, true)
      .add("EstimatedPopulation", LongType, true)
      .add("Lat", DoubleType, true)
      .add("Location", StringType, true)
      .add("LocationText", StringType, true)
      .add("LocationType", StringType, true)
      .add("Long", DoubleType, true)
      .add("Notes", StringType, true)
      .add("RecordNumber", LongType, true)
      .add("State", StringType, true)
      .add("TaxReturnsFiled", LongType, true)
      .add("TotalWages", LongType, true)
      .add("WorldRegion", StringType, true)
      .add("Xaxis", DoubleType, true)
      .add("Yaxis", DoubleType, true)
      .add("Zaxis", DoubleType, true)
      .add("Zipcode", StringType, true)
      .add("ZipCodeType", StringType, true)
    val df_with_schema = spark.read.schema(schema)
        .json("src/main/resources/zipcodes.json")
    df_with_schema.printSchema()
    df_with_schema.show(false)
    spark.sqlContext.sql("CREATE TEMPORARY VIEW zipcode USING json OPTIONS" +
      " (path 'src/main/resources/zipcodes.json')")
    spark.sqlContext.sql("SELECT *FROM zipcode").show()
    //Write json file
    df2.write
      .json("/tmp/spark_output/zipcodes.json")
  }
}
