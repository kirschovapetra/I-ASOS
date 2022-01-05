package asos.spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;


public class NewMain {

  
    public static void main(String[] args) {
        
        SparkConf conf = new SparkConf().setAppName("meno aplikacie").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");
        
        JavaRDD<String> fileRdd = sc.textFile("src/main/resources/text.txt");
        JavaRDD<String> file2Rdd = sc.textFile("src/main/resources/text2.txt");

        
        JavaPairRDD<String, Integer> pairRdd = fileRdd.mapToPair(s -> {
            return new Tuple2(s, s.length());
        });
        
        System.out.println(pairRdd.collect());
       
        JavaPairRDD<String, Integer> reducedPairRdd = pairRdd.reduceByKey((a, b) -> a + b);
        System.out.println(reducedPairRdd.collect());

    }
    
}
