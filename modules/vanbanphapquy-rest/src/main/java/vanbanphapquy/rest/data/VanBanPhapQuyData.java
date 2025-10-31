package vanbanphapquy.rest.data;

import java.util.List;

public class VanBanPhapQuyData {
	private Long id;
	private String sohieu;
	private String trichyeu;
	private String noidung;
	private String ngaybanhanh;
	private String ngayhieuluc;
	private String ngayhethieuluc;
	private String ngayxuatban;
	private String linhvuc;
	private String loaivanban;
	private String capbanhanh;
	private String coquanbanhanh;
	private String nguoiky;
	private String kieuvanban;
	private List<DinhKemData> filedinhkem;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSohieu() {
		return sohieu;
	}
	public void setSohieu(String sohieu) {
		this.sohieu = sohieu;
	}
	public String getTrichyeu() {
		return trichyeu;
	}
	public void setTrichyeu(String trichyeu) {
		this.trichyeu = trichyeu;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getNgaybanhanh() {
		return ngaybanhanh;
	}
	public void setNgaybanhanh(String ngaybanhanh) {
		this.ngaybanhanh = ngaybanhanh;
	}
	public String getNgayhieuluc() {
		return ngayhieuluc;
	}
	public void setNgayhieuluc(String ngayhieuluc) {
		this.ngayhieuluc = ngayhieuluc;
	}
	public String getNgayhethieuluc() {
		return ngayhethieuluc;
	}
	public void setNgayhethieuluc(String ngayhethieuluc) {
		this.ngayhethieuluc = ngayhethieuluc;
	}
	public String getNgayxuatban() {
		return ngayxuatban;
	}
	public void setNgayxuatban(String ngayxuatban) {
		this.ngayxuatban = ngayxuatban;
	}
	public String getLinhvuc() {
		return linhvuc;
	}
	public void setLinhvuc(String linhvuc) {
		this.linhvuc = linhvuc;
	}
	public String getLoaivanban() {
		return loaivanban;
	}
	public void setLoaivanban(String loaivanban) {
		this.loaivanban = loaivanban;
	}
	public String getCapbanhanh() {
		return capbanhanh;
	}
	public void setCapbanhanh(String capbanhanh) {
		this.capbanhanh = capbanhanh;
	}
	public String getCoquanbanhanh() {
		return coquanbanhanh;
	}
	public void setCoquanbanhanh(String coquanbanhanh) {
		this.coquanbanhanh = coquanbanhanh;
	}
	public String getNguoiky() {
		return nguoiky;
	}
	public void setNguoiky(String nguoiky) {
		this.nguoiky = nguoiky;
	}
	public String getKieuvanban() {
		return kieuvanban;
	}
	public void setKieuvanban(String kieuvanban) {
		this.kieuvanban = kieuvanban;
	}
	public List<DinhKemData> getFiledinhkem() {
		return filedinhkem;
	}
	public void setFiledinhkem(List<DinhKemData> filedinhkem) {
		this.filedinhkem = filedinhkem;
	}
}
