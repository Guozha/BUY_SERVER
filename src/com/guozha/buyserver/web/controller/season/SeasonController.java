package com.guozha.buyserver.web.controller.season;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guozha.buyserver.service.season.SeasonService;
import com.guozha.buyserver.web.controller.BaseController;

@Controller
@RequestMapping(value="/season")
public class SeasonController extends BaseController {
	@Autowired
	private SeasonService seasonService;
	
	/**
	 * 查询节气食材
	 * @param response
	 */
	@RequestMapping(value="/list")
	public void list(HttpServletResponse response){
		
		 Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();  
		 
		 String jsonStr = gson.toJson(seasonService.find());
		 System.out.println("转前："+jsonStr);
		 Map<SeasonResponse, List<SeasonGoodsResponse>> map = new LinkedHashMap<SeasonResponse, List<SeasonGoodsResponse>>();
		 map = gson.fromJson(jsonStr, new TypeToken<Map<SeasonResponse, List<SeasonGoodsResponse>>>() {  }.getType());
		 
		 String jsonStr2 = "[[{'season':'01','seasonPicUrl':'1.jpg'},[{'goodsId':1,'goodsName':'青菜','memo':'小青菜：又名小白菜，又名不结球白菜、青菜、油菜。小青菜是蔬菜中含矿物质和维生素最丰富的菜。'}," +
		 		"{'goodsId':2,'goodsName':'西红柿','memo':'番茄营养丰富，富含丰富番茄红素。有助于延缓衰老、增强抗辐射能力、调节血脂；还具有减肥瘦身、消除疲劳、增进食欲、提高对蛋白质的消化、减少胃胀食积等功效'}," +
		 		"{'goodsId':3,'goodsName':'细茄子','memo':'清热解毒、治疗冻疮、茄子有良好降低高血脂，高血压功效；保护心血管、抗坏血酸、防治胃癌、抗衰老、抗癌'}," +
		 		"{'goodsId':4,'goodsName':'黄瓜','memo':'黄瓜富含蛋白质、糖类、维生素B2、维生素C、维生素E、胡萝卜素、尼克酸、钙、磷、铁等营养成分。另外，黄瓜还可美容：黄瓜平和除湿，可以收敛和消除皮肤皱纹，对皮肤较黑的人效果尤佳。'},{'goodsId':5,'goodsName':'花菜','memo':'是一种粗纤维含量少，品质鲜嫩，营养丰富，风味鲜美。食用可增强抵抗力，促进生长发育，维持牙齿、骨骼和身体的正常功能'}]],[{'season':'02','seasonPicUrl':'2.jpg'},[{'goodsId':6,'goodsName':'菜椒','memo':'营养价值高，富含维生素C和碳水化合物。能增进食欲，帮助消化，促进肠蠕动，防止便秘，对减少皮肤皱纹弹性和保持皮肤丰润都有一定的效果。'},{'goodsId':7,'goodsName':'土豆','memo':'土豆中含有丰富的膳食纤维，有助促进胃肠蠕动，疏通肠道。土豆是非常好的高钾低钠食品，很适合水肿型肥胖者食用，加上其钾含量丰富，几乎是蔬菜中最高的，所以还具有瘦腿的功效。'}," +
		 		"{'goodsId':8,'goodsName':'冬笋','memo':'冬笋是一种富有营养价值,质嫩味鲜,清脆爽口,含有丰富的蛋白质和多种氨基酸、维生素,以及钙、磷、铁等微量元素以及丰富的纤维素，能促进肠道蠕动'}," +
		 		"{'goodsId':9,'goodsName':'五花肉','memo':'猪肉纤维较为细软，肌肉组织中含有较多的肌间脂肪，因此，经过烹调加工后肉味特别鲜美。'}," +
		 		"{'goodsId':10,'goodsName':'后腿肉','memo':'猪肉纤维较为细软，肌肉组织中含有较多的肌间脂肪，因此，经过烹调加工后肉味特别鲜美。'}]]," +
		 		"[{'season':'03','seasonPicUrl':'3.jpg'},[{'goodsId':11,'goodsName':'大排','memo':'猪大排的营养价值除含蛋白、脂肪、维生素外，还含有大量磷酸钙、骨胶原、骨粘蛋白等，可为幼儿和老人提供钙质。猪大排营养价值很高，具有滋阴壮阳、益精补血的功效。熬汤来放上葱，和一些相应的调味料，煮过后非常美味，也很有营养。'}," +
		 		"{'goodsId':12,'goodsName':'猪腰/腰花（对）','memo':'具有补肾气、通膀胱、消积滞、止消渴之功效。'}," +
		 		"{'goodsId':13,'goodsName':'猪肝','memo':'增强人体的免疫反应，抗氧化、防衰老。'},{'goodsId':14,'goodsName':'牛肉（腿肉）','memo':'牛肉蛋白质含量高，而脂肪含量低，所以味道鲜美，受人喜爱，享有“肉中骄子”的美称'}," +
		 		"{'goodsId':15,'goodsName':'牛排','memo':'补血益气'}]]]";
		 // map = gson.fromJson(jsonStr2,  new TypeToken<Map<SeasonResponse, List<SeasonGoodsResponse>>>() {  }.getType());
		 // Gson g2 = new Gson();
		 // SeasonResponse list = g2.fromJson(jsonStr2,  SeasonResponse.class);
		 // System.out.println(list);
		
		responseJson(seasonService.find(), response);
	}

}
