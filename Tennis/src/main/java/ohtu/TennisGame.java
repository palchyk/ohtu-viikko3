package ohtu;

public class TennisGame {

    private int score1 = 0;
    private int score2 = 0;
    private String player1Name;
    private String player2Name;
    private String score = "";
    private int tempScore = 0;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            score1 += 1;
        } else {
            score2 += 1;
        }
    }

    public String getScore() {
        if (score1 == score2) {
            sameScore();
        } else if (score1 >= 4 || score2 >= 4) {
            playerWithFourOrMoreScore();
        } else {
            gameBeforeReachingScoreFour();
        }
        return score;
    }

    public void sameScore() {
        switch (score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
    }

    public void playerWithFourOrMoreScore() {
        int resultDifference = score1 - score2;
        if (resultDifference == 1) {
            score = "Advantage player1";
        } else if (resultDifference == -1) {
            score = "Advantage player2";
        } else if (resultDifference >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
    }

    public void gameBeforeReachingScoreFour() {
        tempScore = score1;
        addToScore();
        score += "-";
        tempScore = score2;
        addToScore();

    }

    public void addToScore() {
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
    }
}
