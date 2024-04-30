package pojos;

public class Links{
	private Object next;
	private String current;
	private Object previous;

	public Object getNext(){
		return next;
	}

	public String getCurrent(){
		return current;
	}

	public Object getPrevious(){
		return previous;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"next = '" + next + '\'' + 
			",current = '" + current + '\'' + 
			",previous = '" + previous + '\'' + 
			"}";
		}
}
