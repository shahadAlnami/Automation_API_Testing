package pojos;

public class DataItem{
	private String gender;
	private String name;
	private Integer id;
	private String email;
	private String status;

	public String getGender(){
		return gender;
	}

	public String getName(){
		return name;
	}

	public Integer getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"gender = '" + gender + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
