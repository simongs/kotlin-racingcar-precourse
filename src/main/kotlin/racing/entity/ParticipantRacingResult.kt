package racing.entity


// 사용자별 전진결과
data class ParticipantRacingResult (
    val participant: Participant,
    val isMove: Boolean
)
