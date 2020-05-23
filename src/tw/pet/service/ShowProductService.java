package tw.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.pet.dao.ProductDao;
import tw.pet.model.shopping.ProductBean;
import tw.pet.model.shopping.ProductBeanImageData;

@Service
public class ShowProductService {
	@Autowired
	ProductDao dao;
	public List<ProductBeanImageData> Test(int categoryId){
		List<ProductBeanImageData> list = dao.getAllProductsImageDatasByCategory(categoryId);
		return list;
	}
}
