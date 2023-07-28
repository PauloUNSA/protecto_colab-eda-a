package ejercicio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface extends JFrame {
    JTextField cuadroTexto = new JTextField(15);
    JButton[] botones= new JButton[4];
    JTextArea textoMostrado = new JTextArea(1,1);
    ArrayList<String> palabras = new ArrayList<>();
    Trie trie = new Trie();
    LectorTexto lector=new LectorTexto();
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
        Panel panelInf=new Panel(new FlowLayout());
        botones[0] = new JButton("insertar");
        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	añadirAlTrie(cuadroTexto.getText());
                
                actualizarTextoMostrado();
                cuadroTexto.setText("");
            }
        });
        botones[1] = new JButton("buscar");
        botones[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabraBuscada = cuadroTexto.getText().toLowerCase();
                String msg = trie.search(palabraBuscada) ? "Se encontro":"No se encontro";
                JOptionPane.showMessageDialog(null,msg);
            }
        });
        botones[2] = new JButton("reemplazar");
        botones[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String old = JOptionPane.showInputDialog(null,"Ingresa la palabra que sera reemplazada:");
                String nueva = JOptionPane.showInputDialog(null, "Ingresa la palabra nueva:");
                int index = palabras.indexOf(old);
                if (index != -1) {
                    palabras.set(index, nueva);
                    trie.reemplazar(old.toLowerCase(), nueva.toLowerCase());
                }
                actualizarTextoMostrado();
                cuadroTexto.setText("");
            }
        });
        botones[3] = new JButton("Importar texto");
        botones[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ruta = JOptionPane.showInputDialog(null,"Ingresa la ruta");
                añadirAlTrie(lector.leerArchivo(ruta));
                
                actualizarTextoMostrado();
                
            }
        });
        panel.add(cuadroTexto);
        panel.add(botones[0]);
        panel.add(botones[1]);
        panel.add(botones[2]);
        panelInf.add(botones[3]);
        add(panel,BorderLayout.NORTH);
        add(panelInf,BorderLayout.SOUTH);
        textoMostrado.setEditable(false);
        add(textoMostrado,BorderLayout.CENTER);
    }
    
    private void añadirAlTrie(String frase) {
    	 String[] palabras =  frase.split("\\s+");
         for (String palabra : palabras) {
             trie.insert(palabra.toLowerCase());
             Interface.this.palabras.add(palabra);
         }
    }
    private void actualizarTextoMostrado() {
        String resul = "";
        for (String s :
                palabras) {
            resul += s + " ";
        }
        textoMostrado.setText(resul);
    }
   

    public static void main(String[] args) {
    	
    	
        new Interface();
    }
    /*private Trie trie;
    private JTextField palabraField;
    private JTextArea visualizacionArea;
    private List<String> palabrasIngresadas;
    public Interface() {
        trie = new Trie();
        palabrasIngresadas = new ArrayList<>();
        setTitle("Interfaz Trie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
// Panel para la entrada de palabras
        JPanel palabraPanel = new JPanel();
        palabraPanel.setLayout(new FlowLayout());
        JLabel etiquetaPalabra = new JLabel("Palabra:");
        palabraField = new JTextField(20);
        JButton insertarButton = new JButton("Insertar");
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoIngresado = palabraField.getText();
                String[] palabras = textoIngresado.split("\\s+");
                for (String palabra : palabras) {
                    trie.insert(palabra.toLowerCase());
                    palabrasIngresadas.add(palabra);
                }
// Actualizar el contenido del rea de visualizacin
                actualizarVisualizacion();
                palabraField.setText("");
            }
        });
        palabraPanel.add(etiquetaPalabra);
        palabraPanel.add(palabraField);
        palabraPanel.add(insertarButton);
// Panel para realizar operaciones
        JPanel operacionesPanel = new JPanel();
        operacionesPanel.setLayout(new FlowLayout());
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = palabraField.getText().toLowerCase();
                boolean encontrada = trie.search(palabra);
                String mensaje = encontrada ? "Palabra encontrada" : "Palabra no encontrada";
                JOptionPane.showMessageDialog(Interface.this, mensaje);
            }
        });
        JButton reemplazarButton = new JButton("Reemplazar");
        reemplazarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabraAntigua = JOptionPane.showInputDialog(Interface.this,
                        "Ingresa la palabra a reemplazar:");
                String palabraNueva = JOptionPane.showInputDialog(Interface.this, "Ingresa la nueva palabra:");
                trie.reemplazar(palabraAntigua.toLowerCase(), palabraNueva.toLowerCase());
// Actualizar la lista de palabras ingresadas
                int index = palabrasIngresadas.indexOf(palabraAntigua);
                if (index != -1) {
                    palabrasIngresadas.set(index, palabraNueva);
                }
// Actualizar el contenido del rea de visualizacin
                actualizarVisualizacion();
            }
        });
        operacionesPanel.add(buscarButton);
        operacionesPanel.add(reemplazarButton);
// Panel para mostrar el resultado
        JPanel visualizacionPanel = new JPanel();
        visualizacionPanel.setLayout(new BorderLayout());
        visualizacionArea = new JTextArea();
        visualizacionArea.setEditable(false);
        JScrollPane scrollPaneVisualizacion = new JScrollPane(visualizacionArea);
        visualizacionPanel.add(scrollPaneVisualizacion, BorderLayout.CENTER);
// Agregar los paneles a la ventana
        add(palabraPanel, BorderLayout.NORTH);
        add(operacionesPanel, BorderLayout.CENTER);
        add(visualizacionPanel, BorderLayout.SOUTH);
// Mostrar la ventana
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void actualizarVisualizacion() {
        StringBuilder sb = new StringBuilder();
        for (String palabra : palabrasIngresadas) {
            sb.append(palabra).append(" ");
        }
        visualizacionArea.setText(sb.toString().trim());
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Interface();
        });
    }*/
}