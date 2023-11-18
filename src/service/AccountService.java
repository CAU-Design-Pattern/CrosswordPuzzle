package service;

import com.holub.text.ParseFailure;
import dto.Account;
import exception.IncorrectPasswordException;
import exception.UniqueFailException;
import repository.AccountRepository;

import java.io.IOException;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * 회원가입
     *
     * @param id
     * @param password
     * @return
     * @throws UniqueFailException
     * @throws IOException
     * @throws ParseFailure
     */
    public Account signUp(String id, String password) throws UniqueFailException, IOException, ParseFailure {
        try {
            Account account = new Account(id, password, 0);
            accountRepository.insertOneAccount(account);
            return account;
        } catch (UniqueFailException e) {
            e.printStackTrace();
            throw new UniqueFailException("이미 해당 Id가 존재합니다.");
        }
    }

    /**
     * 로그인
     * @param id
     * @param password
     * @return
     * @throws IOException
     * @throws ParseFailure
     * @throws IncorrectPasswordException
     */
    public Account signIn(String id, String password) throws IOException, ParseFailure, IncorrectPasswordException {
        Account exist = accountRepository.getOneAccountById(id);
        if (exist.getPassword().equals(password)) return exist;
        else throw new IncorrectPasswordException();
    }
}
