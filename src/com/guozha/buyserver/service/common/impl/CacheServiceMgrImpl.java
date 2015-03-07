package com.guozha.buyserver.service.common.impl;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.service.common.CacheServiceMgr;
import com.guozha.buyserver.common.util.ParameterUtil;
import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class)
@Service("cacheServiceMgr")
public class CacheServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements CacheServiceMgr {
	
	@SuppressWarnings("unchecked")
	@Override
	public void cacheConstantData() {
		
		Map<String, Map<String, String>> constantCache = ParameterUtil.getConstantCache();
		constantCache.clear();
		
		String constantFilePath = (CacheServiceMgrImpl.class.getResource("/").getPath()).replace("classes/", "")+"etc/conf/constant.xml";
		try {
			Document doc = new SAXReader().read(constantFilePath);
			Element rootEle = doc.getRootElement();
			List<Element> constantEleList = rootEle.elements();
			for(Element constantEle : constantEleList){
				String constantDef = constantEle.attributeValue("constantDef");
				List<Element> constantNameEleList = constantEle.elements();
				
				for(Element constantNameEle : constantNameEleList){
					String constantValue = constantNameEle.attributeValue("value");
					String constantName = constantNameEle.getText();
					
					ParameterUtil.cacheConstantData(constantDef, constantValue, constantName);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
