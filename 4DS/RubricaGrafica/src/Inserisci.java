import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inserisci extends JFrame{

    private JPanel pagIns;
    private JTextField txtNome;
    private JTextField txtNumero;
    private JTextField txtCitta;
    private JTextField txtEta;
    private JButton btnDone;
    private Persona user;

    public Inserisci(boolean scelta, String nome){
        setContentPane(pagIns);
        setTitle("Inserisci");
        setSize(700, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(scelta) {
                    try {
                        user = new Persona(txtNome.getText(), Integer.parseInt(txtEta.getText()), txtCitta.getText(), txtNumero.getText());

                        MianGrafica.rub.inserimento(user);
                        setVisible(false);
                    } catch (Exception ex) {
                        btnDone.setText(ex.getMessage());
                    }
                }else {
                    try {
                        user = new Persona(txtNome.getText(), Integer.parseInt(txtEta.getText()), txtCitta.getText(), txtNumero.getText());

                        MianGrafica.rub.modifica(nome,user);
                        setVisible(false);
                    } catch (Exception ex) {
                        btnDone.setText(ex.getMessage());
                    }
                }
            }
        });
    }
}
