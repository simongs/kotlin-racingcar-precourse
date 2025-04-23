package racing.entity

import racing.support.printlnWithTime


class RacingGame(private val participants: List<Participant>, private val totalTryCount: Int) {
    private var currentTryCount:Int = 0
    private val histories:ArrayList<RacingHistoryPerCount> = arrayListOf()

    fun play() {
        while (currentTryCount > totalTryCount) {
            printlnWithTime("execution")
            currentTryCount++

            val racingResults:ArrayList<ParticipantRacingResult> = arrayListOf()
            participants.forEach {
                // TODO 전진여부를 판단하는 기능 추가 필요
                racingResults.add(ParticipantRacingResult(it, true))
            }

            histories.add(RacingHistoryPerCount(currentTryCount, racingResults))
        }
    }

    fun printWinParticipantsInfo() {

    }
}