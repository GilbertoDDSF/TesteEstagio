package betternow;

import betternow.web.BuscandoCotacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {

    private JLabel titulo;
    private JTextArea textArea1;
    private JLabel ltexto;
    private JComboBox<String> comboBox1;
    private JPanel mainPanel;
    private JButton buscarCotacaoButton;
    private BuscandoCotacao buscandoCotacao;

    public Tela() {
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        setContentPane(mainPanel);
        setTitle("Auto-cota");
        setSize(800, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setupListeners() {
        buscarCotacaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String escolha = comboBox1.getSelectedItem().toString();
                buscandoCotacao = new BuscandoCotacao();

                switch (escolha) {
                    case "Dolar" -> textArea1.append(buscandoCotacao.buscarCotacaoDolar());
                    case "Euro" -> textArea1.append(buscandoCotacao.buscarCotacaoEuro());
                    case "Real" -> textArea1.append(buscandoCotacao.buscarCotacaoReal());
                    case "Libra" -> textArea1.append(buscandoCotacao.buscarCotacaoLibra());
                    default ->
                            JOptionPane.showMessageDialog(null, "Escolha uma moeda", "Erro", JOptionPane.ERROR_MESSAGE);
                }

                if (buscandoCotacao != null) {
                    buscandoCotacao.fechar();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tela();
            }
        });
    }
}
