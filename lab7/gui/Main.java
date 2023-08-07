package gui;

import sistema.PlagiarismChecker;
import sistema.ResulChacker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class Main extends JFrame{

	private JTextArea textoAIngresar = new JTextArea();
	JButton plagio, cargaArch;
	private JFileChooser fileChooser;
	private PlagiarismChecker pC = new PlagiarismChecker();

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		setSize(500,350);
		setTitle("Detector de plagio");
		setLayout(new BorderLayout());
		cargarContenido();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void cargarContenido() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		JLabel codigoLabel = new JLabel("Ingrese el texto:");
		add(codigoLabel,BorderLayout.NORTH);
		plagio = new JButton("¿Hay plagio?");
		cargaArch = new JButton("Cargar Archivos");
		panel.add(plagio);
		panel.add(cargaArch);
		add(panel,BorderLayout.SOUTH);
		fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);
		textoAIngresar.setEditable(false);
		textoAIngresar.setLineWrap(true);
		textoAIngresar.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textoAIngresar);
		add(scrollPane,BorderLayout.CENTER);
		setActions();
	}

	private void setActions() {
		plagio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = textoAIngresar.getText();
				if (!texto.isEmpty()) {
					ResulChacker rC = pC.verifyPlagiarism(texto);
					String resuls ="";
					int i =0;
					for (boolean b :
							rC.getResul()) {
						resuls += b ? "hay plagio en el archivo "+i+"\n":"No hay plagio en el archivo "+i+"\n";
						i++;
					}
					JOptionPane.showMessageDialog(null,resuls,"Resultados del detector de plagio",INFORMATION_MESSAGE);
				}
			}
		});
		cargaArch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarFileChooser();
			}
		});
	}

	private void mostrarFileChooser() {
		int resultado = fileChooser.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File[] archivosSeleccionados = fileChooser.getSelectedFiles();
			String[] paths = new String[archivosSeleccionados.length];

			for (int i = 0; i < archivosSeleccionados.length; i++) {
				paths[i] = archivosSeleccionados[i].getAbsolutePath();
			}
			if (pC.loadFiles(paths)) {
				mensaje(this, "Archivo(s) correctamente subido(s) y cargado(s)");
				textoAIngresar.setEditable(true);
			}else mensajeError(this,"Archivo en formato incorrecto","Error de carga");
		}
	}
	public void mensajeError(Component location, String alert, String encabezado) {
		JOptionPane.showMessageDialog(location, alert, encabezado, JOptionPane.ERROR_MESSAGE);
	}

	public void mensaje(Component location, String alert) {
		JOptionPane.showMessageDialog(location, alert);
	}
}
