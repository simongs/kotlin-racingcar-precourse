package racing.entity

import racing.support.printlnWithTime


class RacingGame(private val participants: List<Participant>, private val totalTryCount: Int) {
    private var currentTryCount:Int = 0

    // 참가자 목록을 가지고
    // 총 시도횟수 정보를 가지고
    // 현재 시도된 횟수 정보를 가지고
    // 각 참가자가 진행한 정보를 가진다.
    fun play() {
        while (currentTryCount > totalTryCount) {
            printlnWithTime("execution")
            currentTryCount++
        }
    }

    fun printWinParticipantsInfo() {

    }
}