package cinema;

public enum Menu {
    SHOW ("1. Show the seats"),
    BUY ("2. Buy a ticket"),
    STATISTICS ("3. Statistics"),
    EXIT ("0. Exit");

    private final String stringMenu;

    Menu(String stringMenu) {
        this.stringMenu = stringMenu;
    }

    @Override
    public String toString() {
        return stringMenu;
    }
}
