package pojos;

public class Meta{
	private Pagination pagination;

	public Pagination getPagination(){
		return pagination;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"pagination = '" + pagination + '\'' + 
			"}";
		}
}
