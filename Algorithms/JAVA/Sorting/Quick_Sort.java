package Sorting;
import java.util.*;

class Quick_Sort
{
    int size;
    int a[];
    
    public Quick_Sort(int n)
    {
        size=n;
        a=new int[size];
    }
    public void input()
    {
    	Scanner in=new Scanner(System.in);
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<size;i++)
        a[i]=in.nextInt();
        sort(a,0,a.length-1);
    }
    public void sort(int a[],int l,int h)
    {
        if(l<h)
        {
            
            int pi=quick(a,l,h);

            sort(a,l,pi-1);
            sort(a,pi+1,h);
            
        }
    }
    public int quick(int a[],int l,int h)
    {
        int pivot=a[h];
        int i=l-1;
        for(int j=l;j<h;j++){
            if(a[j]<pivot){
                i++;

                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[i+1];
        a[i+1]=a[h];
        a[h]=temp;

        return i+1;

    }
    public void display()
    {
        System.out.println("Sorted Array:");
        for(int i:a)
        System.out.println(i+"\t");
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        
        System.out.println("Enter the size of the array:");
        int n=in.nextInt();
        
        Quick_Sort ob=new Quick_Sort(n);
        ob.input();
        
        ob.display();
        
    }
}
