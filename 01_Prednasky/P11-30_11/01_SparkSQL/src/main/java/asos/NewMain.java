/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

/**
 *
 * @author petra
 */
public class NewMain {
    static SparkSession spark = SparkSession
            .builder()
            .appName("Java Spark SQL basic example").master("local[2]")
            .getOrCreate();
    
    
    
    public static void main(String[] args) {
//        fromCsv();
        cv2(); 
    }
    
    
    static void cv2(){
        
        Dataset<Row> csvDF = spark.read().format("csv")
                .option("sep", ";")
                .option("inferSchema", "true")
                .option("header", "true")
                .load("src/main/resources/ucty.csv");
        
        Dataset<Row> sqlDF = spark.read()
                .format("jdbc")
                .option("url", "jdbc:derby://localhost:1527/sample")
                .option("dbtable", "APP.UCET")
                .option("user", "app")
                .option("password", "app")
                .load();
        
//        csvDF.printSchema();
//        csvDF.show();
//       
//        
//        sqlDF.printSchema();
//        sqlDF.show();
        
        csvDF.createOrReplaceTempView("UCET2");
        Dataset<Row> sqlDF2 = spark.sql("SELECT * FROM UCET2");
        
        Dataset<Row> result = sqlDF.join(sqlDF2, "majitel");
        result.foreach((Row e)->System.out.println(e));
        
    }

    
    
    static void fromCsv(){
        Dataset<Row> df = spark.read().format("csv")
                .option("sep", ";")
                .option("inferSchema", "true")
                .option("header", "true")
                .load("src/main/resources/persons.csv");

        df.printSchema();
        df.show();
        df.select("vyska", "vaha").show();

        JavaRDD<Tuple2<Double, Double>> rdd = df.javaRDD()
                .map(r -> new Tuple2<Double, Double>(r.getDouble(1), r.getDouble(2)));
        rdd.foreach(f -> System.out.println(f));

        // Register the DataFrame as a SQL temporary view
        df.createOrReplaceTempView("people");
        Dataset<Row> sqlDF = spark.sql("SELECT count(*) FROM people");
        sqlDF.show();
    }

}
