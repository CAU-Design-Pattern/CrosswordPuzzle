package service;

import com.holub.text.ParseFailure;
import dto.Rank;
import repository.RankRepository;
import util.DateUtil;

import java.io.IOException;
import java.util.List;

public class RankService {
    private RankRepository rankRepository;

    public RankService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    /**
     * Rank DB에 저장된 랭킹을 return 해줍니다.
     * @return
     * @throws IOException
     * @throws ParseFailure
     */
    public List<Rank> getRankList() throws IOException, ParseFailure {
        return rankRepository.getAllRankList();
    }

    /**
     * id와 score를 입력하면 현재 날짜를 계산해서 rank db에 id, score, date를 저장해줍니다.
     * @param id
     * @param score
     * @throws IOException
     * @throws ParseFailure
     */
    public void saveRank(String id, Integer score) throws IOException, ParseFailure {
        String nowDate = DateUtil.getNowDateYYYYMMDD();
        Rank rank = new Rank(id, score, nowDate);
        Rank exist = rankRepository.getRank(rank);
        if(exist != null){
            rankRepository.updateRank(rank);
        } else {
            rankRepository.insertRank(rank);
        }
    }
}
