package com.relanto.chandanaMnEMS.entity;
import com.relanto.chandanaMnEMS.entity.City;
import com.relanto.chandanaMnEMS.entity.Department;
import java.sql.Date;
//import javax.persistence.*;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
 
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	private String employeeName;
	private String employeeMobile;
	private String employeeEmail;
	@Temporal(TemporalType.DATE)
	private Date employeeDob;
	private Long employeeCityId;
	private Long employeeDepartmentId;
	private String cityName;
    private String cityCode;
    private String departmentName;
	// Constructors
	public Employee() {
	}    
//
//	public Employee(Long employeeId, String employeeName, String employeeMobile, String employeeEmail, Date employeeDob,
//			Long employeeCityId, Long employeeDepartmentId) {
//		this.employeeId = employeeId;
//		this.employeeName = employeeName;
//		this.employeeMobile = employeeMobile;
//		this.employeeEmail = employeeEmail;
//		this.employeeDob = employeeDob;
//		this.employeeCityId = employeeCityId;
//		this.employeeDepartmentId = employeeDepartmentId;
//
//	}
	  public Employee(Long employeeId, String employeeName, String employeeMobile, String employeeEmail, Date employeeDob,
	            Long employeeCityId, Long employeeDepartmentId, String cityName, String cityCode,String departmentName) {
	        this.employeeId = employeeId;
	        this.employeeName = employeeName;
	        this.employeeMobile = employeeMobile;
	        this.employeeEmail = employeeEmail;
	        this.employeeDob = employeeDob;
	        this.employeeCityId = employeeCityId;
	        this.employeeDepartmentId = employeeDepartmentId;
	        this.cityName = cityName;
	        this.cityCode = cityCode;
	        this.departmentName=departmentName;
	    }
 
	
	public Long getEmployeeId() {
		return employeeId;
	}
 
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
 
	public String getEmployeeName() {
		return employeeName;
	}
 
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
 
	public String getEmployeeMobile() {
		return employeeMobile;
	}
 
	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}
 
	public String getEmployeeEmail() {
		return employeeEmail;
	}
 
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
 
	public Date getEmployeeDob() {
		return employeeDob;
	}
 
	public void setEmployeeDOB(Date employeeDob) {
		this.employeeDob = employeeDob;
	}
 
	public Long getEmployeeCityId() {
		return employeeCityId;
	}
 
	public void setEmployeeCityId(Long employeeCityId) {
		this.employeeCityId = employeeCityId;
	}
 
	public Long getEmployeeDepartmentId() {
		return employeeDepartmentId;
	}
 
	public void setEmployeeDepartmentId(Long employeeDepartmentId) {
		this.employeeDepartmentId = employeeDepartmentId;
	}
	 public String getCityName() {
	        return cityName;
	    }
 
	    public void setCityName(String cityName) {
	        this.cityName = cityName;
	    }
 
	    public String getCityCode() {
	        return cityCode;
	    }
 
	    public void setCityCode(String cityCode) {
	        this.cityCode = cityCode;
	    }
	    public String getDepartmentName() {
			return departmentName;
		}
		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}
 
}
