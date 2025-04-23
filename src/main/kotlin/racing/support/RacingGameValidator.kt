package racing.support


object RacingGameValidator {
    private const val PARTICIPANT_MAX_LENGTH:Int = 5

    fun validInputPlayerInfoLine(inputLine:String) : Boolean {
        val playerList = inputLine.split(",")
        for (player in playerList) {
            if (player.isBlank() || player.length > PARTICIPANT_MAX_LENGTH) {
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