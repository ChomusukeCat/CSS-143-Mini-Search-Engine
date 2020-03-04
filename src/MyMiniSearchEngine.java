import java.lang.reflect.Array;
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
        String text = texts.toString();

        //split words from docs then add to array
        String[] wordsArr = text.split(",");
        text = String.join("", wordsArr);//string containing words split by space & comma
        text = text.replaceAll("\\p{P}","");//remove brackets from string
        wordsArr = text.split(" ");//array containing words
        ArrayList<String> wordsList = new ArrayList<>();//list holding final split words

        //add each word into wordList
        for(int i = 0; i < wordsArr.length; i++){
            if(!wordsList.contains(wordsArr[i])){
                wordsList.add(wordsArr[i]);
            }
        }

        System.out.println("wordsList" + wordsList.toString());
        System.out.print("wordsArr:" );
        for(int i = 0; i < wordsArr.length; i++){
           System.out.print(wordsArr[i] + ", ");
        }
        System.out.println();

        //add position of words into index
        for(int docIndex = 0; docIndex < wordsList.size(); docIndex++) {
            List<List<Integer>> docs = new LinkedList<>();
            //List<Integer> doc = new LinkedList<>();

            //add number of lists corresponding to num of documents provided into docs lists
            for(int i = 0; i < texts.size(); i ++) {
                docs.add(new LinkedList<>());
            }

            //traverse each word of each document
            for(int wordIndex = 0; wordIndex < wordsArr.length; wordIndex++) {
                if(wordsList.get(docIndex).equals(wordsArr[wordIndex])){//if curr word is found in doc, add its position to index
                    docs.get(docIndex).add(wordIndex);
                }
            }
            indexes.put(wordsList.get(docIndex), docs);
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
