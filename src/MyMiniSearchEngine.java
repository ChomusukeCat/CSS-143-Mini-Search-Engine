import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    private Map<String, List<List<Integer>>> indexes = new HashMap<>();

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
        //Map<String, List<List<Integer>>> indexes = new HashMap<>();
        String text = texts.toString();

        //split words from docs then add to array
        String[] wordsArr = text.split(",");
        text = String.join("", wordsArr);//string containing words split by space & comma
        text = text.replaceAll("\\p{P}", "");//remove brackets from string
        wordsArr = text.split(" ");//array containing words
        ArrayList<String> wordsList = new ArrayList<>();//list holding final split words

        //add each word into wordList
        for (int i = 0; i < wordsArr.length; i++) {
            if (!wordsList.contains(wordsArr[i])) {
                wordsList.add(wordsArr[i]);
            }
        }
        //display contents of arr and list
        /*
        System.out.println("wordsList" + wordsList.toString());
        System.out.print("wordsArr:");
        for (int i = 0; i < wordsArr.length; i++) {
            System.out.print(wordsArr[i] + ", ");
        }
        System.out.println();*/

        List<List<Integer>> docs;
        //add doc ids into docs
        for (int docIndex = 0; docIndex < wordsList.size(); docIndex++) {
            docs = new LinkedList<>();

            //add number of lists corresponding to num of documents provided into docs lists
            for (int i = 0; i < texts.size(); i++) {
                docs.add(new LinkedList<>());
            }
            indexes.put(wordsList.get(docIndex), docs);
        }

        //traverse each word in the index
        for (int wrdIndx = 0; wrdIndx < wordsList.size(); wrdIndx++) {
            //traverse each doc
            for (int docIndx = 0; docIndx < texts.size(); docIndx++) {
                int pos = 0;
                Scanner scan = new Scanner(texts.get(docIndx));//traverse words in each doc
                while (scan.hasNext()) {
                    if (wordsList.get(wrdIndx).equals(scan.next())) {
                        indexes.get(wordsList.get(wrdIndx)).get(docIndx).add(pos);
                    }
                    pos++;
                }
            }
        }
        //System.out.println("indexes: " + indexes);
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework
        //1. find all occurrences of keyPhrase in index
        //2. traverse occurrences, if kP and occurrence in curr doc matches, add to list

        keyPhrase = keyPhrase.toLowerCase();
        //place kP into arr
        String[] kPArr = keyPhrase.split(" ");
        System.out.println("Index:" + indexes);

        //check if kP found in index
        for(int i = 0; i < kPArr.length; i++){
            if(!indexes.containsKey(kPArr[i])){
                return null;
            }
        }
        List<Integer> result = new ArrayList<>();
        List<List<List<Integer>>> inst = new LinkedList<>();//keeps instances of kP found in index

        //extract keys from indexes into Str arr
        String word = indexes.keySet().toString();
        String[] wordsArr = word.split(",");
        word = String.join("", wordsArr);//string containing words split by space & comma
        word = word.replaceAll("\\p{P}", "");//remove brackets from string
        wordsArr = word.split(" ");//array containing words

        //traverse indexes and add docs into inst list if kP and curr word match
        for(int wrdIndx = 0; wrdIndx < kPArr.length; wrdIndx++) {//wrdIndx indicates curr word
            for(int i = 0; i < wordsArr.length; i++) {
                if (kPArr[wrdIndx].equals(wordsArr[i])) {
                    inst.add(indexes.get(kPArr[wrdIndx]));
                }
            }
        }
        List<Integer> r = new LinkedList<>();
        if(kPArr.length > 1) {
            //when both words in kP appear,
            for(int outerList = 0; outerList < inst.size()-1; outerList++){
                int i = 0;
                for(int innerList = 0; innerList < inst.get(outerList).size(); innerList++) {
                    if (!inst.get(outerList).get(innerList).isEmpty() && !inst.get(outerList + 1).get(innerList).isEmpty()) {
                        r.add(i);
                        System.out.println(r);
                    }
                    i++;
                }
            }
        }

        return result; // place holder
    }
}
