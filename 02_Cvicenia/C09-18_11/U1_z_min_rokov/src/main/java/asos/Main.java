package asos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


//    A. Implementujte funkciu double priemer(List<Double> data), ktorá dostane zoznam 
//        čísel a vypočíta ich priemer pomocou funkcionálnych Stream-metód. 
//
//    Funkcia priemer vytvorí zo zoznamu stream čísel a 
//        - na výpočet súčtu čísel použite stream-metódu reduce a vhodný lambda výraz
//        - zistenie počtu čísel použite stream metódu count.
//        - presvedče sa, že pre výpočet počtu aj súčtu nie je možné použiť ten istý stream (treba ho nanovo vytvoriť zo zoznamu).
//
//    Metóda reduce s jedným parametrom vracia objekt Optional, výslednú hodnotu z neho dostanete pomocou get(). 
//    Môžete použiť metódu reduce s dvoma parametrami, ktorá výslednú hodnotu vracia priamo. Vyskúšajte a provnajte obe verzie.

    
    static double priemer(List<Double> data) {
        long cnt = data.stream().count();
        return data.stream().reduce(0.0, (a,b) -> a + b) / cnt;
    }


//    B. Skúste implementovať výpočet priemeru ako funkciu, ktorá dostane ako vstup stream čisel: 
//    double priemer(Stream<Double> data). 

    
    static double priemer2(Stream<Double> data) {
        List<Double> cntList = data.collect(Collectors.toList());
        double cnt = cntList.stream().count();
        return cntList.stream().reduce(0.0, (a, b) -> a + b) / cnt;
    }

    public static void main(String[] args) {
        
        
        List<Double> cisla = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cisla.add(Math.random());
        }

        System.out.println("Priemer=" + priemer(cisla));
        
        Stream<Double> cislaStream = Stream.generate(() -> Math.random()).limit(10);
        System.out.println("Priemer=" + priemer2(cislaStream));
    }

}
