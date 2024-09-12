package org.example;

public class Servicefacade {
    String query;
    double a;
    double b;

    ReflexCalculator calculator = new ReflexCalculator();

    public Double[] queryDecomposition(String query){
        if (query.equals("http://localhost:36000/calculadora?")){

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

}
