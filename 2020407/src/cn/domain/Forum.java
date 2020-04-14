package cn.domain;

/**
 * ��̳��ʵ����
 */
public class Forum {
       private Integer forum_id;    //��̳id
       private String forum_name;   //��̳����
       private String description;  //��̳����
       private String image;        //��̳ͼƬ
       
       public Forum(String forum_name, String description, String image) {
    	   this.forum_name = forum_name;
    	   this.description = description;
    	   this.image = image;
       }
       
       public Forum() {
    	   
       }

	public Integer getForum_id() {
		return forum_id;
	}

	public void setForum_id(Integer forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_name() {
		return forum_name;
	}

	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
       
    @Override
    public String toString() {
    	return "Forum{" +
               "forum_id=" + forum_id +
               ", forum_name=" + forum_name + '\'' +
               ", description='" + description + '\'' +
               ", image='" + image +'\'' +
               '}';
    }
}
