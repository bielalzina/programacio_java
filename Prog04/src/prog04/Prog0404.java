
package prog04;

public class Prog0404 {
    public static void main(String[] args){
        int a=0;
        int b=1;
        int c;
        
        System.out.println("1)\t"+a);
        System.out.println("2)\t"+b);
        
        for (int i=3; i<=20;i++){
            c = a + b;
            System.out.println(i+")\t"+c);
            a=b;
            b=c;
        }
                
    }
    
}
