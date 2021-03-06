package cn.domain;

public class Forum {
	private Integer forum_id;
	private String forum_name;
	private String description;
	private String image;
	
	public Forum() {
	}
	
	public Forum(String forum_name,String description,String image) {
		this.forum_name=forum_name;
		this.description=description;
		this.image=image;
	}
	
	public Integer getForum_id() {
		return forum_id;
	}
	public void setForum_id(Integer forum_id) {
		this.forum_id = forum_id;
	}
	public String getName() {
		return forum_name;
	}
	public void setName(String name) {
		this.forum_name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desciription) {
		this.description = desciription;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Forum [forum_id=" + forum_id + ", forum_name=" + forum_name + ", desciription=" + description + ", image=" + image+ "]"+"\n";
	}
	

	
}
