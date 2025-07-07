package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.calculos.CalculoPedido;

@Configuration
public class CalculoFreteConfiguration {
    @Bean
    public CalculoPedido calculo(){
        return new CalculoPedido();
    }
}
