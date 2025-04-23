package racing.entity


// 회차별 레이싱 결과
data class RacingHistoryPerCount (
    val tryIndex:Int,
    val racingResults:List<PlayerRacingResult>
)