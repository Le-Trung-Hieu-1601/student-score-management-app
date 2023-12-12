package model;

import java.io.Serializable;
import java.util.ArrayList;

public class QLSVModel  {
  private ArrayList<ThiSinh> dsThiSinh;
  private String luaChon;
  private String tenFile;
  public QLSVModel()
  {
	  this.dsThiSinh=new ArrayList<ThiSinh>();
	  this.luaChon="";
	  this.tenFile="";
  }

public String getTenFile() {
	return tenFile;
}

public void setTenFile(String tenFile) {
	this.tenFile = tenFile;
}

public String getLuaChon() {
	return luaChon;
}

public void setLuaChon(String luaChon) {
	this.luaChon = luaChon;
}

public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
	
	this.dsThiSinh = dsThiSinh;
}

public ArrayList<ThiSinh> getDsThiSinh() {
	return dsThiSinh;
}

public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
	this.dsThiSinh = dsThiSinh;
}
  public void insert(ThiSinh thiSinh) {
	  this.dsThiSinh.add(thiSinh);
  }
  public void delete(ThiSinh ts) {
	 
	this.dsThiSinh.remove(ts);
	
	  
  }
  public void update(ThiSinh thiSinh) {
	  this.delete(thiSinh);
	  this.insert(thiSinh);
  }

  public boolean kiemTraTonTai(ThiSinh ts) {
		for(ThiSinh thiSinh: dsThiSinh) {
			if(thiSinh.getMaThiSinh() == ts.getMaThiSinh())
				return true;
		}
		return false;
	}
	
 
  
  
  
}
