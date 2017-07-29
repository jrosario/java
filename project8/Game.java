package Project;

public class Game {
	//field
	private String title;
	private String designer;
	private String publisher;
	private String category;
	private Integer prodNum;
	public Game(){
		
	}
	
	public Game(Integer prodNum, String title, String designer, String publisher, String category) {
		super();
		this.prodNum = prodNum;
		this.title = title;
		this.designer = designer;
		this.publisher = publisher;
		this.category = category;
	}
	public Integer getProdNum() {
		return prodNum;
	}
	public void setProdNum(Integer prodNum) {
		this.prodNum = prodNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
