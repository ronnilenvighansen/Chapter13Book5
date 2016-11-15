import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronni on 25-10-2016.
 */
public class MyMergeSort<T> {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        list1.add(2);
        list1.add(3);
        list1.add(1);
        list1.add(0);
        list2.add(2);
        list2.add(3);
        list2.add(1);
        list2.add(0);
        System.out.println(list1);
        mergeSort1(list1);
        System.out.println(list1);
        System.out.println(list2);
        mergeSort2(list2);
        System.out.println(list2);
    }

    public static void mergeSort1(List<Integer> list)
    {
        if(list.size() > 1){
            List <Integer> left = new ArrayList<>(list.subList(0, list.size() / 2));
            List <Integer> right = new ArrayList<>(list.subList(list.size() / 2, list.size()));
            mergeSort1(left);
            mergeSort1(right);
            merge1(list, left, right);
        }
    }

    public static void mergeSort2(List<Integer> list) {
        IntComparator comparator = new IntComparator();
        if(list.size() > 1){
            List <Integer> left = new ArrayList<>(list.subList(0, list.size() / 2));
            List <Integer> right = new ArrayList<>(list.subList(list.size() / 2, list.size()));
            mergeSort2(left);
            mergeSort2(right);
            merge2(list, left, right, comparator);
        }
    }

    public static <T extends Comparable<T>> void merge1(List<T> result, List<T> left, List<T> right){
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.size(); i++) {
            if (i2>=right.size() || (i1 < left.size() &&
            left.get(i1).compareTo(right.get(i2)) <= 0)) {
                result.set(i, left.get(i1));
                i1++;
            } else {
                result.set(i, right.get(i2));
                i2++;
            }
        }
    }

    public static void merge2(List<Integer> result, List<Integer> left, List<Integer> right, IntComparator comparator){
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.size(); i++) {
            if (i2>=right.size() || (i1 < left.size() &&
                    comparator.compare(left.get(i1), right.get(i2)) <= 0)) {
                result.set(i, left.get(i1));
                i1++;
            } else {
                result.set(i, right.get(i2));
                i2++;
            }
        }
    }
}
