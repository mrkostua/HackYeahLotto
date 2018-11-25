package hackyeah.hackyeahlotto.model;

import java.util.Date;

public class Draw {
    private Date purchaseDate;
    private Date drawingDate;
    private Game game;
    private GameStatus gameStatus;

    public Draw(Date purchaseDate, Date drawingDate, Game game, GameStatus gameStatus) {
        this.purchaseDate = purchaseDate;
        this.drawingDate = drawingDate;
        this.game = game;
        this.gameStatus = gameStatus;
    }

    public Draw() {
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getDrawingDate() {
        return drawingDate;
    }

    public void setDrawingDate(Date drawingDate) {
        this.drawingDate = drawingDate;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
