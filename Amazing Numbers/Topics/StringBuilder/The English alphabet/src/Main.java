class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        // write your code here
        StringBuilder alphabet = new StringBuilder("A");
        for (char c = 'B'; c <= 'Z' ; ++c) {
            alphabet.append(" " + c);
        }

        return alphabet;
    }
}