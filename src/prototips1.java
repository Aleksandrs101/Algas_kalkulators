import jdk.internal.access.JavaNetHttpCookieAccess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
    boolean nodoklaGramata = false;
    private JavaNetHttpCookieAccess decimalFormat;
    BigDecimal neto;
    double IIN;
    public prototips1() {
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

                if (nodoklaGramata == true){
                    if (brutoAlga<=1667){
                        neto = new BigDecimal(brutoAlga - (brutoAlga*0.105) - ((1667 - (brutoAlga * 0.105) - (apgSk*250) - neapliekamaisMin - atvieglojumsInv) * 0.2 + (brutoAlga - 1667) * 0.2)).setScale(2, RoundingMode.HALF_UP);;
                    }
                    else {
                        neto = new BigDecimal(brutoAlga - (brutoAlga*0.105) - ((1667 - (brutoAlga * 0.105) - (apgSk*250) - neapliekamaisMin - atvieglojumsInv) * 0.2 + (brutoAlga - 1667) * 0.23)).setScale(2, RoundingMode.HALF_UP);;
                    }
                }
                else{
                    IIN = brutoAlga*0.23-(brutoAlga*0.105)*0.2;
                    neto = new BigDecimal(brutoAlga-IIN-(brutoAlga*0.105)).setScale(2, RoundingMode.HALF_UP);
                }

                txtNeto.setText(""+neto);

            }
        });

    }

    public static void main(String[] args) {
        prototips1 h=new prototips1();
        h.setContentPane(h.panelMain);
        h.setTitle("HEllo");
        h.setBounds(200, 50, 1000, 600);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
