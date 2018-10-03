package com.example.feets.feets.constants;

import java.io.Serializable;

/**
 * This class contains all constant url for connecting API purpose
 * Can be used for request and response data
 */
public class ApiConstants implements Serializable {

    private static final String LOCAL_PREFIX = "http://192.168.0.138:3000/api/v2/";
    private static final String SPECIAL_EVENTS = "special_events/";

    // TODO: 10/3/2018 Switch prefix to either local, public etc
    private static String PREFIX = LOCAL_PREFIX;

    // Request constants
    public static final String REQ_SPECIAL_EVENTS = PREFIX + SPECIAL_EVENTS;

}

