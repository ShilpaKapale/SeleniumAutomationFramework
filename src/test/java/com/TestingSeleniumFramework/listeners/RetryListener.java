package com.TestingSeleniumFramework.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {
//    **Retry Listeners **
// 1. It can run the failed test case again
//2. 100 Test case, 97 Passed, due to configuration - 3 are failed, Rerun them ->
//3 failed , rerun them. based on the count that we give.
//1. IRetryAnalyzer -> retry -> (how many times?)
// 2. Retry Listner -> retry the failed testcase , retry ->


        @Override
        public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
}
