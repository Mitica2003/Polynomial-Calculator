package org.example.Data_Models;

public class Monomial {
    private int grad;
    private double coeficient;

    public Monomial(int grad, double coeficient) {
        this.grad = grad;
        this.coeficient = coeficient;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }
}
