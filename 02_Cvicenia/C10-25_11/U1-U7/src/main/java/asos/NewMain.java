/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

/**
 *
 * @author petra
 */
public class NewMain {

    static JavaSparkContext sc = new JavaSparkContext(
            new SparkConf().setAppName("meno aplikacie").setMaster("local")
    );

    public static void main(String[] args) {
        sc.setLogLevel("ERROR");

//        List<Double> data = Arrays.asList(new Double[]{1.0, 2.0, 3.0, 4.0});
//        System.out.println(U1_priemer(sc.parallelize(data)));
//        U2_file();
//        U3_file();
//        U5_files();
//        U7_linReg();
        U7_linReg_v2();
    }

    static double U1_priemer(JavaRDD<Double> data) {
        /*
        
        Ak ste na zistenie počtu čísel použili metódu count, čítate vstupnú 
        RDD kolekciu 2x, (pri výpočte súčtu aj počtu čísel). 
        Skúste navrhnúť algoritmu tak aby súčet aj počet čísel dokázal zistiť 
        naraz jediným prečítaním kolekcie. 
        
        Návod: použite mapToPair, pozri 10. Prednáška, Príklad 3.
        
         */

        JavaPairRDD<Double, Integer> pairs = data.mapToPair(num -> new Tuple2(num, 1));
        JavaPairRDD<Double, Integer> counts = pairs.reduceByKey((a, b) -> a + b);

        int n = counts.map((itm) -> itm._2).reduce((a, b) -> a + b);
        double sum = counts.map(itm -> itm._1 * itm._2).reduce((a, b) -> a + b);

        return sum / n;

    }

    static void U2_file() {
        JavaRDD<String> distFile = sc.textFile("src/main/resources/*");

        // pocet datovych clenov v sade
        System.out.println("Pocet riadkov: " + distFile.count());

        //1. first vracia 1. clen datovej sady
        System.out.println("Prvy riadok: " + distFile.first());

        //2. vytvori List vsetkych clenov RDD
        List<String> lines = distFile.collect();

        lines.forEach(s -> {
            System.out.println(s);
        });

        System.out.println("--- Sample ---");
        List<String> linesSample = distFile.sample(true, 0.5).collect();
        linesSample.forEach(s -> {
            System.out.println(s);
        });

        System.out.println("--- Max len 1 ---");
        Tuple2<Integer, String> maxLenTuple
                = distFile.mapToPair(str -> new Tuple2(str.length(), str))
                        .sortByKey(false).first();

        System.out.println(maxLenTuple._2 + ": " + maxLenTuple._1);
//        
        System.out.println("--- Max len 2 ---");
        Integer maxLen = distFile.map(str -> str.length()).reduce(Math::max);
        System.out.println("dlzka najdlhsieho riadku: " + maxLen);

    }

    static void U3_file() {

        JavaRDD<String> distFile = sc.textFile("src/main/resources/data.txt");
        JavaRDD<String> words = distFile.flatMap((line) -> Arrays.asList(line.split(" ")).iterator());

        JavaPairRDD<String, Integer> pairs = words.mapToPair(s -> new Tuple2(s, 1));
        JavaPairRDD<String, Integer> counts = pairs.reduceByKey((a, b) -> a + b);

        System.out.println("\n--- pocetnosti slov ---");

        counts.collectAsMap().forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        // pri zisťovaní početnosti slov:
        //ignorujte slová, ktoré obsahujú iné ako alfanumerické znaky
        System.out.println("\n--- pocetnosti slov: a-z ---");
        JavaPairRDD<String, Integer> countsLetters
                = pairs.filter(pair -> pair._1.chars()
                                              .allMatch(ch -> Character.isLetter(ch)))
                        .reduceByKey((a, b) -> a + b);

        countsLetters.collectAsMap().forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        //nerozlišujte malé a veľké písmená. Použite najprv  map 
        System.out.println("\n--- pocetnosti slov: case insensitive ---");
        JavaPairRDD<String, Integer> pairsCaseIns = words.mapToPair(s -> new Tuple2(s.toLowerCase(), 1));
        JavaPairRDD<String, Integer> countsCaseIns = pairsCaseIns.reduceByKey((a, b) -> a + b);
        countsCaseIns.collectAsMap().forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        //namiesto  reduceByKey  a  collectAsMap  použite priamo  countByValue 
        System.out.println("\n--- pocetnosti slov: countByValue ---");
        Map<Tuple2<String, Integer>, Long> countsByValue = pairs.countByValue();
        countsByValue.forEach((k, v) -> {
            System.out.println(k._1 + ": " + v);
        });
    }

    static void U5_files(){
        
        // pomocou  wholeTextFiles načíta textové súbory zo zadaného adresára do kolekcie dvojíc  JavaPairRDD<String, String> 
        JavaPairRDD<String, String> files = sc.wholeTextFiles("src/main/resources");

        // a pomocou flatMapValues ich rozloží na slová, čím dostanete kolekciu dvojíc, kde prvá položka je názov súboru a druhá slovo.
        JavaPairRDD<String, String> filesPairs = files.flatMapValues( s -> Arrays.asList(s.split("\\s+")).iterator() );

        // v kolekcii ponechajte len položky, kde slovo pozostáva len z alfanumerických znakov
        JavaPairRDD<String, String> filesPairsAlfanum = filesPairs.filter(t -> t._2.matches("\\w+"));

        // vypíšete jej obsah:
        
        // a) implementujte výpis obsahu, tak že pomocou akcie collect() získate z nej List<Tuple2<String, String>> a následne vypíšete všetky dvojice.
        System.out.println("\n--- Collect ---");
        filesPairsAlfanum.collect().forEach(f -> System.out.println(f._1 + ": " + f._2));
        // b) vyskúšajte, čo dostanete, ak namiesto collect použijete pri výpise collectAsMap
        System.out.println("\n--- collectAsMap ---");
        filesPairsAlfanum.collectAsMap().forEach((k,v) -> System.out.println(k + ": " + v));
        // c) implementujte výpis obsahu pomocou forEach
        System.out.println("\n--- foreach ---");
        filesPairsAlfanum.foreach(f -> System.out.println(f._1 + ": " + f._2));
        
        System.out.println("\n ---------------- \n");
  
        // a) koľko slov obsahujú jednotlivé súbory. Použite  countByKey 
        System.out.println("\n--- pocty slov ---");
        filesPairsAlfanum.countByKey().forEach((k,v)->System.out.println(k + ": " + v + " slov"));

        // b) koľko rôznych slov obsahujú jednotlivé súbory. Použite  distinct 
        System.out.println("\n--- pocty slov - distinct ---");      
        filesPairsAlfanum.distinct().countByKey().forEach((k, v) -> System.out.println(k + ": " + v + " slov"));

        //    Pozn. ak pri tom nechcete rozlišovať malé a veľké písmená, skúste najprv konvertovať slová na malé písmená pomocou  mapValues 
        System.out.println("\n--- pocty slov - distinct + case insensitive ---");
        filesPairsAlfanum.mapValues(s->s.toLowerCase()).distinct().countByKey().forEach((k, v) -> System.out.println(k + ": " + v + " slov"));

        // c) koľkých súboroch sa vyskytujú jednotlivé slová. 
        //    Návod: pomocou  mapMapToPair  vytvorte najprv transponovanú PairRDD, (t.j vymeníte prvú a druhú položku dvojíc.)
        //    Pozor aby ste pre dané slovo započítali súbor len raz, aj keď sa v ňom slovo vyskytuje viac krát.
        System.out.println("\n--- v koľkých súboroch sa vyskytujú jednotlivé slová ---");
        JavaPairRDD<String, String> newPairs = filesPairsAlfanum.mapToPair(pair -> new Tuple2(pair._2, pair._1)).distinct();
        newPairs.foreach(f->System.out.println(f));
        System.out.println("");
        newPairs.countByKey().forEach((a,b)-> System.out.println(a + ": " + b));
       
    }
    
    static void U7_linReg(){
        List<Tuple2<Double, Double>> points = new ArrayList<>();
        points.add(new Tuple2(0.0, -1.0));
        points.add(new Tuple2(1.0, 1.0));
        points.add(new Tuple2(2.0, 3.0));

        JavaRDD<Tuple2<Double, Double>> pointsRDD = sc.parallelize(points);
        
        Tuple2<Double, Double> lrResult = linreg(pointsRDD);
//        
        double a = lrResult._1;
        double c = lrResult._2;
        
        System.out.println("\nPriamka: y=" + a + "+"+c+"x");
        
        /*

Vytvorte csv súbor s dvoma stĺpcami obsahujúci súradnice bodov. (Príklad csv súboru je tu.)

Súbor načítajte do  RDD<String>  pomocou  textFile . (Pozri Prednáška 10, Príklad 2.)

Následne pomocou  map  aplikujte na riadky funkciu, ktorá ich rozdelí na stĺpce a konvertuje na dvojicu čisel - objekt typu  Tuple2<Double,Double> .

Výsledný RDD typu  Tuple2<Double,Double>  použite ako vstup do funkcie linreg.

Návod: Zložky objektu x typu Tupple2 sú prístupne ako x._1 a x._2
        
        */
    }
    
    static void U7_linReg_v2() {

        JavaRDD<Tuple2<Double, Double>> pointsRDD = sc.textFile("src/main/resources/coords.csv").map(line->{
            String[] splt = line.split(";");
            return new Tuple2(Double.parseDouble(splt[0]),Double.parseDouble(splt[1]));
        });
        
        Tuple2<Double, Double> lrResult = linreg(pointsRDD);
//        
        double a = lrResult._1;
        double c = lrResult._2;

        System.out.println("\nPriamka: y=" + a + "+" + c + "x");
    }
    
    
    static Tuple2<Double, Double> linreg(JavaRDD<Tuple2<Double, Double>> pdd){
  
        double n = pdd.map(p->1.0).reduce((a,b)->a+b);
        double x = pdd.map(p->p._1).reduce((a,b)->a+b);
        double y = pdd.map(p->p._2).reduce((a,b)->a+b);
        double xy = pdd.map(p->p._1*p._2).reduce((a,b)->a+b);
        double x2 = pdd.map(p->p._1*p._1).reduce((a,b)->a+b);

        double c = (n*xy - x*y)/ (n*x2 - x*x);
        double a = (y - c*x)/n;
  
        return new Tuple2(a,c);
    }
}
