import jdk.internal.access.JavaNetHttpCookieAccess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Double.isNaN;

public class prototips1 extends JFrame{
    private JPanel panelMain;
    private JTextField txtBruto;
    private JButton btnClick;
    private JTextField txtInvalid;
    private JTextField txtApgad;
    private JTextField txtNeapliekmin;
    private JCheckBox txtNodoklagr;
    private JTextField txtNeto;
    private JComboBox apgSka;
    private JLabel labelBruto;
    private JLabel textArea1;
    private JTextPane textPane1;
    boolean nodoklaGramata = false;
    private JavaNetHttpCookieAccess decimalFormat;
    BigDecimal neto;
    double IIN;
    public prototips1() {
        textPane1.setText("\t\t\t\t2022 \n" +
                "Iedzīvotāju ienākumu nodokļa likme algai gadā līdz 20'004 EUR20%\n" +
                "Iedzīvotāju ienākumu nodokļa likme algai gadā no 20'004.01 līdz 78'100 EUR23%\n" +
                "Iedzīvotāju ienākumu nodokļa likme algai gadā no 78'100.01 EUR31%\n" +
                "Valsts sociālās apdrošināšanas obligātās iemaksas likme10.5%\n" +
                "Atvieglojums par apgādībā esošām personām250 EUR\n" +
                "Neapliekamais minimums0-350 EUR");
        txtNodoklagr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (txtNodoklagr.isSelected()){
                nodoklaGramata = true;
            }
            else{
                nodoklaGramata = false;
            }
            }
        });
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                double brutoAlga =  Double.parseDouble(txtBruto.getText());
                int apgSk = Integer.parseInt((String)apgSka.getSelectedItem());
                double neapliekamaisMin = Double.parseDouble(txtNeapliekmin.getText());
                double atvieglojumsInv =Double.parseDouble(txtInvalid.getText());
                String A = txtNeapliekmin.getText();
                if (!isNaN(brutoAlga) == true) {
                    if (!isNaN(neapliekamaisMin) == true) {
                        if (!isNaN(atvieglojumsInv) == true) {


                            if (neapliekamaisMin >= 0 && neapliekamaisMin <= 350) {
                                if (nodoklaGramata == true) {
                                    if (brutoAlga <= 1667) {
                                        neto = new BigDecimal(brutoAlga - (brutoAlga * 0.105) - ((1667 - (brutoAlga * 0.105) - (apgSk * 250) - neapliekamaisMin - atvieglojumsInv) * 0.2 + (brutoAlga - 1667) * 0.2)).setScale(2, RoundingMode.HALF_UP);
                                        ;
                            } else {
                                        neto = new BigDecimal(brutoAlga - (brutoAlga * 0.105) - ((1667 - (brutoAlga * 0.105) - (apgSk * 250) - neapliekamaisMin - atvieglojumsInv) * 0.2 + (brutoAlga - 1667) * 0.23)).setScale(2, RoundingMode.HALF_UP);
                                        ;
                                    }
                                } else {
                                    IIN = brutoAlga * 0.23 - (brutoAlga * 0.105) * 0.2;
                                    neto = new BigDecimal(brutoAlga - IIN - (brutoAlga * 0.105)).setScale(2, RoundingMode.HALF_UP);
                                }

                                txtNeto.setText("" + neto);
                            } else {
                                JOptionPane.showMessageDialog(null, "Lūdzu ievadiet neapliekamo minimumu no 0 līdz 350");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Lūdzu ievadiet skaitli");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Lūdzu ievadiet skaitli");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet skaitli");
                }
            }
        });

    }

    public static void main(String[] args) {
        prototips1 h=new prototips1();
        h.setContentPane(h.panelMain);
        h.setTitle("Algas kalkulators");
        h.setBounds(200, 30, 870, 640);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(null, "Lūdzu ievadiet skaitļus");

    }

}
