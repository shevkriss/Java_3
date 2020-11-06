import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        LinkedList<Integer> lin1 = new LinkedList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        LinkedList<Integer> lin2 = new LinkedList<Integer>();
        ArrayList<Integer> arr3 = new ArrayList<Integer>();
        LinkedList<Integer> lin3 = new LinkedList<Integer>();

        Runnable arrayListAddTime = new listAddTime(arr1);
        Runnable linkedListAddTime = new listAddTime(lin1);
        Runnable arrayListRemoveTime = new listRemoveTime(arr2);
        Runnable linkedListRemoveTime = new listRemoveTime(lin2);
        Runnable arrayListGetTime = new listGetTime(arr3);
        Runnable linkedListGetTime = new listGetTime(lin3);

        new Thread(arrayListAddTime).start();
        new Thread(linkedListAddTime).start();
        new Thread(arrayListGetTime).start();
        new Thread(arrayListRemoveTime).start();
        new Thread(linkedListGetTime).start();
        new Thread(linkedListRemoveTime).start();
    }

    /**
     * This thread counts the time it took for the add method of Linked and Array List to execute 2000 times.
     */
    static class listAddTime implements Runnable {
        private List<Integer> list;
        public listAddTime(List<Integer> list) {
            this.list = list;
        }

        public void run() {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 2000; i++) {
                list.add(1);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода add для " + list.getClass() + " 2000 раз: " +
                    (endTime - startTime));
        }
    }

    /**
     * This thread counts the time it took for the remove method of Linked and Array List to execute 2000 times.
     */
    static class listRemoveTime implements Runnable {
        private List<Integer> list;
        public listRemoveTime(List<Integer> list) {
            this.list = list;
        }

        public void run() {
            for (int i = 0; i < 2000; i++) {
                list.add(1);
            }
            long startTime = System.currentTimeMillis();
            for (int i = 1999; i >= 0; i--) {
                list.remove(i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода remove для " + list.getClass() + " 2000 раз: " +
                    (endTime - startTime));
        }
    }

    /**
     * This thread counts the time it took for the get method of Linked and Array List to execute 2000 times.
     */
    static class listGetTime implements Runnable {
        private List<Integer> list;
        public listGetTime(List<Integer> list) {
            this.list = list;
        }

        public void run() {
            list.add(1);
            int temp = 0;
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 2000; i++) {
                temp = list.get(0);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Время выполнения метода get для " + list.getClass() + " 2000 раз: " +
                    (endTime - startTime));
        }
    }
}
