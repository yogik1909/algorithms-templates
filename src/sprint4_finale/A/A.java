// Задача A. Поисковая система
// hhttps://contest.yandex.ru/contest/24414/problems/A/
// Посылка: https://contest.yandex.ru/contest/24414/run-report/113784370/

/*
**Поисковый механизм**

Поисковый механизм основан на создании индекса с использованием карты. Для каждого слова создаётся своя карта,
 которая содержит информацию о документе, в котором это слово встречается, а также количество его вхождений.

Операция поиска осуществляется на основе уникальных слов и определения релевантности поиска в зависимости от частоты
встречаемости искомого слова в документе и обобщения по поисковой строке. Этот процесс похож на полнотекстовый поиск.

**Механизм индексации**

Вычислительная сложность механизма индексации равна O(n * k), где n — количество документов, а k — количество слов.
Для построения индекса мы обрабатываем все документы и каждое слово в них.

Сложность построения карты и подсчёта вхождений для каждого слова равна O(1).

Пространственная сложность механизма индексации составляет O(n * k) в худшем случае, когда каждое слово из набора
документов встречается во всех документах одновременно.

**Механизм поиска**

Вычислительная сложность механизма поиска в худшем случае асимптотически равна O(k + n^2), где k — количество слов
в поисковой строке, а n — количество документов в индексе. Для получения релевантных результатов поиска необходимо
обработать все уникальные слова, которые могут быть в поисковой строке.

Квадратичная сложность возникает при определении релевантности поиска, то есть при сортировке результатов.

Пространственная сложность механизма поиска составляет O(n^2 + k), где n — количество документов в индексе,
а k — количество слов в строке. Также требуется дополнительное пространство для хранения карт вхождений слов в строку,
массива уникальных слов поисковой строки, массива результатов поиска по индексу и определения релевантности.
 */


package sprint4_finale.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class SeachEngine {


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

        List<Map.Entry<Integer, Integer>> limitItem = new ArrayList<>();
        Map<Integer, Object> mapMaxRelevItemConst = new HashMap<>();
        Map.Entry<Integer, Integer> maxItem;
        for (int i = 0; i < 5; i++) {
            maxItem = null;
            for (Map.Entry<Integer, Integer> relSetEntry : relevance.entrySet()) {
                if (mapMaxRelevItemConst.containsKey(relSetEntry.getKey())) {
                    continue;
                }
                if (maxItem == null) {
                    maxItem = relSetEntry;
                    continue;
                }
                int comp = Integer.compare(relSetEntry.getValue(), maxItem.getValue());
                if (comp > 0) {
                    maxItem = relSetEntry;
                } else if (comp == 0 && Integer.compare(relSetEntry.getKey(), maxItem.getKey()) < 0) {
                    maxItem = relSetEntry;
                }

            }
            if (maxItem == null) break;
            limitItem.add(maxItem);
            mapMaxRelevItemConst.put(maxItem.getKey(), "");
        }
        List<Integer> results = new ArrayList<>(5);

        for (int i = 0; i < limitItem.size(); i++) {
            if (limitItem.get(i).getValue() > 0) {
                results.add(limitItem.get(i).getKey());
            }
        }
        return results;
    }
}

public class A {

    public static void main(String[] args) throws IOException {

        SeachEngine engine = new SeachEngine();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
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
