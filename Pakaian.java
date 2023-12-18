/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum;

/**
 *
 * @author ASUS
 */
public abstract class Pakaian {
   private String jenis;
     String ukuran;
    public String harga;
    int jmlhpakaian;
// Konstruktor dengan parameter
    public Pakaian(String jenis, String ukuran, String harga) {
        // Penanganan exception untuk harga yang tidak valid
        try {
            Double.parseDouble(harga);
        } catch (NumberFormatException e) {
            System.out.println("Exception: Harga tidak valid!");
            this.harga = "Default Harga";
        }

        this.jenis = jenis;
        this.ukuran = ukuran;
        this.harga = harga;
    }
    // Konstruktor default
    public Pakaian() {
        // Inisialisasi default jika diperlukan
        this.jenis = "Default Jenis";
        this.ukuran = "Default Ukuran";
        this.harga = "Default Harga";
    }
   //Deklarasi polimorfisme dynamic di Super Class    
    public void HitTotalpakaian(){ 
        this.jmlhpakaian= getJmlhPakaian(); 
   }  


    // Setter untuk mengatur nilai jenis pakaian menggunakan parameter.
    void setDataJenis(String jenis) {
        this.jenis = jenis;
    }

    // Overloading: Setter untuk mengatur nilai jenis dan ukuran pakaian menggunakan parameter.
    void setDataJenis(String jenis, String ukuran) {
        this.jenis = jenis;
        this.ukuran = ukuran;
    }

    // Setter untuk mengatur nilai harga pakaian menggunakan parameter.
    void setDataHarga(String harga) {
        this.harga = harga;
    }

    // Overloading: Setter untuk mengatur nilai harga dan ukuran pakaian menggunakan parameter.
    void setDataHarga(String harga, String ukuran) {
        this.harga = harga;
        this.ukuran = ukuran;
    }

    // Setter untuk mengatur nilai ukuran pakaian menggunakan parameter.
    void setDataUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    // Overloading: Setter untuk mengatur nilai ukuran dan jenis pakaian menggunakan parameter.
    void setDataUkuran(String ukuran, String jenis) {
        this.ukuran = ukuran;
        this.jenis = jenis;
    }

    // Getter tetap sama

    // Overriding: Getter untuk mendapatkan nilai jenis pakaian. (mengubah cara implementasi)
    String getCetakJenisPakaian() {
        return "Jenis : " + jenis;
    }
   int getJmlhPakaian() {
    return jmlhpakaian;
}
    // Overriding: Getter untuk mendapatkan nilai harga pakaian. (mengubah cara implementasi)
    String getCetakHargaPakaian() {
        return "Harga : " + harga;
    }

    // Overriding: Getter untuk mendapatkan nilai ukuran pakaian. (mengubah cara implementasi)
    String getCetakUkuranPakaian() {
        return "Ukuran : " + ukuran;
    }
public abstract int infopakaian();
}






