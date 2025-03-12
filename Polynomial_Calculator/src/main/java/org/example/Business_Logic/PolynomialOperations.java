package org.example.Business_Logic;

import org.example.Data_Models.Monomial;
import org.example.Data_Models.Polynomial;

import java.util.Map;

public class PolynomialOperations {
    public PolynomialOperations(){
    }

    public Polynomial addPolynomials(Polynomial x, Polynomial y){
        Polynomial result = new Polynomial("");
        for(Map.Entry<Integer, Double> i: x.getPolynomialMap().entrySet()){
            result.getPolynomialMap().put(i.getKey(), i.getValue());
        }

        for(Map.Entry<Integer, Double> j: y.getPolynomialMap().entrySet()){
            if (result.getPolynomialMap().containsKey(j.getKey())) {
               result.getPolynomialMap().put(j.getKey(), result.getCurrentValue(j.getKey()) + j.getValue());
            } else {
                result.getPolynomialMap().put(j.getKey(), j.getValue());
            }
        }

        return result;
    }

    public Polynomial substractPolynomials(Polynomial x, Polynomial y){
        Polynomial result = new Polynomial("");
        for(Map.Entry<Integer, Double> i: x.getPolynomialMap().entrySet()){
            result.getPolynomialMap().put(i.getKey(), i.getValue());
        }

        for(Map.Entry<Integer, Double> j: y.getPolynomialMap().entrySet()){
            if (result.getPolynomialMap().containsKey(j.getKey())) {
                result.getPolynomialMap().put(j.getKey(), result.getCurrentValue(j.getKey()) - j.getValue());
            } else {
                result.getPolynomialMap().put(j.getKey(), -j.getValue());
            }
        }

        return result;
    }

    public Polynomial multiplyPolynomials(Polynomial x, Polynomial y){
        Polynomial result = new Polynomial("");

        for(Map.Entry<Integer, Double> i: x.getPolynomialMap().entrySet()){
            for(Map.Entry<Integer, Double> j: y.getPolynomialMap().entrySet()){
                int degree = i.getKey() + j.getKey();
                double product = i.getValue() * j.getValue();
                result.addMonomial(degree, product);
            }
        }

        return result;
    }

    public Polynomial dividePolynomials(Polynomial x, Polynomial y){
        Polynomial result = new Polynomial("");

        return result;
    }

    public Polynomial derivatePolynomial(Polynomial x){
        Polynomial result = new Polynomial("");

        for(Map.Entry<Integer, Double> i: x.getPolynomialMap().entrySet()){
            if(i.getKey() != 0) {
                double key = i.getKey();
                result.addMonomial(i.getKey() - 1, i.getValue() * key);
            }
        }

        return result;
    }

    public Polynomial integratePolynomial(Polynomial x){
        Polynomial result = new Polynomial("");

        for(Map.Entry<Integer, Double> i: x.getPolynomialMap().entrySet()){
            double key = i.getKey();
            result.addMonomial(i.getKey() + 1, i.getValue() / (key + 1));
        }

        return result;
    }
}