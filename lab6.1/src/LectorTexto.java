package ejercicio;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LectorTexto {

	public String leerArchivo(String rutaArchivo) {
		StringBuilder contenidoArchivo = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                // Agregar cada línea al StringBuilder
                contenidoArchivo.append(linea).append("\n");
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Obtener el contenido completo del archivo en un String
        String contenido = contenidoArchivo.toString();

        return contenido;
        
    }
	

}
