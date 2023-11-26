package test;

import com.holub.database.Database;
import com.holub.text.ParseFailure;
import connector.DatabaseConnector;
import dto.Account;
import exception.IncorrectPasswordException;
import exception.UniqueFailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.AccountRepository;
import service.AccountService;

import java.io.IOException;

public class AccountServiceTest {
    private AccountService accountService;

    @BeforeEach
    public void setUp() throws IOException, ParseFailure {
        DatabaseConnector instance = DatabaseConnector.getInstance();
        Database database = instance.getDatabase();
        AccountRepository accountRepository = new AccountRepository(database);
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void AccountTest() throws IncorrectPasswordException, IOException, ParseFailure, UniqueFailException {
        try {
            System.out.println("현재 디비에 id : test, pw : test1234 로 계정을 만듭니다.");
            accountService.signUp("test", "test1234");
        } catch (UniqueFailException e) {
            System.out.println("이미 생성된 Id입니다.");
        }

        System.out.println("틀린 비밀번호를 넣었을 때 exception이 작동하는지 체크");
        Assertions.assertThrows(IncorrectPasswordException.class, () -> accountService.signIn("test", "test1111"));

        System.out.println("맞는 로그인 에러 없이 정상 작동");
        Assertions.assertDoesNotThrow(() -> accountService.signIn("test", "test1234"));


    }
}
