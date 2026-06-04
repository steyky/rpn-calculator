import java.util.Arrays;

interface SortStrategy {
    void sort(int[] data);
}

class BubbleSort implements SortStrategy {
    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }
}

class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }
}

class Sorter {
    private SortStrategy strategy;

    void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    void executeSort(int[] data) {
        strategy.sort(data);
    }
}

// Использование:
public class MainStrategy {
    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 5, 6};
        Sorter sorter = new Sorter();

        sorter.setStrategy(new BubbleSort());
        sorter.executeSort(data);
        System.out.println(Arrays.toString(data));

        int[] data2 = {5, 2, 9, 1, 5, 6};
        sorter.setStrategy(new QuickSort());
        sorter.executeSort(data2);
        System.out.println(Arrays.toString(data2));
    }
}