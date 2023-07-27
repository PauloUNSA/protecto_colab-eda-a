import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class Interface extends JFrame {
    JTextField texto = new JTextField(15);
    JButton[] botones= new JButton[3];
    JTextArea jTextArea = new JTextArea(1,1);
    public Interface() {
        setSize(500,500);
        setTitle("Prueba");
        setLayout(new BorderLayout());
        createContents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void createContents(){
        Panel panel = new Panel(new FlowLayout());
        botones[0] = new JButton("insertar");
        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("insertar");
            }
        });
        botones[1] = new JButton("buscar");
        botones[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("buscar");
            }
        });
        botones[2] = new JButton("reemplazar");
        botones[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("reemplazar");
            }
        });
        panel.add(texto);
        panel.add(botones[0]);
        panel.add(botones[1]);
        panel.add(botones[2]);
        add(panel,BorderLayout.NORTH);
        add(jTextArea,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Interface();
    }

}