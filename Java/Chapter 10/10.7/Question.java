/* Question 10.7 Imagine a web server for a simplified search engine.This system has 10O machines to respond to searchqueries,
 which may then call out using processSearch (string query) to another cluster of machines to actually get the result.
 The machine which responds to a given query is chosen at random,
 so you can not guarantee that the same machine will always respond to the same request.
 The method processSearch is very expensive.
 Design a caching mechanism to cache the results of the most recent queries.
 Be sure to explain how you would update the cache when data changes.*/

/*
This is a single machine caching system. And we use linkedlist and hashmap to maintain the query we cache in the machine as we want to update data and
look up data as fast as we can. Every time we access a new query, we put the query in the first of linkedlist.
 */


public class Question {

    public static String[] generateResults(int i) {
        String[] results =  {"resultA" + i, "resultB" + i, "resultC" + i};
        return results;
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 20; i++) {
            String query = "query" + i;
            cache.insertResults(query, generateResults(i));
            if (i == 9 || i == 16 || i == 19) {
                cache.getResults("query" + 2);
                cache.getResults("query" + 6);
                cache.getResults("query" + 9);
            }
        }

        for (int i = 0; i < 30; i++) {
            String query = "query" + i;
            String[] results = cache.getResults(query);
            System.out.print(query + ": ");
            if (results == null) {
                System.out.print("null");
            } else {
                for (String s : results) {
                    System.out.print(s + ", ");
                }
            }
            System.out.println("");
        }
    }
}