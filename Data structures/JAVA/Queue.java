package queue;

class QueueX
{
	private int maxSize;
	private int queueArray[];
	private int front;
	private int rear;
	private int nItems;
	
	
	public QueueX(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.queueArray = new int[maxSize];
		this.front = 0;
		this.rear = -1;
		this.nItems = 0;
	}
	
	public void insert(int s)
	{
		if(rear == (maxSize - 1))
		{
			System.out.println("FULL");
		}
		else 
		{
			queueArray[++rear] = s;
			nItems++;
		}
	}
	
	
	public int remove() {
		if(nItems == 0)
		{
			System.out.println("Empty");
			return 0;
		}else 
		{
			nItems--;
			return queueArray[front++];
		}
	}
	
	public int peekFront() {
		if(nItems == 0)
		{
			System.out.println("Empty");
			return 0;
		}else 
		{
			nItems--;
			return queueArray[front];
		}
	}
	


}





public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueX q = new QueueX(5);
		q.insert(10);
		q.insert(20);
		q.insert(30);
		q.insert(40);
		q.remove();
		q.peekFront();
		
	}

}
