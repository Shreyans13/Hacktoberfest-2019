package HackerRank;

public class RadixSort {

	public static void Radix_Sort( int arr[] , int n ) {

		int max = 0 ;
		for( int i = 0 ; i < n ; i++ )
			if(arr[i] > max)
				max = arr[i] ;

		for( int pos = 1 ; max/pos > 0 ; pos = pos*10 ) {
			Counting_Sort( arr , n , pos ) ;
		}
	}

	public static void Counting_Sort( int arr[] , int n , int pos ) {

		int count[] = new int[10] ;
		for( int i = 0 ; i < n ; i++ ) {
			++count[ (arr[i]/pos)%10 ] ;
		}

		for( int i = 1 ; i < 10 ; i++ ){
			count[i] = count[i] + count[ i - 1] ;
		}

		int newArr[] = new int[n] ;

		for( int i = n-1 ; i >=0 ; i-- ) {
			newArr[--count[(arr[i]/pos)%10 ] ] = arr[i] ;
		}

		for( int i = 0 ; i< n ; i++  )
			arr[i] = newArr[i] ;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2 , 5 , 1 , 9 , 24 , 12 , 400 , 522 , 123 , 100 } ;
		Radix_Sort( arr , 10);
		for( int i = 0 ; i < 10 ; i++ ) {
			System.out.print(arr[i] + " ");
		}
	}

}
