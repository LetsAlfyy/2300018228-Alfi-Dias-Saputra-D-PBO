import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cashier cashier = new Cashier(); // Membuat objek Cashier untuk mengelola transaksi
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari pengguna

        while (true) {
            // Menampilkan menu opsi kepada pengguna
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Tampilkan Total");
            System.out.println("4. Proses Pembayaran");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: "); // Meminta pengguna memilih opsi

            int choice = scanner.nextInt(); // Membaca input pilihan dari pengguna

            switch (choice) {
                case 1: // Opsi untuk menambahkan barang
                    System.out.print("Masukkan kode barang: ");
                    String addCode = scanner.next();
                    System.out.print("Masukkan nama barang: ");
                    String addName = scanner.next();
                    System.out.print("Masukkan harga barang: ");
                    double addPrice = scanner.nextDouble();
                    System.out.print("Masukkan jumlah barang: ");
                    int addQuantity = scanner.nextInt();
                    cashier.addItem(addPrice, addCode, addName, addQuantity);
                    break;
                case 2: // Opsi untuk menghapus barang
                    System.out.print("Masukkan kode barang yang akan dihapus: ");
                    String removeCode = scanner.next();
                    cashier.removeItem(removeCode);
                    break;
                case 3: // Opsi untuk menampilkan total
                    cashier.displayTotal();
                    break;
                case 4: // Opsi untuk memproses pembayaran
                    cashier.processPayment(scanner);
                    break;
                case 5: // Opsi untuk keluar
                    System.out.println("Terima kasih telah menggunakan sistem kasir kami!");
                    return; // Keluar dari program
                default: // Opsi tidak valid
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}
