# Tugas_PBO

## Penjelasan studi kasus yang dipilih

Studi kasus yang digunakan adalah aplikasi pengelolaan data Rumah Qur'an Al-Hafizh. Aplikasi ini digunakan untuk mengelola data santri, kelas mengaji, dan pengajar.

Pada data santri, aplikasi menyimpan nama, umur, nomor telepon wali, serta kelas mengaji yang diikuti. Data kelas mengaji terdiri dari kode kelas, nama kelas, pengajar, dan kapasitas. Data pengajar terdiri dari nama, nomor telepon, dan spesialisasi.

Aplikasi menggunakan konsep CRUD, yaitu tambah, lihat, update, dan hapus data. Aplikasi juga menerapkan validasi input, seperti batas umur santri 5 sampai 17 tahun, nomor telepon 10 sampai 15 digit, serta kapasitas kelas 1 sampai 30 orang.

## Hierarki Class

                 RumahQuran
                 /        \
                /          \
           Santri        Pengajar
              |
              |
        KelasMengaji

Penjelasannya: 

    RumahQuran
    ├── nama
    ├── nomorTelepon
    └── getJenisPengguna()
    
           ▲
           │ extends
           │
     ┌─────┴─────┐
     │           │
    Santri     Pengajar
     │           │
     │           └── spesialisasi
     │
     └── umur
     └── kelasMengaji

Class RumahQuran menjadi parent class atau superclass. Class Santri dan Pengajar menjadi child class atau subclass yang mewarisi sifat dari RumahQuran.

Class KelasMengaji tidak mewarisi RumahQuran. Class ini digunakan sebagai objek yang berhubungan dengan Santri untuk menentukan kelas mengaji yang diikuti.


## Penjelasan kode yang menerapkan inheritance

### Parent class (Rumah Quran)
<img width="549" height="166" alt="image" src="https://github.com/user-attachments/assets/9e9e6f9c-af7f-41b4-ab25-43de06bebaf7" />

Class RumahQuran berperan sebagai parent class. Class ini menyimpan atribut umum yang dimiliki oleh turunannya, yaitu nama dan nomor telepon. Method getJenisPengguna() dibuat abstract agar setiap class turunan dapat menentukan jenis penggunanya masing-masing.

### Child class (Santri)
<img width="779" height="213" alt="image" src="https://github.com/user-attachments/assets/e82d81ae-56a4-40f3-85f3-893da5f48aa1" />

Class Santri merupakan child class dari RumahQuran karena menggunakan extends RumahQuran. Santri mewarisi atribut dan method dari RumahQuran. Keyword super() digunakan untuk memanggil constructor parent class. Method getJenisPengguna() kemudian dioverride untuk mengembalikan jenis pengguna sebagai "Santri".

### Child class (Pengajar)
<img width="679" height="167" alt="image" src="https://github.com/user-attachments/assets/e1e82351-f03c-4f88-b235-0f77a1dc177f" />

Class Pengajar juga merupakan child class dari RumahQuran karena menggunakan extends RumahQuran. Pengajar mewarisi data dan method dasar dari RumahQuran, kemudian memiliki atribut tambahan berupa spesialisasi. Keyword super() digunakan untuk memanggil constructor parent class. Method getJenisPengguna() dioverride untuk mengembalikan jenis pengguna sebagai "Pengajar".

## Penjelasan Program

