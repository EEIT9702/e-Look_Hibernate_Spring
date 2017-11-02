package toolkie;

import org.apache.commons.fileupload.ProgressListener;

public class UploadListener implements ProgressListener {

	// 紀錄上傳資訊的java Bean
	private UploadStatus status;

	// 建構函數
	public UploadListener(UploadStatus status) {
		this.status = status;
	}

	//上傳原件呼叫該方法
	public void update(long bytesRead, long contentLength, int items) {
		
		status.setBytesRead(bytesRead);//以讀取的資料長度
		status.setContentLength(contentLength);//檔案的總長度
		//status.setItems(items);//正在儲存地幾個檔案
	}
}
