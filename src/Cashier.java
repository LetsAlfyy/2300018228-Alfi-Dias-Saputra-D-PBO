import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {
    private ArrayList<Item> items;

    // Konstruktor untuk menginisialisasi daftar item
    public Cashier() {
        items = new ArrayList<>();
    }

    // Menambahkan item ke daftar
    public void addItem(double price, String code, String name, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan."); //
    }

    // Menghapus item berdasarkan kode
    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) { // Mencari item berdasarkan kode
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    // Menampilkan total belanja dan daftar item
    public void displayTotal() {
        double total = 0.0;
        System.out.println("Daftar Item:"); // Judul daftar item
        System.out.printf("%-10s %-20s %-10s %-10s %-10s%n", "Kode", "Nama", "Harga", "Jumlah", "Subtotal"); // Header tabel
        for (Item item : items) {
            double subtotal = item.getPrice() * item.getStock(); // Menghitung subtotal
            System.out.printf("%-10s %-20s %-10.2f %-10d %-10.2f%n", item.getCode(), item.getName(), item.getPrice(), item.getStock(), subtotal); // Menampilkan detail item
            total += subtotal; // Menambahkan subtotal ke total
        }
        System.out.printf("Total belanja: %.2f%n", total); // Menampilkan total belanja
    }

    // Memproses pembayaran
    public void processPayment(Scanner scanner) {
        System.out.print("Masukkan jumlah yang dibayar: ");
        double payment = scanner.nextDouble();
        double total = calculateTotal();
        System.out.printf("Total bayar: %.2f%n", total); // Menampilkan total
        System.out.printf("Jumlah dibayar: %.2f%n", payment); // Menampilkan jumlah yang dibayar
        if (payment >= total) { // Memeriksa apakah pembayaran cukup
            double change = payment - total;
            System.out.printf("Kembali: %.2f%n", change);
        } else {
            System.out.println("Jumlah yang dibayar kurang dari total.");
        }
    }

    // Menghitung total belanja
    private double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getStock(); // Menambahkan subtotal setiap item ke total
        }
        return total;
    }
}