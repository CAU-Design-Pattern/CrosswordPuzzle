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
    public void test() throws IncorrectPasswordException, IOException, ParseFailure, UniqueFailException {
        try {
            accountService.signUp("test", "test1234");
        } catch (UniqueFailException e) {
            System.out.println("이미 생성된 Id");
        }


        Assertions.assertThrows(IncorrectPasswordException.class, () -> accountService.signIn("test", "test1111"));

        Account account = accountService.signIn("test", "test1234");

    }
}
