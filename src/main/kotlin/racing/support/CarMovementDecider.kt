package racing.support

import kotlin.random.Random


object CarMovementDecider {

    private val random = Random.Default

    private const val MOVEMENT_THRESHOLD = 4
    private const val RANDOM_BOUND = 10

    fun isMovable(): Boolean {
        val randomValue = random.nextInt(RANDOM_BOUND) // 0부터 9까지의 난수 생성
        return randomValue >= MOVEMENT_THRESHOLD
    }

}