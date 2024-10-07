package app.api;


import app.api.exchangerate.ExchangeRate;
import com.google.gson.Gson;

import javax.xml.transform.sax.SAXSource;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;

public class ConsultarExchangeRate {
    public ExchangeRate buscarConversionRate(String strConversion) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8647079e43aae154c882502a/pair/" + strConversion + "/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response;
        try {

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("Hubo un error en la búsqyeda de los conversores");
        }
        return new Gson().fromJson(response.body(), ExchangeRate.class);
    }
}