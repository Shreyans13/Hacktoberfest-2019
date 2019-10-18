package linkedClass;

class LinkX
{
	public int iData;
	public LinkX next;
	
	
	LinkX(int iData)
	{
		this.iData = iData;
		next = null;
	}
	
	public void display() 
	{
		System.out.println(iData);
	}
}


public class Link {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkX  l = new LinkX(5);
		LinkX  l2 = new LinkX(51);
		LinkX  l3 = new LinkX(52);
		
		l.next = l2;
		l2.next = l3;
		
		
	}

}
