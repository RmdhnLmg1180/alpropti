import java.util.Scanner;

public class Siakad {

    static int jumlahData = 0;
    static mahasiswa[] Mahasiswa = new mahasiswa[1000];

    // menambhkan data
    public static void tambahData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Silahkan tambah data");
        System.out.print("Masukkan NIM = ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama = ");
        String nama = scan.nextLine();
        Mahasiswa[jumlahData] = new mahasiswa();
        Mahasiswa[jumlahData].setNim(nim);
        Mahasiswa[jumlahData].setNama(nama);
        jumlahData++;

        menu();
    }

    // menampilkan data
    public static void tampilData() {
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(Mahasiswa[i].getNim() + "  " + Mahasiswa[i].getNama());
            i++;
        }
        menu();
    }

    // Urutkan Data"
    public static void urutkandata() {
        Scanner scan1 = new Scanner(System.in);
        int menu1;
        while (true) {
            System.out.println("Urutkan Data");
            System.out.println("1. Exchange Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Bubble Sort");
            System.out.println("5. Shell Sort");
            System.out.println("6. Kembali");
            System.out.println("Pilih Menu =");
            menu1 = scan1.nextInt();
            switch (menu1) {
                case 1:
                    exchangeSort();
                case 2:
                    selectionsort();
                case 3:
                    quickSort(Mahasiswa, 0, jumlahData - 1);
                case 4:
                    bubblesort();
                case 5:
                    shellsort();
                case 6:
                    menu();
            }
        }
    }

    // Jenis Short
    // exchange sort
    public static void exchangeSort() {
        for (int x = 0; x < jumlahData; x++) {
            for (int y = x + 1; y < jumlahData; y++) {
                if (Mahasiswa[x].getNim().compareTo(Mahasiswa[y].getNim()) >= 1) {
                    mahasiswa temp = Mahasiswa[x];
                    Mahasiswa[x] = Mahasiswa[y];
                    Mahasiswa[y] = temp;
                }
            }
        }
        menu();
    }

    // selection sort
    public static void selectionsort() {
        for (int i = 0; i < jumlahData - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < jumlahData; j++)
                if (Mahasiswa[j].getNim().compareTo(Mahasiswa[minIndex].getNim()) <= 1)
                    minIndex = j;
            mahasiswa temp = Mahasiswa[minIndex];
            Mahasiswa[minIndex] = Mahasiswa[i];
            Mahasiswa[i] = temp;
        }
        menu();
    }

    // quick sort
    public static void quickSort(mahasiswa[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
        menu();
    }

    static int partition(mahasiswa[] arr, int low, int high) {
        int p = low, j;
        for (j = low + 1; j <= high; j++)
            if (arr[j].getNim().compareTo(arr[low].getNim()) <= -1)
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

    static void swap(mahasiswa[] arr, int low, int pivot) {
        mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    // bubble sort
    public static void bubblesort() {
        for (int i = 0; i < jumlahData - 1; i++)
            for (int j = 0; j < jumlahData - i - 1; j++)
                if (Mahasiswa[j].getNim().compareTo(Mahasiswa[j + 1].getNim()) >= 1) {
                    mahasiswa temp = Mahasiswa[j];
                    Mahasiswa[j] = Mahasiswa[j + 1];
                    Mahasiswa[j + 1] = temp;
                }
        menu();
    }

    // shell sort
    public static void shellsort() {
        int juml = jumlahData - 1;
        int gap = juml / 2;
        boolean swap = true;
        mahasiswa temp;
        while (gap > 0) {
            swap = true;
            while (swap == true) {
                swap = false;
                for (int i = 0; i <= (juml - gap); i++) {
                    int temp2 = Integer.parseInt(Mahasiswa[i].getNim());
                    int temp3 = Integer.parseInt(Mahasiswa[i + gap].getNim());
                    ;
                    if (temp2 > temp3) {
                        temp = Mahasiswa[i];
                        Mahasiswa[i] = Mahasiswa[i + gap];
                        Mahasiswa[i + gap] = temp;
                        swap = true;
                    }
                }
            }
            gap = gap / 2;

        }
        menu();
    }

    // Pencarian Data

    public static void caridata() {
        Scanner scan1 = new Scanner(System.in);
        while (true) {
            System.out.println("Urutkan Data");
            System.out.println("1. Linier Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Keluar");
            System.out.println("Pilih Menu =");
            int menu1 = scan1.nextInt();
            switch (menu1) {
                case 1:
                    liniersearch();
                case 2:
                    binarysearch();
                case 3:
                    menu();
            }
        }

    }

    // jenis pencarian data
    // linier search
    public static void liniersearch() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Nama/NIM = ");
        String xdata = scan.nextLine();
        for (int i = 0; i < jumlahData; i++) {
            String temp = Mahasiswa[i].getNama();
            String temp2 = Mahasiswa[i].getNim();
            if (xdata.equals(temp)) {
                System.out.println("Data Ditemukan!!");
                System.out.println(Mahasiswa[i].getNama() + "  " + Mahasiswa[i].getNim());
                System.out.println(" ");
            } else if (xdata.equals(temp2)) {
                System.out.println("Data Ditemukan!!");
                System.out.println(Mahasiswa[i].getNama() + "  " + Mahasiswa[i].getNim());
                System.out.println(" ");
            }
        }
        caridata();
    }

    // binary search
    public static void binarysearch() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan NIM mahasiswa yang ingin dicari: ");
        String nim = scan.nextLine();
        boolean found = false;
        int low = 0;
        int high = jumlahData - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = Mahasiswa[mid].getNim().compareTo(nim);
            if (comparison == 0) {
                System.out.println("Data ditemukan!!");
                System.out.println(Mahasiswa[mid].getNama() + "  " + Mahasiswa[mid].getNim());
                System.out.println(" ");
                return;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Data Tidak ditemukan.");
    }

    // edit data

    public static void editdata() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i < jumlahData) {
            System.out.print(i + 1 + ". ");
            System.out.println(Mahasiswa[i].getNama() + " " + Mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan No yang mau diubah= ");
        int xdata = scan.nextInt() - 1;
        System.out.print("Masukan Nama Baru = ");
        String nama = scan.next();
        System.out.print("Masukan NIM Baru = ");
        String nim = scan.next();

        Mahasiswa[xdata].setNama(nama);
        Mahasiswa[xdata].setNim(nim);

        menu();
    }

    // hapus data

    public static void hapusdata() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j;
        while (i < jumlahData) {
            System.out.print(i + 1 + ". ");
            System.out.println(Mahasiswa[i].getNama() + " " + Mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan nomer yang mau dihapus = ");
        int xdata = scan.nextInt() - 1;

        System.out.println("Nama : " + Mahasiswa[xdata].getNama());
        System.out.println("Nim : " + Mahasiswa[xdata].getNim());
        System.out.println("Yakin hapus? y/n");
        String pil = scan.next();
        if (pil.equalsIgnoreCase("y")) {
            Mahasiswa[xdata] = null;
            for (i = 0; i < jumlahData - 1; i++) {
                mahasiswa temp;
                if (Mahasiswa[i] == null) {
                    temp = Mahasiswa[i + 1];
                    Mahasiswa[i] = Mahasiswa[i + 1];
                    Mahasiswa[i + 1] = null;

                }
            }
            jumlahData = jumlahData - 1;

            System.out.println("Data Berhasil Dihapus!");
        } else {

        }
        menu();
    }

    // menu utama
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scan = new Scanner(System.in);
        int menu;
        while (true) {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Pencarian Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. UAS");
            System.out.println("8. Keluar");
            System.out.println("Pilih Menu = ");
            menu = scan.nextInt();
            switch (menu) {
                case 1:
                    tambahData();
                case 2:
                    tampilData();
                case 3:
                    urutkandata();
                case 4:
                    caridata();
                case 5:
                    editdata();
                case 6:
                    hapusdata();
                case 7:
                    uas();
                case 8:
                    System.exit(0);
            }
        }
    }

    // soal no 2 UAS
    public static void uas() {
        if (jumlahData == 0) {
            System.out.println("Tidak ada data");
            menu();
        } else { // O(1)
            int jarak = jumlahData - 1;
            int susut = 13;
            int urut = 0;
            while (urut == 0) {
                jarak = (jarak * 10) / susut;
                if (jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                    for (int i = 0; i + jarak < jumlahData; i++) {
                        int temp2 = Integer.parseInt(Mahasiswa[i].getNim());
                        int temp3 = Integer.parseInt(Mahasiswa[i + jarak].getNim());
                        if (temp2 > (temp3)) {
                            mahasiswa temp = Mahasiswa[i];
                            Mahasiswa[i] = Mahasiswa[i + jarak];
                            Mahasiswa[i + jarak] = temp;
                            urut = 0;
                        }
                    }
                }
            }
            System.out.println("Data telah diurutkan silahkan tampilkan data");
            menu();
        }
    }

}