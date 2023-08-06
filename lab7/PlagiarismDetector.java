

public class PlagiarismDetector {
    private ParagraphNode paragraphsHead;

    public PlagiarismDetector() {
        paragraphsHead = null;
    }

    public void addParagraph(String paragraphText) {
        ParagraphNode paragraphNode = new ParagraphNode();
        String[] words = paragraphText.split("\\s+");
        for (String word : words) {
            paragraphNode.trie.insert(word);
        }
        if (paragraphsHead == null) {
            paragraphsHead = paragraphNode;
        } else {
            ParagraphNode current = paragraphsHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = paragraphNode;
        }
    }

    public boolean checkPlagiarism(String textToCheck) {
        String[] words = textToCheck.split("\\s+");
        for (String word : words) {
            ParagraphNode current = paragraphsHead;
            while (current != null) {
                if (current.trie.search(word)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }


}
