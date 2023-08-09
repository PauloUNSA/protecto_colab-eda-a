private void detectPlagiarism(ArrayList<Trie> tries) {
        String[] words = str.toLowerCase().split("\\s+");
        for (int i = 0; i < resul.length; i++) {
            int numPalbrasConcidentes =0;
            Trie trie = tries.get(i);
            for (String word : words) {
                if (trie.search(word)) {
                    numPalbrasConcidentes++;
                }
            }
            System.out.println(trie.getSize());
            resul[i] = (int) (0.2 * trie.getSize()) <= numPalbrasConcidentes;
        }
    }
