package service;

import com.holub.database.*;
import com.holub.text.ParseFailure;
import dto.Word;
import exception.UnsupportedExtensionException;
import repository.WordRepository;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Random;

public class WordService {
    private WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    /**
     * 모든 word를 return해줍니다.
     * @return
     * @throws IOException
     * @throws ParseFailure
     */
    public List<Word> getAllWordList() throws IOException, ParseFailure {
        return wordRepository.getWordList();
    }

    /**
     * 특정 길이의 word 목록을 return해줍니다.
     * @param length
     * @return
     * @throws IOException
     * @throws ParseFailure
     */
    public List<Word> getWordListByLength(int length) throws IOException, ParseFailure {
        return wordRepository.getWordList(length);
    }

    /**
     * 특정 알파벳을 포함하는 Word 중 랜덤하게 하나를 return
     * @param alphabet
     * @return null or Word
     * @throws IOException
     * @throws ParseFailure
     */
    public Word getRandomWordIncludingAlphabet(char alphabet) throws IOException, ParseFailure {
        // 기존 board에서 사용하고 있는 word랑 중복 회피 ?
        List<Word> wordList = wordRepository.getWordList(alphabet);
        if(wordList.isEmpty()) return null;
        Random random = new Random();
        int randomIdx = random.nextInt(wordList.size());
        return wordList.get(randomIdx);
    }
    
    /**
     * index번째에 특정 알파벳을 가진 length 길이의 word를 return
     * @param alphabet
     * @param index
     * @param length
     * @return
     * @throws ParseFailure 
     * @throws IOException 
     */
    public Word getRandomWord(char alphabet, int index, int length) throws IOException, ParseFailure {
    	List<Word> wordList = wordRepository.getWordList(alphabet, index, length);
        if(wordList.isEmpty()) return null;
        Random random = new Random();
        int randomIdx = random.nextInt(wordList.size());
        return wordList.get(randomIdx);
    }
    
    /**
     * index번째에 특정 알파벳을 가진 word를 return
     * @param alphabet
     * @param index
     * @return
     * @throws IOException
     * @throws ParseFailure
     */
    public Word getRandomWord(char alphabet, int index) throws IOException, ParseFailure {
    	List<Word> wordList = wordRepository.getWordList(alphabet, index);
        if(wordList.isEmpty()) return null;
        Random random = new Random();
        int randomIdx = random.nextInt(wordList.size());
        return wordList.get(randomIdx);
    }

    /**
     * 입력받은 word의 Word 객체를 return
     * ex) 인자로 "test"가 넘어올 시 DB에 저장된 "test"의 desc와 level등을 조회해서 return해줍니다
     * @param word
     * @return
     * @throws IOException
     * @throws ParseFailure
     */
    public Word getOneWord(String word) throws IOException, ParseFailure {
        return wordRepository.getWord(word);
    }

    /**
     * word 하나를 DB에 저장해줍니다.( 사용자가 화면상에서 직접 입력해서 저장하는 경우에 사용할 수 있을 것같습니다.)
     * @param word
     * @throws IOException
     * @throws ParseFailure
     */
    public void insertOneWord(Word word) throws IOException, ParseFailure {
        wordRepository.insertOneWord(word);
    }

    /**
     * word 여러개를 DB에 저장해줍니다. ( 사용자가 화면상에서 직접 입력해서 저장하는 경우에 사용할 수 있을 것같습니다.)
     * @param wordList
     * @throws IOException
     * @throws ParseFailure
     */
    public void insertManyWord(List<Word> wordList) throws IOException, ParseFailure {
        for (Word word : wordList) {
            insertOneWord(word);
        }
    }

    /**
     * 해당 단어를 DB에서 업데이트 해줍니다. (해당 word의 desc와 level을 업데이트 시켜줄 수 있습니다.)
     * @param word
     * @throws IOException
     * @throws ParseFailure
     */
    public void updateOneWord(Word word) throws IOException, ParseFailure {
        wordRepository.updateOneWord(word);
    }

    /**
     * 파일경로와 확장자를 넘겨주면 해당 파일에 있는 단어목록을 db에 저장 (필요시 사용)
     * ex) importWordList("C:/dp2023/migration", "csv") -> migration.csv에 있는 단어들을 word.csv에 import 시켜줍니다.
     * sql에서 추가로 확장한 xml, html import 를 사용할 수 있도록 설계를 해놨습니다. (현재는 주석처리 )
     * @param filePath
     * @param extension
     * @throws IOException
     * @throws UnsupportedExtensionException
     * @throws ParseFailure
     */
    public void importWordList(String filePath, String extension) throws IOException, UnsupportedExtensionException, ParseFailure {

        filePath = filePath + "." +extension;
        Reader in = new FileReader(filePath);
        Table.Importer importer;
        switch (extension){
            case "csv":
                importer = new CSVImporter(in);
                break;
//            case "xml":
//                importer = new XMLImporter(in);
//                break;
            default:
                throw new UnsupportedExtensionException();
        }
        UnmodifiableTable importTable = new UnmodifiableTable(new ConcreteTable(importer));
        in.close();
        Cursor cursor = importTable.rows();
        List<Word> words = wordRepository.transferWordList(cursor);
        this.insertManyWord(words);
    }
}
