import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronni on 25-10-2016.
 */
public class MyBubbleSort<T>
{
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        IntComparator comparator = new IntComparator();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(0);
        list2.add(50);
        list2.add(25);
        list2.add(39);
        list2.add(11);
        bubbleSort1(list1);
        bubbleSort2(list2, comparator);
        System.out.println(list1);
        System.out.println(list2);
    }

    public static <T extends Comparable<T>> void bubbleSort1(List<T> list)
    {
        for (int k = 1; k < list.size(); k++)
        {
            for (int i = 0; i < list.size() - k; i++)
            {
                if (list.get(i).compareTo(list.get(i + 1)) > 0)
                {
                    T temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
    }

    public static <T> void bubbleSort2(List<T> list, IntComparator comparator) {
        for (int k = 1; k < list.size(); k++)
        {
            for (int i = 0; i < list.size() - k; i++)
            {
                if (comparator.compare((Integer)list.get(i), (Integer)list.get(i + 1)) > 0)
                {
                    T temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
    }
}