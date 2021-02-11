package AlgotirmLaba1;

import AlgotirmLaba1.LinkListOneWay;

import java.util.LinkedList;

public class Main {

    public static LinkListOneWay<Integer> linkListOneWay = new LinkListOneWay<>(); //Однобічно зв'язаний список
    public static LinkedListTwoWay<Integer> linkedListTwoWay = new LinkedListTwoWay<>(); // Двобічно зв'язаний список
    public static ArrayListOurVersion<Integer> arrayListOurVersion = new ArrayListOurVersion<>(); // Масиви (аналог ArrayList)
    public static int test_amount =1000;


    public static void main(String[] args) throws Exception {
        ClassForTestArrayList test = new ClassForTestArrayList();

        testOneWayList();
        System.out.println();
        testTwoWayList();
        System.out.println();
        test.testOurArrayList(arrayListOurVersion,test_amount);

    }
    public static void testTwoWayList() throws Exception {
        String nameOfCollection = "Двухсвязного списка ";

        System.out.println("Кол-во елементов которых мы добавляем или от которых избавляемся: " + test_amount );

        long tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            linkedListTwoWay.add(i);
        }
        long timer = (System.nanoTime()-tStart);
        System.out.println( "Время на добавление в конец "+ nameOfCollection + timer + " nanosecond.");

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            linkedListTwoWay.removeLast();
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на удаление с конца "+ nameOfCollection + timer + " nanosecond.");

        System.out.println();

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            linkedListTwoWay.addFirst(i);
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на добавление с начала "+ nameOfCollection + timer + " nanosecond.");

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            linkedListTwoWay.removeFirst();
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на удаление с начала "+ nameOfCollection + timer + " nanosecond.");

        System.out.println();

        tStart = System.nanoTime();
        System.out.println("Дальше добавляем по 3 елемента, а потом тестируем запихивая елементы в так называемую середину");
        linkedListTwoWay.add(1); linkedListTwoWay.add(1); linkedListTwoWay.add(1);
        for (int i = 0 ;i < test_amount; i++) {
            linkedListTwoWay.add(i,1);
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на добавление в середину "+ nameOfCollection + timer + " nanosecond.");

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount-3; i++) {
            linkedListTwoWay.add(i,1);
        }
        linkedListTwoWay.removeFirst();
        linkedListTwoWay.removeFirst();
        linkedListTwoWay.removeFirst();
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на удаление с середины "+ nameOfCollection + timer + " nanosecond.");
    }

    public static void testOneWayList() throws Exception {
        String nameOfCollection = "односвязного списка ";

        System.out.println("Кол-во елементов которых мы добавляем или от которых избавляемся: " +test_amount );

        long tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            linkListOneWay.add(i);
        }
        long timer = (System.nanoTime()-tStart);
        System.out.println( "Время на добавление в конец "+ nameOfCollection + timer + " nanosecond.");

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            linkListOneWay.removeLast();
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на удаление с конца "+ nameOfCollection + timer + " nanosecond.");

        System.out.println();

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            linkListOneWay.addFirst(i);
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на добавление с начала "+ nameOfCollection + timer + " nanosecond.");

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            linkListOneWay.removeFirst();
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на удаление с начала "+ nameOfCollection + timer + " nanosecond.");

        System.out.println();

        tStart = System.nanoTime();
        System.out.println("Дальше добавляем по 3 елемента, а потом тестируем запихивая елементы в так называемую середину");
        linkListOneWay.addFirst(1); linkListOneWay.add(1); linkListOneWay.add(1);

        for (int i = 0 ;i < test_amount; i++) {
            linkListOneWay.add(i,1);
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на добавление в середину "+ nameOfCollection + timer + " nanosecond.");

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount-3; i++) {
            linkListOneWay.add(i,1);
        }
        linkListOneWay.removeFirst();
        linkListOneWay.removeFirst();
        linkListOneWay.removeFirst();
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на удаление с середины "+ nameOfCollection + timer + " nanosecond.");
    }



}
