package racing.support


object RacingGameValidator {
    private const val PARTICIPANT_MAX_LENGTH:Int = 5

    fun validInputParticipantInfoLine(inputLine:String) : Boolean {
        val participantList = inputLine.split(",")
        for (participant in participantList) {
            if (participant.isBlank() || participant.length > PARTICIPANT_MAX_LENGTH) {
                return false
            }
        }

        return true
    }

    fun validInputTotalTryCount(totalTryCount: String?): Boolean {
        return try {
            val number = Integer.parseInt(totalTryCount)
            number > 0
        } catch (e: NumberFormatException) {
            false
        }
    }

}