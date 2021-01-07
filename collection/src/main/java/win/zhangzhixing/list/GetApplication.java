package win.zhangzhixing.list;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetApplication {
    public static void main(String[] args) throws InterruptedException {
        GetApplication getApplication = new GetApplication();
        List<GetListStatistics> list = new ArrayList<>();
        Integer wan = 10000;
        int[] arr = new int[]{
                10 * wan
                , 11 * wan
                , 12 * wan
                , 13 * wan
                , 14 * wan
                , 15 * wan
                , 16 * wan
                , 17 * wan
                , 18 * wan
                , 19 * wan
                , 20 * wan
                , 50 * wan
//                , 100 * wan
        };
        System.out.println("get       \tfirst                 \titerator              \tlast");
        System.out.println(
                String.format(
                        "%s\t%s\t%s\t%s\t%s\t%s\t%s",
                        String.format("%-10s", "num"),
                        String.format("%-10s", "array"),
                        String.format("%-10s", "linked"),
                        String.format("%-10s", "array"),
                        String.format("%-10s", "linked"),
                        String.format("%-10s", "array"),
                        String.format("%-10s", "linked")
                )
        );
        for (int i : arr) {
            ArrayList<Integer> arrayList = getApplication.addArrayList(i);
            LinkedList<Integer> linkedList = getApplication.addLinkedList(i);
            GetListStatistics getListStatistics = new GetListStatistics(i);
            getApplication.testGet(getListStatistics, arrayList, linkedList);
            list.add(getListStatistics);
        }
        Thread.sleep(100);
    }

    private void testGet(GetListStatistics getListStatistics, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList) {
        get(GetListEnum.FIRST, arrayList, linkedList, getListStatistics);
        get(GetListEnum.ITERATOR, arrayList, linkedList, getListStatistics);
        get(GetListEnum.LAST, arrayList, linkedList, getListStatistics);
        System.out.println(String.format(
                "%s\t%s\t%s\t%s\t%s\t%s\t%s",
                String.format("%-10s", getListStatistics.getNum()),
                String.format("%-10s", getListStatistics.getFirst().getArray()),
                String.format("%-10s", getListStatistics.getFirst().getLinked()),
                String.format("%-10s", getListStatistics.getIterator().getArray()),
                String.format("%-10s", getListStatistics.getIterator().getLinked()),
                String.format("%-10s", getListStatistics.getLast().getArray()),
                String.format("%-10s", getListStatistics.getLast().getLinked())
        ));
    }

    private void get(GetListEnum getListEnum, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, GetListStatistics getListStatistics) {
        if (getListEnum.equals(GetListEnum.FIRST)) {
            // get arrayList
            StopWatch arrayListStopWatch = new StopWatch();
            arrayListStopWatch.start();
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(0);
            }
            arrayListStopWatch.stop();

            // get linkedList
            StopWatch linkedListStopWatch = new StopWatch();
            linkedListStopWatch.start();
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.get(0);
            }
            linkedListStopWatch.stop();

            getListStatistics.getFirst().setArray(arrayListStopWatch.getTime());
            getListStatistics.getFirst().setLinked(linkedListStopWatch.getTime());
        } else if (getListEnum.equals(GetListEnum.LAST)) {
            // get arrayList
            StopWatch arrayListStopWatch = new StopWatch();
            arrayListStopWatch.start();
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(arrayList.size() - 1);
            }
            arrayListStopWatch.stop();

            // get linkedList
            StopWatch linkedListStopWatch = new StopWatch();
            linkedListStopWatch.start();
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.get(linkedList.size() - 1);
            }
            linkedListStopWatch.stop();

            getListStatistics.getLast().setArray(arrayListStopWatch.getTime());
            getListStatistics.getLast().setLinked(linkedListStopWatch.getTime());
        } else {
            // get arrayList
            StopWatch arrayListStopWatch = new StopWatch();
            arrayListStopWatch.start();
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i);
            }
            arrayListStopWatch.stop();

            // get linkedList
            StopWatch linkedListStopWatch = new StopWatch();
            linkedListStopWatch.start();
            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.get(i);
            }
            linkedListStopWatch.stop();
            getListStatistics.getIterator().setArray(arrayListStopWatch.getTime());
            getListStatistics.getIterator().setLinked(linkedListStopWatch.getTime());
        }
    }

    private ArrayList addArrayList(int num) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    private LinkedList addLinkedList(int num) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }
}
