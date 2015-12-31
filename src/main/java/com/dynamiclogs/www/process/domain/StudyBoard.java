package com.dynamiclogs.www.process.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class StudyBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sbSeq;
	
	@Column(name = "cc_seq", nullable = false)
	private int ccSeq;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	@Column(name = "finish_date", nullable = false)
	private Date finishDate;
	
	@Column(name = "reg_seq", nullable = true)
	private int	regSeq;
	
	@Column(name = "reg_date", nullable = false)
	private Date regDate;
	
	@Column(name = "upd_seq", nullable = true)
	private int updSeq;
	
	@Column(name = "upd_date", nullable = true)
	private Date updDate;
	
	public int getSbSeq() {
		return sbSeq;
	}
	public void setSbSeq(int sbSeq) {
		this.sbSeq = sbSeq;
	}
	public int getCcSeq() {
		return ccSeq;
	}
	public void setCcSeq(int ccSeq) {
		this.ccSeq = ccSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public int getRegSeq() {
		return regSeq;
	}
	public void setRegSeq(int regSeq) {
		this.regSeq = regSeq;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getUpdSeq() {
		return updSeq;
	}
	public void setUpdSeq(int updSeq) {
		this.updSeq = updSeq;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	
}
