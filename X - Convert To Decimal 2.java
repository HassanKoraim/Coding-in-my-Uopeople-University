import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    // Scanner 
	    Scanner in = new Scanner(System.in);
	    int T = in.nextInt();
	    // loop to give the numbers from User 
	    for (int i = 0 ; i < T ; i++){
	        int N = in.nextInt();
	        decToBin(N); 
	    }
		
	}
	static void decToBin(int n){
	    int[] binaryNum = new int[100];
	    
	    // counter for binaryNum
	    int i = 0;
	    while(n > 0){
	        binaryNum[i] = n % 2;
	        n = n / 2;
	        i++;
	    }
	    //loop to sum binaryNum
	   // int sum = 0;
	    String s = "";
	    for(int x : binaryNum){
	        if (x == 1){
	            s = s+ '1';
	        }
	    }
	    System.out.println(binToDic(s));
	}
	static int binToDic(String S){
	    double result = 0;
	    for(int i = 0; i < S.length(); i++){
	        if (S.charAt(i) == '1'){
	            result = result + Math.pow(2, S.length()-1 - i );
	        }
	    }
	    return (int) result;
	}
}
