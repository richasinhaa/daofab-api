package com.api.daofab.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

/** Parent table **/

@Entity
@Table(name = "parent")
@EntityListeners(AuditingEntityListener.class)
public class Parent implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String sender;
	
	private String receiver;
	
	private Long totalAmount;
	
	private Long totalPaidAmount;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "parentId")
	private List<Child> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	/** Get Total Paid Amount **/
	public Long getTotalPaidAmount() {
		Long total = 0L;
		List<Child> ch = this.getChildren();
		for(Child c : ch) {
			total = total+c.getPaidAmount();
		}
		
		return total;
	}
	
	/** Set Total Paid Amount **/
	public void setTotalPaidAmount(Long totalPaidAmount) {
		Long total = 0L;
		List<Child> ch = this.getChildren();
		for(Child c : ch) {
			total = total+c.getPaidAmount();
		}
		
		this.totalPaidAmount = total;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result + ((totalPaidAmount == null) ? 0 : totalPaidAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (totalPaidAmount == null) {
			if (other.totalPaidAmount != null)
				return false;
		} else if (!totalPaidAmount.equals(other.totalPaidAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", totalAmount=" + totalAmount
				+ ", totalPaidAmount=" + totalPaidAmount + ", children=" + children + "]";
	}
}
