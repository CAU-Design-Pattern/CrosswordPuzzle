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
     * 회원가입 (id, password) 를 받으면 중복되지 않은 id에 한해서 회원가입을 해줍니다.
     * 중복된 경우 UniqueFailException 을 던집니다.
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
     * 로그인 : id와 password를 받고 맞으면 해당 사용자의 정보 (id, password, level)을 저장한 Account 인스턴스를 return합니다.
     * 만약 password가 맞지않아 실패한 경우 IncorrectPasswordException 를 던집니다.
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
