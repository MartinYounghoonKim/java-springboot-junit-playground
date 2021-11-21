package com.example.javaspringbootjunitplayground;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringHelperTest {

    StringHelper helper = new StringHelper();
    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions () {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }

    @Test
    public void testTruncateAInFirst2Positions2_AInFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
//        assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"), "테스트가 통과하지 않았을 경우 노출되는 메세지");
    }
}