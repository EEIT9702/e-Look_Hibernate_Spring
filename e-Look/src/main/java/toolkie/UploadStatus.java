package toolkie;

public class UploadStatus {
    //已上傳位元組數
	private long bytesRead;
	//所有檔案的總長度
	private long contentLength;
	//正在上傳第幾個檔案
	//private int items;

	//開始上傳時間 計算時間用
	private long startTime = System.currentTimeMillis();

	public long getBytesRead() {
		return bytesRead;
	}

	public void setBytesRead(long bytesRead) {
		this.bytesRead = bytesRead;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

//	public int getItems() {
//		return items;
//	}
//
//	public void setItems(int items) {
//		this.items = items;
//	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

}
