package racing.support


object RacingGameUtils {
    private const val PARTICIPANT_MAX_LENGTH:Int = 5

    fun validInputParticipantInfoLine(inputLine:String?) : Boolean {
        if (inputLine == null) {
            return false
        }

        val participantList = inputLine.split(",")
        for (participant in participantList) {
            if (notValidParticipantString(participant)) {
                return false
            }
        }

        return true
    }

    private fun notValidParticipantString(participantString: String) : Boolean {
        return participantString.isBlank() || participantString.length > PARTICIPANT_MAX_LENGTH
    }

}