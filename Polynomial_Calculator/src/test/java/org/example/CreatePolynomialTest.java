package org.example;

import org.example.Business_Logic.PolynomialOperations;
import org.example.Data_Models.Polynomial;
import org.junit.Test;

public class CreatePolynomialTest {

    @Test
    public void createPolynomialSuccess() {
        Polynomial p1 = new Polynomial("5x^2+3x+6");

        String resultAsString = p1.createString().toString();

        assert(resultAsString.equals("5.0x^2+3.0x+6.0"));
    }

    @Test
    public void createPolynomialFailure() {
        Polynomial p1 = new Polynomial("5x^2+3x+6");

        String resultAsString = p1.createString().toString();

        assert(resultAsString.equals("5x^2+3x+6"));
    }
}
