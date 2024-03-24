package game.configuration;

public class GameConfiguration {
    private GameRules gameRules;
    private GameType gameType;

    private int maxNumberLength;

    public GameRules getGameRules() {
        return gameRules;
    }

    public void setGameRules(GameRules gameRules) {
        this.gameRules = gameRules;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public int getMaxNumberLength() {
        return maxNumberLength;
    }

    public void setMaxNumberLength(int maxNumberLength) {
        this.maxNumberLength = maxNumberLength;
    }

    public GameConfiguration(GameRules gameRules, GameType gameType, int maxNumberLength) {
        this.gameRules = gameRules;
        this.gameType = gameType;
        this.maxNumberLength = maxNumberLength;
    }
}
