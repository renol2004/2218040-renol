/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum;

/**
 *
 * @author ASUS
 */
public class Celana extends Pakaian {
    private String tipe;
    private String warna;

    // Konstruktor default
    public Celana() {
        // Inisialisasi default jika diperlukan
        this.tipe = "Default Tipe";
        this.warna = "Default Warna";
    }

    // Konstruktor dengan parameter
    public Celana(String tipe, String warna) {
        this.tipe = tipe;
        this.warna = warna;
    }

    // Setter untuk mengatur nilai tipe celana menggunakan parameter.
    void setDataTipe(String tipe) {
        this.tipe = tipe;
    }

    // Overloading: Setter untuk mengatur nilai tipe dan warna celana menggunakan parameter.
    void setDataTipe(String tipe, String warna) {
        this.tipe = tipe;
        this.warna = warna;
    }

    // Setter untuk mengatur nilai warna celana menggunakan parameter.
    void setDataWarna(String warna) {
        this.warna = warna;
    }

    // Overloading: Setter untuk mengatur nilai warna dan tipe celana menggunakan parameter.
    void setDataWarna(String warna, String tipe) {
        this.warna = warna;
        this.tipe = tipe;
    }

    // Getter tetap sama

    // Overriding: Getter untuk mendapatkan nilai tipe celana. (mengubah cara implementasi)
    String getCetakTipe() {
        return "Tipe Celana: " + tipe;
    }

    // Overriding: Getter untuk mendapatkan nilai warna celana. (mengubah cara implementasi)
    String getCetakWarna() {
        return "Warna Celana: " + warna;
    }
@Override 
 public int infopakaian() { 
 return infopakaian();
 }
    
}


