import java.util.*;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    private Map<String, List<List<Integer>>> indexes;

    // disable default constructor
    private MyMiniSearchEngine() {
    }

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    // each item in the List is considered a document.
    // assume documents only contain alphabetical words separated by white spaces.
    private void index(List<String> texts) {
        //homework
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        int n = texts.size();
        List<List<Integer>> position = new LinkedList<>();
        String text = texts.toString();
        //split words from docs then add to array
        String[] words = text.split(",");//array containing words split by comma
        text = String.join("", words);//string containing words split by space
        String[] words0 = text.split(" ");//array containing words split by space and comma
        String[] wordsSplit = new String[n];//array holding final split words
        for (int i = 0; i < words0.length; i++) {
            System.out.print(words0[i] + ", ");
        }
        System.out.println();
        /*add all words into array from doc
        use another array that only contains diff words
        if curr word i is not the same as other words, add to 2nd array
        */
        for(int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (!words0[i].equals(words0[j])) {
                    wordsSplit[i] = words[j];
                    break;
                }
            }
        }
        System.out.println("wordsSplit: ");
        for(int i = 0; i < wordsSplit.length; i++) {
            System.out.print( wordsSplit[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            List<Integer> pos = new LinkedList<>();
            //traverse strings of each doc
            for(int j = 0; j < wordsSplit.length; j++) {
                if(wordsSplit[i].equals(words[j])){
                    pos.add(j);
                    position.add(pos);
                }
            }
            indexes.put(wordsSplit[i], position);
        }
        System.out.println(indexes);
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework

        return new ArrayList<>(); // place holder
    }
}
