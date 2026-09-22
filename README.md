# Tugas_PBO

## Nama  : Wahid Nur Hakim
## NIM   : 2509116016
## Kelas : Sistem Informasi A'25 

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

## Penjelasan alur program
<img width="400" height="153" alt="image" src="https://github.com/user-attachments/assets/ef29d39b-14d0-40d7-b799-a2d302dd497b" />

Gambar tersebut merupakan teampilan utama. Sistem dapat mengelola data pada data santri, pengajar, dan kelas mengaji

<img width="230" height="152" alt="image" src="https://github.com/user-attachments/assets/3bb16602-f4f2-4704-b07d-81ee0b7df6db" />

Setelah kita memilih data yang ingin dikelola, kita akan memilih data tersebut ingin dilakukan apa

<img width="569" height="361" alt="image" src="https://github.com/user-attachments/assets/ccbcb824-22a6-46f1-a9f4-362827de5c51" />

Di sini ambil contoh untuk menu 1 tambah data pada data santri yang dimana sistem akan menyuruh untuk input nama, umur santri, no telepon wali, dan kode kelas (untuk menentukan kelas)

<img width="648" height="386" alt="image" src="https://github.com/user-attachments/assets/bb31a169-986a-445b-ba55-3ffd25799ca1" />

Untuk menu 2 lihat data pada data santri, sistem akan menampilkan data santri yang tersimpan pada ArrayList

<img width="608" height="430" alt="image" src="https://github.com/user-attachments/assets/04903ed2-8a04-46bd-ba0a-b32c288f4861" />

Untuk menu 3 hapus data pada data santri sistem akan menampilkan semua data yang ada, kemudian input nomor santri yang ingin dihapus

<img width="610" height="644" alt="image" src="https://github.com/user-attachments/assets/0c004ce9-9d74-4289-9f35-62dc8a97ab79" />

Untuk menu 4 update data pada data santri sistem akan menampilkan semua data santri pada ArrayList, input nomor santri yang ingin diupdate dan input kode kelas. Jadi, untuk menu update pada data santri hanya melakukan update kode kelas saja.

<img width="399" height="170" alt="image" src="https://github.com/user-attachments/assets/9a9748a2-da86-498b-ae6b-f0c6e5b8fde0" />

Untuk menu 5 yaitu akan mengembalikan ke tampilan utama

<img width="403" height="176" alt="image" src="https://github.com/user-attachments/assets/405d211e-5a88-435e-aff7-abd72766f0d2" />

Untuk keluar dari program, pada tampilan utama input angka 4 dan sistem pun selesai dijalankan.

