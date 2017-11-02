package com.e_Look.ad;

import java.io.InputStream;
import java.util.List;

public class AdService {
	private AdDAO_interface dao;

	public AdService() {
		dao = new AdDAO();
	}

	public AdVO addAd(String fileName, InputStream adFile, Byte status) {
		AdVO AdVO = new AdVO();
		AdVO.setFileName(fileName);
		AdVO.setAdFile(adFile);
		AdVO.setStatus(status);
		return AdVO;
	}

	public AdVO getOneAd(Integer adID) {
		return dao.findByAdID(adID);
	}

	public List<AdVO> getAll() {
		return dao.getAll();
	}

	public void updateAd(AdVO AdVO) {
		dao.update(AdVO);
	}

	public List<AdVO> findByStatus() {
		return dao.findByStatus();
	}
}
