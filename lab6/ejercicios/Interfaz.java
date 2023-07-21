import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {

    private JTextField textField;
    private TextArea textArea;


    public Interfaz() {
        setTitle("Buscador de Palabras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new TextArea("");

        textField = new JTextField(20);
        JButton searchButton = new JButton("Buscar");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = textField.getText();
                String palabraCompleta = buscarPalabras(searchText);
                textArea.setText(palabraCompleta);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Palabra a buscar: "));
        panel.add(textField);
        panel.add(searchButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    private String buscarPalabras(String palabra) {
        return palabra;
    }

    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }
}

