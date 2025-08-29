package br.com.fiap.service;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.com.fiap.service.Operations")
public class Sum implements Operations {

    @Override
    public double calculate(double valorA, double valorB) {
        // TODO Auto-generated method stub
        return valorA + valorB;
    }

    @Override
    public String showMessage(double valorA, double valorB) {
        // TODO Auto-generated method stub
        return "O resultado da " + showName() + "(" + showSymbol() + ")"  + " é igual a " + calculate(valorA, valorB);
    }

    @Override
    public String showName() {
        // TODO Auto-generated method stub
        return "Soma";
    }

    @Override
    public String showSymbol() {
        // TODO Auto-generated method stub
        return "+";
    }
    
}
