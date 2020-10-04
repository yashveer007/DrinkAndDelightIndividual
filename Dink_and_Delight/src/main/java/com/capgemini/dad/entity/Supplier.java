package com.capgemini.dad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Supplier_Details")
@Table(name="Supplier_Details")
public class Supplier{
	

		@Id
		@Column(name="Supplier_Id")
		private Long supplierId;
		
		@Column(name="SupplierName")
		private String supplierName;
		
		@Column(name="address")
		private String address;
		
		@Column(name="phone")
		private String phoneNumber;

		public Long getSupplierId() {
			return supplierId;
		}

		public void setSupplierId(Long supplierId) {
			this.supplierId = supplierId;
		}

		public String getSupplierName() {
			return supplierName;
		}

		public void setSupplierName(String supplierName) {
			this.supplierName = supplierName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Supplier(Long supplierId, String supplierName, String address, String phoneNumber) {
			super();
			this.supplierId = supplierId;
			this.supplierName = supplierName;
			this.address = address;
			this.phoneNumber = phoneNumber;
		}

		@Override
		public String toString() {
			return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", address=" + address
					+ ", phoneNumber=" + phoneNumber + "]";
		}
		
		public Supplier() {
			
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
			result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
			result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
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
			Supplier other = (Supplier) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (phoneNumber == null) {
				if (other.phoneNumber != null)
					return false;
			} else if (!phoneNumber.equals(other.phoneNumber))
				return false;
			if (supplierId == null) {
				if (other.supplierId != null)
					return false;
			} else if (!supplierId.equals(other.supplierId))
				return false;
			if (supplierName == null) {
				if (other.supplierName != null)
					return false;
			} else if (!supplierName.equals(other.supplierName))
				return false;
			return true;
		}
		
		
}