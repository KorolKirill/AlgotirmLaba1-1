package AlgotirmLaba1;

public class ClassForTestArrayList {
    public void testOurArrayList(ArrayListOurVersion list,int test_amount) throws Exception {

        String nameOfCollection = "ArrayList-a ";

        System.out.println("Кол-во елементов которых мы добавляем или от которых избавляемся: " +test_amount );

        long tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) { ;
            list.add(i);
        }
        //System.out.println(list.getSize());

        long timer = (System.nanoTime()-tStart);
        System.out.println( "Время на добавление в конец "+ nameOfCollection + timer + " nanosecond.");
        tStart = System.nanoTime();

        for (int i = 0 ;i < test_amount; i++) {
            list.removeLast();
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на удаление с конца "+ nameOfCollection + timer + " nanosecond.");

        System.out.println();

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            list.addFirst(i);
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на добавление с начала "+ nameOfCollection + timer + " nanosecond.");

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount; i++) {
            list.removeFirst();
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на удаление с начала "+ nameOfCollection + timer + " nanosecond.");

        System.out.println();

        tStart = System.nanoTime();
        System.out.println("Дальше добавляем по 3 елемента, а потом тестируем запихивая елементы в так называемую середину");
        list.add(1); list.add(1); list.add(1);
        for (int i = 0 ;i < test_amount; i++) {
            list.add(i,1);
        }
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на добавление в середину "+ nameOfCollection + timer + " nanosecond.");

        tStart = System.nanoTime();
        for (int i = 0 ;i < test_amount-3; i++) {
            list.remove(1);
        }
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        timer = System.nanoTime()-tStart ;
        System.out.println( "Время на удаление с середины "+ nameOfCollection + timer + " nanosecond.");
    }
}
