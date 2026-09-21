package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.KelasMengaji;
import model.Santri;
import model.Pengajar;
import view.Menu;

public class CrudUmmi {
    private final ArrayList<Santri> daftarSantri;
    private final ArrayList<KelasMengaji> daftarKelas;
    private final ArrayList<Pengajar> daftarPengajar;
    private final Menu menu;
    private final Scanner scanner;

    public CrudUmmi(Scanner scanner, Menu menu) {
        this.daftarSantri = new ArrayList<>();
        this.daftarKelas = new ArrayList<>();
        this.daftarPengajar = new ArrayList<>();
        this.menu = menu;
        this.scanner = scanner;

        daftarKelas.add(new KelasMengaji(1, "UMMI 1", "Ibu Ana", 30));
        daftarKelas.add(new KelasMengaji(2, "UMMI 2", "Ibu Fatimah", 30));
        daftarKelas.add(new KelasMengaji(3, "UMMI 3", "Ibu Hajrah", 30));
        daftarKelas.add(new KelasMengaji(4, "UMMI 4", "Ibu Alya", 30));
        daftarKelas.add(new KelasMengaji(5, "UMMI 5", "Ibu Khansa", 30));
        daftarKelas.add(new KelasMengaji(6, "UMMI 6", "Ibu Gita", 30));
        
        KelasMengaji kelasUmmi1 = daftarKelas.get(0);
        KelasMengaji kelasUmmi2 = daftarKelas.get(1);
        KelasMengaji kelasUmmi3 = daftarKelas.get(2);
        KelasMengaji kelasUmmi4 = daftarKelas.get(3);
        KelasMengaji kelasUmmi5 = daftarKelas.get(4);
        KelasMengaji kelasUmmi6 = daftarKelas.get(5);

        daftarSantri.add(new Santri("Ahmad Fauzan",10,"081234567890",kelasUmmi1));
        daftarSantri.add(new Santri("Aisyah Putri",8,"081298765432",kelasUmmi1));
        daftarSantri.add(new Santri("Muhammad Rizky",12,"082112223333",kelasUmmi2));
        daftarSantri.add(new Santri("Siti Khadijah",9,"082233445566",kelasUmmi2));
        daftarSantri.add(new Santri("Abdullah Faqih",11,"083344556677",kelasUmmi3));
        daftarSantri.add(new Santri("Fatimah Zahra",7,"083455667788",kelasUmmi3));
        daftarSantri.add(new Santri("Ali Imran",13,"084566778899",kelasUmmi4));
        daftarSantri.add(new Santri("Maryam Aulia",10,"084677889900",kelasUmmi4));
        daftarSantri.add(new Santri("Hasan Basri",14,"085788990011",kelasUmmi5));
        daftarSantri.add(new Santri("Hana Safitri",8,"085899001122",kelasUmmi5));
        daftarSantri.add(new Santri("Yusuf Maulana",15,"086900112233",kelasUmmi6));
        daftarSantri.add(new Santri("Khadijah Nabila",11,"086011223344",kelasUmmi6));
        
        daftarPengajar.add(new Pengajar("Ibu Ana","081111111111","UMMI 1"));
        daftarPengajar.add(new Pengajar("Ibu Fatimah","081222222222","UMMI 2"));
        daftarPengajar.add(new Pengajar("Ibu Hajrah","081333333333","UMMI 3"));
        daftarPengajar.add(new Pengajar("Ibu Alya","081444444444","UMMI 4"));
        daftarPengajar.add(new Pengajar("Ibu Khansa","081555555555","UMMI 5"));
        daftarPengajar.add(new Pengajar("Ibu Gita","081666666666","UMMI 6"));
    }

    public void kelolaSantri() {
        boolean kembali = false;
        while (!kembali) {
            menu.tampilkanMenuSantri();

            int pilihan = menu.bacaPilihan("Pilih Menu: ");

            switch (pilihan) {
                case 1 -> tambahSantri();
                case 2 -> tampilkanSantri();
                case 3 -> hapusSantri();
                case 4 -> updateKelasSantri();
                case 5 -> kembali = true;
                default -> System.out.println("Pilihan tidak valid!!!!!!!!!!!");
            }
        }
    }

    public void kelolaKelasMengaji() {
        boolean kembali = false;
        while (!kembali) {
            menu.tampilkanMenuKelasMengaji();

            int pilihan = menu.bacaPilihan("Pilih Menu: ");

            switch (pilihan) {
                case 1 -> tambahKelasMengaji();
                case 2 -> tampilkanKelasMengaji();
                case 3 -> updateKelasMengaji();
                case 4 -> hapusKelasMengaji();
                case 5 -> kembali = true;
                default -> System.out.println("Pilihan tidak valid!!!");
            }
        }
    }
    
    public void kelolaPengajar() {
        boolean kembali = false;

        while (!kembali) {
            menu.tampilkanMenuPengajar();

            int pilihan = menu.bacaPilihan(
                    "Pilih menu: "
            );

            switch (pilihan) {
                case 1 -> tambahPengajar();
                case 2 -> tampilkanPengajar();
                case 3 -> updatePengajar();
                case 4 -> hapusPengajar();
                case 5 -> kembali = true;
                default -> menu.tampilkanPesan(
                        "Pilihan tidak valid!"
                );
            }
        }
    }

    private void tambahSantri() {
        String nama;
        int umur;
        String noTelpWali;

        while (true) {
            System.out.print("\nNama Santri: ");
            nama = scanner.nextLine().trim();

            if (!nama.isBlank()) {
                break;
            }

            System.out.println("Nama tidak boleh kosong yaaa!!");
        }

        while (true) {
            System.out.print("Umur (5-17 tahun): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Umur harus berupa angka");
                scanner.nextLine();
                continue;
            }

            umur = scanner.nextInt();
            scanner.nextLine();

            if (umur >= 5 && umur <= 17) {
                break;
            }

            System.out.println("Umur santri diisi antara 5 sampai 17 tahun");
        }

        while (true) {
            System.out.print("No. Telepon Wali: ");
            noTelpWali = scanner.nextLine().trim();

            if (noTelpWali.matches("\\d{10,15}")) {
                break;
            }

            System.out.println(
                    "Nomor telepon harus berupa angka sebanyak 10-15 digit"
            );
        }

        while (true) {
            tampilkanKelasMengaji();
            System.out.print("Pilih kode kelas: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Kode kelas harus berupa angka");
                scanner.nextLine();
                continue;
            }

            int pilihanKelas = scanner.nextInt();
            scanner.nextLine();

            KelasMengaji kelasDipilih =
                    cariKelasBerdasarkanKode(pilihanKelas);

            if (kelasDipilih == null) {
                System.out.println("Kode kelas tidak ditemukan");
                continue;
            }

            if (jumlahSantriDalamKelas(kelasDipilih)
                    >= kelasDipilih.getKapasitas()) {
                System.out.println("Kelas tersebut sudah penuh");
                continue;
            }

            daftarSantri.add(
                    new Santri(nama, umur, noTelpWali, kelasDipilih)
            );

            System.out.println("Data santri berhasil ditambahkan");
            break;
        }
    }

        private void tampilkanSantri() {
            if (daftarSantri.isEmpty()) {
                System.out.println("\nBelum ada data santri.");
                return;
            }
            System.out.println("\n=== Data Santri RQ Al-Hafizh ===");
            System.out.println(Santri.getHeader());
            System.out.println("-----------------------------------------------------------------------");
            for (int i = 0; i < daftarSantri.size(); i++) {
                System.out.printf("%-4d | %s%n", i + 1, daftarSantri.get(i));
            }
        }

        private void hapusSantri() {
            if (daftarSantri.isEmpty()) {
                System.out.println("\nBelum ada data santri");
                return;
            }
            tampilkanSantri();

            int nomor;
            while (true) {
                System.out.print("Masukkan nomor santri yang akan dihapus: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Input harus berupa angka");
                    scanner.nextLine();
                    continue;
                }
                nomor = scanner.nextInt();
                scanner.nextLine();
                if (nomor >= 1 && nomor <= daftarSantri.size()) {
                    break;
                }
                System.out.println("Nomor santri tidak valid");
            }

            daftarSantri.remove(nomor - 1);
            System.out.println("Data santri berhasil dihapus");
        }

        private void updateKelasSantri() {
            if (daftarSantri.isEmpty()) {
                System.out.println("\nBelum ada data santri");
                return;
            }

            tampilkanSantri();

            int nomorSantri;

            while (true) {
                System.out.print("Masukkan nomor santri: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Input harus berupa angka");
                    scanner.nextLine();
                    continue;
                }

                nomorSantri = scanner.nextInt();
                scanner.nextLine();

                if (nomorSantri >= 1 && nomorSantri <= daftarSantri.size()) {
                    break;
                }

                System.out.println("Nomor santri tidak valid");
            }

            int kodeKelas;

            while (true) {
                tampilkanKelasMengaji();
                System.out.print("Pilih kode kelas baru: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Input harus berupa angka");
                    scanner.nextLine();
                    continue;
                }

                kodeKelas = scanner.nextInt();
                scanner.nextLine();

                KelasMengaji kelasBaru =
                        cariKelasBerdasarkanKode(kodeKelas);

                if (kelasBaru == null) {
                    System.out.println("Kode kelas tidak ditemukan");
                    continue;
                }

                Santri santriDipilih = daftarSantri.get(nomorSantri - 1);
                KelasMengaji kelasLama = santriDipilih.getKelasMengaji();

                if (kelasLama.getKodeKelas() 
                        == kelasBaru.getKodeKelas()) {
                    System.out.println("Santri sudah berada di kelas tersebut");
                    return;
                }

                if (jumlahSantriDalamKelas(kelasBaru)
                        >= kelasBaru.getKapasitas()) {
                    System.out.println("Kelas baru tersebut sudah penuh");
                    continue;
                }

                santriDipilih.setKelasMengaji(kelasBaru);
                System.out.println("Kelas santri berhasil diupdate");
                break;
            }
        }

        private void tambahKelasMengaji() {
            String namaKelas;
            String pengajar;
            int kapasitas;

            while (true) {
                System.out.print("\nNama Kelas Mengaji: ");
                namaKelas = scanner.nextLine().trim();
                if (!namaKelas.isEmpty()) {
                    break;
                }
                System.out.println("Nama kelas tidak boleh kosong");
            }

            while (true) {
                System.out.print("Nama Pengajar: ");
                pengajar = scanner.nextLine().trim();
                if (!pengajar.isEmpty()) {
                    break;
                }
                System.out.println("Nama pengajar tidak boleh kosong");
            }

            while (true) {
                System.out.print("Kapasitas (1-30): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Kapasitas harus angka");
                    scanner.nextLine();
                    continue;
                }
                kapasitas = scanner.nextInt();
                scanner.nextLine();
                if (kapasitas >= 1 && kapasitas <= 30) {
                    break;
                }
                System.out.println("Kapasitas kelas antara 1 sampai 30");
            }

            int kodeBaru = generateKodeKelas();
            daftarKelas.add(new KelasMengaji(kodeBaru, namaKelas, pengajar, kapasitas));
            System.out.println("Kelas mengaji berhasil ditambahkan");
        }
        
        private int generateKodeKelas() {
            int kodeTerbesar = 0;

            for (KelasMengaji kelas : daftarKelas) {
                if (kelas.getKodeKelas() > kodeTerbesar) {
                    kodeTerbesar = kelas.getKodeKelas();
                }
            }

            return kodeTerbesar + 1;
        }

        private KelasMengaji cariKelasBerdasarkanKode(int kode) {
            for (KelasMengaji kelas : daftarKelas) {
                if (kelas.getKodeKelas() == kode) {
                    return kelas;
                }
            }
            return null;
        }

        private int jumlahSantriDalamKelas(KelasMengaji kelas) {
            int jumlah = 0;

            for (Santri santri : daftarSantri) {
                if (santri.getKelasMengaji().getKodeKelas() 
                        == kelas.getKodeKelas()) {
                    jumlah++;
                }
            }

            return jumlah;
        }

    private void tampilkanKelasMengaji() {
        if (daftarKelas.isEmpty()) {
            System.out.println("\nBelum ada data kelas mengaji");
            return;
        }
        System.out.println("\n=== Data Kelas Mengaji RQ Al-Hafizh ===");
        System.out.println(KelasMengaji.getHeader());
        System.out.println("--------------------------------------------------------------");
        for (KelasMengaji kelas : daftarKelas) {
            System.out.println(kelas);
        }
    }

    private void updateKelasMengaji() {
        if (daftarKelas.isEmpty()) {
            System.out.println("\nBelum ada data kelas");
            return;
        }

        tampilkanKelasMengaji();

        int kodeKelas;

        while (true) {
            System.out.print("Masukkan kode kelas yang akan diupdate: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka");
                scanner.nextLine();
                continue;
            }

            kodeKelas = scanner.nextInt();
            scanner.nextLine();

            KelasMengaji kelasDipilih =
                    cariKelasBerdasarkanKode(kodeKelas);

            if (kelasDipilih == null) {
                System.out.println("Kode kelas tidak ditemukan");
                continue;
            }

            String namaKelas;
            String pengajar;
            int kapasitas;

            while (true) {
                System.out.print("Nama Kelas Baru: ");
                namaKelas = scanner.nextLine().trim();

                if (!namaKelas.isEmpty()) {
                    break;
                }

                System.out.println("Nama kelas tidak boleh kosong");
            }

            while (true) {
                System.out.print("Nama Pengajar Baru: ");
                pengajar = scanner.nextLine().trim();

                if (!pengajar.isEmpty()) {
                    break;
                }

                System.out.println("Nama pengajar tidak boleh kosong");
            }

            while (true) {
                System.out.print("Kapasitas Baru (1-30): ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Kapasitas harus angka");
                    scanner.nextLine();
                    continue;
                }

                kapasitas = scanner.nextInt();
                scanner.nextLine();

                if (kapasitas < 1 || kapasitas > 30) {
                    System.out.println("Kapasitas kelas antara 1 sampai 30");
                    continue;
                }

                if (kapasitas < jumlahSantriDalamKelas(kelasDipilih)) {
                    System.out.println(
                            "Kapasitas tidak boleh lebih kecil dari jumlah santri saat ini"
                    );
                    continue;
                }

                break;
            }

            kelasDipilih.setNamaKelas(namaKelas);
            kelasDipilih.setPengajar(pengajar);
            kelasDipilih.setKapasitas(kapasitas);

            System.out.println("Data kelas mengaji berhasil diupdate");
            break;
        }
    }
    
    private void hapusKelasMengaji() {
        if (daftarKelas.isEmpty()) {
            System.out.println("\nBelum ada data kelas");
            return;
        }

        tampilkanKelasMengaji();

        int kodeKelas;

        while (true) {
            System.out.print("Masukkan kode kelas yang akan dihapus: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka");
                scanner.nextLine();
                continue;
            }

            kodeKelas = scanner.nextInt();
            scanner.nextLine();

            KelasMengaji kelasDipilih =
                    cariKelasBerdasarkanKode(kodeKelas);

            if (kelasDipilih == null) {
                System.out.println("Kode kelas tidak ditemukan");
                continue;
            }

            if (jumlahSantriDalamKelas(kelasDipilih) > 0) {
                System.out.println(
                        "Kelas tidak dapat dihapus karena masih memiliki santri"
                );
                return;
            }

            daftarKelas.remove(kelasDipilih);
            System.out.println("Kelas mengaji berhasil dihapus");
            return;
        }
    }
    
    private void tambahPengajar() {
        String nama;
        String nomorTelepon;
        String spesialisasi;

        while (true) {
            nama = menu.bacaTeks("Nama Pengajar: ");

            if (!nama.isBlank()) {
                break;
            }
            menu.tampilkanPesan("Nama pengajar tidak boleh kosong");
        }

        while (true) {
            nomorTelepon = menu.bacaTeks("Nomor Telepon: ");

            if (nomorTelepon.matches("\\d{10,15}")) {
                break;
            }

            menu.tampilkanPesan("Nomor telepon harus 10-15 digit angka");
        }

        while (true) {
            spesialisasi = menu.bacaTeks("Spesialisasi: ");

            if (!spesialisasi.isBlank()) {
                break;
            }

            menu.tampilkanPesan("Spesialisasi tidak boleh kosong");
        }

        daftarPengajar.add(new Pengajar(
                nama,
                nomorTelepon,
                spesialisasi
        ));

        menu.tampilkanPesan("Data pengajar berhasil ditambahkan");
    }
    
    private void tampilkanPengajar() {
        if (daftarPengajar.isEmpty()) {
            menu.tampilkanPesan("Belum ada data pengajar");
            return;
        }

        System.out.println("\n=== Data Pengajar RQ Al-Hafizh ===");
        System.out.println(Pengajar.getHeader());
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < daftarPengajar.size(); i++) {
            System.out.printf("%-4d | %s%n",i + 1,daftarPengajar.get(i));
        }
    }
    
    private void updatePengajar() {
        if (daftarPengajar.isEmpty()) {
            menu.tampilkanPesan("Belum ada data pengajar");
            return;
        }

        tampilkanPengajar();

        int nomor;

        while (true) {
            nomor = menu.bacaPilihan("Masukkan nomor pengajar yang akan diupdate: ");

            if (nomor >= 1 && nomor <= daftarPengajar.size()) {
                break;
            }

            menu.tampilkanPesan("Nomor pengajar tidak valid");
        }

        String spesialisasiBaru;

        while (true) {
            spesialisasiBaru = menu.bacaTeks("Masukkan spesialisasi baru: ");

            if (!spesialisasiBaru.isBlank()) {
                break;
            }

            menu.tampilkanPesan("Spesialisasi tidak boleh kosong");
        }

        Pengajar pengajarDipilih =
                daftarPengajar.get(nomor - 1);

        pengajarDipilih.setSpesialisasi(spesialisasiBaru);

        menu.tampilkanPesan("Spesialisasi pengajar berhasil diupdate");
    }
    
    private void hapusPengajar() {
        if (daftarPengajar.isEmpty()) {
            menu.tampilkanPesan("Belum ada data pengajar");
            return;
        }

        tampilkanPengajar();

        int nomor;

        while (true) {
            nomor = menu.bacaPilihan("Masukkan nomor pengajar yang akan dihapus: ");

            if (nomor >= 1 && nomor <= daftarPengajar.size()) {
                break;
            }

            menu.tampilkanPesan("Nomor pengajar tidak valid");
        }

        daftarPengajar.remove(nomor - 1);

        menu.tampilkanPesan("Data pengajar berhasil dihapus");
    }
}