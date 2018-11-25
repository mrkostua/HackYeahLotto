package hackyeah.hackyeahlotto.api.mock;

import hackyeah.hackyeahlotto.model.Draw;
import hackyeah.hackyeahlotto.model.Game;
import hackyeah.hackyeahlotto.model.GameStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DrawMockService {
    private static long MILISECNDS_IN_DAY = 86400000L;

    static List<Draw> draws;

    static {
        draws = generateDraws();
    }

    static private List<Draw> generateDraws() {
        List<Draw> draws = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Date purchase = getRandomPastDate();
            Date drawingDate;

            if (i % 2 == 0) {
                drawingDate = getRandomPastDateAfter(purchase);
            } else {
                drawingDate = new Date(System.currentTimeMillis() + MILISECNDS_IN_DAY * i);
            }
            GameStatus gameStatus = GameStatus.WAITING;

            if (today().after(drawingDate)) {
                if (i % 4 == 0) {
                    gameStatus = GameStatus.WIN;
                } else {
                    gameStatus = GameStatus.LOST;
                }
            }
            Boolean bg = GameStatus.WAITING == gameStatus;
            Draw draw = new Draw(purchase, drawingDate, Game.TRAVEL_WITH_LOTTO, gameStatus,bg );
            draws.add(draw);
        }
        return draws;
    }

    private static Date today() {
        return new Date(System.currentTimeMillis());
    }

    static public List<Draw> getDraws(long userId) {
        return draws;
    }


    private static Date getRandomPastDate() {
        int factor = ThreadLocalRandom.current().nextInt(1, 10);
        return new Date(System.currentTimeMillis() - factor * MILISECNDS_IN_DAY);
    }

    private static Date getRandomPastDateAfter(Date before) {
        int factor = ThreadLocalRandom.current().nextInt(-5, 1);
        return new Date(before.getTime() - factor * MILISECNDS_IN_DAY);
    }

}
