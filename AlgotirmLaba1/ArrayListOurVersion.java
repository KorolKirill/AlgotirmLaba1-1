package AlgotirmLaba1;


public class ArrayListOurVersion<E> implements MegaInterface {
    private int initializationSize = 10; //Если не задан размер, то будет 10
    private Object[] array;
    private int elements;
    private int coefficient = 2; // Коэфициент во сколько раз будет увеличиваться массив.

    private void replaceAllElements(Object[] arr1,Object[] arr2) {
        for (int i = 0; i <arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }


    public ArrayListOurVersion(int initialSize) {
        array = new Object[initialSize];
    }

    public ArrayListOurVersion() {
        array = new Object[initializationSize];

    }


    @Override
    public void add(Object data) throws Exception {

        checkForNull(data);

        if (array.length <= elements) {
            Object[] newArray = new Object[array.length*coefficient];
            replaceAllElements(array,newArray);
            array = newArray;
        }
        array[elements++] = data;
    }

    private void checkForNull(Object data) throws Exception {
        if (data == null) {
            throw new Exception("Вы пытаеться добавить или заменить елемент на null, в этой реализации" +
                    "это запрещено.");
        }
    }

    public void add(Object data, int index) throws Exception {

        checkForNull(data);

        if (index>elements) {
            throw new Exception("Индекс выходить за размеры массива");
            //Подразумевается что в середине массива не может быть null;
        }
        else if (index == elements) {
            add(data);
        }
        else {
            Object[] tempArray = array.clone();
            for (int i = 0, b = 0; i < array.length;) {
                if (i == index) {
                    array[i] = data;
                    i++;
                    continue;
                }
                array[i] = tempArray[b];
                i++;
                b++;
            }
            elements++;
        }
    }

    public Object[] getArray() {
        return array;
    }

    @Override
    public void remove(int index) throws Exception {
        if ( index > elements-1 ) {
            throw new Exception("Выходит за границы");
        }
        else if (index== elements-1 ) {
            removeLast();
        }
        else {
            Object[] tempArray = array.clone();
            for (int i = 0, b = 0; i < array.length-1;) {
                if (i == index) {
                    i++;
                    b+=2;
                    continue;
                }
                array[i] = tempArray[b];
                i++; b++;
            }
            elements--;
        }
    }

    @Override
    public int getSize() {
        return elements;
    }

    @Override
    public void removeFirst() throws Exception {
        remove(0);
    }

    @Override
    public void removeLast() throws Exception {
        array[--elements] = null;
    }

    @Override
    public void addFirst(Object data) throws Exception {
        add(data,0);
    }

    @Override
    public void addLast(Object data) throws Exception {
        add(data);
    }
    public void replace(Object data,int index) throws Exception {
        checkForNull(data);
        if (index > elements || index < 0) {
            throw new Exception("Выходит за рамки массива");
        }
        else {
            array[index] = data;
        }
    }
    public void replaceFirst(Object data) throws Exception {
        replace(data,0);
    }
    public void replaceLast(Object data) throws Exception {
        replace(data,elements-1);
    }

}
