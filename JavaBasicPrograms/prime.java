import java.util.*;
public class prime{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int flag=0;
		if(n==0 || n==1){
			System.out.println("Not a prime number");
		}else{
		 for(int i=2;i<=(n/2);i++){
		 	if(n%i==0){
		 		System.out.println("Not a prime number");
		 		flag=1;
		 		break;
		 	}
		}
		if(flag==0){
			System.out.println("prime number");
		}
	}
}
}
