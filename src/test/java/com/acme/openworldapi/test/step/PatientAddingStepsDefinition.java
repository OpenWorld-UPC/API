package com.acme.openworldapi.test.step;

import com.acme.openworldapi.appointment.resource.CreatePatientResource;
import com.acme.openworldapi.appointment.resource.PatientResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatObject;

public class PatientAddingStepsDefinition {
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

    @When("a Patient Request is sent with values {string}, {int}, {string}")
    public void aPatientRequestIsSentWithValues(String name, int age, String photoUrl) {
        CreatePatientResource resource = new CreatePatientResource()
                .withName(name)
                .withAge(age)
                .withPhotoUrl(photoUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreatePatientResource> request = new HttpEntity<>(resource, headers);
        responseEntity = testRestTemplate.postForEntity(endpointPath, request, String.class);
    }

    @Then("a Response with Status {int} is received")
    public void aResponseIsReceivedWithStatus(int expectedStatusCode) {
        int actualStatusCode = responseEntity.getStatusCodeValue();
        assertThat(expectedStatusCode).isEqualTo(actualStatusCode);
    }

    @And("a Patient Resource with values {string}, {int}, {string} is included in Response Body")
    public void aPatientResourceWithValuesIsIncludedInResponseBody(String name, int age, String photoUrl) {
        PatientResource expectedResource = new PatientResource()
                .withName(name)
                .withAge(age)
                .withPhotoUrl(photoUrl);
        String value = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        PatientResource actualResource;

        try {
            actualResource = mapper.readValue(value, PatientResource.class);
        }catch (JsonProcessingException | NullPointerException e){
            actualResource = new PatientResource();
        }
        expectedResource.setId(actualResource.getId());
        assertThat(expectedResource).usingRecursiveComparison().isEqualTo(actualResource);
    }

}

