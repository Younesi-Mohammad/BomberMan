package sample;

public abstract class Command {

    private GamePlayer gamePlayer;

    public Command(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public abstract boolean execute();

    public abstract boolean isValid();
}
