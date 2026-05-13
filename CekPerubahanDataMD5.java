import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CekPerubahanDataMD5 {

    // Method untuk membuat hash MD5
    public static String buatMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // INPUT DATA AWAL
        System.out.println("===== INPUT DATA USER AWAL =====");

        System.out.print("Masukkan Nama  : ");
        String namaAwal = input.nextLine();

        System.out.print("Masukkan Email : ");
        String emailAwal = input.nextLine();

        System.out.print("Masukkan No HP : ");
        String hpAwal = input.nextLine();

        // Gabungkan data user
        String dataAwal = namaAwal + emailAwal + hpAwal;

        // Membuat hash MD5 awal
        String hashAwal = buatMD5(dataAwal);

        // Menampilkan hash awal
        System.out.println("\nHash MD5 Awal : ");
        System.out.println(hashAwal);

        // INPUT DATA BARU
        System.out.println("\n===== INPUT DATA USER BARU =====");

        System.out.print("Masukkan Nama Baru  : ");
        String namaBaru = input.nextLine();

        System.out.print("Masukkan Email Baru : ");
        String emailBaru = input.nextLine();

        System.out.print("Masukkan No HP Baru : ");
        String hpBaru = input.nextLine();

        // Gabungkan data baru
        String dataBaru = namaBaru + emailBaru + hpBaru;

        // Membuat hash MD5 baru
        String hashBaru = buatMD5(dataBaru);

        // PERBANDINGAN HASH
        System.out.println("\n===== HASIL PERBANDINGAN =====");

        System.out.println("Hash Lama : ");
        System.out.println(hashAwal);

        System.out.println("\nHash Baru : ");
        System.out.println(hashBaru);

        // Cek perubahan data
        if (hashAwal.equals(hashBaru)) {
            System.out.println("\nStatus : Data TIDAK berubah");
        } else {
            System.out.println("\nStatus : Data TELAH berubah / dimodifikasi");
        }

        input.close();
    }
}