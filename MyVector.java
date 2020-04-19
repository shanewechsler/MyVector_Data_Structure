import java.util.Arrays;

public class MyVector<E> extends MyAbstractList<E> {
    E[] myList;
    private int capacityIncrement =  5;
    private int currentCapacity;

    @SuppressWarnings("unchecked")
    public MyVector(){
        myList = (E[]) new Object[10];
        currentCapacity = 10;
    }

    @SuppressWarnings("unchecked")
    public MyVector(int initialCapacity){
        myList = (E[]) new Object[initialCapacity];
        currentCapacity = initialCapacity;
    }

    @SuppressWarnings("unchecked")
    public MyVector(int initialCapacity, int capacityIncrement){
        myList = (E[]) new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
        currentCapacity = initialCapacity;
    }

    public int getCapacity(){
        return currentCapacity;
    }

    public int getIncrement(){
        return capacityIncrement;
    }

    @SuppressWarnings("unchecked")
    public boolean add(E data){
        if(currentCapacity == size()){
            currentCapacity += capacityIncrement;
            E[] temp = (E[]) new Object[currentCapacity];
            for(int i = 0; i < myList.length; i++){
                temp[i] = myList[i];
            }
            myList = temp;
        }
        myList[size()] = data;
        return true;
    }

    public boolean add(int index, E data) throws IndexOutOfBoundsException{
        if(index < 0 || index > myList.length - 1){
            throw new IndexOutOfBoundsException();
        }
        myList[index] = data;
        return true;
    }

    public void clear(){
        Arrays.fill(myList, null);
    }

    public E get(int index){
        return myList[index];
    }

    @Override
    public boolean isEmpty(){
        for(int i = 0; i < myList.length; i++){
            if(myList[i] != null){
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index > myList.length - 1){
            throw new IndexOutOfBoundsException();
        }
        E[] temp = (E[]) new Object[currentCapacity];
        E removed = myList[index];
        int tempIndex = 0;
        for(int i = 0; i < index; i++){
            temp[tempIndex] = myList[i];
            tempIndex++;
        }
        for(int i = index+1; i < size(); i++){
            temp[tempIndex] = myList[i];
            tempIndex++;
        }
        myList = temp;

//        for(int i = 0; i < index-1; )
        return removed;
    }

    @SuppressWarnings("unchecked")
    public void trimToSize(){
        currentCapacity = size();
        E[] trimmed = (E[]) new Object[size()];
        int trimIndex = 0;
        for(int i = 0; i < myList.length; i++){
            if(myList[i] != null){
                trimmed[trimIndex] = myList[i];
                trimIndex++;
            }
        }
        myList = trimmed;
    }

    public int size(){
        int size = 0;
        for(int i = 0; i < myList.length; i++){
            if(myList[i] != null){
                size++;
            }
        }
        return size;
    }

    @Override
    public String toString(){
        trimToSize();
        return Arrays.toString(myList);
    }
}
