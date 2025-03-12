package org.example;

import org.example.Business_Logic.PolynomialOperations;
import org.example.Data_Models.Polynomial;
import org.junit.Test;

public class MultiplicationTest {

    @Test
    public void multiplicationSuccess() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("x^2+3x+2");
        Polynomial p2 = new Polynomial("x^3-x^2-x+1");

        Polynomial result = operation.multiplyPolynomials(p1, p2);

        String resultAsString = result.createString().toString();
        assert(resultAsString.equals("x^5+2.0x^4-2.0x^3-4.0x^2+x+2.0"));
    }

    @Test
    public void multiplicationFailure() {
        PolynomialOperations operation = new PolynomialOperations();

        Polynomial p1 = new Polynomial("x^2+3x+2");
        Polynomial p2 = new Polynomial("x^3-x^2-x+1");

        Polynomial result = operation.multiplyPolynomials(p1, p2);

        String resultAsString = result.createString().toString();
        assert(resultAsString.equals("x^5-2.0x^4+2.0x^3-4.0x^2+x+2.0"));
    }
}
