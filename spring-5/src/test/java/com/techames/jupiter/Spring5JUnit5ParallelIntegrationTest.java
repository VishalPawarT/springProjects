package com.techames.jupiter;

import org.junit.experimental.ParallelComputer;
import org.junit.jupiter.api.Test;
import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;

import com.techames.Example1IntegrationTest;
import com.techames.Example2IntegrationTest;

class Spring5JUnit5ParallelIntegrationTest {

    @Test
    void givenTwoTestClasses_whenJUnitRunParallel_thenTheTestsExecutingParallel() {
        final Class<?>[] classes = { Example1IntegrationTest.class, Example2IntegrationTest.class };

        JUnitCore.runClasses(new ParallelComputer(true, true), classes);
    }

    @Test
    void givenTwoTestClasses_whenJUnitRunParallel_thenTheTestsExecutingLinear() {
        final Class<?>[] classes = { Example1IntegrationTest.class, Example2IntegrationTest.class };

        JUnitCore.runClasses(new Computer(), classes);
    }
}