package racing

import racing.support.RacingGameValidator
import racing.support.printlnWithTime


fun main() {
    printlnWithTime("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val playerInfoLine = readln()
    if (!RacingGameValidator.validInputPlayerInfoLine(playerInfoLine)) {
        printlnWithTime("유효하지 않은 참가자 정보를 입력하였습니다. ($playerInfoLine)")
        return
    }

    printlnWithTime("시도할 회수는 몇회인가요?")
    val totalTryCount = readln()
    if (!RacingGameValidator.validInputTotalTryCount(totalTryCount)) {
        printlnWithTime("유효하지 않은 숫자 정보를 입력하였습니다. ($totalTryCount)")
        return
    }

    RacingGameConsole().insertCoin(playerInfoLine, totalTryCount)
}


