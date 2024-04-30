package pojos;

public class Pagination{
	private Integer total;
	private Integer pages;
	private Integer limit;
	private Links links;
	private Integer page;

	public Integer getTotal(){
		return total;
	}

	public Integer getPages(){
		return pages;
	}

	public Integer getLimit(){
		return limit;
	}

	public Links getLinks(){
		return links;
	}

	public Integer getPage(){
		return page;
	}

	@Override
 	public String toString(){
		return 
			"Pagination{" + 
			"total = '" + total + '\'' + 
			",pages = '" + pages + '\'' + 
			",limit = '" + limit + '\'' + 
			",links = '" + links + '\'' + 
			",page = '" + page + '\'' + 
			"}";
		}
}
