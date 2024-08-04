package com.ecom.productservice.thirdpartyclients.productservice.fakestore;

import com.ecom.productservice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/***
 * Wrapper over FakeStore API
 */
@Service
public class FakeStoreProductServiceClient {

    //We can provide it by passing in field also as shown in commented segment.
    // But at runtime we are unable to find this value
//    @Value("${fakestore.api.url}")
//    private String fakestoreapiurl;
//
//    @Value("${fakestore.api.paths.product}")
//    private String fakeStoreProductapipath;

    private RestTemplate restTemplate;
    private String specificProductRequestUrl;
    private String productRequestsBaseUrl;

    public FakeStoreProductServiceClient(RestTemplate restTemplate,
                                         @Value("${fakestore.api.url}") String fakestoreapiurl,
                                         @Value("${fakestore.api.paths.product}") String fakeStoreProductapipath)
    {
        this.restTemplate = restTemplate;
        this.productRequestsBaseUrl = fakestoreapiurl + fakeStoreProductapipath;
        this.specificProductRequestUrl = productRequestsBaseUrl + "/{id}";
    }

//    public FakeStoreProductServiceClient(RestTemplate restTemplate)
//    {
//        this.restTemplate = restTemplate;
//        this.productRequestsBaseUrl = fakestoreapiurl + fakeStoreProductapipath;
//        this.specificProductRequestUrl = productRequestsBaseUrl + "/{id}";
//    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        //return restTemplate.getForObject(specificProductRequestUrl, FakeStoreProductDto.class, id);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl,
            FakeStoreProductDto.class, id);

        if(response.getBody() == null)
        {
            throw new NotFoundException("Product with id: "+id+" does not exist.");
        }

        return response.getBody();
    }

    public FakeStoreProductDto createProdcut(FakeStoreProductDto product)
    {
        //return restTemplate.postForObject(productRequestsBaseUrl, product, FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(productRequestsBaseUrl, product,
                FakeStoreProductDto.class);

        return response.getBody();
    }

    public List<FakeStoreProductDto> getAllProducts(){
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestsBaseUrl,
                FakeStoreProductDto[].class);

        return Arrays.stream(response.getBody()).toList();
    }

    public FakeStoreProductDto updateProduct(Long id, FakeStoreProductDto product)
    {
        //Patch for entity is not available
        return restTemplate.patchForObject(specificProductRequestUrl, product,
                FakeStoreProductDto.class, id);
    }
}
