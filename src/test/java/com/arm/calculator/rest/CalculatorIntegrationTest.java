package com.arm.calculator.rest;

import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@SpringApplicationConfiguration(classes = CalculatorApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class CalculatorIntegrationTest {
    @Value("${local.server.port}")
    private int port;
    private String url;

    @Before
    public void init() throws Exception {
        url = "http://localhost:" + port + "/calculator";
    }

    @Test
    public void should_convert_numbers() throws Exception {
        given()
                .body("{ \"input\" : \"1,2,3,1000\"}")
                .contentType(ContentType.JSON)
                .when()
                .post(url)
                .then()
                .statusCode(200)
                .body(is("1006"));
    }

}