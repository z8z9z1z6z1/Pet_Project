package tw.pet.dao_impl.shopping;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.pet.dao.ProductDao;

import tw.pet.model.shopping.ProductBean;
import tw.pet.model.shopping.ProductBeanImageData;



@Repository
public class ProductDao_impl implements ProductDao  {
	
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	@Autowired
	ServletContext ctx;
	
	Integer id;
	
	
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	public ProductDao_impl() {
		
	}


	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	
	@Override
	public ProductBean selectOne(int ProductId) {	 
		ProductBean select = getSession().get(ProductBean.class,ProductId);
		return select;
	}
	

		
		
	
	@Override
	public  List<ProductBean> selectAll(){
		Query<ProductBean> selectAll= getSession().createQuery("from  ProductBean",ProductBean.class);
		
		return selectAll.list();
	}
	

	@Override
	public  List<ProductBean> selectCategory(int categoryId){
		Query<ProductBean> selectCate = getSession().createQuery("from ProductBean  where categoryId=:categoryId",ProductBean.class);
	
		return selectCate.list();
	}
	
	//用銷售金額去選擇
	
	@Override
	public List<ProductBean> selectSales(){
		String hql ="from ProductBean order by sales desc";
		Query<ProductBean> selectSales= getSession().createQuery(hql,ProductBean.class);
		 
		return selectSales.list();
	}
	
	//用名稱去選擇
	
	@Override
	public List<ProductBean> selectName(String name){
		String hql = "from ProductBean where name =:name";
		Query<ProductBean> query = getSession().createQuery(hql, ProductBean.class);
		
		return query.list();
	}
	 
	//用價格去選  從高到低
	
	@Override
	public List<ProductBean> selectPriceUp(){
		String hql ="from ProductBean order by price desc";
		Query<ProductBean> query = getSession().createQuery(hql, ProductBean.class);
		
		return query.list();
	}
	//用價格去選  從低到高
	
	@Override
	public List<ProductBean> selectPriceDown(){
		String hql ="from ProductBean order by price asc";
		Query<ProductBean> query = getSession().createQuery(hql, ProductBean.class);
		
		return query.list();
	}
	
	
	//取得總商品數目
	
	@Override
	public long getRecordCounts() {
		String hql ="select count(*) from ProductBean";
		long count=0;
		 Query<?> query = getSession().createQuery(hql);
		 Object singleResult = query.getSingleResult();
		 count=(long)singleResult;
		
		return  count;
		
	}
	
	
	@Override
	public String insert(ProductBean productBean) {
//		ProductBean pBean = getSession().get(ProductBean.class, productBean.getProductId());
		if(productBean!=null ) {
			getSession().save(productBean);
			return productBean.getName()+"商品已成功新增 ";
		}else {
			return "新增失敗";
		}
		
	}
	//取得ArrayList
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProductBean> getAllProductsJson()  {
		List<ProductBean> list = new ArrayList<>();
		String hql = "FROM ProductBean";
		
		list = getSession().createQuery(hql).getResultList();
		return  list;
	}
	
	
	@Override
//	@SuppressWarnings("unchecked")
	public List<ProductBeanImageData> getAllProductsImageDatas( ){
		
//		List<ProductBean> listSource2 = getSession().createQuery(hql).setParameter("id", categoryId).getResultList();
		List<ProductBean> listSource = getSession().createQuery("from  ProductBean",ProductBean.class).getResultList();
		List<ProductBeanImageData> listTarget=new ArrayList<>();
		for(ProductBean bean:listSource) {
			listTarget.add(addImageData(bean));
		}
		return listTarget;
	}
	
	//由分類取得有照片的產品
	@Override
	@SuppressWarnings("unchecked")
	public List<ProductBeanImageData> getAllProductsImageDatasByCategory(Integer categoryId){
		String hql = "FROM ProductBean WHERE categoryId = :categoryId";
		List<ProductBean> listSource = getSession().createQuery(hql).setParameter("id", categoryId).getResultList();
		
		List<ProductBeanImageData> listTarget=new ArrayList<>();
		for(ProductBean bean:listSource) {
			listTarget.add(addImageData(bean));
		}
		return listTarget;
	}
	
	
	
	//由ID取得有照片的產品
		@SuppressWarnings("unchecked")
		@Override
		public List<ProductBeanImageData> getAllProductsImageDatasByID(Integer productId){
			String hql = "FROM ProductBean WHERE productId = :productId";
			List<ProductBean> listSource = getSession().createQuery(hql).setParameter("id", productId).getResultList();
			
			List<ProductBeanImageData> listTarget=new ArrayList<>();
			for(ProductBean bean:listSource) {
				listTarget.add(addImageData(bean));
			}
			return listTarget;
		}
	
	
	public ProductBeanImageData addImageData(ProductBean bean) {
		ProductBeanImageData pbid = null ;
		try {
			StringBuffer sb = new StringBuffer();
			String fileName = bean.getFileName();
			String mimeType = ctx.getMimeType(fileName);
			Blob blob = bean.getCoverImage();
			byte[] bytes = blob.getBytes(1, (int) blob.length());
			String prefix = "data:" + mimeType + ";base64,";
			sb.append(prefix);
			Base64.Encoder be = Base64.getEncoder();
			String str = new String(be.encode(bytes));
			sb.append(str);
			String iamgeData = sb.toString();
			pbid = new ProductBeanImageData(bean, iamgeData);
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return pbid;	
	}



	
}
