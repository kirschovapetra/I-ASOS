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

public class NewMain {

    public static void main(String[] args) {
        main5(args);
    }

    public static void main1(String[] args) {
        List<Ucet> uList = new ArrayList<>();
        uList.add(new Ucet("U001", 100));
        uList.add(new Ucet("U002", 200));
        uList.add(new Ucet("U003", 300));
        uList.add(new Ucet("U004", 400));

        SparkConf conf = new SparkConf().setAppName("meno aplikacie").setMaster("local"); //local[4]
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        // parallelize
        JavaRDD<Ucet> udd = sc.parallelize(uList);
        // foreach
        udd.foreach(u -> System.out.println("" + u));

        // map reduce
        System.out.println(udd.map(u -> u.getStav()).reduce((a, b) -> a + b));
    }

    public static void main2(String[] args) {
        SparkConf conf = new SparkConf().setAppName("meno aplikacie").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        // textfile
        JavaRDD<String> rdd = sc.textFile("src/main/resources/data.txt");
        // count
        System.out.println("Pocet riadkov: " + rdd.count());

        // first
        System.out.println("Prvy riadok: " + rdd.first());

        // collect
        System.out.println("Vypis vsetkych riadkov: "
                + rdd.collect());

        // filter
        System.out.println(
                "Pocet riadkov ktore obsahuju slovo riadok: "
                + rdd.filter(s -> s.contains("riadok")).count());

        System.out.println(
                "Riadky ktore NEobsahuju slovo riadok: "
                + rdd.filter(s -> !s.contains("riadok")).collect());

//        System.out.println("\ndlzky riadkov");
        System.out.println(
                "Dlzka najdlhsieho riadku: "
                + rdd.map(String::length).reduce(Math::max));

        // JavaPairRDD mapToPair collectAsMap
        JavaPairRDD<String, Integer> rdd2 = rdd.mapToPair(s -> new Tuple2(s, s.length()));
        Map<String, Integer> dlzky = rdd2.collectAsMap();

        System.out.println("\nRiadky a ich dlzky: ");
        dlzky.forEach((k, v) -> System.out.println("\t" + k + ":" + v));

        // groupBy sortByKey
        Tuple2<Integer, Iterable<String>> t = rdd.groupBy(s -> s.length()).sortByKey(false).first();

        System.out.println("Najdlhsie riadky s dlzkou: " + t._1);
        t._2.forEach(s -> System.out.println("\t" + s));
    }

    public static void main3(String[] args) {
        SparkConf conf = new SparkConf().setAppName("meno aplikacie").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        JavaRDD<String> rdd = sc.textFile("src/main/resources/data.txt");
//        rdd.collect().forEach(s -> System.out.println(s));

        // flatMap
        System.out.println("Rozdelenie na slova a ich vypis");
        JavaRDD<String> wdd = rdd.flatMap(s -> Arrays.asList(s.split(" ")).iterator());
        wdd.collect().forEach(s -> System.out.println("\t" + s));

        // distinct
        System.out.println(
                "Roznych slov "
                + wdd.distinct().count()
                + " " + wdd.distinct().collect());

        // countByValue
        System.out.println("Pocetnosti slov");
        Map<String, Long> pocty = wdd.countByValue();
        pocty.keySet().forEach(s -> {
            System.out.println("\t" + s + ":" + pocty.get(s));
        });

        // CV
        // Pocet roznych slov kratsich ako 5
        JavaRDD<String> slovaKratsieAko5 = wdd.distinct().filter(s -> s.length() < 5);
        System.out.println(
                "Rozne slova kratsie ako 5: "
                + "\n\tPocet: " + slovaKratsieAko5.count()
                + "\n\t" + slovaKratsieAko5.collect());

        // Pocet roznych slov pricom sa nerozlisuju male a velke pismena
        JavaRDD<String> rozneSlovaCaseInsensitive
                = wdd.map((String slovo) -> {
                    return slovo.toLowerCase();
                }).distinct();

        System.out.println(
                "Rozne slova, nerozlisuje sa case: "
                + "\n\tPocet: " + rozneSlovaCaseInsensitive.count()
                + "\n\t" + rozneSlovaCaseInsensitive.collect());

        // Pocetnosti slov pricom sa nerozlisuju male a velke pismena
        System.out.println("Pocetnosti slov, cse insensitive: ");
        Map<String, Long> poctyCaseInsensitive = wdd.map((String slovo) -> {
            return slovo.toLowerCase();
        }).countByValue();
        poctyCaseInsensitive.keySet().forEach(s -> {
            System.out.println("\t" + s + ":" + poctyCaseInsensitive.get(s));
        });

    }

    public static void main4(String[] args) {
        SparkConf conf = new SparkConf().setAppName("meno aplikacie").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        // wholeTextFiles collectAsMap
        System.out.println("\nmeno-suboru : cely obsah");
        JavaPairRDD<String, String> pdd = sc.wholeTextFiles("src/main/resources"); // cely adresar
        pdd.collectAsMap().forEach((k, v) -> System.out.println(k + ":" + v));

//        // mapValues
        System.out.println("\nmeno suboru : velkost suboru");
        JavaPairRDD<String, Integer> pdd2 = pdd.mapValues(s -> s.length());
        pdd2.collectAsMap().forEach((k, v) -> System.out.println(k + ":" + v));

        // flatMapValues
        System.out.println("\nmeno suboru : slova");
        JavaPairRDD<String, String> fwdd = pdd.flatMapValues(s -> Arrays.asList(s.split("\\s+")).iterator());
        List<Tuple2<String, String>> tl = fwdd.collect();
        tl.forEach(t -> System.out.println(t._1 + ":" + t._2));

        // reduceByKey
        System.out.println("\nmeno suboru : dlzka najkratsieho slova v subore");
        fwdd.mapValues(s -> s.length()).reduceByKey(Math::min).collectAsMap()
                .forEach((k, v) -> System.out.println(k + " : " + v));


        // Pre kazdy subor vypiste meno suboru a najdlhsie slovo v subore
        System.out.println("\nmeno suboru : najdlhsie slovo v subore");
        
        List<Tuple2<String, String>> collected = fwdd.collect();
                
        fwdd.mapValues(
                s -> s.length())
                .reduceByKey(Math::max).collectAsMap()
                .forEach((k, v) -> {

                    collected.forEach((pair) -> {
                        if (pair._2.length() == v) {
                            System.out.println(k + " dlzka: " + v + " slovo: " + pair._2);
                        }
                    });
                }        
                );

        // countByKey
        System.out.println("\nmeno suboru : pocet roznych slov");
        fwdd.distinct().countByKey().forEach((k, v) -> System.out.println(k + ":" + v));
        
        // slova ktore obsahuju iba a-zA-Z
        System.out.println("\nmeno suboru : slovo (a-z)");
        fwdd.filter(itm -> itm._2.chars().allMatch(Character::isLetter))
                .collect()
                .forEach((itm)->{
                    System.out.println(itm._1 + ": " + itm._2);
                });
        // Pre kazde slovo vypiste slovo a pocet suborov v ktorych sa nachadza
        //     Navod: pomocou mapToPair vymente vo dvojiciach ich 1. a 2. polozku
        System.out.println("\nslovo : pocet");
        fwdd.mapToPair(itm -> new Tuple2<String, String>(itm._2, itm._1))
                .countByKey().forEach((k, v) -> System.out.println(k + ":" + v));

        // Pre kazdy slovo vypiste mena suborov v ktorych sa nachadza - spojene do jedneho retazca
        System.out.println("\nslovo : mena suborov");
        fwdd.mapToPair(itm -> new Tuple2<String, String>(itm._2, itm._1))
                .reduceByKey((a, b) -> a + ", " + b)
                .foreach((itm) -> {
                    System.out.println(itm._1 + ": " + itm._2);
                });

    }

    public static void main5(String[] args) {
        SparkConf conf = new SparkConf().setAppName("meno aplikacie").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        JavaRDD<String> rdd1 = sc.textFile("src/main/resources/data.txt")
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator());
        JavaRDD<String> rdd2 = sc.textFile("src/main/resources/data2.txt")
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator());

        // intersection
        System.out.println("\nslova ktore sa nachadzaju v oboch suboroch");
        rdd1.intersection(rdd2).collect().forEach(s -> System.out.println(s));

        // subtract
        System.out.println("\npocet roznych slov ktore sa nachadzaju v data2.txt ale nechachadzaju v data.txt");
        System.out.println(rdd2.distinct().subtract(rdd1.distinct()).count());

        // CV 
        // Pocet roznych slov, ktore sa nachadzaju aspon v jednom zo suborov
        System.out.println("\nPocet roznych slov, ktore sa nachadzaju aspon v jednom zo suborov");
        System.out.println(rdd2.distinct().union(rdd1.distinct()).count());
        
        // Vypisat rozne slova, ktore sa nachadzaju aspon v jednom zo suborov
        System.out.println("\nRozne slova, ktore sa nachadzaju aspon v jednom zo suborov");
        rdd2.distinct().union(rdd1.distinct()).foreach(slovo->System.out.print(slovo + ", "));
        
        // Symetricka diferencia mnoziny slov v suboroch data.txt a data2.txt 
        System.out.println("\n\nSymetricka diferencia mnoziny slov v suboroch data.txt a data2.txt ");
        
        JavaRDD<String> A = rdd2.distinct().subtract(rdd1.distinct());
        JavaRDD<String> B = rdd1.distinct().subtract(rdd2.distinct());
 
        System.out.println(A.union(B).distinct().collect());

    }
}
