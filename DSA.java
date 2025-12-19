public class DSA {
    static boolean[] used;
    static boolean formChain(String[] words, int count, String firstWord, String currentWord) {
        if (count == words.length) {
            char endChar = currentWord.charAt(currentWord.length() - 1);
            char startChar = firstWord.charAt(0);
            return endChar == startChar;
        }
        for (int i = 0; i < words.length; i++) {
            if (!used[i]) {
                if (currentWord.charAt(currentWord.length() - 1) == words[i].charAt(0)) {
                    used[i] = true;

                    if (formChain(words, count + 1, firstWord, words[i]))
                        return true;

                    used[i] = false;
                }
            }
        }
        return false;
    }
    static boolean canFormCircle(String[] words) {
        used = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            used[i] = true;
            if (formChain(words, 1, words[i], words[i]))
                return true;
            used[i] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] words = {"chair", "height", "racket", "touch", "tunic"};

        if (canFormCircle(words))
            System.out.println("YES, they form a circle!");
        else
            System.out.println("NO, they don't form a circle.");
    }
}