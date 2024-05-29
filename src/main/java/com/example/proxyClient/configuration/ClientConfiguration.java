package com.example.proxyClient.configuration;

import com.example.proxyClient.errordecoder.RetreiveMessageErrorDecoder;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class ClientConfiguration {
    @Bean
    public feign.okhttp.OkHttpClient client() {
        return new feign.okhttp.OkHttpClient();
    }

    @Bean
    public feign.codec.ErrorDecoder errorDecoder() {
        return new RetreiveMessageErrorDecoder();
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(3L), 5);
    }

}
