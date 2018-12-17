package com.company;

public enum Mark {

    X(" X "),
    O(" O "),
    EMPTY("   "),
    ACTIVE("teraz Twoja kolej!"),
    unACTIVE("poczekaj na swoja kolej!");

    private String mark;

    private Mark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}

