import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.util.ArrayList;
//Masabil Arraya Muhammad
//2206082101
public class Main extends JFrame{

    public static void main(String[] args) {
        // set up frame

        JFrame frame = new JFrame();

        frame.setSize(300, 500);

        frame.setTitle("Mempermudah DDAK by bangABB");

        frame.setLocationByPlatform(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // set up panel

        JPanel panel = new JPanel();

        // set layout to 5x1 grid layout

        panel.setLayout(new GridLayout(5, 1));


        // set up buttons

        JButton decimalToBinary, decimalToNonary, binaryToDecimal, nonaryToDecimal, exit;

        decimalToBinary = new JButton("Decimal To Binary");

        decimalToBinary.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                try {

                    String input = JOptionPane.showInputDialog("Masukkan angka");


                    JOptionPane.showMessageDialog(null, "Berikut hasilnya "  +  decimalToBinary(Double.parseDouble(input),6));

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "An Error Occured!");

                }

            }

        });

        decimalToNonary = new JButton("Decimal To Nonary");

        decimalToNonary.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                try {

                    String input = JOptionPane.showInputDialog("Masukkan angka");

                    JOptionPane.showMessageDialog(null, "Berikut hasilnya "+decimalToNonary(Double.parseDouble(input),6));

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "An Error Occured!");

                }

            }

        });

        binaryToDecimal = new JButton("Binary To Decimal");

        binaryToDecimal.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                try {

                    String input = JOptionPane.showInputDialog("Masukkan String Binary ke Desimal (Bisa koma)");
                    JOptionPane.showMessageDialog(null, "Berikut hasilnya "+binaryToDecimal(input,input.length()));

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "An Error Occured!");

                }

            }

        });

        nonaryToDecimal = new JButton("Nonary To Decimal");

        nonaryToDecimal.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                try {

                    String input = JOptionPane.showInputDialog("Masukkan String Nonary ke Deciimal (Bisa koma");
                    JOptionPane.showMessageDialog(null, "Berikut hasilnya "+nonaryToDecimal(input,input.length()));

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "An Error Occured!");

                }

            }

        });

        exit = new JButton("Exit");

        exit.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Bye!");

                System.exit(0);

            }

        });
        // add components to panel
        panel.add(decimalToBinary);
        panel.add(decimalToNonary);
        panel.add(binaryToDecimal);
        panel.add(nonaryToDecimal);
        panel.add(exit);
        // add panel to frame and make it visible
        frame.add(panel);
        frame.setVisible(true);
    }

    static double binaryToDecimal(String binary,
                                  int len) {

        // Fetch the radix point
        int point = binary.indexOf('.');

        // Update point if not found
        if (point == -1)
            point = len;

        double intDecimal = 0,
                fracDecimal = 0,
                twos = 1;

        // Convert integral part of binary to decimal
        // equivalent
        for (int i = point - 1; i >= 0; i--) {
            intDecimal += (binary.charAt(i) - '0') * twos;
            twos *= 2;
        }

        // Convert fractional part of binary to
        // decimal equivalent
        twos = 2;
        for (int i = point + 1; i < len; i++) {
            fracDecimal += (binary.charAt(i) - '0') / twos;
            twos *= 2.0;
        }

        // Add both integral and fractional part
        return intDecimal + fracDecimal;
    }

    static double nonaryToDecimal(String binary,
                                  int len) {

        // Fetch the radix point
        int point = binary.indexOf('.');

        // Update point if not found
        if (point == -1)
            point = len;

        double intDecimal = 0,
                fracDecimal = 0,
                twos = 1;

        // Convert integral part of binary to decimal
        // equivalent
        for (int i = point - 1; i >= 0; i--) {
            intDecimal += (binary.charAt(i) - '0') * twos;
            twos *= 9;
        }

        // Convert fractional part of binary to
        // decimal equivalent
        twos = 9;
        for (int i = point + 1; i < len; i++) {
            fracDecimal += (binary.charAt(i) - '0') / twos;
            twos *= 9.0;
        }

        // Add both integral and fractional part
        return intDecimal + fracDecimal;
    }

    public static String Reverse(String str) {
        int len = str.length();
        String rev = "";

        for (int i = 0; i < len; i++) {
            rev = str.charAt(i) + rev;
        }
        return rev;
    }

    static String decimalToBinary(double num, int k_prec) {
        String binary = "";

        // Fetch the integral part of decimal number
        int Integral = (int) num;

        // Fetch the fractional part decimal number
        double fractional = num - Integral;

        // Conversion of integral part to
        // binary equivalent
        while (Integral > 0) {
            int rem = Integral % 2;

            // Append 0 in binary
            binary += ((char) (rem + '0'));

            Integral /= 2;
        }

        // Reverse string to get original binary
        // equivalent
        binary = Reverse(binary);

        // Append point before conversion of
        // fractional part
        binary += ('.');

        // Conversion of fractional part to
        // binary equivalent
        while (k_prec-- > 0) {
            // Find next bit in fraction
            fractional *= 2;
            int fract_bit = (int) fractional;

            if (fract_bit == 1) {
                fractional -= fract_bit;
                binary += (char) (1 + '0');
            } else {
                binary += (char) (0 + '0');
            }
        }

        return binary;
    }


    static String decimalToNonary(double num, int k_prec) {
        String binary = "";

        // Fetch the integral part of decimal number
        int Integral = (int) num;

        // Fetch the fractional part decimal number
        double fractional = num - Integral;

        // Conversion of integral part to
        // binary equivalent
        while (Integral > 0) {
            int rem = Integral % 9;

            // Append 0 in binary
            binary += ((char) (rem + '0'));

            Integral /= 9;
        }

        // Reverse string to get original binary
        // equivalent
        binary = Reverse(binary);

        // Append point before conversion of
        // fractional part
        binary += ('.');

        // Conversion of fractional part to
        // binary equivalent
        while (k_prec-- > 0) {
            // Find next bit in fraction
            fractional *= 9;
            int fract_bit = (int) fractional;

            if (fract_bit == 1) {
                fractional -= fract_bit;
                binary += (char) (1 + '0');
            } else {
                binary += (char) (0 + '0');
            }
        }

        return binary;
    }

}