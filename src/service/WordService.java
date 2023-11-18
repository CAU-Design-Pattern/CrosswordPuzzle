package service;

import com.holub.text.ParseFailure;
import dto.Word;
import repository.WordRepository;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class WordService {
    private WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> getAllWordList() throws IOException, ParseFailure {
        return wordRepository.getWordList();
    }

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

    public Word getOneWord(String word) throws IOException, ParseFailure {
        return wordRepository.getWord(word);
    }

    public void insertOneWord(Word word) throws IOException, ParseFailure {
        wordRepository.insertOneWord(word);
    }

    public void insertManyWord(List<Word> wordList) throws IOException, ParseFailure {
        for (Word word : wordList) {
            insertOneWord(word);
        }
    }

    public void updateOneWord(Word word) throws IOException, ParseFailure {
        wordRepository.updateOneWord(word);
    }
}
