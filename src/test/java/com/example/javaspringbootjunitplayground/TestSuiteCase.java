package com.example.javaspringbootjunitplayground;


import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({ ArraysCompareTest.class, StringHelperTest.class })
@SuiteDisplayName("Integration Tests")
//@SelectPackages("my.domain")
//@IncludeClassNamePatterns(".*ITTest")
public class TestSuiteCase {

}
