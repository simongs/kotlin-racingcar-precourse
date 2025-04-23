package racing.support

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RacingGameUtilsTest {

    @Test
    fun test_validInputParticipantInfoLine_null() {
        val validResult = RacingGameUtils.validInputParticipantInfoLine(null)
        assertFalse(validResult)
    }

    @Test
    fun test_validInputParticipantInfoLine_single_participant_valid_case() {
        assertTrue(RacingGameUtils.validInputParticipantInfoLine("user"))
        assertTrue(RacingGameUtils.validInputParticipantInfoLine("user1"))
    }

    @Test
    fun test_validInputParticipantInfoLine_single_participant_invalid_case() {
        assertFalse(RacingGameUtils.validInputParticipantInfoLine("participant"))
        assertFalse(RacingGameUtils.validInputParticipantInfoLine("user10"))
    }

}

