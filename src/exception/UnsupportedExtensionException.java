package exception;

public class UnsupportedExtensionException extends Exception {
    public UnsupportedExtensionException() {
        super("지원하지 않는 확장자입니다.");
    }
}
