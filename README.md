# Kalkulator Premium RMBL

Proyek Android WebView offline untuk **Kalkulator Premium RMBL**.

- Tema gelap dengan aksen ungu dan hijau neon
- Operasi tambah, kurang, kali, bagi, persen, ubah tanda, hapus, dan reset
- Kalkulator HTML lokal, tidak membutuhkan internet saat digunakan
- Gambar kalkulator RMBL yang disediakan pengguna dipakai di halaman aplikasi dan ikon launcher

## Build APK lewat GitHub Actions

1. Unggah seluruh isi ZIP ini ke root repositori GitHub (bukan folder luar).
2. Buka tab **Actions** dan aktifkan workflow jika GitHub memintanya.
3. Pilih **Android Build** → **Run workflow**.
4. Setelah selesai, buka run yang berhasil dan unduh artifact **app-debug**.
5. Ekstrak ZIP artifact dan instal `app-debug.apk` di Android.

Build memakai JDK 17 dan Gradle 8.9 melalui GitHub Actions. File APK belum dibangun di sini; GitHub Actions yang akan mengompilasinya.
