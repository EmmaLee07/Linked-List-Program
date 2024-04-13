public class JavaLinkedList {

    private MyLinkedList<Integer> list;

    public JavaLinkedList() {
        list = new MyLinkedList<>();
    }

    public JavaLinkedList(int[] elements) {
        list = new MyLinkedList<>();
        for (int element : elements) {
            list.add(element);
        }
    }

    public double getSum() {
        int sum = 0;
        int size = list.size();

        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }

        return sum;
    }

    public double getMean() {
        int size = list.size();

        if (size == 0) {
            return -1;
        }

        double sum = getSum();

        return sum / size;
    }

    public int getLargest() {
        int size = list.size();

        if (size == 0) {
            return -1;
        }

        int largest = list.get(0);

        for (int i = 1; i < size; i++) {
            int element = list.get(i);
            if (element > largest) {
                largest = element;
            }
        }

        return largest;
    }

    public int getSmallest() {
        int size = list.size();

        if (size == 0) {
            return -1;
        }

        int smallest = list.get(0);

        for (int i = 1; i < size; i++) {
            int element = list.get(i);
            if (element < smallest) {
                smallest = element;
            }
        }

        return smallest;
    }

    @Override
    public String toString() {
        String x = "SUM:: " + getSum() + "\nMEAN:: " + getMean() + "\nSMALLEST:: " + getSmallest() + "\nLARGEST:: " + getLargest();
        return x;
    }
}
