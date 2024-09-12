package org.example;

public class Servicefacade {
    String query;
    double a;
    double b;

    ReflexCalculator calculator = new ReflexCalculator();

    public Double[] queryDecomposition(String query){
        if (query.equals("http://localhost:36000/calculadora?")){
            String[] parts = query.split(",");
            String[] parts2 = parts[1].split("&");
            String[] parts3 = parts2[1].split("=");
            a = Integer.parseInt(parts2[0]);
            b = Integer.parseInt(parts3[1]);
            Double[] numbers = {a, b};
            return numbers;
        }
        else return null;
    }

    public double rescal(Double[] numbers){
        double ans = 0;
        if(query.contains("add")){
            ans = calculator.add(numbers[0], numbers[1]);
        }
        else if(query.contains("mul")){
            ans = calculator.mul(numbers[0], numbers[1]);
        }
        else if(query.contains("div")){
            ans = calculator.div(numbers[0], numbers[1]);
        }
        else if(query.contains("res")){
            ans = calculator.res(numbers[0], numbers[1]);
        }
        return ans;
    }

    public Double[] bubbleSort(Double[] numbers){
        double temp;
        for (int i = 0; i < numbers.length; i++){
            for (int j = 1; j < (numbers.length - i); j++){
                if (numbers[j-1] > numbers[j]){
                    temp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }
}
