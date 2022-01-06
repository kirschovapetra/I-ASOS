/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.ArrayList;
import java.util.List;
import org.apache.spark.util.AccumulatorV2;

/**
 *
 * @author igor
 */
public class SumAccum extends AccumulatorV2<Ucet, List<Double>> {
   
    private List<Double> sumList = new ArrayList<>();

    @Override
    public boolean isZero() {
        return true;
    }

    @Override
    public AccumulatorV2<Ucet, List<Double>> copy() {
        AccumulatorV2<Ucet, List<Double>> c = new SumAccum();
        c.merge(this);
        return c;
    }

    @Override
    public void reset() {
        sumList.clear();
    }

    @Override
    public void add(Ucet in) {
        
        double urok = 0.1 * in.getStav();
        in.setStav(in.getStav() + urok);
        sumList.add(urok);
    }

    @Override
    public void merge(AccumulatorV2<Ucet, List<Double>> av) {
        sumList.addAll(av.value());
    }

    @Override
    public List<Double> value() {
        return sumList;
    }

 
}
