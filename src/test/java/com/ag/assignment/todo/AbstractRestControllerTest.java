package com.ag.assignment.todo;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by AMK on 17/12/18.
 */
public abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
