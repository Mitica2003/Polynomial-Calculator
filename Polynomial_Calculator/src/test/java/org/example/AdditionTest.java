package org.example;

import org.example.Business_Logic.PolynomialOperations;
import org.example.Data_Models.Polynomial;
import org.junit.Test;

public class AdditionTest {

    @Test
    public void additionSuccess() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("x^2+3x+2");
        Polynomial p2 = new Polynomial("x^3-x^2-x+1");

        Polynomial result = operation.addPolynomials(p1, p2);

        String resultAsString = result.createString().toString();
        assert(resultAsString.equals("x^3+2.0x+3.0"));
    }

    @Test
    public void additionFailure() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("x^2+3x+2");
        Polynomial p2 = new Polynomial("x^3-x^2-x+1");

        Polynomial result = operation.addPolynomials(p1, p2);

        String resultAsString = result.createString().toString();
        assert(resultAsString.equals("x^2+2.0x-3.0"));
    }
}
