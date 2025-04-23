package racing.entity

import racing.support.CarMovementDecider
import racing.support.printlnWithTime


class RacingGame(private val players: List<Player>, private val totalTryCount: Int) {
    private var currentTryCount:Int = 0
    private val histories:ArrayList<RacingHistoryPerCount> = arrayListOf()

    fun play() {
        while (currentTryCount < totalTryCount) {
            val racingResults:ArrayList<PlayerRacingResult> = arrayListOf()
            players.forEach {
                racingResults.add(PlayerRacingResult(it, CarMovementDecider.isMovable()))
            }

            histories.add(RacingHistoryPerCount(++currentTryCount, racingResults))
        }
    }

    fun printWinPlayersInfo() {
        printlnWithTime("실행 결과")

        val resultReduceMap = players.associateWith { 0 }.toMutableMap()

        for (history in histories.sortedBy { it.tryIndex }) {

            printlnWithTime("===== [${history.tryIndex}] 번째 결과 =======")
            // 회차별 누적 결과 계산
            history.racingResults.forEach {
                if (it.isMove) {
                    resultReduceMap[it.player] = resultReduceMap[it.player]!! + 1
                }
            }

            // 회차별 누적 결과 출력
            resultReduceMap.forEach { (key, value) ->
                val text = "-".repeat(value)
                printlnWithTime("${key.name} : $text")
            }
        }

        // 최종 우승자 구하기
        val maxValue = resultReduceMap.values.maxOrNull()
        val winnerList = resultReduceMap.filter { it.value == maxValue }.keys.toList()
        winnerList.joinToString()
        printlnWithTime("최종 우승자 : ${winnerList.joinToString { it.name }}")
    }
}