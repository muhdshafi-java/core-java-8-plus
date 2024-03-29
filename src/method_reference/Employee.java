package method_reference;

public class Employee {

	private String name;
	private String id;
	private String designation;

	Employee(String name, String id, String designation) {
		this.name = name;
		this.id = id;
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + id + ", " + designation + "]";
	}

}
