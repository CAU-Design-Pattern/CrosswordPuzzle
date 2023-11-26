package test;

import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import dto.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.RankRepository;
import service.RankService;

import java.io.IOException;
import java.util.List;

public class RankServiceTest {
    private RankService rankService;
    @BeforeEach
    public void setUp() throws IOException, ParseFailure {
        DatabaseConnector instance = DatabaseConnector.getInstance();
        Database database = instance.getDatabase();
        RankRepository rankRepository = new RankRepository(database);
        rankService = new RankService(rankRepository);
    }

    @Test
    public void RankTest() throws IOException, ParseFailure {
        rankService.saveRank("test9999999", 200000000);
        rankService.saveRank("test8888888", 200000000);
        rankService.saveRank("test7777777", 400000000);
        rankService.saveRank("test6666666", 300000000);

        List<Rank> rankList = rankService.getRankList();

        Rank rank1 = rankList.get(0);
        Assertions.assertEquals("test7777777", rank1.getId());
        Assertions.assertEquals(1, rank1.getRank());


        Rank rank2 = rankList.get(1);
        Assertions.assertEquals("test6666666", rank2.getId());
        Assertions.assertEquals(2, rank2.getRank());

        Rank rank3 = rankList.get(2);
        System.out.println(rank3);
        Assertions.assertEquals(3, rank3.getRank());

        Rank rank3_1 = rankList.get(3);
        System.out.println(rank3_1);
        Assertions.assertEquals(3, rank3_1.getRank());

    }
}
