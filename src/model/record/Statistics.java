package model.record;

public class Statistics extends Record{
    private int matchesPlayed;

    public Statistics(int id, int matchesPlayed) {
        super(id);
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
}
