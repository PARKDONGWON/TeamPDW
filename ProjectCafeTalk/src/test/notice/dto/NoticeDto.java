package test.notice.dto;

public class NoticeDto {
	private int num;
	private String writer;
	private String title;
	private String smallTitle;
	private String content;
	private int viewCount;
	private String regdate;
	private int startRowNum;
	private int endRowNum;
	
	public NoticeDto() {}

	public NoticeDto(int num, String writer, String title, String smallTitle, String content, int viewCount,
			String regdate, int startRowNum, int endRowNum) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.smallTitle = smallTitle;
		this.content = content;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSmallTitle() {
		return smallTitle;
	}

	public void setSmallTitle(String smallTitle) {
		this.smallTitle = smallTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	
	
}