package edu.goit.telegrambot.constants;

public enum Emoji {
    UA("\uD83C\uDDFA\uD83C\uDDE6"),
    USA("\uD83C\uDDFA\uD83C\uDDF8"),
    EU("\uD83C\uDDEA\uD83C\uDDFA");

    String field;
    Emoji(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
