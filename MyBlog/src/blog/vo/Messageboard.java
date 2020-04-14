package blog.vo;

import java.util.Date;

public class Messageboard {
	    private String name;
        private int id;
        private String content;
        private String reply;
        private Date time;
        public String getName() {
        	return name;
        }
        public void setName(String name) {
        	this.name = name;
        }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getReply() {
			return reply;
		}
		public void setReply(String reply) {
			this.reply = reply;
		}
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		
}
