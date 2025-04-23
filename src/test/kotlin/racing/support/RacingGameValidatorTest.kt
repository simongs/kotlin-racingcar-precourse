package racing.support

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RacingGameValidatorTest {

    @Test
    fun test_validInputParticipantInfoLine_single_participant_valid_case() {
        assertTrue(RacingGameValidator.validInputPlayerInfoLine("user"))
        assertTrue(RacingGameValidator.validInputPlayerInfoLine("user1"))
    }

    @Test
    fun test_validInputParticipantInfoLine_single_player_invalid_case() {
        assertFalse(RacingGameValidator.validInputPlayerInfoLine("participant"))
        assertFalse(RacingGameValidator.validInputPlayerInfoLine("user10"))
    }

    @Test
    fun validInputTotalTryCount() {
        assertTrue(RacingGameValidator.validInputTotalTryCount("5"))
        assertFalse(RacingGameValidator.validInputTotalTryCount("user10"))
    }

}

