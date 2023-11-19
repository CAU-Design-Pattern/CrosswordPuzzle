package test;

import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import dto.Rank;
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
    public void test() throws IOException, ParseFailure {
        rankService.saveRank("test1", 10);
        rankService.saveRank("test2", 20);
        rankService.saveRank("test3", 40);
        rankService.saveRank("test4", 30);

        List<Rank> rankList = rankService.getRankList();
        for (Rank rank : rankList) {
            System.out.println(rank);
        }
    }
}
