package com.dudgns.problemtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@WebMvcTest
class ProblemtestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("조회 테스트")
    void contextLoads() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/problemTest/carManagement"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
