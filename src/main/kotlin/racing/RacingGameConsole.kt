package racing

import racing.entity.Player
import racing.entity.RacingGame


class RacingGameConsole {

    fun insertCoin(playersLine: String, totalTryCount: String) {
        val players = playersLine.split(",").map { Player(it) }

        val racingGame = RacingGame(players, totalTryCount.toInt())

        racingGame.play()

        racingGame.printWinPlayersInfo()
    }

}