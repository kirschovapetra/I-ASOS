package asos;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Main {

    private static final Integer RANDOM_INTS = 10;
    static JavaSparkContext sc = new JavaSparkContext(
            new SparkConf().setAppName("meno aplikacie").setMaster("local")
    );

    static void u2Sum(int n) {

//        Double sum = 0.0;
//        for (double i = 0; i < n; i ++) {
//            double x = i/n;
//            double y = x*x;
//            sum += y;
//        }
//        System.out.println(sum/n);
        List<Double> nums = new ArrayList<>();
        for (double i = 0; i < n; i++) {
            nums.add(i);
        }

        double vysledok = nums.stream().map((x) -> {
            return x / n * x / n;
        }).reduce(0.0, (a, b) -> {
            return a + b;
        });

        System.out.println(vysledok);

    }

    static void u2Sum_v2(int n) {

        List<Double> nums = new ArrayList<>();
        for (double i = 0; i < n; i++) {
            nums.add(i);
        }

        JavaRDD<Double> rddNums = sc.parallelize(nums);

        double vysledok = rddNums
                .map((x) -> x / n * x / n)
                .reduce((a, b) -> a + b);

        System.out.println(vysledok);

    }

    static boolean u3Prime(long n) {

//        for (long i = 2; i < Math.sqrt(n + 1); i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
        long maxSqrt = (long) Math.sqrt(n + 1);

        return Stream.iterate(2, x -> x + 1)
                .limit(maxSqrt + 1)
                .filter(x -> x <= maxSqrt)
                .map(a -> n % a)
                .allMatch(t -> t != 0);

    }

    static void u4Supplier() throws NoSuchAlgorithmException {

        /*
        odstráňte triedenie a uloženie do poľa a namiesto toho vypíšte generované čisla priamo pomocou forEach.
        upravte program tak aby vypísal 50 čísel, vyskúšajte tiež, čo sa stane ak odstánite volanie limit.
        upravte program tak aby načítal 50 čísel a vypočítal ich priemer.
        
         */

//        Object[] randomInts = rndStream.limit(RANDOM_INTS).sorted().toArray();
//        for (Object randomInt1 : randomInts) {
//            System.out.println(randomInt1);
//        }


        // odstráňte triedenie a uloženie do poľa a namiesto toho vypíšte generované čisla priamo pomocou forEach.
        Stream.generate(new MySupplier())
                .limit(RANDOM_INTS).forEach((x) -> System.out.println(x));

        int lim = 50;
//        //  upravte program tak aby vypísal 50 čísel, vyskúšajte tiež, čo sa stane ak odstánite volanie limit.
        Stream.generate(new MySupplier())
                .limit(lim).forEach((x) -> System.out.println(x));
        
        // upravte program tak aby načítal 50 čísel a vypočítal ich priemer.
        
        double avg = Stream.generate(new MySupplier())
                .limit(lim).reduce((a,b) -> a + b).get() * 1.0 / lim;
        

        System.out.println("avg:" + avg);
        
    }
    
    static void u5Supplier(int n) {
    
        double vysledok = Stream.generate(new MySupplier2())
                .limit(n)
                .mapToDouble((x) -> ((double)x) / n * ((double)x) / n)
                .reduce((a, b) -> a + b).getAsDouble();

        System.out.println(vysledok);
    }

   
    public static void main(String[] args) throws NoSuchAlgorithmException {

        sc.setLogLevel("ERROR");
        
        int n = 3;
        
//        u2Sum(n);
//        u2Sum_v2(n);
        
//        for (long i = 1; i < 40; i++) {
//            System.out.println("i: " + i + ": " + u3Prime(i));
//        }

//        u4Supplier();
//        u5Supplier(n);
    }

}
