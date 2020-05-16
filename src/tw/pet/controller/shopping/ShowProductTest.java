package tw.pet.controller.shopping;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tw.pet.dao.ProductDao;
import tw.pet.model.shopping.ProductBean;
import tw.pet.model.shopping.ProductBeanImageData;

@Controller
public class ShowProductTest {
	@Autowired
	SessionFactory session;
	@Autowired
	ProductDao dao;
	
	@Autowired
	ServletContext context;
	
	@GetMapping(value = "/allProductNoImage", produces= {"application/json"} )
	public ResponseEntity<List<ProductBeanImageData>> allProductNoImage() {
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

	
	
	
	
}
