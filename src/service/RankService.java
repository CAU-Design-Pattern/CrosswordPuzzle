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

    public List<Rank> getRankList() throws IOException, ParseFailure {
        return rankRepository.getAllRankList();
    }

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
