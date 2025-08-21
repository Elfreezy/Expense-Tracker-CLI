public class CustomExceptions {
}


class NotValidAmount extends RuntimeException {
    NotValidAmount() {
        super();
    }

    NotValidAmount(String message) {
        super(message);
    }
}