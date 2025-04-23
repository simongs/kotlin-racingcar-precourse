package racing.entity

import racing.support.CarMovementDecider
import racing.support.printlnWithTime


class RacingGame(private val participants: List<Participant>, private val totalTryCount: Int) {
    private var currentTryCount:Int = 0
    private val histories:ArrayList<RacingHistoryPerCount> = arrayListOf()

    fun play() {
        while (currentTryCount < totalTryCount) {
            val racingResults:ArrayList<ParticipantRacingResult> = arrayListOf()
            participants.forEach {
                racingResults.add(ParticipantRacingResult(it, CarMovementDecider.isMovable()))
            }

            histories.add(RacingHistoryPerCount(++currentTryCount, racingResults))
        }
    }

    fun printWinParticipantsInfo() {
        printlnWithTime("실행 결과")

        val participantMap = participants.associateWith { 0 }

        for (history in histories.sortedBy { it.tryIndex }) {
            printlnWithTime(history)
        }

        printlnWithTime("최종 우승자 : pobi, jun")
    }
}