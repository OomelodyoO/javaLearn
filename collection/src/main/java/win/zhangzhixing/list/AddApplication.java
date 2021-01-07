package win.zhangzhixing.list;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddApplication {
    public static void main(String[] args) throws InterruptedException {
        AddApplication addApplication = new AddApplication();
        List<AddListStatistics> list = new ArrayList<>();
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
        System.out.println("add       \tfirst                 \tother                 \tlast");
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
            AddListStatistics addListStatistics = new AddListStatistics(i);
            addApplication.testAdd(addListStatistics);
            list.add(addListStatistics);
        }
        Thread.sleep(100);
    }

    private void testAdd(AddListStatistics addListStatistics) {
        add(addListStatistics.getNum(), AddListEnum.FIRST, addListStatistics);
        add(addListStatistics.getNum(), AddListEnum.OTHER, addListStatistics);
        add(addListStatistics.getNum(), AddListEnum.LAST, addListStatistics);
        System.out.println(String.format(
                "%s\t%s\t%s\t%s\t%s\t%s\t%s",
                String.format("%-10s", addListStatistics.getNum()),
                String.format("%-10s", addListStatistics.getFirst().getArray()),
                String.format("%-10s", addListStatistics.getFirst().getLinked()),
                String.format("%-10s", addListStatistics.getOther().getArray()),
                String.format("%-10s", addListStatistics.getOther().getLinked()),
                String.format("%-10s", addListStatistics.getLast().getArray()),
                String.format("%-10s", addListStatistics.getLast().getLinked())
        ));
    }

    private void add(Integer num, AddListEnum addListEnum, AddListStatistics addListStatistics) {
        if (addListEnum.equals(AddListEnum.FIRST)) {
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
            addListStatistics.getFirst().setArray(arrayListStopWatch.getTime());
            addListStatistics.getFirst().setLinked(linkedListStopWatch.getTime());
        } else if (addListEnum.equals(AddListEnum.LAST)) {
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
            addListStatistics.getLast().setArray(arrayListStopWatch.getTime());
            addListStatistics.getLast().setLinked(linkedListStopWatch.getTime());
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
            addListStatistics.getOther().setArray(arrayListStopWatch.getTime());
            addListStatistics.getOther().setLinked(linkedListStopWatch.getTime());
        }
    }
}
