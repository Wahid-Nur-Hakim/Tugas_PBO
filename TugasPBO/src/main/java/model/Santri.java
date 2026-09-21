package model;

public class Santri extends RumahQuran {

    private int umur;
    private KelasMengaji kelasMengaji;

    public Santri(
            String nama,
            int umur,
            String noTelpWali,
            KelasMengaji kelasMengaji
    ) {
        super(nama, noTelpWali);
        setUmur(umur);
        setKelasMengaji(kelasMengaji);
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if (umur < 5 || umur > 17) {
            throw new IllegalArgumentException(
                    "Umur santri harus antara 5 sampai 17 tahun"
            );
        }

        this.umur = umur;
    }

    public KelasMengaji getKelasMengaji() {
        return kelasMengaji;
    }

    public void setKelasMengaji(KelasMengaji kelasMengaji) {
        if (kelasMengaji == null) {
            throw new IllegalArgumentException(
                    "Kelas mengaji tidak boleh kosong"
            );
        }

        this.kelasMengaji = kelasMengaji;
    }

    @Override
    public String getJenisPengguna() {
        return "Santri";
    }

    public static String getHeader() {
        return String.format(
                "%-4s | %-20s | %-5s | %-15s | %-6s",
                "No.",
                "Nama",
                "Umur",
                "No. Telp Wali",
                "Kode Kelas"
        );
    }

    @Override
    public String toString() {
        return String.format(
                "%-20s | %-5d | %-15s | %-6d",
                getNama(),
                umur,
                getNomorTelepon(),
                kelasMengaji.getKodeKelas()
        );
    }
}