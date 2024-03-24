package dto;

public class GameProgressResult {
    private int assumption;
    private int cowsCount;
    private int bullsCount;
    private boolean isNumberGuessed;

    public int getAssumption() {
        return assumption;
    }

    public void setAssumption(int assumption) {
        this.assumption = assumption;
    }

    public int getCowsCount() {
        return cowsCount;
    }

    public void setCowsCount(int cowsCount) {
        this.cowsCount = cowsCount;
    }

    public int getBullsCount() {
        return bullsCount;
    }

    public void setBullsCount(int bullsCount) {
        this.bullsCount = bullsCount;
    }

    public boolean isNumberGuessed() {
        return isNumberGuessed;
    }

    public void setNumberGuessed(boolean numberGuessed) {
        isNumberGuessed = numberGuessed;
    }

    public GameProgressResult(int assumption, int cowsCount, int bullsCount, boolean isNumberGuessed) {
        this.cowsCount = cowsCount;
        this.bullsCount = bullsCount;
        this.isNumberGuessed = isNumberGuessed;
        this.assumption = assumption;
    }
}
