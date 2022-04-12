package Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name="create_at")
	private Date createAt;

	private String note;

	private int status;

	@Column(name="tatol_money")
	private double tatolMoney;

	//bi-directional many-to-one association to Oderdetail
	@OneToMany(mappedBy="order")
	private List<Oderdetail> oderdetails;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getTatolMoney() {
		return this.tatolMoney;
	}

	public void setTatolMoney(double tatolMoney) {
		this.tatolMoney = tatolMoney;
	}

	public List<Oderdetail> getOderdetails() {
		return this.oderdetails;
	}

	public void setOderdetails(List<Oderdetail> oderdetails) {
		this.oderdetails = oderdetails;
	}

	public Oderdetail addOderdetail(Oderdetail oderdetail) {
		getOderdetails().add(oderdetail);
		oderdetail.setOrder(this);

		return oderdetail;
	}

	public Oderdetail removeOderdetail(Oderdetail oderdetail) {
		getOderdetails().remove(oderdetail);
		oderdetail.setOrder(null);

		return oderdetail;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}