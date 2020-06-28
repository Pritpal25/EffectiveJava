package chapter2.item5;

import java.util.Objects;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        Objects.requireNonNull(dictionary);
        this.dictionary = dictionary;
    }

    public boolean isValidWord(String word) {
        return true;
    }
}

