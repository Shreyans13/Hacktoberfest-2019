package Sorting;
import java.util.*;

class Bubble_Sort
{
    int size;
    int a[];
    
    Scanner in=new Scanner(System.in);
    public Bubble_Sort(int n)
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
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size-1-i;j++)
            {
                if(a[j]>a[j+1])
                {
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
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
        
        Bubble_Sort ob=new Bubble_Sort(n);
        ob.input();
        ob.sort();
        ob.display();
        
    }
}
