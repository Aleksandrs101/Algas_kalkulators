import jdk.internal.access.JavaNetHttpCookieAccess;
import org.w3c.dom.css.DocumentCSS;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;


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
    private JSlider slider1;
    private JComboBox comboBox1;
    boolean nodoklaGramata = false;
    private JavaNetHttpCookieAccess decimalFormat;
    BigDecimal neto;
    double IIN;
    String[] Gads;
    String[] values;
    int gads = Integer.parseInt((String) Objects.requireNonNull(comboBox1.getSelectedItem()));
    public prototips1() {
        if (gads==2022) {

            textPane1.setText("""
                    \t\t\t\t2022\s
                    Iedzīvotāju ienākumu nodokļa likme algai gadā līdz 20'004 EUR 20%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 20'004.01 līdz 78'100 EUR 23%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 78'100.01 EUR 31%
                    Valsts sociālās apdrošināšanas obligātās iemaksas likme 10.5%
                    Atvieglojums par apgādībā esošām personām 250 EUR
                    Neapliekamais minimums 0-350 EUR""");
        }
        if (gads==2021) {
            textPane1.setText("""
                    \t\t\t\t2021\s
                    Iedzīvotāju ienākumu nodokļa likme algai gadā līdz 20'004 EUR 20%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 20'004.01 līdz 78'100 EUR 23%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 78'100.01 EUR 31.4%
                    Valsts sociālās apdrošināšanas obligātās iemaksas likme 10.5%
                    Atvieglojums par apgādībā esošām personām 250 EUR
                    Neapliekamais minimums 0-300 EUR""");
        }
        if (gads==2020) {
            textPane1.setText("""
                    \t\t\t\t2020\s
                    Iedzīvotāju ienākumu nodokļa likme algai gadā līdz 20'004 EUR 20%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 20'004.01 līdz 78'100 EUR 23%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 78'100.01 EUR 31.4%
                    Valsts sociālās apdrošināšanas obligātās iemaksas likme 11%
                    Atvieglojums par apgādībā esošām personām 250 EUR
                    Neapliekamais minimums 0-300 EUR""");
        }
        if (gads==2019) {
            textPane1.setText("""
                    \t\t\t\t2019\s
                    Iedzīvotāju ienākumu nodokļa likme algai gadā līdz 20'004 EUR 20%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 20'004.01 līdz 78'100 EUR 23%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 78'100.01 EUR 31.4%
                    Valsts sociālās apdrošināšanas obligātās iemaksas likme 11%
                    Atvieglojums par apgādībā esošām personām 230 EUR
                    Neapliekamais minimums 0-300 EUR""");
        }
        if (gads==2018) {
            textPane1.setText("""
                    \t\t\t\t2018\s
                    Iedzīvotāju ienākumu nodokļa likme algai gadā līdz 20'004 EUR 20%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 20'004.01 līdz 78'100 EUR 23%
                    Iedzīvotāju ienākumu nodokļa likme algai gadā no 78'100.01 EUR 31.4%
                    Valsts sociālās apdrošināšanas obligātās iemaksas likme 11%
                    Atvieglojums par apgādībā esošām personām 200 EUR
                    Neapliekamais minimums 0-200 EUR""");
        }
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
        String path = "C:\\Users\\aozolins\\OneDrive - Emergn Ltd\\Darbvirsma\\algaCSV.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null){
                values = line.split(";");

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double neapliekamaisMinimums = 0;
                double atvieglojumsInvalid = 0;
                slider1.setValue(Integer.parseInt(txtBruto.getText()) / 5);
                double brutoAlga = Double.parseDouble(txtBruto.getText());
                int apgSk = Integer.parseInt((String) Objects.requireNonNull(apgSka.getSelectedItem()));
                gads = Integer.parseInt((String) Objects.requireNonNull(comboBox1.getSelectedItem()));
                String neapliekamaisMin = (txtNeapliekmin.getText());
                String atvieglojumsInv = (txtInvalid.getText());
                double VSAOI = brutoAlga*0.105;
                double apgadSk = apgSk*250;
                if (gads == 2022) {
                    if (neapliekamaisMin.isEmpty()) {
                    neapliekamaisMinimums = 0;

                    } else {
                        neapliekamaisMinimums = Double.parseDouble(txtNeapliekmin.getText());
                    }
                    if (atvieglojumsInv.isEmpty()) {
                        atvieglojumsInvalid = 0;
                    } else {
                        atvieglojumsInvalid = Double.parseDouble(txtInvalid.getText());
                    }
                    if (brutoAlga > 0) {
                        if (atvieglojumsInvalid >= 0) {
                            if (neapliekamaisMinimums >= 0) {
                                if (neapliekamaisMinimums <= 350) {
                                    if (nodoklaGramata) {
                                        if (brutoAlga <= 1667) {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.2)).setScale(2, RoundingMode.HALF_UP);
                                        } else {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.23)).setScale(2, RoundingMode.HALF_UP);
                                        }
                                    } else {
                                        IIN = brutoAlga * 0.23 - VSAOI * 0.2;
                                        neto = BigDecimal.valueOf(brutoAlga - IIN - VSAOI).setScale(2, RoundingMode.HALF_UP);
                                    }

                                    txtNeto.setText("" + neto);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet neapliekamo minimumu no 0 līdz 350");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                    }
                }
                if (gads == 2021) {

                    if (neapliekamaisMin.isEmpty()) {
                        neapliekamaisMinimums = 0;

                    } else {
                        neapliekamaisMinimums = Double.parseDouble(txtNeapliekmin.getText());
                    }
                    if (atvieglojumsInv.isEmpty()) {
                        atvieglojumsInvalid = 0;
                    } else {
                        atvieglojumsInvalid = Double.parseDouble(txtInvalid.getText());
                    }
                    if (brutoAlga > 0) {
                        if (atvieglojumsInvalid >= 0) {
                            if (neapliekamaisMinimums >= 0) {
                                if (neapliekamaisMinimums <= 300) {
                                    if (nodoklaGramata) {
                                        if (brutoAlga <= 1667) {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.2)).setScale(2, RoundingMode.HALF_UP);
                                        } else {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.23)).setScale(2, RoundingMode.HALF_UP);
                                        }
                                    } else {
                                        IIN = brutoAlga * 0.23 - VSAOI * 0.2;
                                        neto = BigDecimal.valueOf(brutoAlga - IIN - VSAOI).setScale(2, RoundingMode.HALF_UP);
                                    }

                                    txtNeto.setText("" + neto);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet neapliekamo minimumu no 0 līdz 300");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                    }
                }
                if (gads == 2020) {
                    VSAOI = brutoAlga*0.11;
                    apgadSk = apgSk*250;
                    if (neapliekamaisMin.isEmpty()) {
                        neapliekamaisMinimums = 0;

                    } else {
                        neapliekamaisMinimums = Double.parseDouble(txtNeapliekmin.getText());
                    }
                    if (atvieglojumsInv.isEmpty()) {
                        atvieglojumsInvalid = 0;
                    } else {
                        atvieglojumsInvalid = Double.parseDouble(txtInvalid.getText());
                    }
                    if (brutoAlga > 0) {
                        if (atvieglojumsInvalid >= 0) {
                            if (neapliekamaisMinimums >= 0) {
                                if (neapliekamaisMinimums <= 300) {
                                    if (nodoklaGramata) {
                                        if (brutoAlga <= 1667) {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.2)).setScale(2, RoundingMode.HALF_UP);
                                        } else {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.23)).setScale(2, RoundingMode.HALF_UP);
                                        }
                                    } else {
                                        IIN = brutoAlga * 0.23 - VSAOI * 0.2;
                                        neto = BigDecimal.valueOf(brutoAlga - IIN - VSAOI).setScale(2, RoundingMode.HALF_UP);
                                    }

                                    txtNeto.setText("" + neto);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet neapliekamo minimumu no 0 līdz 350");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                    }
                }
                if (gads == 2019) {
                    VSAOI = brutoAlga*0.11;
                    apgadSk = apgSk*230;
                    if (neapliekamaisMin.isEmpty()) {
                        neapliekamaisMinimums = 0;

                    } else {
                        neapliekamaisMinimums = Double.parseDouble(txtNeapliekmin.getText());
                    }
                    if (atvieglojumsInv.isEmpty()) {
                        atvieglojumsInvalid = 0;
                    } else {
                        atvieglojumsInvalid = Double.parseDouble(txtInvalid.getText());
                    }
                    if (brutoAlga > 0) {
                        if (atvieglojumsInvalid >= 0) {
                            if (neapliekamaisMinimums >= 0) {
                                if (neapliekamaisMinimums <= 300) {
                                    if (nodoklaGramata) {
                                        if (brutoAlga <= 1667) {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.2)).setScale(2, RoundingMode.HALF_UP);
                                        } else {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.23)).setScale(2, RoundingMode.HALF_UP);
                                        }
                                    } else {
                                        IIN = brutoAlga * 0.23 - VSAOI * 0.2;
                                        neto = BigDecimal.valueOf(brutoAlga - IIN - VSAOI).setScale(2, RoundingMode.HALF_UP);
                                    }

                                    txtNeto.setText("" + neto);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet neapliekamo minimumu no 0 līdz 350");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                    }
                }
                if (gads == 2018) {
                    VSAOI = brutoAlga*0.11;
                    apgadSk = apgSk*200;
                    if (neapliekamaisMin.isEmpty()) {
                        neapliekamaisMinimums = 0;

                    } else {
                        neapliekamaisMinimums = Double.parseDouble(txtNeapliekmin.getText());
                    }
                    if (atvieglojumsInv.isEmpty()) {
                        atvieglojumsInvalid = 0;
                    } else {
                        atvieglojumsInvalid = Double.parseDouble(txtInvalid.getText());
                    }
                    if (brutoAlga > 0) {
                        if (atvieglojumsInvalid >= 0) {
                            if (neapliekamaisMinimums >= 0) {
                                if (neapliekamaisMinimums <= 200) {
                                    if (nodoklaGramata) {
                                        if (brutoAlga <= 1667) {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.2)).setScale(2, RoundingMode.HALF_UP);
                                        } else {
                                            neto = BigDecimal.valueOf(brutoAlga - VSAOI - ((1667 - VSAOI - apgadSk - neapliekamaisMinimums - atvieglojumsInvalid) * 0.2 + (brutoAlga - 1667) * 0.23)).setScale(2, RoundingMode.HALF_UP);
                                        }
                                    } else {
                                        IIN = brutoAlga * 0.23 - (brutoAlga * 0.11) * 0.2;
                                        neto = BigDecimal.valueOf(brutoAlga - IIN - VSAOI).setScale(2, RoundingMode.HALF_UP);
                                    }

                                    txtNeto.setText("" + neto);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet neapliekamo minimumu no 0 līdz 350");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                    }
                }
            }
        });

        txtBruto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char c = e.getKeyChar();
                if(!Character.isDigit(c)&& !(c == 8)){
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
                if(!Character.isDigit(b)&& !(b == 8)){
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
                if(!Character.isDigit(d) && !(d == 8)){

                    txtNeapliekmin.setEditable((false));
                    JOptionPane.showMessageDialog(null, "Lūdzu ievadiet pozitīvus skaitļus");
                }else
                {
                    txtNeapliekmin.setEditable(true);
                }
            }
        });

        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                slider1.setSnapToTicks(true);
                JSlider source = (JSlider) e.getSource();
                if (source.getValueIsAdjusting()) {
                    slider1.setSnapToTicks(true);
                    txtBruto.setText(String.valueOf(slider1.getValue()*5));
            }}
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    }

}
