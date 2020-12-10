package com.ssaa;

import static org.junit.Assert.assertEquals;

import com.ssaa.model.UserModel;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMongodbRestApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIT {

    final UserModel userModel = new UserModel();
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    @Before
    public void before() throws Exception {
        userModel.setAge("19");
        userModel.setGender("Male");
        userModel.setCountry("UK");
        userModel.setName("Fooo");
    }

    @Test
    public void testUserRestEndPoints() throws JSONException {

        testCreateUser();

        testGetUser();

        testDelete();


    }

    private void testCreateUser() {
        //Test create user
        HttpEntity<UserModel> entity = new HttpEntity<>(userModel, headers);

        ResponseEntity<UserModel> response = restTemplate.exchange(
                createURLWithPort("/user/create"),
                HttpMethod.POST, entity, UserModel.class);
        userModel.setId(response.getBody().getId());
        assertEquals(userModel, response.getBody());
    }

    private void testGetUser() {
        //test Get User with id
        HttpEntity<String> entityGet = new HttpEntity<>(null, headers);
        ResponseEntity<UserModel> responseGet = restTemplate.exchange(
                createURLWithPort("/user/read/" + userModel.getId()),
                HttpMethod.GET, entityGet, UserModel.class);

        assertEquals(userModel, responseGet.getBody());
    }

    private void testDelete() {
        //test delete user with id
        HttpEntity<String> entityDelete = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseDelete = restTemplate.exchange(
                createURLWithPort("/user/delete/" + userModel.getId()),
                HttpMethod.DELETE, entityDelete, String.class);

        assertEquals("User deleted with id " + userModel.getId(), responseDelete.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
