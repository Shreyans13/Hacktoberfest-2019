package Sorting;
import java.util.*;

class Merge_Sort
{
    int size;
    int a[];
    
    Scanner in=new Scanner(System.in);
    public Merge_Sort(int n)
    {
        size=n;
        a=new int[size];
    }
    public void input()
    {
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<size;i++)
        a[i]=in.nextInt();
        sort(a,0,a.length-1);
    }
    public void sort(int a[],int l,int r)
    {
        if(l<r)
        {
            int m=(l+r)/2;
            
            sort(a,l,m);
            sort(a,m+1,r);
            
            merge(a,l,m,r);
        }
    }
    public void merge(int a[],int l,int m,int r)
    {
        int n1=m+1-l;
        int n2=r-m;
        
        int X[]=new int [n1];
        int Y[]=new int [n2];
        
        for(int i=0;i<n1;i++)
        X[i]=a[i+l];
        for(int j=0;j<n2;j++)
        Y[j]=a[m+j+1];
        
        int i = 0,j = 0,k = l;  
        while (i < n1 && j < n2) 
        { 
            if (X[i] <= Y[j]) 
            { 
                a[k] = X[i]; 
                i++; 
            } 
            else
            { 
                a[k] = Y[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            a[k] = X[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            a[k] = Y[j]; 
            j++; 
            k++; 
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
        
        Merge_Sort ob=new Merge_Sort(n);
        ob.input();
        
        ob.display();
        
    }
}
