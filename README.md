# I-ASOS

Architektúra softvérových systémov (2. ročník ING, zimný semester)

<br>

## Dependencies

```
<dependencies>
    <dependency>
        <groupId>org.apache.spark</groupId>
        <artifactId>spark-sql_2.12</artifactId>
        <version>3.2.0</version>
    </dependency>
</dependencies>
```
<br>

## Custom Consumer

Namiesto lambda vyrazu sa funkcia vytiahne do consumera

```
myList.stream().forEach(new MyConsumer());
```

MyConsumer.java
```
public class MyConsumer implements Consumer<T>{

    @Override
    public void accept(T t) {}  
}
```
<br>

## Custom Supplier
```
Stream.generate(new MySupplier()).forEach(t -> {});
```
MySupplier.java
```
public class MySupplier implements Supplier<T>{

    @Override
    public T get() {
        return new T(...);
    }  
}
```

<br>

## BufferredReader stream (lines)
```
static Stream getBrLines(String fname) throws FileNotFoundException {
    return new BufferedReader(
            new FileReader(fname)
    ).lines()
}
```
```
static Stream getStdInLines() {
    return new BufferedReader(
            new InputStreamReader(System.in)
    ).lines()
}

```

<br>

## Spark

<br>

```
SparkConf conf = new SparkConf().setAppName("meno aplikacie").setMaster("local"); 
JavaSparkContext sc = new JavaSparkContext(conf);
sc.setLogLevel("ERROR");
```

<br>


## List

<br>


### parallelize: List to RDD
```
JavaRDD<String> listRdd = sc.parallelize(list);
```
### collect: RDD to List
```
List<String> collectedList = listRdd.collect();
```

### foreach/ forEach
```
listRdd.foreach(item -> {
    System.out.println(item);
});
```
### map
```
JavaRDD<String> listRdd2 = listRdd.map(item -> {
    return item.toLowerCase();
});
```
### count
```
long itemCount = listRdd.count();
```
### filter
```
JavaRDD<String> filtered = listRdd.filter(item -> {
    return item.length() > 2;
});

JavaRDD<String> filtered = listRdd.filter(item -> {
    return item.contains("A");
});
```
### first
```
String firstItem = listRdd.first();
```

<!-- ### limit
```
``` -->
### distinct
```
JavaRDD<String> distinctVals = listRdd.distinct();
```
### reduce: spojenie elementov pomocou nejakeho operatora
```
int sum = numbers.reduce((a,b)->a+b); 

String concatAll = listRdd.reduce((a,b)->{
    return a + b;
});

int maxLength = listRdd.map(String::length).reduce(Math::max);

```
### subtract: rozdiel mnozin
```
JavaRDD<String> subtracted = listRdd.subtract(list2Rdd);
```

<br>

## File

<br>


### textFile
```
JavaRDD<String> fileRdd = sc.textFile("src/main/resources/text.txt");
```
### wholeTextFiles
```
JavaPairRDD<String, String> dirPairRdd = sc.wholeTextFiles("src/main/resources");
```

<br>

## Map , JavaPairRDD, Tuple2

<br>


### mapToPair
```
// [(AAA,3), (BB,2), (CC,2), (BB,2), (C,1)]

JavaPairRDD<String, Integer> pairRdd = fileRdd.mapToPair(s -> {
    return new Tuple2(s, s.length());
});

```
### mapValues
```
JavaPairRDD<String, Integer> pairRddMapVal = pairRdd.mapValues((val) -> {
    return val * 10;
});

// pairRdd: [(AAA,3), (BB,2), (CC,2), (BB,2), (C,1)]
// pairRddMapVal: [(AAA,30), (BB,20), (CC,20), (BB,20), (C,10)]
```
### collectAsMap
```
pairRdd.collect(): [(AAA,3), (BB,2), (CC,2), (BB,2), (C,1)]
pairRdd.collectAsMap(): {AAA=3, C=1, BB=2, CC=2}
```
### groupBy 
```
JavaPairRDD<Integer, Iterable<String>> groups = fileRdd.groupBy(s -> s.length());

// iba jedna tuple
Tuple2<Integer, Iterable<String>> tuple = groups.first();
System.out.println(tuple._1 + " " + tuple._2);
```
### sortByKey
```
JavaPairRDD<String, Integer> sorted = pairRdd.sortByKey();
// sorted.collect(): [(AAA,3), (BB,2), (BB,2), (C,1), (CC,2)]
// sorted.collectAsMap(): {AAA=3, C=1, BB=2, CC=2} - map nie je sortnuta
```
### countByValue
```
Map<String, Long> countByVal = fileRdd.countByValue();
// fileRdd: [AAA, BB, CC, BB, C]
// countByVal: {BB=2, AAA=1, C=1, CC=1}

Map<Tuple2<String, Integer>, Long> countByVal = pairRdd.countByValue();
// pairRdd: [(AAA,3), (BB,2), (CC,2), (BB,2), (C,1)]
// countByVal: {(BB,2)=2, (CC,2)=1, (C,1)=1, (AAA,3)=1}
```
### flatMap
```
JavaRDD<String> rdd1 = 
    sc.textFile("src/main/resources/data.txt")
    .flatMap(s -> Arrays.asList(s.split(" ")).iterator());
```

### flatMapValues
```
JavaPairRDD<String, String> fwdd = 
    pdd.flatMapValues(s -> Arrays.asList(s.split("\\s+")).iterator());
```
### reduceByKey
```
// Pre kazdy slovo mena suborov spojene do jedneho retazca
fwdd.mapToPair(itm -> new Tuple2<String, String>(itm._2, itm._1))
    .reduceByKey((a, b) -> a + ", " + b);
```




