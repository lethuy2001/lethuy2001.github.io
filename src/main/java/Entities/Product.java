package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_at")
	private Date createAt;

	private String image;

	private String name;

	private double price;

	private int quantity;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_at")
	private Date updateAt;

	//bi-directional one-to-one association to Cart
	@OneToOne(mappedBy="product")
	private Cart cart;

	//bi-directional many-to-one association to Oderdetail
	@OneToMany(mappedBy="product")
	private List<Oderdetail> oderdetails;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	//bi-directional many-to-one association to Size
	@ManyToOne
	private Size size;

	//bi-directional many-to-one association to Color
	@ManyToOne
	private Color color;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Oderdetail> getOderdetails() {
		return this.oderdetails;
	}

	public void setOderdetails(List<Oderdetail> oderdetails) {
		this.oderdetails = oderdetails;
	}

	public Oderdetail addOderdetail(Oderdetail oderdetail) {
		getOderdetails().add(oderdetail);
		oderdetail.setProduct(this);

		return oderdetail;
	}

	public Oderdetail removeOderdetail(Oderdetail oderdetail) {
		getOderdetails().remove(oderdetail);
		oderdetail.setProduct(null);

		return oderdetail;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}