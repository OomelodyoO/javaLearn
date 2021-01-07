package win.zhangzhixing.list;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddApplication {
    public static void main(String[] args) throws InterruptedException {
        AddApplication addApplication = new AddApplication();
        ArrayList<ListStatistics> list = new ArrayList<>();
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
                , 100 * wan
        };
        System.out.println("num       \tfirst                 \tother                 \tlast");
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
            ListStatistics listStatistics = new ListStatistics(i);
            addApplication.testAdd(listStatistics);
            list.add(listStatistics);
        }
        Thread.sleep(100);
    }

    private void testAdd(ListStatistics listStatistics) {
        add(listStatistics.getNum(), ListEnum.FIRST, listStatistics);
        add(listStatistics.getNum(), ListEnum.OTHER, listStatistics);
        add(listStatistics.getNum(), ListEnum.LAST, listStatistics);
        System.out.println(String.format(
                "%s\t%s\t%s\t%s\t%s\t%s\t%s",
                String.format("%-10s", listStatistics.getNum()),
                String.format("%-10s", listStatistics.getFirst().getArray()),
                String.format("%-10s", listStatistics.getFirst().getLinked()),
                String.format("%-10s", listStatistics.getOther().getArray()),
                String.format("%-10s", listStatistics.getOther().getLinked()),
                String.format("%-10s", listStatistics.getLast().getArray()),
                String.format("%-10s", listStatistics.getLast().getLinked())
        ));
    }

    private void add(Integer num, ListEnum listEnum, ListStatistics listStatistics) {
        if (listEnum.equals(ListEnum.FIRST)) {
            // ArrayList插入
            StopWatch arrayListStopWatch = new StopWatch();
            List<Integer> arrayList = new ArrayList<>();
            arrayListStopWatch.start();
            for (int i = 0; i < num; i++) {
                arrayList.add(0, i);
            }
            arrayListStopWatch.stop();
            // ArrayList插入
            StopWatch linkedListStopWatch = new StopWatch();
            List<Integer> linkedList = new LinkedList<>();
            linkedListStopWatch.start();
            for (int i = 0; i < num; i++) {
                linkedList.add(0, i);
            }
            linkedListStopWatch.stop();
            listStatistics.getFirst().setArray(arrayListStopWatch.getTime());
            listStatistics.getFirst().setLinked(linkedListStopWatch.getTime());
        } else if (listEnum.equals(ListEnum.LAST)) {
            // ArrayList插入
            StopWatch arrayListStopWatch = new StopWatch();
            List<Integer> arrayList = new ArrayList<>();
            arrayListStopWatch.start();
            for (int i = 0; i < num; i++) {
                arrayList.add(i);
            }
            arrayListStopWatch.stop();
            // ArrayList插入
            StopWatch linkedListStopWatch = new StopWatch();
            List<Integer> linkedList = new LinkedList<>();
            linkedListStopWatch.start();
            for (int i = 0; i < num; i++) {
                linkedList.add(i);
            }
            linkedListStopWatch.stop();
            listStatistics.getLast().setArray(arrayListStopWatch.getTime());
            listStatistics.getLast().setLinked(linkedListStopWatch.getTime());
        } else {
            // ArrayList插入
            StopWatch arrayListStopWatch = new StopWatch();
            List<Integer> arrayList = new ArrayList<>();
            arrayListStopWatch.start();
            for (int i = 0; i < num; i++) {
                arrayList.add((int) Math.ceil((i / 2)), i);
            }
            arrayListStopWatch.stop();
            // ArrayList插入
            StopWatch linkedListStopWatch = new StopWatch();
            List<Integer> linkedList = new LinkedList<>();
            linkedListStopWatch.start();
            for (int i = 0; i < num; i++) {
                linkedList.add((int) Math.ceil((i / 2)), i);
            }
            linkedListStopWatch.stop();
            listStatistics.getOther().setArray(arrayListStopWatch.getTime());
            listStatistics.getOther().setLinked(linkedListStopWatch.getTime());
        }
    }
}
