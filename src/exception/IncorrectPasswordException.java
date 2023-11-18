package exception;

public class IncorrectPasswordException extends Exception{
    public IncorrectPasswordException() {
        super("잘못된 비밀번호 입니다.");
    }
}
