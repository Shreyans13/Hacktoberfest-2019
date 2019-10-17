package queue;

class CircularQueue
{
	private int maxSize;
	private int queueArray[];
	private int front;
	private int rear;
	private int nItems;
	
	
	public CircularQueue(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.queueArray = new int[maxSize];
		this.front = 0;
		this.rear = -1;
		this.nItems = 0;
	}
	
	public void insert(int s)
	{
		if(nItems == maxSize) 
		{
			System.out.println("Full");
		}else 
		{
			nItems++;
			if(rear == (maxSize - 1))
			{
				rear = -1;
			}
			queueArray[++rear] = s;
		}
	}
	
	
	public int remove() {
		if(nItems == 0) 
		{
			System.out.println("Empty");
		}else 
		{
			nItems--;
			int temp = queueArray[front];
			if(front == (maxSize - 1)) 
			{
				front = 0;
			}else {
				front ++;
				
			}
			
		}
		return temp;
	}

	


}





public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularQueue circularQueue = new CircularQueue(5);
		circularQueue.insert(19);
		circularQueue.insert(50);
		circularQueue.insert(33);
		circularQueue.insert(45);
		circularQueue.remove();
    circularQueue.remove();
    
		
	}

}
