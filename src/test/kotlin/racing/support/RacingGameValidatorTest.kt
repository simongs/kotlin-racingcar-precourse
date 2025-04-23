package racing.support

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RacingGameValidatorTest {

    @Test
    fun test_validInputParticipantInfoLine_single_participant_valid_case() {
        assertTrue(RacingGameValidator.validInputParticipantInfoLine("user"))
        assertTrue(RacingGameValidator.validInputParticipantInfoLine("user1"))
    }

    @Test
    fun test_validInputParticipantInfoLine_single_participant_invalid_case() {
        assertFalse(RacingGameValidator.validInputParticipantInfoLine("participant"))
        assertFalse(RacingGameValidator.validInputParticipantInfoLine("user10"))
    }

    @Test
    fun validInputTotalTryCount() {
        assertTrue(RacingGameValidator.validInputTotalTryCount("5"))
        assertFalse(RacingGameValidator.validInputTotalTryCount("user10"))
    }

}

