package tw.pet.model.shopping;




import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Component
@Table(name = "OrderDetail")
public class OrderDetailBean {
	
	private Integer seqno;
	private Integer orderId;
	private	Integer productId;
	private String description;
	private Integer quantity;
	private Double unitPrice;
	private Double discount;
	
	public OrderDetailBean() {
		
	}
	
	public OrderDetailBean( Integer productId, String description, Integer quantity,
			Double unitPrice, Double discount) {
		
	
	
		this.productId = productId;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	@Column(name = "orderId")
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Column(name = "productId")
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Column(name = "unitPrice")
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Column(name = "discount")
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	
	
}
