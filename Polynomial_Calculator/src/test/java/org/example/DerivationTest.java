package org.example;

import org.example.Business_Logic.PolynomialOperations;
import org.example.Data_Models.Polynomial;
import org.junit.Test;

public class DerivationTest {

    @Test
    public void derivationSuccess() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("x^2+3x+2");

        Polynomial result = operation.derivatePolynomial(p1);

        String resultAsString = result.createString().toString();
        assert(resultAsString.equals("2.0x+3.0"));
    }

    @Test
    public void derivationFailure() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("x^2+3x+2");

        Polynomial result = operation.derivatePolynomial(p1);

        String resultAsString = result.createString().toString();
        assert(resultAsString.equals("x+3.0"));
    }
}
