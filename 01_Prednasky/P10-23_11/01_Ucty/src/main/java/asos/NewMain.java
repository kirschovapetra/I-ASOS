/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.util.DoubleAccumulator;
import scala.Tuple2;

public class NewMain {

    static JavaSparkContext sc = new JavaSparkContext(
            new SparkConf().setAppName("meno aplikacie").setMaster("local[2]")
    );

    static int zlava;
    static double SADZBA = 0.01;

    public static void main(String[] args) {

        sc.setLogLevel("ERROR");
        JavaRDD<Ucet> rdd = sc.parallelize(init());

//        pr1_Shuffle();
//        pr2_Closure(rdd);
//        pr2_Closure_v2(rdd);
//        pr3_Closure_UcetConfig(rdd);
//        pr4_Action_Transformation(rdd);
//        pr5_InputChange(rdd);
//        pr5_InputChange_v2();
//        pr6_Broadcast(rdd);
//        pr7_Logging(rdd);
//        pr8_Accumulator(rdd);
//        pr8_Accumulator_v2(rdd);
        pr8_Accumulator_v3(rdd);

    }

    static List<Ucet> init() {

        List<Ucet> ucty = new ArrayList<>();
        ucty.add(new Ucet("U001", 100));
        ucty.add(new Ucet("U002", 200));
        ucty.add(new Ucet("U003", 300));
        ucty.add(new Ucet("U004", 400));
        return ucty;
    }

    static Ucet doStuff(Ucet u) {
        u.pripocitajUrok();
        System.out.println("" + u);
        return u;
    }

    static Ucet doStuff2(Ucet u, double urok) {
        u.pripocitajUrok(urok);
//        System.out.println("" + u);
        return u;
    }

    static Ucet doStuff3(Ucet u, UcetConfig uc) {
        u.pripocitajUrok(uc);
        return u;
    }

    static void pr0() {
        List<Integer> dl = Arrays.asList(100, 110, 120, 130, 140, 150);

        zlava = 25;

        JavaRDD<Integer> rdd1 = sc.parallelize(dl);
        JavaRDD<Integer> rdd2 = rdd1.map(x -> x - zlava);

        zlava = 5;
        JavaRDD<Integer> rdd3 = rdd2.map(x -> x - zlava)
                .map(x -> x - zlava);

        System.out.println(rdd3.filter(x -> x < 100).count());
    }

    static void pr1_Shuffle() {

        // transformacie idu na kazdy clen zvlast - ked idu paralelne, tak mozu byt poprehadzovane
        JavaRDD<String> lines = sc.textFile("src/main/resources/data.txt");
        System.out.println("--- lines --");
        lines.foreach(i -> System.out.println(i));

        // flatMap rozdeli riadky na slova: kolelcia words obsahuje slová a je rozdelená do
        // rovnakých partícií ako lines, pričom slová z každého riadku ostanú v jeho partícii.
        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(s.split(" ")).iterator());
        System.out.println("--- words --");
        words.foreach(i -> System.out.println(i));

        // rovnako mapToPair vytvorí dvojicu (slovo,1) v partícii, v ktorej bolo slovo
        JavaPairRDD<String, Integer> pairs = words.mapToPair(s -> new Tuple2(s, 1));
        System.out.println("--- pairs (slovo,1) --");
        pairs.foreach(i -> System.out.println(i));

        // aby mohla prebehnúť redukcia musí reduceByKey najprv dvojice prerozdeliť (zgrupovať)
        // tak aby dvojice s rovnakým klúčom (slovom) boli len na jednom uzle.
        JavaPairRDD<String, Integer> counts = pairs.reduceByKey((a, b) -> a + b);
        System.out.println("--- counts (slovo,count) --");
        counts.foreach(i -> System.out.println(i));

        System.out.println("--- counts as map --");
        counts.collectAsMap().forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

    static void pr2_Closure() {

        List<Ucet> ucty = init();
        JavaRDD<Ucet> rdd = sc.parallelize(ucty);

        // Zo skutočnosti, že výpočty sa vykonávajú na workeroch plynú viaceré problémy a dôsledky.
        System.out.println("\n--- foreach: uroky sa neupdatnu ---");
        // neupdartnu sa realne uroky v liste - vo foreach iba temp premenne
        // účty sa zmenili na workeri ale nie driveri
        rdd.foreach(u -> {
            u.pripocitajUrok();
            System.out.println("" + u);
        });
        System.out.println("---");
        ucty.forEach(u -> System.out.println(u));

        System.out.println("\n--- map: uroky sa updatnu ---");

        // Účty musíme dostať späť z workera na driver
        // map vráti modifikovaný účet a collect to pošle na driver
        List<Ucet> ucty2 = rdd.map(u -> {
            u.pripocitajUrok();
            return u;
        }).collect();

        ucty2.forEach(u -> {
            System.out.println(u);
        });

        System.out.println("\n--- problem vypisov na konzolu ---");

        //vypisujú sa na konzolu workera
        List<Ucet> ucty3 = rdd.map(u -> {
            u.pripocitajUrok();
            System.out.println("vnutri map: " + u);
            return u;
        }).collect();

        ucty3.forEach(u -> {
            System.out.println("vonku z map:" + u.getStav());
        });

    }

    static void pr2_Closure_v2(JavaRDD<Ucet> rdd) {

//        a) Overte si spravanie foreach rdd.foreach(u -> {System.out.println("" + u);});
//            Všimnite si, že poradie vypisov sa može meniť ak mate viac cpu. 
        rdd.foreach(u -> {
            System.out.println("" + u);
        });

//        b) Namiesto collect, pouzite first, count (prip. sample)
//        c) Do map funkcie pridajte logovaci vypis aby ste sa presvedcili ku 
//        ktorym uctom sa pripocitava urok. Záleží na použitej akcii?
        Ucet prvy = rdd.map(u -> {
            u.pripocitajUrok();
            System.out.println("logujem v map: " + u); // vypise iba prvy
            return u;
        }).first();
        System.out.println("prvy: " + prvy);

        long cnt = rdd.map(u -> {
            u.pripocitajUrok();
            System.out.println("logujem v map: " + u); // vypise 4 krat
            return u;
        }).count();
        System.out.println("cnt: " + cnt);

//        d) Pridajte úroky za viac mesiacov a všimnite si poradie logovacich vypisov. - U1 U1 U1 U2 U2 U2 ...
//        Čo sa stane ak nezavoláte collect ani inú akciu ? // nic nevypise
        JavaRDD<Ucet> rdd2 = rdd.map(u -> doStuff(u));
        JavaRDD<Ucet> rdd3 = rdd2.map(u -> doStuff(u));
        JavaRDD<Ucet> rdd4 = rdd3.map(u -> doStuff(u));
        System.out.println("\ncalling collect...");
        List<Ucet> uctyRdd4 = rdd4.collect();
    }

    static void pr3_Closure_UcetConfig(JavaRDD<Ucet> rdd) {

//      Pre vykonanie map funkcie je nutné samotných objektov Ucet 
//      na worker node skopírovať aj objekt UcetConfig.
        UcetConfig uc = new UcetConfig(0.1);
        List<Ucet> ucty2 = rdd.map(u -> {
            u.pripocitajUrok(uc);
            return u;
        }).collect();

        ucty2.forEach(u -> {
            System.out.println(u);
        });
    }

    static void pr4_Action_Transformation(JavaRDD<Ucet> rdd) {

        // Funguje ale problém je ukladanie medzivýsledkov do pamäte.
        // collect sa vypise skor ako vypisy z map
        JavaRDD<Ucet> rdd1 = rdd.map(u -> doStuff2(u, 0.01));
        JavaRDD<Ucet> rdd2 = rdd1.map(u -> doStuff2(u, 0.05));
        JavaRDD<Ucet> rdd3 = rdd2.map(u -> doStuff2(u, 0.1));

        rdd3.collect().forEach(u -> {
            System.out.println("" + u.getStav());
        });

        System.out.println("collect...");
        rdd3.collect().forEach(u -> {
            System.out.println(u.getStav());
        });
    }

    static void pr5_InputChange(JavaRDD<Ucet> rdd) {

        // updatne sa 2x 
        UcetConfig uc = new UcetConfig(0.01);
        rdd = rdd.map(u -> doStuff2(u, uc.sadzba));
        rdd = rdd.map(u -> doStuff2(u, uc.sadzba));

        // updatne sa povodna suma, nie updatnuta
        uc.sadzba = 0.0;
        rdd = rdd.map(u -> doStuff2(u, uc.sadzba));

        rdd.collect().forEach(u -> {
            System.out.println("" + u.getStav());
        });
    }

    static void pr5_InputChange_v2() {

//        funguje , T.j. za 3. mesiac sa pripočíta naozaj 0.0
        System.out.println("\n--- funguje ---");
        List<Ucet> ucty = init();
        JavaRDD<Ucet> rdd = sc.parallelize(ucty);

        rdd = rdd.map(u -> doStuff2(u, 0.01));
        rdd = rdd.map(u -> doStuff2(u, 0.01));
        rdd = rdd.map(u -> doStuff2(u, 0.0));

        rdd.collect().forEach(u -> {
            System.out.println(u);
        });

        // lokálna premenna v lambda výraze - compile error
//        double sadzba = 0.01;
//        rdd = rdd.map(u -> doStuff2(u, sadzba));
//        rdd = rdd.map(u -> doStuff2(u, sadzba));
//        sadzba = 0.0;
//        rdd = rdd.map(u -> doStuff2(u,sadzba));
//        rdd.collect().forEach(u -> {
//            System.out.println("" + u.getStav());
//        });
//        Staticka premenna - Rovnaký problém ako s UcetConfig
        System.out.println("\n--- Staticka premenna ---");
        ucty = init();
        rdd = sc.parallelize(ucty);
        rdd = rdd.map(u -> {
            u.pripocitajUrok(SADZBA);
            return u;
        });
        rdd = rdd.map(u -> {
            u.pripocitajUrok(SADZBA);
            return u;
        });
        SADZBA = 0.0;
        rdd = rdd.map(u -> {
            u.pripocitajUrok(SADZBA);
            return u;
        });
        rdd.collect().forEach(u -> {
            System.out.println(u);
        });

//        zmeniť stav na účte
        System.out.println("\n--- set stav uctu[0] = 0.0 ---");
        ucty = init();
        rdd = sc.parallelize(ucty);
        rdd = rdd.map(u -> {
            u.pripocitajUrok(0.01);
            return u;
        });
        rdd = rdd.map(u -> {
            u.pripocitajUrok(0.01);
            return u;
        });
        ucty.get(0).setStav(0.0);
        rdd = rdd.map(u -> {
            u.pripocitajUrok(0.01);
            return u;
        });
        rdd.collect().forEach(u -> {
            System.out.println(u);
        });
    }

    static void pr6_Broadcast(JavaRDD<Ucet> rdd) {

        // Broadcast variables allow to keep a read-only variable cached on 
        // each machine rather than shipping a copy of it with tasks
        Broadcast<UcetConfig> ucb = sc.broadcast(new UcetConfig(0.01));

        rdd = rdd.map(u -> doStuff3(u, ucb.value()));
        rdd = rdd.map(u -> doStuff3(u, ucb.value()));
        rdd = rdd.map(u -> doStuff3(u, ucb.value()));

        rdd.collect().forEach(u -> {
            System.out.println(u);
        });
    }

    static void pr7_Logging(JavaRDD<Ucet> rdd) {

        System.out.println("\n--- rozhadzane vypisy ---");

        List<Ucet> ucty2 = rdd.map(u -> {
            u.pripocitajUrok();
            System.out.println("" + u);
            return u;
        }).collect();

        System.out.println("");
        ucty2.forEach(u -> {
            System.out.println(u);
        });

        System.out.println("\n--- logger - nic neloguje ---");

        UcetLogger logger = new UcetLogger();
        rdd.map(u -> {
            u.pripocitajUrok();
            logger.log("Log " + u.getStav());
            return u;
        }).collect();
        
        System.out.println("count " + logger.logCount());
        logger.logPrint();
    }

    static void pr8_Accumulator(JavaRDD<Ucet> rdd) {
        
        System.out.println("\n--- accumulator logger - loguje ---");

        UcetLoggerAcum acumLogger = new UcetLoggerAcum();
        sc.sc().register(acumLogger, "MyAcumLogger");
        rdd.map(u -> {
            u.pripocitajUrok();
            acumLogger.add("Log: " + u);
            return u;
        }).collect();

        List<String> logs = acumLogger.value();
        System.out.println("count " + logs.size());
        logs.forEach(s -> {
            System.out.println(s);
        });
        
        
        acumLogger.reset();
        
        System.out.println("\n--- accumulator logger + foreach ---");

        rdd.foreach(u -> {
            acumLogger.add("Log: " + u);
        });
        
        logs = acumLogger.value();
        System.out.println("count " + logs.size());
        logs.forEach(s -> {
            System.out.println(s);
        });

    }

    static void pr8_Accumulator_v2(JavaRDD<Ucet> rdd) {

        System.out.println("\n--- accumulator logger + foreach ---");
        UcetLoggerAcum acumLogger = new UcetLoggerAcum();
        sc.sc().register(acumLogger, "MyAcumLogger");
        
        rdd.foreach(u -> {
            acumLogger.add("Log: " + u);
        });

        List<String> logs = acumLogger.value();
        System.out.println("count " + logs.size());
        logs.forEach(s -> {
            System.out.println(s);
        });

    }

    static void pr8_Accumulator_v3(JavaRDD<Ucet> rdd) {

        // Počas pripočítavania úrokov chceme spočítať aj celkovú sumu pripočítanych úrokov.
        
        // a) Presvedčte sa že naivné riešenie nefunguje a vysvetlite prečo.
        //      - meni sa local variable - error
//        double suma = 0.0;
//        rdd = rdd.map(u -> {
//            double urok = 0.1 * u.getStav();
//            u.setStav(u.getStav() + urok);
//            suma = suma + urok;
//            return u;
//        });

        // b) Imlementujte akumlátor, ktorý sčituje double hodnoty a 
        //    reimplementujte výpočet korektne s jeho použitím.
        System.out.println("\n--- sum accumulator ---");
        SumAccum sumAccum = new SumAccum();
        sc.sc().register(sumAccum, "MySumAccum");

        rdd.map(u -> {
            sumAccum.add(u);
            return u;
        }).collect().forEach(u->System.out.println(u)); 
        
        System.out.println("Suma: " 
                + sumAccum.value().stream().reduce(0.0, (a,b) -> a + b));

        // Reimplementujte výpočet korektne s použitím knižničného 
        // akumlátora DoubleAccumulator
        System.out.println("\n--- DoubleAccumulator ---");
        DoubleAccumulator doubleAccum = new DoubleAccumulator();
        sc.sc().register(doubleAccum, "MyDoubleAccum");

        rdd.map(u -> {
            double stav = u.getStav();
            double urok = stav * 0.1;
            u.setStav(stav + urok);
            doubleAccum.add(urok);
            return u;
        }).collect().forEach(u -> System.out.println(u));

        System.out.println("Suma doubleAccum: "
                + doubleAccum.value());

    }


}
