/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum;

/**
 *
 * @author ASUS
 */
public class Baju extends Pakaian implements PakaianInterface {
   private String lengan;
    private String merek;
   //Override polimorfisme dynamic dari Super Class ke Sub Class  
 @Override
    public int getJmlhPakaian() {
        return jmlhpakaian;
    }
//Override polimorfisme dynamic dari Super Class ke Sub Class 
    @Override
    public int infopakaian() {
        System.out.println("Jumlah Baju: " + jmlhpakaian);
        return jmlhpakaian;
    }
    // Mengimplementasikan metode dari interface
    @Override
    public int infoPakaian() {
        System.out.println("Jumlah Baju: " + jmlhpakaian);
        return jmlhpakaian;
    }
    // Konstruktor default
    public Baju() {
        // Inisialisasi default jika diperlukan
        this.lengan = "Default Lengan";
        this.merek = "Default Merek";
    }

   // Konstruktor dengan parameter
    public Baju(String lengan, String merek) {
        // Penanganan exception untuk lengan atau merek yang null
        if (lengan == null || merek == null) {
            System.out.println("Exception: Lengan atau merek tidak boleh null!");
            // Inisialisasi default jika diperlukan
            this.lengan = "Default Lengan";
            this.merek = "Default Merek";
        } else {
            this.lengan = lengan;
            this.merek = merek;
        }
    }
// Setter untuk mengatur nilai merek baju menggunakan parameter.
    void setDataMerek(String merek) {
        // Penanganan exception untuk merek yang tidak valid
        if (merek == null) {
            System.out.println("Exception: Merek tidak boleh null!");
        } else {
            this.merek = merek;
        }
    }

    // Overloading: Setter untuk mengatur nilai merek dan jenis lengan baju menggunakan parameter.
    void setDataMerek(String merek, String lengan) {
        this.merek = merek;
        this.lengan = lengan;
    }

    // Setter untuk mengatur jenis lengan baju menggunakan parameter.
    void setDataLengan(String lengan) {
        this.lengan = lengan;
    }

    // Overloading: Setter untuk mengatur jenis lengan dan merek baju menggunakan parameter.
    void setDataLengan(String lengan, String merek) {
        this.lengan = lengan;
        this.merek = merek;
    }

    // Getter tetap sama

    // Overriding: Getter untuk mendapatkan nilai merek baju. (mengubah cara implementasi)
    String getCetakMerek() {
        return "Merek Baju: " + merek;
    }

    // Overriding: Getter untuk mendapatkan jenis lengan baju. (mengubah cara implementasi)
    String getCetakLengan() {
        return "Jenis Lengan Baju: " + lengan;
    }

}



