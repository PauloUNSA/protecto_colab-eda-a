package sistema;

import trie.Trie;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class PlagairismChecker {
    private ArrayList<Trie> tries = new ArrayList<>();
    /*
    * @params paths: Rutas de los archivos que forman la 80
    *
    * @return : Booleano informando que no hubo errores de lectura
     */
    public boolean loadFiles(String[] paths){
        //Llenar las estructuras (recomendado)
        //Lectura del archivo (recomendado)
        for (String path : paths) {
            if (!loadFile(path)) {
                return false;
            }
        }
        return true;
    }
    private boolean loadFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            String msg = "";
            Trie trie = new Trie();
            while ((line = reader.readLine()) != null) {
                String[] palabras = line.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                    palabras[i] = palabras[i].trim().toLowerCase();
                    Pattern pattern = Pattern.compile("^[a-z]+$");
                    if (pattern.matcher(palabras[i]).matches())
                        trie.insert(palabras[i]);
                    else {
                        msg = "hay palabras que son letras o tienen caracteres especiales";
                    }
                }
            }
            if (!msg.isEmpty()) JOptionPane.showMessageDialog(null,"texto no proporcionado en "+path+" es de solo palabras",msg,JOptionPane.ERROR_MESSAGE);
            tries.add(trie);
            return true;

        } catch (IOException e) {
            return false;
        }
    }
    /*
    * @params paths: Ruta del archivo donde colocaremos el texto con/sin plagio
    *
    * @return : Booleano informando que no hubo errores de lectura
     */
    public ResulChacker loadFiles(String path){
        //Retornar resultados del sistema (obligatorio)
        return new ResulChacker(tries);
    }
}
