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
        text = String.join("", words);//string containing words split by space & comma
        text = text.replaceAll("\\p{P}","");//remove brackets from string
        String[] words0 = text.split(" ");//array containing words split by space and comma
        ArrayList<String> wordsList = new ArrayList<>();//list holding final split words

        //add each word into wordList
        for(int i = 0; i < words0.length; i++){
            if(!wordsList.contains(words0[i])){
                wordsList.add(words0[i]);
            }
        }
        for(int numWords = 0; numWords < wordsList.size(); numWords++){
            indexes.put(wordsList.get(numWords), position);
        }

        for(int docIndex = 0; docIndex < texts.size(); docIndex++) {
            List<Integer> pos = new LinkedList<>();
            position.add(pos);
            //traverse strings of each doc
            for(int strIndex = 0; strIndex < texts.size(); strIndex++) {
                if(wordsList.get(docIndex).equals(wordsList.get(strIndex))){
                    //pos.add(strIndex);

                }
            }

        }
        System.out.println("indexes: " + indexes);
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework

        return new ArrayList<>(); // place holder
    }
}
