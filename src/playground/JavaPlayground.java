package playground;
public class JavaPlayground {
    private static int compare(int arrA[],int arrB[],int len){
        int diff =0;
        for(int i=0; i<len; i++){
            diff+=Math.abs(arrA[i]-arrB[i]);
        }
        return diff;
    }

    private static int compareDispatcher(int arrA[],int arrB[],int len){
        //Dispatcher
        if(len==0) return 0;
        int lastDiff = Math.abs(arrA[len-1] - arrB[len-1]);
        lastDiff+=compareDispatcher(arrA,arrB,len-1);
        return lastDiff;

    }

    private static int compareDispatcherTailRec(int arrA[],int arrB[],int len, int lastDiff){
        if(len==0) return lastDiff;
        lastDiff = lastDiff+ Math.abs(arrA[len-1] - arrB[len-1]);
        return compareDispatcherTailRec(arrA,arrB,len-1, lastDiff);
    }

    public static void main(String args[]){
        System.out.println("Hello Java");

        int[] lArrA = {10,12,14,16,67,89,0,1,4,4,3,4};
        int[] lArrB = {10,12,14,16,76,98,0,1,4,4,3,4};
        System.out.println(compare(lArrA,lArrB,12));
        System.out.println(compareDispatcher(lArrA,lArrB,12));
        System.out.println(compareDispatcherTailRec(lArrA,lArrB,12,0));

    }
}
