package enums;

public enum StatusEnum {
	NEW("新建立", 1), 
	END("結案", 2);
	// 成員變數
	private String status;
	private int index;
	// 構造方法
	private StatusEnum(String status, int index) {
		this.status = status;
		this.index = index;
	}

	public String getStatus() {
		return status;
	}
	public int getIndex() {
		return index;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
