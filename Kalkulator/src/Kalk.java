import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Kalk implements ActionListener {
    JTextField t1, t2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bkropka;
    JButton bplus, bminus, bmnoz, bdziel, bmodulo, bpierw, bpotega, brow, bclear;
    String dzialanie;
    double x, buf;
    Stack<String> history;

    public Kalk() {
        history = new Stack<>();
    }

    public void actionPerformed(ActionEvent e) {
        Object target = e.getSource();
        t1.setEditable(false);

        if (target == b1 || target == b2 || target == b3 || target == b4 || target == b5 ||
                target == b6 || target == b7 || target == b8 || target == b9 || target == b0) {
            String buttonText = ((JButton) target).getText();
            addToHistory(buttonText);
            t1.setText(t1.getText() + buttonText);
            t1.requestFocus();
        } else if (target == bkropka) {
            boolean jestKropka = false;
            String buf = t1.getText();
            for (int i = 0; i < buf.length(); i++) {
                if (buf.charAt(i) == '.') {
                    jestKropka = true;
                    break;
                }
            }
            if (!jestKropka) {
                addToHistory(((JButton) target).getText());
                t1.setText(t1.getText() + ((JButton) target).getText());
                t1.requestFocus();
            }
        } else if (target == bplus || target == bminus || target == bmnoz || target == bdziel ||
                target == bmodulo || target == bpotega) {
            String buttonText = ((JButton) target).getText();
            addToHistory(" " + buttonText + " ");
            buf = Double.parseDouble(t1.getText());
            dzialanie = buttonText;
            t1.setText("");
            t1.requestFocus();
        } else if (target == bpierw) {
            addToHistory(" " + ((JButton) target).getText() + " ");
            dzialanie = "√";
            t1.setText("");
            t1.requestFocus();
        } else if (target == bclear) {
            addToHistory(" clear ");
            buf = 0;
            t1.setText("");
            t1.requestFocus();
        } else if (target == brow || target == t1) {
            x = Double.parseDouble(t1.getText());
            if (dzialanie.equals("-")) {
                x = buf - x;
            } else if (dzialanie.equals("+")) {
                x = buf + x;
            } else if (dzialanie.equals("*")) {
                x = buf * x;
            } else if (dzialanie.equals("/")) {
                if (x == 0) {
                    t1.setText("Nie można wykonać działania. Dzielenie przez 0!");
                    t1.requestFocus();
                    return;
                } else {
                    x = buf / x;
                }
            } else if (dzialanie.equals("%")) {
                x = buf % x;
            } else if (dzialanie.equals("√")) {
                if (x < 0) {
                    t1.setText("Nie można wykonać działania. Ujemna liczba!");
                    t1.requestFocus();
                    return;
                } else {
                    x = Math.sqrt(x);
                }
            } else if (dzialanie.equals("**")) {
                x = Math.pow(buf, x);
            }

            t1.setText(Double.toString(x));
            t1.requestFocus();
            addToHistory(" = " + x);

            // Zapis historii do pliku
            saveHistoryToFile();
        }
    }

    void init() {
        JFrame f = new JFrame();
        Container c = f.getContentPane();

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.setLayout(gbl);

        t1 = new JTextField(15);
        t1.addActionListener(this);
        t1.setHorizontalAlignment(JTextField.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.ipadx = 0;
        gbc.ipady = 5;
        gbc.insets = new Insets(5, 5, 0, 5);
        gbl.setConstraints(t1, gbc);
        c.add(t1);

        b1 = new JButton("1");
        b1.addActionListener(this);
        b1.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b1, gbc);
        c.add(b1);

        b2 = new JButton("2");
        b2.addActionListener(this);
        b2.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b2, gbc);
        c.add(b2);

        b3 = new JButton("3");
        b3.addActionListener(this);
        b3.setFocusable(false);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b3, gbc);
        c.add(b3);

        b4 = new JButton("4");
        b4.addActionListener(this);
        b4.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b4, gbc);
        c.add(b4);

        b5 = new JButton("5");
        b5.addActionListener(this);
        b5.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b5, gbc);
        c.add(b5);

        b6 = new JButton("6");
        b6.addActionListener(this);
        b6.setFocusable(false);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b6, gbc);
        c.add(b6);

        b7 = new JButton("7");
        b7.addActionListener(this);
        b7.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b7, gbc);
        c.add(b7);

        b8 = new JButton("8");
        b8.addActionListener(this);
        b8.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b8, gbc);
        c.add(b8);

        b9 = new JButton("9");
        b9.addActionListener(this);
        b9.setFocusable(false);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b9, gbc);
        c.add(b9);

        b0 = new JButton("0");
        b0.addActionListener(this);
        b0.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 0);
        gbl.setConstraints(b0, gbc);
        c.add(b0);

        bkropka = new JButton(".");
        bkropka.addActionListener(this);
        bkropka.setFocusable(false);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 0);
        gbl.setConstraints(bkropka, gbc);
        c.add(bkropka);

        bplus = new JButton("+");
        bplus.addActionListener(this);
        bplus.setFocusable(false);
        bplus.setToolTipText("dodawanie");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 30;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 5);
        gbl.setConstraints(bplus, gbc);
        c.add(bplus);

        bminus = new JButton("-");
        bminus.addActionListener(this);
        bminus.setFocusable(false);
        bminus.setToolTipText("odejmowanie");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 30;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 5);
        gbl.setConstraints(bminus, gbc);
        c.add(bminus);

        bmnoz = new JButton("*");
        bmnoz.addActionListener(this);
        bmnoz.setFocusable(false);
        bmnoz.setToolTipText("mnozenie");
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 30;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbl.setConstraints(bmnoz, gbc);
        c.add(bmnoz);

        bdziel = new JButton("/");
        bdziel.addActionListener(this);
        bdziel.setFocusable(false);
        bdziel.setToolTipText("dzielenie");
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 30;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbl.setConstraints(bdziel, gbc);
        c.add(bdziel);

        bmodulo = new JButton("%");
        bmodulo.addActionListener(this);
        bmodulo.setFocusable(false);
        bmodulo.setToolTipText("modulo");
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 30;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbl.setConstraints(bmodulo, gbc);
        c.add(bmodulo);

        bpierw = new JButton("√");
        bpierw.addActionListener(this);
        bpierw.setFocusable(false);
        bpierw.setToolTipText("pierwiastek");
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 30;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbl.setConstraints(bpierw, gbc);
        c.add(bpierw);

        bpotega = new JButton("**");
        bpotega.addActionListener(this);
        bpotega.setFocusable(false);
        bpotega.setToolTipText("potega");
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 30;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbl.setConstraints(bpotega, gbc);
        c.add(bpotega);

        brow = new JButton("=");
        brow.addActionListener(this);
        brow.setFocusable(false);
        brow.setToolTipText("wykonaj działanie");
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 30;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 5);
        gbl.setConstraints(brow, gbc);
        c.add(brow);

        bclear = new JButton("clear");
        bclear.addActionListener(this);
        bclear.setFocusable(false);
        bclear.setToolTipText("wyczysc input");
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        //gbc.ipadx=0;
        //gbc.ipady=0;
        gbc.insets = new Insets(0, 5, 0, 5);
        gbl.setConstraints(bclear, gbc);
        c.add(bclear);

        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Kalk");
        f.setVisible(true);
    }


    private void addToHistory(String entry) {
        history.push(entry);
    }

    private void saveHistoryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("history.txt", true))) {
            for (String entry : history) {
                writer.write(entry);
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Kalk().init());
    }
}
