package tintuc.rest.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.dnict.tintuc.model.News_Categories;

public class TinTucData {
	private Long id;
	private Long typeId;
	private String title;
	private String info;
	private String content;
	private List<ChuyenMucData> chuyenmuc;
	private List<DinhKemData> filedinhkem;
	private String language;
	private String urlimagesmall;
	private Long luotxem;
	private Long isnoibat;
	private String ngayxuatban;
	private String ngayketthuc;
	private Long nguontin;
	private String congtacvien;
	private String tukhoa;
	private int loaitintuc;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public List<ChuyenMucData> getChuyenmuc() {
		return chuyenmuc;
	}
	public void setChuyenmuc(List<ChuyenMucData> chuyenmuc) {
		this.chuyenmuc = chuyenmuc;
	}
	
	public List<DinhKemData> getFiledinhkem() {
		return filedinhkem;
	}
	public void setFiledinhkem(List<DinhKemData> filedinhkem) {
		this.filedinhkem = filedinhkem;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getUrlimagesmall() {
		return urlimagesmall;
	}
	public void setUrlimagesmall(String urlimagesmall) {
		this.urlimagesmall = urlimagesmall;
	}
	public Long getLuotxem() {
		return luotxem;
	}
	public void setLuotxem(Long luotxem) {
		this.luotxem = luotxem;
	}
	public Long getIsnoibat() {
		return isnoibat;
	}
	public void setIsnoibat(Long isnoibat) {
		this.isnoibat = isnoibat;
	}
	public String getNgayxuatban() {
		return ngayxuatban;
	}
	public void setNgayxuatban(String ngayxuatban) {
		this.ngayxuatban = ngayxuatban;
	}
	public String getNgayketthuc() {
		return ngayketthuc;
	}
	public void setNgayketthuc(String ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}
	public Long getNguontin() {
		return nguontin;
	}
	public void setNguontin(Long nguontin) {
		this.nguontin = nguontin;
	}
	public String getCongtacvien() {
		return congtacvien;
	}
	public void setCongtacvien(String congtacvien) {
		this.congtacvien = congtacvien;
	}
	public String getTukhoa() {
		return tukhoa;
	}
	public void setTukhoa(String tukhoa) {
		this.tukhoa = tukhoa;
	}
	public int getLoaitintuc() {
		return loaitintuc;
	}
	public void setLoaitintuc(int loaitintuc) {
		this.loaitintuc = loaitintuc;
	}
	
	
	
	
}
