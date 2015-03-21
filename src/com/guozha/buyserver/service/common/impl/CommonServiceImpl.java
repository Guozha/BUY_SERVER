package com.guozha.buyserver.service.common.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guozha.buyserver.framework.sys.business.AbstractBusinessObjectServiceMgr;
import com.guozha.buyserver.persistence.beans.BasPaperGen;
import com.guozha.buyserver.persistence.mapper.BasPaperGenMapper;
import com.guozha.buyserver.service.common.CommonService;

@Transactional(rollbackFor = Exception.class)
@Service("commonService")
public class CommonServiceImpl extends AbstractBusinessObjectServiceMgr
		implements CommonService {
	
	@Autowired
	private BasPaperGenMapper basPaperGenMapper;
	
	private static String getTargetLengthStr(int no,int length){
		String str = String.valueOf(no);
		StringBuffer someZeroStr = new StringBuffer();
		for(int i=0;i<length-str.length();i++){
			someZeroStr.append("0");
		}
		return someZeroStr+str;
	}
	
	private  String buildPaperCode(BasPaperGen sysPaperGen){
		return sysPaperGen.getAreaCode()+sysPaperGen.getYear()+sysPaperGen.getMonth()+sysPaperGen.getDay()+getTargetLengthStr(sysPaperGen.getNo(),5);
	}
	
	private void addCodeGen(BasPaperGen sysPaperGen){
		basPaperGenMapper.insert(sysPaperGen);
	}
    
	private void updateCodeGen(BasPaperGen sysPaperGen){
    	basPaperGenMapper.update(sysPaperGen);
	}
	
	public String getPaperNo(String areaCode, String paperType){
		
    	BasPaperGen sysPaperGen = new BasPaperGen();
    	sysPaperGen.setAreaCode(areaCode);
    	sysPaperGen.setPaperType(paperType);
    	sysPaperGen.setYear(new SimpleDateFormat("yy").format(new Date()));
    	sysPaperGen.setMonth(new SimpleDateFormat("MM").format(new Date()));
    	sysPaperGen.setDay(new SimpleDateFormat("dd").format(new Date()));
    	
		BasPaperGen po = basPaperGenMapper.getOne(sysPaperGen);
		if(po==null){
			sysPaperGen.setNo(1);
			addCodeGen(sysPaperGen);
			return buildPaperCode(sysPaperGen);
		}else{
			sysPaperGen.setNo(Integer.valueOf(po.getNo().toString())+1);
			updateCodeGen(sysPaperGen);
			return buildPaperCode(sysPaperGen);
		}
	}

}
