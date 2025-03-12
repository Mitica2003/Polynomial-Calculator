package org.example.Data_Models;

import java.io.StringReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private Map<Integer, Double> polynomialMap;

    public void addMonomial(int degree, double coefficient) {
        if (polynomialMap.containsKey(degree)) {
            polynomialMap.put(degree, polynomialMap.get(degree) + coefficient);
            if(polynomialMap.get(degree) == 0)
                polynomialMap.remove(degree);
        } else {
            polynomialMap.put(degree, coefficient);
            if(polynomialMap.get(degree) == 0)
                polynomialMap.remove(degree);
        }
    }

    public Polynomial(String polynomial){
        this.polynomialMap= new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));

        Pattern pattern = Pattern.compile("([+-]?\\d*)(x)(\\^(\\d+))?|([+-]?\\d+)");
        Matcher matcher = pattern.matcher(polynomial);
            while (matcher.find()) {
                String matched = matcher.group(0);
                String coefficient = matcher.group(1);
                String variable = matcher.group(2);
                String exponent = matcher.group(4);

                if(coefficient == null)
                    coefficient = matcher.group(0);
                else if( coefficient.equals("") || coefficient.equals("+") )
                    coefficient = "1";
                else if ( coefficient.equals("-"))
                        coefficient = "-1";

                if( variable == null ) {
                    coefficient = matched;
                    exponent = "0";
                }
                else if ( exponent == null )
                        exponent = "1";

                addMonomial(Integer.parseInt(exponent), Double.parseDouble(coefficient));
        }
    }

    public StringBuilder createString() {
        StringBuilder resultString = new StringBuilder("");
        int ok, counter = 0;
        for(Map.Entry<Integer, Double> i : this.polynomialMap.entrySet()){
            if(counter == 0){
                ok = createFirstMonomial(i.getKey(), i.getValue(), resultString);
                if(ok == 1){
                    counter++;
                    continue;
                }
            }
            else {
                ok = createOtherMonomial(i.getKey(), i.getValue(), resultString);
                if(ok == 1){
                    counter++;
                    continue;
                }
            }
            constructVariable(i.getKey(), resultString);
            counter++;
    }
        return  resultString;
    }

    private int createFirstMonomial(Integer degree, Double coefficient, StringBuilder resultString) {
        if (coefficient == -1 && degree != 0) {
            resultString.append("-");
        }
        else if (coefficient == 1 && degree == 0)
            resultString.append(coefficient);
        else if (coefficient == 1 && degree != 0);
        else if (coefficient == 0){
            return 1;
        }
        else
            resultString.append(coefficient);

        return 0;
    }

    private int createOtherMonomial(Integer degree, Double coefficient, StringBuilder resultString) {
        if (coefficient == -1 && degree != 0) {
            resultString.append("-");
        }
        else if (coefficient == 1 && degree != 0)
            resultString.append("+");
        else if (coefficient == 0){
            return 1;
        }
        else{
            if(coefficient > 0){
                resultString.append("+");
                resultString.append(coefficient);
            }
            else
                resultString.append(coefficient);
        }

        return 0;
    }

    private void constructVariable(int exponent, StringBuilder resultString) {
        if (exponent == 0) ;
        else if (exponent == 1) {
            resultString.append("x");
        } else {
            resultString.append("x^");
            resultString.append(exponent);
        }
    }

    public Map<Integer, Double> getPolynomialMap() {
        return polynomialMap;
    }

    public Double getCurrentValue(int key){
        Double result = 0.0;
        if(this.polynomialMap.containsKey(key))
            result = this.polynomialMap.get(key);

        return result;
    }
}
