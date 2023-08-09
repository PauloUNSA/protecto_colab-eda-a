private boolean loadFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            if (path.endsWith(".txt")) {
                String line;
                String msg = "";
                boolean exito = false;
                Trie trie = new Trie();
                while ((line = reader.readLine()) != null) {
                    String[] palabras = line.split("\\ss+| ");
                    for (int i = 0; i < palabras.length; i++) {
                        palabras[i] = palabras[i].trim().toLowerCase();
                        Pattern pattern = Pattern.compile("^[a-z]+$");
                        if (pattern.matcher(palabras[i]).matches()) {
                            exito = true;
                            trie.insert(palabras[i]);
                        } else {
                            msg = "hay palabras que son letras o tienen caracteres especiales";
                        }
                    }
                }
                if (!msg.isEmpty())
                    JOptionPane.showMessageDialog(null, "texto no proporcionado en " + path + " no es de solo palabras", msg, JOptionPane.ERROR_MESSAGE);
                if (exito) tries.add(trie);
                return exito;
            }else return false;
        } catch (Exception e) {
            return false;
        }
    }