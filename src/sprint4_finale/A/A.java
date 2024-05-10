package sprint4_finale.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {
    private Map<String, Map<Integer, Integer>> index = new HashMap<>();
    private List<String> documents = new ArrayList<>();

    public void addNewDocument(String document) {
        int docId = documents.size();
        documents.add(document);
        String[] words = document.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();
            index.computeIfAbsent(word, k -> new HashMap<>()).put(docId, count);
        }
    }

    public List<Integer> doSearch(String query) {
        Map<Integer, Integer> relevance = new HashMap<>();

        String[] queryWords;
        queryWords = new HashSet<>(Arrays.asList(query.split("\\s+"))).toArray(new String[0]);

        for (String word : queryWords) {
            if (relevance.containsKey(word)) continue;
            if (index.containsKey(word)) {
                for (Map.Entry<Integer, Integer> entry : index.get(word).entrySet()) {
                    int docId = entry.getKey();
                    int count = entry.getValue();
                    relevance.put(docId, relevance.getOrDefault(docId, 0) + count);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(relevance.entrySet());
        sortedEntries.sort((a, b) -> {
            int cmp = Integer.compare(b.getValue(), a.getValue());
            if (cmp == 0) {
                return Integer.compare(a.getKey(), b.getKey());
            }
            return cmp;
        });

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < Math.min(5, sortedEntries.size()); i++) {
            if (sortedEntries.get(i).getValue() > 0) {
                results.add(sortedEntries.get(i).getKey());
            }
        }
        return results;
    }

    public static void main(String[] args) throws IOException {

        A engine = new A();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                engine.addNewDocument(reader.readLine());
            }
            List<Integer> results;
            int m = Integer.parseInt(reader.readLine());
            for (int i = 0; i < m; i++) {
                results = engine.doSearch(reader.readLine());
                StringBuilder sb = new StringBuilder("");
                for (Integer result : results) {
                    sb.append(result + 1).append(" ");
                }
                System.out.println(sb);
            }
        }

    }
}
