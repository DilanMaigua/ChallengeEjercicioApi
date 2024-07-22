package com.example;

import com.intuit.karate.junit5.Karate;


public class DemoBlazeRunner {

    @Karate.Test
    Karate testDemoBlaze() {
        return Karate.run("classpath:DemoBlaze.feature").relativeTo(getClass());
    }
}