package pojos;

public class Category{
	private String name;
	private Integer id;

	public String getName(){
		return name;
	}

	public Integer getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Category{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
