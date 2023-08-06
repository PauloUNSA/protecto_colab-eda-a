package gui;

import sistema.PlagairismChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main extends JFrame{

	private JTextArea textoAIngresar = new JTextArea();
	JButton plagio, cargaArch;
	private JFileChooser fileChooser;
	private PlagairismChecker pC = new PlagairismChecker();

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
		add(textoAIngresar,BorderLayout.CENTER);
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
		setActions();
/*
		guardarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarDatos()) {
										
					int codigo = Integer.parseInt(codigoField.getText());
					String nombre = nombreField.getText();
					String direccion = direccionField.getText();
					//boolean seGuardo = rutaDeDistribucion.loadFiles(codigo, nombre, direccion);
					window.getDistributionRoute().addAlmacen(new Almacen(codigo, nombre, direccion));

					codigoField.setText("");
					nombreField.setText("");
					direccionField.setText("");
					
					JOptionPane.showMessageDialog(null, "Datos guardados exitosamente");
				}
			}
		});

		cargarArchivosButton = new JButton("Cargar Archivos");
		cargarArchivosButton.setBounds(224, 259, 143, 30);
		cargarArchivosButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarFileChooser();
			}
		});



		this.add(codigoLabel);
		this.add(codigoField);
		this.add(nombreField);
		this.add(direccionField);
		this.add(cargarArchivosButton);*/
	}

	private void setActions() {
		plagio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

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
			}
		}
	}
	public void mensajeError(Component location, String alert, String encabezado) {
		JOptionPane.showMessageDialog(location, alert, encabezado, JOptionPane.ERROR_MESSAGE);
	}

	public void mensaje(Component location, String alert) {
		JOptionPane.showMessageDialog(location, alert);
	}/*

	
	private boolean validarDatos() {
		String codigoStr = codigoField.getText();
		String nombre = nombreField.getText();
		String direccion = direccionField.getText();

		try {
			Integer.parseInt(codigoStr);
		} catch (NumberFormatException e) {
			mensajeError(this, "El código debe ser un número entero válido", "Error de validación");
			return false;
		}

		if (codigoStr.isEmpty() || nombre.isEmpty() || direccion.isEmpty()) {
			mensajeError(this, "Todos los campos son obligatorios", "Error de validación");
			return false;
		}

		return true;
	}*/
}
