package com.api.daofab.model;

import java.io.Serializable;
import java.util.List;

/** DTO class for child data from json **/
public class ChildJsonDTO implements Serializable  {
	
	private List<ChildJsonObject> data;

	public List<ChildJsonObject> getData() {
		return data;
	}

	public void setData(List<ChildJsonObject> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		ChildJsonDTO other = (ChildJsonDTO) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChildJsonDTO [data=" + data + "]";
	}
}
