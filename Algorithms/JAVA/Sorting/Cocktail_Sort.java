package Sorting;
import java.util.*;

class Cocktail_Sort
{
    int size;
    int a[];
    
    Scanner in=new Scanner(System.in);
    public Cocktail_Sort(int n)
    {
        size=n;
        a=new int[size];
    }
    public void input()
    {
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<size;i++)
        a[i]=in.nextInt();
    }
    public void sort()
    {
        boolean swap=true;
        int s=0;
        int e=a.length;
        
        while(swap=true)
        {
            swap=false;
            
            for(int i=s;i<e-1;i++)
            {
                if(a[i]>a[i+1])
                {
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    swap=true;
                }
            }
            
            if(swap==false)
            break;
            
            swap=false;
            e=e-1;
            for(int i=e-1;i>=s;i--)
            {
                if(a[i]>a[i+1])
                {
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    swap=true;
                }
            }
            s=s+1;
        }
    }
    public void display()
    {
        System.out.println("Sorted Array:");
        for(int i:a)
        System.out.println(i+"\t");
    }
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        
        System.out.println("Enter the size of the array:");
        int n=in.nextInt();
        
        Cocktail_Sort ob=new Cocktail_Sort(n);
        ob.input();
        ob.sort();
        ob.display();
        
    }
}
