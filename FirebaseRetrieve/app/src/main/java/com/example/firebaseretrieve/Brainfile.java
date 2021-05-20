package com.example.firebaseretrieve;

public class Brainfile {

    String pertanyaan;
    String jawaban;

    Brainfile(String q, String a){
        this.pertanyaan = q;
        this.jawaban = a;
    }
    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
