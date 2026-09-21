package model;

public class KelasMengaji {
    private final int kodeKelas;
    private String namaKelas;
    private String pengajar;
    private int kapasitas;

    public KelasMengaji(
            int kodeKelas,
            String namaKelas,
            String pengajar,
            int kapasitas
    ) {
        if (kodeKelas <= 0) {
            throw new IllegalArgumentException(
                    "Kode kelas harus lebih besar dari 0"
            );
        }

        this.kodeKelas = kodeKelas;
        setNamaKelas(namaKelas);
        setPengajar(pengajar);
        setKapasitas(kapasitas);
    }

    public int getKodeKelas() {
        return kodeKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public String getPengajar() {
        return pengajar;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setNamaKelas(String namaKelas) {
        if (namaKelas == null || namaKelas.isBlank()) {
            throw new IllegalArgumentException(
                    "Nama kelas tidak boleh kosong"
            );
        }

        this.namaKelas = namaKelas.trim();
    }

    public void setPengajar(String pengajar) {
        if (pengajar == null || pengajar.isBlank()) {
            throw new IllegalArgumentException(
                    "Nama pengajar tidak boleh kosong"
            );
        }

        this.pengajar = pengajar.trim();
    }

    public void setKapasitas(int kapasitas) {
        if (kapasitas < 1 || kapasitas > 30) {
            throw new IllegalArgumentException(
                    "Kapasitas harus antara 1 sampai 30"
            );
        }

        this.kapasitas = kapasitas;
    }

    public static String getHeader() {
        return String.format(
                "%-6s | %-20s | %-15s | %-9s",
                "Kode",
                "Nama Kelas",
                "Pengajar",
                "Kapasitas"
        );
    }

    @Override
    public String toString() {
        return String.format(
                "%-6d | %-20s | %-15s | %-9d",
                kodeKelas,
                namaKelas,
                pengajar,
                kapasitas
        );
    }
}