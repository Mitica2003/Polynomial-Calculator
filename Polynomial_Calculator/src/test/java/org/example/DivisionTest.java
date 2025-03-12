package org.example;

import org.example.Business_Logic.PolynomialOperations;
import org.example.Data_Models.Polynomial;
import org.junit.Test;

public class DivisionTest {

    @Test
    public void divisionSuccess() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("x^2+3x+2");
        Polynomial p2 = new Polynomial("x+1");

        Polynomial result = operation.dividePolynomials(p1, p2);

        String resultAsString = result.createString().toString();
        assert(resultAsString.equals(""));
    }

    @Test
    public void divisionFailure() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("x^2+3x+2");
        Polynomial p2 = new Polynomial("x+1");

        Polynomial result = operation.dividePolynomials(p1, p2);

        String resultAsString = result.createString().toString();
        assert(resultAsString.equals("x+2"));
    }

}
