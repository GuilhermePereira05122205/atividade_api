package com.example.calculos;

public class CalculoPedido {
    public static double calcularFrete(String cidade){
        switch(cidade){
            case "PR":
            case "SP":
                return 0;
            case "RJ":
            case "RS":
            case "SC":
                return 20;
            case "MG":
            case "MT":
            case "MS":
            case "ES":
                return 50;
            default:
                new RuntimeException("Não Realizamos Frete");
                return -1;
        }
    }
}
