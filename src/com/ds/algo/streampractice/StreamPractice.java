package com.ds.algo.streampractice;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreamPractice {
  public static void main(String[] args) {
    List<List<Double>> list =
        Arrays.asList(Arrays.asList(3.0), Arrays.asList(9.0, 20.0, 1.0), Arrays.asList(15.0, 7.0), Arrays.asList());

    List<Double> resultNew = list.stream()
            .map(a -> a.stream().mapToDouble(x -> x).average().orElse(0.0))
            .collect(Collectors.toList());

    List<Double> result = list.stream()
            .map(t -> t.stream().collect(Collectors.averagingDouble(Double::doubleValue)))
            .collect(Collectors.toList());

    System.out.println("resultNew : "+resultNew);
    System.out.println("resilt :"+result);
  }
}
