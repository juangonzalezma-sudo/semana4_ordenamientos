import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arrayOriginal = generarArray(1000);
        int[] arrayBurbuja = arrayOriginal.clone();
        int[] arraySeleccion = arrayOriginal.clone();
        int[] arrayInsercion = arrayOriginal.clone();
        long inicio = System.nanoTime();
        burbuja(arrayBurbuja);
        long fin = System.nanoTime();
        System.out.println("Tiempo Burbuja: " + (fin - inicio) + " ns");
        inicio = System.nanoTime();
        seleccion(arraySeleccion);
        fin = System.nanoTime();
        System.out.println("Tiempo Selección: " + (fin - inicio) + " ns");
        inicio = System.nanoTime();
        insercion(arrayInsercion);
        fin = System.nanoTime();
        System.out.println("Tiempo Inserción: " + (fin - inicio) + " ns");
    }
    public static int[] generarArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        return arr;
    }
    public static void burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selección
    public static void seleccion(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    // Inserción
    public static void insercion(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
