package com.example.demo.integration.client;

import org.springframework.context.annotation.Configuration;

import com.example.exception.BadRequestException;
import com.example.exception.NotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Configuration
public class FeignErrorDecoder implements ErrorDecoder{
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                throw new BadRequestException("Integracao nao deu certo");
            case 404:
                throw new NotFoundException("Usuario não existe");
            default:
                throw new RuntimeException("Erro não mapeado na UserAPI");
        }
    }
}
