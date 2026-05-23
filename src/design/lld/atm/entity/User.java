package design.lld.atm.entity;

public class User {
    private final String name;
    private final Card card;

    public User(String name, Card card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public Card getCard() {
        return card;
    }
}
