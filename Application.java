public class Application {
    public static void main(String[] args){
        MyVector<Integer> testVec = new MyVector<>();
        testVec.add(7, 5);
        testVec.add(2, 4);
        testVec.add(0, 3);
        testVec.add(9,2);
        testVec.add(3, 2);
        testVec.trimToSize();
        testVec.trimToSize();
//        System.out.println(testVec.isEmpty());
//        System.out.println(testVec.size());
//        System.out.println(testVec.get(0));
//        System.out.println(testVec.get(1));
        //testVec.trimToSize();
    }
}
