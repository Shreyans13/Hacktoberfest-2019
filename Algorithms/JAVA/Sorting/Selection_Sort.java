package Sorting;

import java.util.*;

class Selection_Sort
{
    int size;
    int a[];
    
    Scanner in=new Scanner(System.in);
    public Selection_Sort(int n)
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
        for(int i=0;i<size-1;i++)
        {
            
            int s=i;
            for(int j=i+1;j<size;j++)
            if(a[j]<a[s]) 
                s=j;
            
            int temp=a[s];
            a[s]=a[i];
            a[i]=temp;
            
            
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
        
        Selection_Sort ob=new Selection_Sort(n);
        ob.input();
        ob.sort();
        ob.display();
        
    }
}
