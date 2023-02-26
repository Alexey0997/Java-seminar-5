import java.util.Arrays;
import java.util.Random;

/*
Задача № 3.
Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */
public class Sem_5_Hmw_Task3 {
    public static void main(String[] args) {
        int[] numbers = randomArr();
        System.out.println("Исходный массив:   " + Arrays.toString(numbers));
        heapSort(numbers);
        System.out.println("Результа HeapSort: " + Arrays.toString(numbers));
    }

    // МЕТОД ФОРМИРОВАНИЯ МАССИВА СЛУЧАЙНЫХ ЧИСЕЛ
    public static int[] randomArr(){
        Random random = new Random();
        int[] originArray = new int[10];                      // Инициализация массива целых чисел из 10 элементов.
        for (int i = 0; i < 10; i++) {                        // Добавим числа в диапазоне [0, 99]
            originArray[i] = random.ints(1, (100)).findFirst().getAsInt();
        }
        return originArray;
    }

    // МЕТОД СОРТИРОВКИ МАССИВА
    public static void heapSort(int[] myArray){               // Аргумент - исходный массив.
        int arrLength = myArray.length;
        for (int i = arrLength / 2 - 1; i >= 0; i--) {        // Создаем дерево HeapSort.
            heaping(myArray, arrLength, i);
        }
        for (int i = arrLength - 1; i >= 0; i--) {            // Берем максимальный элемент в куче myArray[0]
            int temp = myArray[0];                            // и ставим его на последнее место в массиве.
            myArray[0] = myArray[i];
            myArray[i] = temp;
            heaping(myArray, i, 0);                        // Вызываем метод изменения данных в куче.
        }
    }

    // МЕТОД ИЗМЕНЕНИЯ ДАННЫХ В КУЧЕ
    public static void heaping(int[] newArray, int n, int i){
        int largest = i;                                      // Корневой элемент.
        int left = 2 * i + 1;                                 // Дочерний элемент слева.
        int right = 2 * i + 2;                                // Дочерний элемент справа.

        if (left < n && newArray[left] > newArray[largest])   // Если дочерний элемент слева больше корневого,
            largest = left;                                   // то делаем его корневым.

        if (right < n && newArray[right] > newArray[largest]) // Если дочерний элемент справа больше корневого,
            largest = right;                                  // то делаем его корневым.

        if (largest != i) {                                   // Если наибольший элемент некорневой, то меняем их местами.
            int temp = newArray[i];
            newArray[i] = newArray[largest];
            newArray[largest] = temp;
            heaping(newArray, n, largest);                    // Вызываем рекурсию для упорядочивания других элементов.
        }
    }
}
