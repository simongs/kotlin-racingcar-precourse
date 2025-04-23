package racing.support


object CarMovementDecider {

    fun isMovable(): Boolean {
        val randomValue = (0..9).random()
        return randomValue >= 4
    }

}