package Sorting;
import java.util.*;

class Insertion_sort
{
    int size;
    int a[];
    
    Scanner in=new Scanner(System.in);
    public Insertion_sort(int n)
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
        for(int i=1;i<size;i++)
        {
            int key=a[i];
            int j=i-1;
            
            while(j>=0&&a[j]>key)
            {
                a[j+1]=a[j];
                j=j-1;
            }
            a[j+1]=key;
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
        
        Insertion_sort ob=new Insertion_sort(n);
        ob.input();
        ob.sort();
        ob.display();
        
    }
}
