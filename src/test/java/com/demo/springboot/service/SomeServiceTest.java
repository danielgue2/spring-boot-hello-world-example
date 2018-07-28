package com.demo.springboot.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SomeServiceTest {

    private SomeService s;

    @Before
    public void setUp() throws Exception {
        s = new SomeService();
    }

    @Test
    public void testResult() throws Exception {

        assertEquals(7, s.result(4L, 3L));
    }

    @Ignore
    public void testResultNull() throws Exception {
        assertEquals(9, s.result(4, 3));
    }}