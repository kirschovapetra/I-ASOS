package asos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UctyLambdaApp {

    static Ucet splitAndGetUcet(String l) {
        String[] splitLine = l.split(",");
        Ucet u = new Ucet(splitLine[0], Double.parseDouble(splitLine[1]));
        u.pripocitajUrok(0.2);
        System.out.println(l + " | " + u);
        return u;
    }

    static BufferedReader getBr(String fname) throws FileNotFoundException {
        return new BufferedReader(
                new FileReader(fname)
        );
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        main1(args);
//        main2(args);
        main3(args);

    }

    public static void main1(String[] args) {
        Ucet ucty[] = {
            new Ucet("U001", 100),
            new Ucet("U002", 200),
            new Ucet("U003", 300),
            new Ucet("U004", 400)
        };
        // 1. sposob - na obyc array sa neda dat foreach
        for (Ucet u : ucty) {
            u.pripocitajUrok(0.05);
        }

        // 2. sposob - na list foreach ide, nie je paralelne
        List<Ucet> uList = Arrays.asList(ucty);

        uList.forEach((Ucet u) -> {
            u.pripocitajUrok(0.05);
            System.out.println(u);
        });

        // 3. sposob - consumer ktory implementuje Consumer<T>
        uList.forEach(new MyConsumer());

        // 4. sposob - stream
        // Poradie v akom sa budu spracovavat ucty by sme mohli nechat na kontainer
        // Kontaineru by sme len povedali co ma s prvkami robit, nie vsak v akom poradi.
        // Java 8 poskytuje specialny kontainer stream. 
        // Stream poskytuje interface s metody umoznujucimi zadat funkciu ktora sa ma vykonat pre kazdy prvok
        uList.stream().forEach(u -> {
            u.pripocitajUrok(0.05);
            System.out.println(u);
        });

        // ---------
        uList.stream().forEach(u -> u.pripocitajUrok(0.05));
        uList.stream().forEach(u -> {
            System.out.println(u);
        });

    }

    // Stream mozeme vytvorit aj z suboru alebo hociakeho InputStream-u  
    public static void main2(String[] args) throws FileNotFoundException {

        getBr("src/main/resources/ucty.csv").lines()
                .forEach(l -> {
                    splitAndGetUcet(l);
                }
        );

        System.out.println("-----------------");

        // --------------- map --------------
        getBr("src/main/resources/ucty.csv").lines() // treba limit lebo lines uz robi limit
                .map((String l) -> {
                    return splitAndGetUcet(l);
                })
                .forEach((Ucet u) -> {
                    System.out.println("hghghg " + u);
                });

        System.out.println("-----------------");

        // supplier
        MySupplier supp = new MySupplier();

        Stream.generate(supp)
                .limit(supp.maxPocet) // treba limit lebo supplier je dumb
                .forEach((Ucet u) -> {
                    u.pripocitajUrok(0.2);
                    System.out.println(u);
                });
               
        System.out.println("-----------------");
              
        BufferedReader brStd = new BufferedReader(
                new InputStreamReader(System.in)
        );

        // stop po 3 inputoch
        brStd.lines()
                .limit(3)
                .forEach(l -> {
                    splitAndGetUcet(l);
                });
  
    }

    // Dalsie  metody Stream API
    public static void main3(String[] args) throws FileNotFoundException, IOException {

        // count
        System.out.println("COUNT: pocet riadkov: "
                + getBr("src/main/resources/ucty.csv").lines()
                        .count());
        
        // first
        System.out.println("FIRST: "
                + getBr("src/main/resources/ucty.csv").lines()
                        .findFirst()
                        .orElse("nic"));
        
        // filter + collect
        System.out.println("FILTER: "
                + getBr("src/main/resources/ucty.csv").lines()
                        .filter((String s) -> {
                            return s.contains("3");

                        }).collect(Collectors.toList()));

        // collect
        System.out.println("COLLECT: " + getBr("src/main/resources/ucty.csv").lines()
                .collect(Collectors.toList()));

        // map reduce
        BufferedReader br = getBr("src/main/resources/cisla.txt");
        Stream<Integer> cisla = br.lines().map(l -> Integer.decode(l));
        Stream<Integer> mocniny = cisla.map(n -> n * n);
        System.out.println("REDUCE: Suma " + mocniny.reduce(0, (a, b) -> a + b));
        
        
        System.out.println("REDUCE: Dlzka najdlhsieho riadku = " 
                + getBr("src/main/resources/cisla.txt").lines()
                        .map(String::length)
                        .reduce(Math::max)
                        .orElse(0));
    }
   
}
