public class balancedarray1 {
    public static int balanced(int [] array ){
        int c=array.length,i;
        for( i=0;i<array.length;i++)
            if(!(i%2==array[i]%2))
                break;
        if(c==i)
            return 1;
        else
            return  0;
    }
    public static void main(String[] args) {
        int [] array = { 1,4,4,5,8,3,2};
        if(balanced(array)==1)
            System.out.println("The  array is balanced");
        else
            System.out.println("The  array is not balanced");
    }
}