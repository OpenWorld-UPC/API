package com.acme.openworldapi.test.step;

import com.acme.openworldapi.appointment.domain.model.entity.enums.Status;
import com.acme.openworldapi.appointment.resource.CreateReservationResource;
import com.acme.openworldapi.appointment.resource.ReservationResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class ReservationAddingStepsDefinition {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int randomServerPort;

    private String endpointPath;

    private ResponseEntity<String> responseEntity;

    @Given("the Endpoint {string} is available")
    public void theEndpointIsAvailable(String endpointPath) {
        this.endpointPath=String.format(endpointPath, randomServerPort);
    }

    @When("a Reservation Request is sent with values {string}, {string}, {string}, {string}, {status}")
    public void aReservationRequestIsSentWithValues(String title, String content, String meetUrl, String meetDate, Status status) {
        CreateReservationResource resource = new CreateReservationResource()
                .withTitle(title)
                .withContent(content)
                .withMeetUrl(meetUrl)
                .withMeetDate(meetDate)
                .withStatus(status);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateReservationResource> request = new HttpEntity<>(resource, headers);
        responseEntity = testRestTemplate.postForEntity(endpointPath, request, String.class);
    }

    @Then("a Response with Status {int} is received")
    public void aResponseIsReceivedWithStatus(int expectedStatusCode) {
        int actualStatusCode = responseEntity.getStatusCodeValue();
        assertThat(expectedStatusCode).isEqualTo(actualStatusCode);
    }

    @And("a Reservation Resource with values {string}, {string}, {string}, {string}, {status} is included in Response Body")
    public void aReservationResourceWithValuesIsIncludedInResponseBody(String title, String content, String meetUrl, String meetDate, Status status) {
        ReservationResource expectedResource = new ReservationResource()
                .withTitle(title)
                .withContent(content)
                .withMeetUrl(meetUrl)
                .withMeetDate(meetDate)
                .withStatus(status);
        String value = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        ReservationResource actualResource;

        try {
            actualResource = mapper.readValue(value, ReservationResource.class);
        }catch (JsonProcessingException | NullPointerException e){
            actualResource = new ReservationResource();
        }
        expectedResource.setId(actualResource.getId());
        assertThat(expectedResource).usingRecursiveComparison().isEqualTo(actualResource);
    }
}
