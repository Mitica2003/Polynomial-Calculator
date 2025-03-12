package org.example.GUI;

import org.example.Business_Logic.PolynomialOperations;
import org.example.Data_Models.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

public class InterfataGrafica {
    static JTextField textFieldP1 = new JTextField();
    static JTextField textFieldP2 = new JTextField();
    static JTextField textFieldResult = new JTextField();

    public InterfataGrafica() {
        JFrame mainFrame = new JFrame("Polynomial Calculator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(500, 300, 500, 500);

        JPanel panelPrincipal = createPrincipalPanel();

        mainFrame.setContentPane(panelPrincipal);
        mainFrame.setVisible(true);
    }

    private JPanel createPrincipalPanel(){
        JPanel panelPrincipal = new JPanel();
        JPanel panelOperatii = new JPanel();

        panelPrincipal.setLayout(new GridLayout(4, 1));

        createPanelForOperationButtons(panelOperatii);
        addPrincipalPanelContents(panelPrincipal, panelOperatii);

        return panelPrincipal;
    }

    private void addPrincipalPanelContents(JPanel panelPrincipal, JPanel panelOperations){
        JLabel labelP1 = new JLabel("Primul polinom:");
        JLabel labelP2 = new JLabel("Al doilea polinom:");
        JLabel labelOperation = new JLabel("Operatia:");
        JLabel labelResult = new JLabel("Rezultat:");

        panelPrincipal.add(labelP1);
        panelPrincipal.add(textFieldP1);
        panelPrincipal.add(labelP2);
        panelPrincipal.add(textFieldP2);
        panelPrincipal.add(labelOperation);
        panelPrincipal.add(panelOperations);
        panelPrincipal.add(labelResult);
        panelPrincipal.add(textFieldResult);
    }
    private void createPanelForOperationButtons(JPanel panelOperatii){
        JButton buttonAdd = new JButton("+");
        JButton buttonSub = new JButton("-");
        JButton buttonMul = new JButton("x");
        JButton buttonDiv = new JButton("/");
        JButton buttonDerivation = new JButton("d/dx");
        JButton buttonIntegration = new JButton("∫");

        buttonAdd.setPreferredSize(new Dimension(50, 50));
        buttonSub.setPreferredSize(new Dimension(50, 50));
        buttonMul.setPreferredSize(new Dimension(50, 50));
        buttonDiv.setPreferredSize(new Dimension(50, 50));
        buttonDerivation.setPreferredSize(new Dimension(60, 50));
        buttonIntegration.setPreferredSize(new Dimension(50, 50));

        panelOperatii.add(buttonAdd);
        panelOperatii.add(buttonSub);
        panelOperatii.add(buttonMul);
        panelOperatii.add(buttonDiv);
        panelOperatii.add(buttonDerivation);
        panelOperatii.add(buttonIntegration);

        buttonActions(buttonAdd, buttonSub, buttonMul, buttonDiv, buttonDerivation, buttonIntegration);
    }

    private void buttonActions(JButton buttonAdd,JButton buttonSub,JButton buttonMul,JButton buttonDiv,JButton buttonDeriv,JButton buttonInteg){
        PolynomialOperations operations = new PolynomialOperations();

        buttonAddAction(buttonAdd, operations);
        buttonSubAction(buttonSub, operations);
        buttonMulAction(buttonMul, operations);
        buttonDivAction(buttonDiv, operations);
        buttonDerivationAction(buttonDeriv, operations);
        buttonIntegrationAction(buttonInteg, operations);
    }

    public boolean verifyPolynomial(String polynomial) {
        boolean isExponent = false;
        boolean isNumber = false;

        if (polynomial.equals("+") || polynomial.equals("-") || polynomial.equals("^")) return false;
        for (char c : polynomial.toCharArray()) {
            if (Character.isDigit(c) || c == '+' || c == '-' || c == 'x' || c == '^') {
                if(c == 'x') isNumber = true;
                else if(isNumber && Character.isDigit(c)) return false;
                else if(isNumber) isNumber = false;

                if (c == '^') isExponent = true;
                else if (isExponent && (c == '-' || c == '+' || c == '(')) return false;
                else if(isExponent) isExponent = false;
            } else if (Character.isWhitespace(c) || !Character.isWhitespace(c)) return false;
        }
        return true;
    }

    public boolean verifyText(String firstPolynome, String secondPolynome){
        if(!verifyPolynomial(firstPolynome) && !verifyPolynomial(secondPolynome))
            textFieldResult.setText("Ambele polinoame sunt introduse gresit!");
        else if(!verifyPolynomial(firstPolynome))
            textFieldResult.setText("Primul polinom este introdus gresit!");
        else if(!verifyPolynomial(secondPolynome))
            textFieldResult.setText("Al doilea polinom este introdus gresit!");
        else
            return true;

        return false;
    }

    private void buttonAddAction(JButton buttonAdd, PolynomialOperations operations){
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstPolynome = textFieldP1.getText();
                String secondPolynome = textFieldP2.getText();
                Polynomial x = new Polynomial(firstPolynome);
                Polynomial y = new Polynomial(secondPolynome);
                Polynomial result = operations.addPolynomials(x, y);

                if(verifyText(firstPolynome, secondPolynome)) {
                    boolean isZero = true;
                    for (Map.Entry<Integer, Double> j : result.getPolynomialMap().entrySet()) {
                        if (j.getValue() != 0) {
                            isZero = false;
                            break;
                        }
                    }
                    if (!isZero)
                        textFieldResult.setText(result.createString().toString());
                    else
                        textFieldResult.setText("0.0");
                }
            }
        });
    }

    private void buttonSubAction(JButton buttonSub, PolynomialOperations operations){
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstPolynome = textFieldP1.getText();
                String secondPolynome = textFieldP2.getText();
                Polynomial x = new Polynomial(firstPolynome);
                Polynomial y = new Polynomial(secondPolynome);
                Polynomial result = operations.substractPolynomials(x, y);

                if(verifyText(firstPolynome, secondPolynome)) {
                    boolean isZero = true;
                    for (Map.Entry<Integer, Double> j : result.getPolynomialMap().entrySet()) {
                        if (j.getValue() != 0) {
                            isZero = false;
                            break;
                        }
                    }
                    if (!isZero)
                        textFieldResult.setText(result.createString().toString());
                    else
                        textFieldResult.setText("0.0");
                }
            }
        });
    }

    private void buttonMulAction(JButton buttonMul, PolynomialOperations operations){
        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstPolynome = textFieldP1.getText();
                String secondPolynome = textFieldP2.getText();
                Polynomial x = new Polynomial(firstPolynome);
                Polynomial y = new Polynomial(secondPolynome);
                Polynomial result = operations.multiplyPolynomials(x, y);

                if(verifyText(firstPolynome, secondPolynome)) {
                    if (x.getPolynomialMap().isEmpty() || y.getPolynomialMap().isEmpty()) {
                        textFieldResult.setText("0.0");
                    } else
                        textFieldResult.setText(result.createString().toString());
                }
            }
        });
    }

    private void buttonDivAction(JButton buttonDiv, PolynomialOperations operations){
        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstPolynome = textFieldP1.getText();
                String secondPolynome = textFieldP2.getText();

                if(verifyText(firstPolynome, secondPolynome))
                    textFieldResult.setText("(" + firstPolynome + ")/(" + secondPolynome + ")");
            }
        });
    }

    private void buttonDerivationAction(JButton buttonDerivation, PolynomialOperations operations){
        buttonDerivation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstPolynome = textFieldP1.getText();
                Polynomial x = new Polynomial(firstPolynome);
                Polynomial result = operations.derivatePolynomial(x);

                if(!verifyPolynomial(firstPolynome))
                    textFieldResult.setText("Polinomul de derivat este introdus gresit!");
                else {
                    if (x.getPolynomialMap().isEmpty() || result.getPolynomialMap().isEmpty()) {
                        textFieldResult.setText("0.0");
                    } else if (firstPolynome.equals("x"))
                        textFieldResult.setText("1.0");
                    else
                        textFieldResult.setText(result.createString().toString());
                }
            }
        });
    }

    private void buttonIntegrationAction(JButton buttonIntegration, PolynomialOperations operations){
        buttonIntegration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstPolynome = textFieldP1.getText();
                Polynomial x = new Polynomial(firstPolynome);
                Polynomial result = operations.integratePolynomial(x);

                if(!verifyPolynomial(firstPolynome))
                    textFieldResult.setText("Polinomul de integrat este introdus gresit!");
                else {
                    if (x.getPolynomialMap().isEmpty() || result.getPolynomialMap().isEmpty()) {
                        textFieldResult.setText("C");
                    } else
                        textFieldResult.setText(result.createString().toString() + " + C");
                }
            }
        });
    }
}
