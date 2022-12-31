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
    }

    // menampilkan data
    public static void tampilData() {
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(Mahasiswa[i].getNim() + "  " + Mahasiswa[i].getNama());
            i++;
        }
    }

    // Urutkan Data"
    public static void urutkandata() {
        Scanner scan1 = new Scanner(System.in);
        int menu1;
        do {
            System.out.println("Urutkan Data");
            System.out.println("1. Exchange Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Bubble Sort");
            System.out.println("5. Shell Sort");
            System.out.println("6. Kembali");
            System.out.println("Pilih Menu =");
            menu1 = scan1.nextInt();
            if (menu1 == 1) {
                exchangeSort();
            } else if (menu1 == 2) {
                selectionsort();
            } else if (menu1 == 3) {
                quickSort(Mahasiswa, 0, jumlahData - 1);
            } else if (menu1 == 4) {
                bubblesort();
            } else if (menu1 == 5) {
                shellsort();
            }
        } while (menu1 != 6);

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
    }

    // quick sort
    public static void quickSort(mahasiswa[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
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
    }

    // shell sort
    public static void shellsort() {
        for (int gap = jumlahData / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < jumlahData; i++) {
                for (int j = i; j >= gap && Mahasiswa[j].getNim().compareTo(Mahasiswa[j - gap].getNim()) <= 1; j--) {
                    swap(j, j - gap);
                }
            }
        }
    }

    // Pencarian Data

    public static void caridata() {
        Scanner scan1 = new Scanner(System.in);
        int menu1;
        do {
            System.out.println("Urutkan Data");
            System.out.println("1. Linier Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Keluar");
            System.out.println("Pilih Menu =");
            menu1 = scan1.nextInt();
            if (menu1 == 1) {
                liniersearch();
            } else if (menu1 == 2) {
                binarysearch();
            }
        } while (menu1 != 3);

    }

    // jenis pencarian data
    // linier search
    public static void liniersearch() {

    }

    // binary search
    public static void binarysearch() {

    }

    // edit data

    public static void editdata() {

    }

    // hapus data

    public static void hapusdata() {

    }

    // menu utama
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Pencarian Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. Keluar");
            System.out.println("Pilih Menu = ");
            menu = scan.nextInt();
            if (menu == 1) {
                tambahData();
            } else if (menu == 2) {
                tampilData();
            } else if (menu == 3) {
                urutkandata();
            } else if (menu == 4) {
                caridata();
            } else if (menu == 5) {
                editdata();
            } else if (menu == 6) {
                hapusdata();
            }
        } while (menu != 7);

    }

}