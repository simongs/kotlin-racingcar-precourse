package racing.entity

import racing.support.CarMovementDecider
import racing.support.printlnWithTime


class RacingGame(private val players: List<Player>, private val totalTryCount: Int) {
    private var currentTryCount:Int = 0
    private val histories:ArrayList<RacingHistoryPerCount> = arrayListOf()

    fun play() {
        while (currentTryCount < totalTryCount) {
            val racingResults = players.map { player ->
                PlayerRacingResult(player, CarMovementDecider.isMovable())
            }
            histories.add(RacingHistoryPerCount(++currentTryCount, racingResults))
        }
    }

    fun printWinPlayersInfo() {
        printlnWithTime("실행 결과")

        val resultReduceMap = players.associateWith { 0 }.toMutableMap()

        for (history in histories.sortedBy { it.tryIndex }) {
            printlnWithTime("===== [${history.tryIndex}] 번째 결과 =======")
            // 이동 결과 누적결과 반영
            updateMoveResults(history, resultReduceMap)
            // 현재까지의 누적 결과 출력
            printCurrentResults(resultReduceMap)
        }
        // 최종 우승자 출력
        printFinalWinners(resultReduceMap)
    }

    private fun updateMoveResults(history: RacingHistoryPerCount, resultReduceMap: MutableMap<Player, Int>) {
        history.racingResults.forEach {
            if (it.isMove) {
                resultReduceMap[it.player] = resultReduceMap[it.player]!! + 1
            }
        }
    }

    private fun printCurrentResults(resultReduceMap: MutableMap<Player, Int>) {
        resultReduceMap.forEach { (key, value) ->
            val text = "-".repeat(value)
            printlnWithTime("${key.name} : $text")
        }
    }

    private fun printFinalWinners(resultReduceMap: MutableMap<Player, Int>) {
        val maxValue = resultReduceMap.values.maxOrNull()
        val winnerList = resultReduceMap.filter { it.value == maxValue }.keys.toList()
        winnerList.joinToString()
        printlnWithTime("최종 우승자 : ${winnerList.joinToString {it.name} }")
    }

}