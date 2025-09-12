package br.com.fiap.client;

import java.io.IOException;

import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.fiap.model.EnderecoDTO;

public class ViaCEPClient {
    public static EnderecoDTO getEndereco(String cep) throws IOException{
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        // endereco do viacep

        String jsonResponse = Request.Get(url).connectTimeout(10000).socketTimeout(10000).execute().returnContent().asString();
        // modelo de Request
        // Request.Get() pra fazer um Get
        // timeout de 10 sec para garantir resposta bem sucedida
        // precisa do asString() para armazenar resultado como String

        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        if (jsonObject.has("erro") && jsonObject.get("erro").getAsBoolean()) {
            throw new CEPNotFoundException("CEP não encontrado na base de dados.");
        }
        //checa se ocorre um retorno de um CEP inválido, mas de formato válido

        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, EnderecoDTO.class);
        // usa modelo de Request + modelo de DTO para retornar um DTO completo
    }
}
