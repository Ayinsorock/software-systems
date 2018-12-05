package ss.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    public static <E extends Comparable<E>>
           void mergesort(List<E> list) {
        if(list.size() < 2) {
            return;
        }

        // split the array into singletons
    	List<List<E>> lists = new ArrayList<>();
    	for(E element:list) {
            lists.add(Collections.singletonList(element));
        }

        // perform the merge
        List<E> sortedList = MergeSort.doMerge(lists);

        // overwrite the original array, not sure if this is the only/best way to do this
        for (int i = 0; i < list.size(); i++) {
            list.set(i, sortedList.get(i));
        }
    }

    private static <E extends Comparable<E>>
            List<E> doMerge(List<List<E>> lists) {
        List<List<E>> nextLists = new ArrayList<>();

        for (int i = 0; i < lists.size(); i += 2) {
            // prevent out of bounds for uneven lists
            if(i + 1 >= lists.size()) {
                nextLists.add(lists.get(i));
                continue;
            }

            List<E> firstList = lists.get(i);
            List<E> secondList = lists.get(i + 1);

            // account for empty lists
            if (firstList.size() == 0 || secondList.size() == 0) {
                firstList.addAll(secondList);
                nextLists.add(firstList);
                continue;
            }

            nextLists.add(doSingleMerge(firstList, secondList));
        }

        return nextLists.size() > 1 ? doMerge(nextLists) : nextLists.get(0);
    }

    private static <E extends Comparable<E>>
            List<E> doSingleMerge(List<E> firstList, List<E> secondList) {
        List<E> mergedList = new ArrayList<>();

        while(firstList.size() > 0 && secondList.size() > 0) {
            if(firstList.get(0).compareTo(secondList.get(0)) < 0) {
                mergedList.add(firstList.get(0));
                // TODO: SingletonLists are immutable therefor the extra check is needed. Preferably this would be solved in another way..
                if (firstList.size() == 1) {
                    firstList = new ArrayList<>();
                } else {
                    firstList.remove(0);
                }
            } else {
                mergedList.add(secondList.get(0));
                if(secondList.size() == 1) {
                    secondList = new ArrayList<>();
                } else {
                    secondList.remove(0);
                }
            }
        }

        // when one of the lists is empty the other can fully appended
        // instead of checking which we just add both as one is empty anyways..
        mergedList.addAll(firstList);
        mergedList.addAll(secondList);

        return mergedList;
    }
}
