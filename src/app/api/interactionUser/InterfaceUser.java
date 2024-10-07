package app.api.interactionUser;

import app.api.ConsultarExchangeRate;
import app.api.exchangerate.ExchangeRate;
import app.api.operations.Operation;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Scanner;

public class InterfaceUser {
    String [] arrayKeys = new String[]{"USD/ARS", "ARS/USD", "USD/BRL", "BRL/USD", "USD/COP", "COP/USD"};

    public InterfaceUser(){

    }

    public void loop() {
        Scanner lectura = new Scanner(System.in);
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("1) Dollar ==> Peso Argentino");
            System.out.println("2) Peso Argentino ==> Dollar");
            System.out.println("3) Dollar ==> Real Brasileño");
            System.out.println("4) Real Brsileño ==> Dollar");
            System.out.println("5) Dollar ==> Peso Colombiano");
            System.out.println("6) Peso Colombiano ==> Dollar");
            System.out.println("7) Salir");
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("Ingrese en un valor: ");
            try{
                int valor = lectura.nextInt();
                if (valor==7) {
                    System.out.println("Aplicación finalizada");
                    break;
                }

                System.out.println("+++++++++++++++++++++++++++++++++");
                System.out.println("Ingrese el valor a convetir: ");
                float coin = lectura.nextFloat();
                ConsultarExchangeRate consulta = new ConsultarExchangeRate();
                ExchangeRate rates = consulta.buscarConversionRate(arrayKeys[valor]+"/"+coin);
                System.out.println("El valor de convertir de "+arrayKeys[valor].split("/")[0] + " a "+
                        arrayKeys[valor].split("/")[1] + " es: " + rates.conversion_result());
            }catch (RuntimeException e){
                System.out.println("Ha ocurrido un problema con la entrada del usuario");
            }
        }
    }
}
