package racing

import racing.support.RacingGameUtils
import racing.support.printlnWithTime


fun main() {
    printlnWithTime("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val participantInfoLine = readlnOrNull()

    if (!RacingGameUtils.validInputParticipantInfoLine(participantInfoLine)) {
        printlnWithTime("유효하지 않은 참가자 정보를 입력하였습니다. ($participantInfoLine)")
    } else {
        printlnWithTime("정상적으로 게임을 시작하였습니다.")
    }


}