package com.example.proxyClient.integration;

import com.example.proxyClient.dto.productsDTOs.ProductDto;
import com.example.proxyClient.remote.ProductClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import java.util.List;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureWireMock(port = 8080)
public class FeignClientIntegrationTests {
    @Autowired
    private ProductClient productClient;

    @Test
    public void getProductsWithoutParam_productsPresent_responseProductsListDTO() {
        //given
        stubFor(get(urlEqualTo("/"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("[{\"id\":1,\"name\":\"Toshiba\",\"price\":\"1000\" ,\"productType\":\"COMPUTER\" ,\"visibleToSell\":true,\"configurations\":[],\"possibleConfigurations\":[]}]")));

        //when
        List<ProductDto> result = productClient.getProducts(Optional.empty());

        //then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Toshiba", result.get(0).getName());
        assertEquals(1000, result.get(0).getPrice());
        assertEquals("COMPUTER", result.get(0).getProductType().name());
        assertEquals(true, result.get(0).isVisibleToSell());
    }
}
