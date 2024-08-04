package com.ecom.productservice.services;

import com.ecom.productservice.dtos.UserDto;
import com.ecom.productservice.exception.AuthencationException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {

    private RestTemplate restTemplate;

    public TokenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validateToken(String token) throws AuthencationException {

        try {
            ResponseEntity<UserDto> userResponse =
                    restTemplate.exchange("http://localhost:9000/users/validate/"+ token, HttpMethod.POST,
                            null,UserDto.class);

            if(userResponse.getStatusCode() == HttpStatus.OK) {
                return true;
            }
        }
        catch (HttpStatusCodeException e) {
            if(e.getStatusCode().is4xxClientError())
            {
                throw new AuthencationException(e.getResponseBodyAsString());
            }
            else
            {
                throw new RuntimeException(e.getMessage());
            }
        }

        return false;
    }
}
