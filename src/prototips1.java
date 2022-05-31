import jdk.internal.access.JavaNetHttpCookieAccess;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
                double neapliekamaisMinimums = 0;
                double atvieglojumsInvalid = 0;

                double brutoAlga =  Double.parseDouble(txtBruto.getText());
                int apgSk = Integer.parseInt((String)apgSka.getSelectedItem());
                String neapliekamaisMin = (txtNeapliekmin.getText());
                String atvieglojumsInv = (txtInvalid.getText());
                if (neapliekamaisMin.isEmpty()){
                     neapliekamaisMinimums = 0;
                }
                else {
                    neapliekamaisMinimums = Double.parseDouble(txtNeapliekmin.getText());
                }
                if (atvieglojumsInv.isEmpty()){
                    atvieglojumsInvalid = 0;
                }
                else {
                    atvieglojumsInvalid = Double.parseDouble(txtNeapliekmin.getText());
                }
                if (brutoAlga>0){
                    if (atvieglojumsInvalid>=0){
                        if (neapliekamaisMinimums>=0) {
                            if (neapliekamaisMinimums >= 0 && neapliekamaisMinimums <= 350) {
                                if (nodoklaGramata == true) {
                                    if (brutoAlga <= 1667) {
                                        neto = new BigDecimal(brutoAlga - (brutoAlga * 0.105) - ((1667 - (brutoAlga * 0.105) - (apgSk * 250) - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.2)).setScale(2, RoundingMode.HALF_UP);
                                        ;
                                    } else {
                                        neto = new BigDecimal(brutoAlga - (brutoAlga * 0.105) - ((1667 - (brutoAlga * 0.105) - (apgSk * 250) - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.23)).setScale(2, RoundingMode.HALF_UP);
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
                            JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                    }
            }else {
                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                }
            }
        });

        txtBruto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                     txtBruto.setEditable((false));
                     JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                }else
                {
                    txtBruto.setEditable(true);
                }
            }
        });
        txtInvalid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char b = e.getKeyChar();
                if(Character.isLetter(b)){
                    txtInvalid.setEditable((false));
                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                }else
                {
                    txtInvalid.setEditable(true);
                }
            }
        });
        txtNeapliekmin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char d = e.getKeyChar();
                if(Character.isLetter(d)){
                    txtNeapliekmin.setEditable((false));
                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                }else
                {
                    txtNeapliekmin.setEditable(true);
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
