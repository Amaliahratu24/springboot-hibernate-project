# 🛠️ Sistem Pelaporan Tiket IT (Helpdesk) Berbasis Web

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap_5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)

> **Project Ujian Akhir Semester (UAS)** > **Mata Kuliah:** Peminatan Software Engineer 2025  
> **Dosen Pengampu:** Rizal Broer Bahaweres, M.Kom.

---

## 📖 Tentang Project

Aplikasi ini adalah **Sistem Informasi Helpdesk / Ticketing** yang dirancang untuk menangani pelaporan masalah IT dalam sebuah organisasi. Sistem ini dibangun menggunakan arsitektur **Monolith** dengan **Spring Boot** sebagai backend dan **HTML/Bootstrap** sebagai frontend.

Keunggulan utama sistem ini adalah penerapan konsep **BPM (Business Process Management) Lifecycle** dalam penanganan tiket, yang memastikan setiap laporan melalui tahapan status yang jelas dan terstruktur.

### 🔄 Alur Kerja Sistem (BPM Lifecycle)
1.  🔴 **OPEN**: Tiket baru dibuat oleh User (Pelapor).
2.  🟡 **IN PROGRESS**: Tiket divalidasi dan sedang dikerjakan oleh Admin (Teknisi).
3.  🟢 **CLOSED**: Tiket telah selesai diperbaiki dan ditutup dengan dokumentasi solusi.

---

## ✨ Fitur Utama

### 👤 User (Pelapor)
* **Registrasi & Login:** Sistem autentikasi aman dengan pemisahan hak akses.
* **Dashboard Modern:** Antarmuka responsif dengan desain *Purple Gradient*.
* **Buat Tiket (Create):** Form pelaporan masalah IT (Judul & Deskripsi).
* **Monitoring:** Melihat status dan riwayat tiket milik sendiri (*My Tickets*).

### 👮 Admin (Teknisi)
* **Dashboard Admin:** Akses penuh untuk melihat **SEMUA** tiket dari seluruh user.
* **Manajemen Status:** Mengubah status tiket dari `OPEN` ke `IN_PROGRESS`.
* **Penyelesaian Masalah:** Menutup tiket (`CLOSED`) dan wajib memberikan **Solusi** perbaikan.
* **Indikator Visual:** Badge status berwarna (Merah/Kuning/Hijau) untuk memudahkan monitoring.

---

## 💻 Teknologi yang Digunakan

* **Bahasa Pemrograman:** Java (JDK 17/21)
* **Framework Backend:** Spring Boot 3.x
* **Database & ORM:** MySQL & Hibernate (Spring Data JPA)
* **Frontend:** HTML5, CSS3, Bootstrap 5, JavaScript (Fetch API)
* **Tools:** Maven, Spring Tool Suite (STS) / VS Code, Postman

---

## ⚙️ Cara Menjalankan Project (Installation)

Ikuti langkah-langkah berikut untuk menjalankan project ini di komputer lokal (Localhost):

### 1. Persiapan Database
Pastikan **XAMPP** sudah menyala (Modul Apache & MySQL). Buat database baru di phpMyAdmin:

```sql
CREATE DATABASE springboot_auth;
2. Konfigurasi DatabaseBuka file src/main/resources/application.properties dan sesuaikan konfigurasi berikut:Propertiesspring.datasource.url=jdbc:mysql://localhost:3306/springboot_auth
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
3. Jalankan AplikasiBuka terminal di folder project, lalu ketik perintah berikut:Bashmvn spring-boot:run
Atau jika menggunakan IDE (STS/Eclipse/IntelliJ): Klik kanan project -> Run As -> Spring Boot App.4. Akses AplikasiBuka browser dan kunjungi alamat:http://localhost:8080🧪 Akun Demo (Testing)Gunakan akun berikut untuk simulasi peran User dan Admin:RoleUsernamePasswordDeskripsi Hak AksesAdminadminpasswordBisa melihat semua tiket, mengubah status, dan input solusi.Useruser1123Hanya bisa melapor dan melihat status tiket sendiri.Catatan: Jika akun belum ada di database, silakan lakukan registrasi manual melalui menu Register. Gunakan username admin untuk mendapatkan akses administrator (hardcoded logic).👥 Tim PenyusunProject ini disusun oleh Kelompok 3 - Program Studi Teknik Informatika, Fakultas Sains dan Teknologi, UIN Syarif Hidayatullah Jakarta:👩‍💻 Ratu Amaliah (11230910000026)👩‍💻 Syifa Auliyah Kusumawardani (11230910000114)👩‍💻 Diniah Nurrohmah (1121091000098)Copyright © 2025 - Fakultas Sains dan Teknologi UIN Jakarta
