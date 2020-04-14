package cn.domain;

import java.sql.Timestamp;

public class Post {
	private Integer post_id;
	private Integer forum_id;
	private String title;
	private String content;
	private byte[] thumbnail;
	private Timestamp post_time;
	private String account;
	
	public Post() {}
	public Post(Integer forum_id,String title,String content,byte[] thumbnail,Timestamp post_time,String account) {
		this.forum_id=forum_id;
		this.title=title;
		this.content=content;
		this.thumbnail=thumbnail;
		this.post_time=post_time;
		this.account=account;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	public Integer getForum_id() {
		return forum_id;
	}
	public void setForum_id(Integer forum_id) {
		this.forum_id = forum_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte[] getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Timestamp getPost_time() {
		return post_time;
	}
	public void setPost_time(Timestamp post_time) {
		this.post_time = post_time;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", forum_id=" + forum_id + ", title=" + title + 
				", content=" + content + ", post_time=" + post_time +", account=" + account+ "]"+"\n";
	}
	

}
