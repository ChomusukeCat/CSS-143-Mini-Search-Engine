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
        wordsArr = text.split(" ");//array containing words split by space and comma
        ArrayList<String> wordsList = new ArrayList<>();//list holding final split words

        //add each word into wordList
        for(int i = 0; i < wordsArr.length; i++){
            if(!wordsList.contains(wordsArr[i])){
                wordsList.add(wordsArr[i]);
            }
        }
        //add words into index
        /*for(int numWords = 0; numWords < wordsList.size(); numWords++){

            indexes.put(wordsList.get(numWords), doc);
        }*/

        //add location of words into index
        for(int docIndex = 0; docIndex < texts.size(); docIndex++) {
            List<List<Integer>> doc = new LinkedList<>();
            List<Integer> pos = new LinkedList<>();
            doc.add(pos);
            //traverse strings of each doc
            for(int strIndex = 0; strIndex < texts.size(); strIndex++) {
                if(wordsList.get(docIndex).equals(wordsArr[strIndex])){
                   pos.add(strIndex);
                }
            }
            indexes.put(wordsList.get(docIndex), doc);
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
