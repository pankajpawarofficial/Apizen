package com.zensar.dashboard.Apizen.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.zensar.dashboard.Apizen.persistence.ApizenSequenceGenerator;

@Entity(name="dashboard_details")
public class DashboardBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dashboard_sequence")
	@GenericGenerator(
			name="dashboard_sequence",
			strategy="com.zensar.dashboard.Apizen.persistence.ApizenSequenceGenerator",
			parameters={
					@Parameter(name=ApizenSequenceGenerator.INCREMENT_PARAM,value="1"),
					@Parameter(name=ApizenSequenceGenerator.VALUE_PREFIX_PARAMETER, value="dashboard"),
					@Parameter(name=ApizenSequenceGenerator.NUMBER_FORMAT_PARAMETER, value="%d")
			}
			)
	@Column(name="dashboard_id")
	private String dashboardID;
	
	@Column(name="dashboard_name")
	private String dashboardName;
	
	@Column(name="username")
	private String username;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="grid_id",nullable=false)
	private GridBean gridBean;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="update_date")
	private Date updateDate;	

	public String getDashboardID() {
		return dashboardID;
	}

	public void setDashboardID(String dashboardID) {
		this.dashboardID = dashboardID;
	}

	public String getDashboardName() {
		return dashboardName;
	}

	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public GridBean getGridBean() {
		return gridBean;
	}

	public void setGridBean(GridBean gridBean) {
		this.gridBean = gridBean;
	}

	@Override
	public String toString() {
		return "DashboardBean [dashboardID=" + dashboardID + ", dashboardName=" + dashboardName + ", username="
				+ username + ", gridBean=" + gridBean + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}

	
	
	
}
