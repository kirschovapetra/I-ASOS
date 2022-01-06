/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos;

import java.util.ArrayList;
import java.util.List;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import java.util.Arrays;
import java.util.Map;
import scala.Tuple2;

/**
 *
 * @author sheax
 */
public class FriendshipSuggestor {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("spark-ucet-app").setMaster("local[4]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        JavaRDD<String> lines = sc.textFile("src/main/resources/friendshipTest.csv");

        JavaPairRDD<Long, List<String>> friendships = lines.mapToPair(
                (String line) -> {
                    List<String> tmpList = Arrays.asList(line.split(";"));
                    return new Tuple2(Long.parseLong(tmpList.get(0)),
                                      tmpList.subList(1, tmpList.size()));

                }
        );

        JavaPairRDD<Friendship, Long> commonFriends = friendships.flatMapToPair(
                (fr) -> {

                    Long id = fr._1;
                    List<String> friends = fr._2;

                    List<Tuple2<Friendship, Long>> pairs = new ArrayList<>();

                    friends.forEach(friendId -> {
                        pairs.add(new Tuple2<>(new Friendship(id, friendId), - 1L));
                    });

                    for (int i = 0; i < friends.size(); i++) {
                        for (int j = i + 1; j < friends.size(); j++) {
                            
                            Friendship f = new Friendship(friends.get(i), friends.get(j));
                            pairs.add(new Tuple2(f, 1L));
                        }
                    }

                    return pairs.iterator();
                }
        );

        JavaPairRDD<Friendship, Long> commonFriendsCount = commonFriends.reduceByKey((a, b) -> a + b);

        JavaRDD<Friendship> friendsSuggestions = commonFriendsCount.filter(t -> t._2 >= 3).map(t -> t._1);

        JavaPairRDD<Long, Long> friendsSuggestionsPairs = friendsSuggestions.flatMapToPair(f -> {
            List<Tuple2<Long, Long>> tmpList = new ArrayList<>();
            tmpList.add(new Tuple2(f.getFirst(), f.getSecond()));
            tmpList.add(new Tuple2(f.getSecond(), f.getFirst()));

            return tmpList.iterator();
        });

        JavaPairRDD<Long, List<Long>> friendsSuggestionsList = friendsSuggestionsPairs.aggregateByKey(
                new ArrayList<>(),
                (list, id) -> {
                    list.add(id);
                    return list;
                },
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                });

        Map<Long, List<Long>> friendshipSuggestionMap = friendsSuggestionsList.collectAsMap();

        
        for (long key : friendshipSuggestionMap.keySet()) {
            System.out.print(key + " by mal byt priatelom s: ");
            for (long val: friendshipSuggestionMap.get(key)) {
                System.out.print(val + ", ");
            }
            System.out.println("");
        }
    }

}
