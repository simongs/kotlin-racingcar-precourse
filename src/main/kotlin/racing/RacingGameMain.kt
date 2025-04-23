package racing

import racing.entity.Participant
import racing.entity.RacingGame
import racing.support.RacingGameValidator
import racing.support.printlnWithTime


fun main() {
    printlnWithTime("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val participantInfoLine = readln()
    if (!RacingGameValidator.validInputParticipantInfoLine(participantInfoLine)) {
        printlnWithTime("유효하지 않은 참가자 정보를 입력하였습니다. ($participantInfoLine)")
    }

    printlnWithTime("시도할 회수는 몇회인가요?")
    val totalTryCount = readln()
    if (!RacingGameValidator.validInputTotalTryCount(totalTryCount)) {
        printlnWithTime("유효하지 않은 숫자 정보를 입력하였습니다. ($totalTryCount)")
    }

    val participants = participantInfoLine.split(",").map { Participant(it) }

    val racingGame = RacingGame(participants, totalTryCount.toInt())

    racingGame.play()

    racingGame.printWinParticipantsInfo()

}