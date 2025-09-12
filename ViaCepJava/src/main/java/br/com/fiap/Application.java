package br.com.fiap;

import java.io.IOException;
import java.util.Scanner;

import br.com.fiap.client.ViaCEPClient;
import br.com.fiap.model.EnderecoDTO;

public class Application {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o CEP:\n\t- ");
        String cep = sc.next();
        sc.close();

        EnderecoDTO endereco = ViaCEPClient.getEndereco(cep);

        System.out.println("cep: " + endereco.cep());
        System.out.println("logradouro: " + endereco.logradouro());
        System.out.println("complemento: " + endereco.complemento());
        System.out.println("bairro: " + endereco.bairro());
        System.out.println("estado: " + endereco.estado());
        System.out.println("uf: " + endereco.uf());

        
    }
}