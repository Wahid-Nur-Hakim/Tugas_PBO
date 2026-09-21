package model;

public class Pengajar extends RumahQuran {

    private String spesialisasi;

    public Pengajar(String nama,String nomorTelepon,String spesialisasi) {
        super(nama, nomorTelepon);
        setSpesialisasi(spesialisasi);
    }
    
    public static String getHeader(){
        return String.format(
            "%-4s | %-20s | %-15s | %-20s",
            "No", "Nama", "No. Telepon", "Spesialisasi");
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        if (spesialisasi == null || spesialisasi.isBlank()) {
            throw new IllegalArgumentException(
                    "Spesialisasi tidak boleh kosong"
            );
        }

        this.spesialisasi = spesialisasi.trim();
    }

    @Override
    public String getJenisPengguna() {
        return "Pengajar";
    }

    @Override
    public String toString() {
        return String.format(
                "Nama: %s | No. Telepon: %s | Spesialisasi: %s",
                getNama(),
                getNomorTelepon(),
                spesialisasi
        );
    }
}