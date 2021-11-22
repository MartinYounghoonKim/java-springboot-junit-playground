package com.example.javaspringbootjunitplayground;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.context.event.annotation.BeforeTestClass;

class StringHelperTest {

    StringHelper helper;

    // StringHelperTest 의 테스트들이 실행되기 전, 한번 호출된다.
    // Junit4 에서는 @BeforeClass 로 쓰다 Junit5 에서 변경되었다고 한다.
    @BeforeAll
    static void beforeAll() {
        System.out.println("StringHelperTest 의 테스트들이 실행되기 전, 한번 호출된다. ");
    }

    // StringHelperTest 의 테스트들이 실행 완료 후, 한번 호출된다.
    // Junit4 에서는 @AfterClass 로 쓰다 Junit5 에서 변경되었다고 한다.
    @AfterAll
    static void afterAll() {
        System.out.println("StringHelperTest 의 테스트들이 실행된 후, 한번 호출된다. ");
    }

    // 각각의 테스트 케이스 실행 전마다 호출된다.
    // Junit4 에서는 @Before 로 쓰다 Junit5에서 이름이 변경되었다고 한다.
    @BeforeEach
    void setUp() {
        helper = new StringHelper();
        System.out.println("setup executed before every test method invoke.");
    }

    // 각각의 테스트 케이스 완료 시마다 호출된다.
    // Junit4 에서는 @After 로 쓰다 Junit5에서 이름이 변경되었다고 한다.
    @AfterEach
    void tearDown() {
        System.out.println("tearDown executed after every test method invoke.");
    }

    @ParameterizedTest
//    @ValueSource(strings = {"CD", "CD", "CDEF", "CDAA" })
//    @Test
    @MethodSource("parametersProvider")
    public void testTruncateAInFirst2Positions_AInFirst2Positions (String expected, String actual) {
        assertEquals(expected, helper.truncateAInFirst2Positions(actual));
    }

    public static Stream<Arguments> parametersProvider() {
        return Stream.of(
          Arguments.arguments("CD", "AACD"),
          Arguments.arguments("CD", "ACD"),
          Arguments.arguments("CDEF", "CDEF"),
          Arguments.arguments("CDAA", "CDAA")
        );
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