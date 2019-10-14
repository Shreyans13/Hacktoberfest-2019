#include<stdio.h>
#include<conio.h>
#define SIZE 10  //defining SIZE constant 

//declaring the functions used in the function
void enQueue(int);
void deQueue();
void display();

int queue[SIZE], front = -1, rear = -1; 	

void main()
{
   int value, choice;
   while(1){
      printf("\n\n***** MENU *****\n");
      printf("1. Insertion\n2. Deletion\n3. Display\n4. Exit");
      printf("\nEnter your choice: ");
      scanf("%d",&choice);
      switch(choice){
	 case 1: printf("Enter the value to be insert: ");	
		 scanf("%d",&value);
		 enQueue(value);		// i.e. if choice is insertion, use enQueue function
		 break;
	 case 2: deQueue();
		 break;
	 case 3: display();
		 break;
	 case 4: exit(0);
	 default: printf("\nWrong selection!!! Try again!!!");
      }
   }
}
void enQueue(int value){			//Insertion function 
   if(rear == SIZE-1)
      printf("\nQueue is Full!!! Insertion is not possible!!!");
   else{
      rear++;						
      queue[rear] = value;
      printf("\nInsertion success!!!");
      if(front == -1)			//if we're entering the first value in the blank queue, then point front to 0 index value
        front = 0;
   }
}
void deQueue(){					//Deletion function
   if(front == -1)
      printf("\nQueue is Empty!!! Deletion is not possible!!!");
   else{
      printf("\nDeleted : %d", queue[front]);
      front++;
      if(front == rear)			//if we're deleting the last value and the stack is now empty, then set front and rear to -1 index
        front = rear = -1;
   }
}
void display(){				//Displaying queue function
   if(front == -1)
      printf("\nQueue is Empty!!!");
   else{
      int i;
      printf("\nQueue elements are:\n");
      for(i=front; i<=rear; i++)	//iterate from front to rear to access all the elements 
        printf("%d\t",queue[i]);
   }
}
