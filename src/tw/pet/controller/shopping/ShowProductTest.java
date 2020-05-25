package tw.pet.controller.shopping;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.gson.Gson;
import com.mchange.v2.cfg.PropertiesConfigSource.Parse;


import tw.pet.dao.ProductDao;
import tw.pet.model.shopping.ProductBean;
import tw.pet.model.shopping.ProductBeanImageData;
import tw.pet.service.ShowProductService;

@Controller
public class  ShowProductTest{
	@Autowired
	SessionFactory session;
	@Autowired
	ProductDao dao;
	@Autowired
	ShowProductService ShowProductService;
	
	@Autowired
	ServletContext context;
	
	@GetMapping(value = "/allProductNoImage", produces= {"application/json"} )
	public ResponseEntity<List<ProductBean>> allProductNoImage() {
//	public String test() {
		System.out.println("進入controller");
		System.out.println("test");
		List<ProductBean> selectAll = dao.selectAll();
		ResponseEntity<List<ProductBean>> re  = new ResponseEntity<>(selectAll, HttpStatus.OK);
//		System.out.println(re);
		
		return re;
	}
	
	@GetMapping(value = "/allProductWithImage", produces= {"application/json"} )
	public ResponseEntity<List<ProductBeanImageData>> allProductWithImage() {
//	public String test() {
		System.out.println("進入controller");
		System.out.println("test");
		List<ProductBeanImageData> list = dao.getAllProductsImageDatas();
		ResponseEntity<List<ProductBeanImageData>> re  = new ResponseEntity<>(list, HttpStatus.OK);
//		System.out.println(re);
		
		return re;
	}
	
//	@GetMapping(value = "/OutputLineChart", produces= {"application/json"} )
//	public ResponseEntity<List<LChartBean>> OutputLineChart(@RequestParam String yearmonths, Model model) {
//		List<LChartBean> list = commentServiceIMPL.getLineChart(yearmonths);
//		ResponseEntity<List<LChartBean>> re  = new ResponseEntity<>(list, HttpStatus.OK);
//		return re;
//	}

		@PostMapping("/showProductByCategory")
		public String showProductByCategory(Model m,HttpServletRequest request,@RequestParam("categoryId") Integer categoryId ) {
//			System.out.println("進categoryId_#showProductByCategory");
//			System.out.println("傳入資料狀況:"+categoryId);	
			List<ProductBean> list = dao.selectCategory(categoryId);
			m.addAttribute("productList", list);
//			System.out.println("categoryId="+categoryId);
//			System.out.println("list"+list);
//			System.out.println("list"+list.get(0).getBiPhoto());
			return "showProduct";
		}
	
	
	
	
}
