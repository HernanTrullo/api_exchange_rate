package app.api.operations;

public class Operation {
    public static float usdToOthercoin(float valueToConvert, float rate){
        return valueToConvert*rate;
    }

    public static float othercoinToUsd(float valurToConvert, float rate){
        return valurToConvert/rate;
    }
}
