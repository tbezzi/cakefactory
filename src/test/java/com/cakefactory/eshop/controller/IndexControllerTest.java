package com.cakefactory.eshop.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("index page returns the landing page")
    void returnsLandingPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cake Factory")));
    }

    @Test
    @DisplayName("test with htlm unit")
    void checkATag() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = webClient.getPage("http://localhost:8091");
            HtmlDivision div = page.getHtmlElementById("carouselExampleIndicators");
        }
    }

}
