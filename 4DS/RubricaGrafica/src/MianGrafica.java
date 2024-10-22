import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MianGrafica extends JFrame {
    private JPanel pagRub;
    private JButton btnInser;
    private JTextField txtCerca;
    private JButton btnShow;
    private JLabel lblShow;
    private JButton btnCerca;
    public static Rubrica rub;

    public MianGrafica() {
        setContentPane(pagRub);
        setTitle("Rubrica");
        setSize(700, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        rub = new Rubrica(10);

        btnInser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inserisci pag2 = new Inserisci(true, "");
            }
        });

        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblShow.setText(rub.minMaxToString());
            }
        });

        btnCerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inserisci pag2 = new Inserisci(false, txtCerca.getText());
            }
        });
    }

    public static void main (String[] args){
        MianGrafica pag1 = new MianGrafica();
    }
}


