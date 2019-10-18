package stackpackage;

class stackX
{
	private double[] stackArray;
	private int maxSize;
	private int top;
	
	public stackX(int maxSize) {
		super();
		this.maxSize = maxSize;
		stackArray = new double[maxSize];
		
		this.top = -1;
	}
	
	
	public void push(int num)
	{
		if(top == maxSize - 1) 
		{
			System.out.println("fail to add");
		}
		else {
			top++;
			stackArray[top] = num;
		}
	}
	
	
	public double pop() 
	{
		if(top == -1) 
		{
			System.out.println("Empty ");
			return 0;
		}else 
		{
			return stackArray[top--];
		}
	}
	
	
	public double peek() 
	{
		if(top == -1) 
		{
			System.out.println("Empty ");
			return 0;
		}else 
		{
			return stackArray[top];
		}
	}
	
	
	
	
	
}


public class StackX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stackX stack = new stackX(5);
		stack.push(20);
		stack.push(40);
		stack.push(90);
		stack.pop();
		stack.peek();
		
	}

}
