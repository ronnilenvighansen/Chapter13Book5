import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronni on 03-11-2016.
 */
public class MyQuickSort <T> {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(0);
        list1.add(5);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(14);
        list2.add(62);
        list2.add(32);
        list2.add(17);
        int low = 0;
        int high = list1.size()-1;
        quickSort1(list1, low, high);
        quickSort2(list2, low, high);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }

    public static <T extends Comparable<T>> void quickSort1(List<T> list, int low, int high) {
        int i = low;
        int j = high;
        int middle = low + (high - low) / 2;
        T pivot = list.get(middle);
        while (i <= j) {
            while (list.get(i).compareTo(pivot) < 0) {
                i++;
            }
            while (list.get(j).compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
            if (low < j) {
                quickSort1(list, low, j);
            }
            if (high > i) {
                quickSort1(list, i, high);
            }
        }
    }

    public static <T> void quickSort2(List<T> list, int low, int high) {
        IntComparator comparator = new IntComparator();
        int i = low;
        int j = high;
        int middle = low + (high - low) / 2;
        T pivot = list.get(middle);
        while (i <= j) {
            while (comparator.compare((Integer)list.get(i), (Integer)pivot) < 0) {
                i++;
            }
            while (comparator.compare((Integer)list.get(j), (Integer)pivot) > 0) {
                j--;
            }
            if (i <= j) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
            if (low < j) {
                quickSort2(list, low, j);
            }
            if (high > i) {
                quickSort2(list, i, high);
            }
        }
    }
}