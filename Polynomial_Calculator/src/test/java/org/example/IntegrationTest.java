package org.example;

import org.example.Business_Logic.PolynomialOperations;
import org.example.Data_Models.Polynomial;
import org.junit.Test;

public class IntegrationTest {

    @Test
    public void integrationSuccess() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("3x+2");

        Polynomial result = operation.integratePolynomial(p1);

        String resultAsString = result.createString().toString();
        resultAsString = resultAsString.concat(" + C");

        assert(resultAsString.equals("1.5x^2+2.0x + C"));
    }

    @Test
    public void integrationFailure() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("3x+2");

        Polynomial result = operation.integratePolynomial(p1);

        String resultAsString = result.createString().toString();
        resultAsString = resultAsString.concat(" + C");

        assert(resultAsString.equals("3.0x^2/2.0+2.0x + C"));
    }
}
