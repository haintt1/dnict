/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.dnict.tintuc.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link News_Log}.
 * </p>
 *
 * @author dnict
 * @see News_Log
 * @generated
 */
public class News_LogWrapper
	extends BaseModelWrapper<News_Log>
	implements ModelWrapper<News_Log>, News_Log {

	public News_LogWrapper(News_Log news_Log) {
		super(news_Log);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("id", getId());
		attributes.put("typeid", getTypeid());
		attributes.put("idnewactivity", getIdnewactivity());
		attributes.put("title", getTitle());
		attributes.put("info", getInfo());
		attributes.put("content", getContent());
		attributes.put("createdby", getCreatedby());
		attributes.put("createdtime", getCreatedtime());
		attributes.put("modifiedby", getModifiedby());
		attributes.put("modifiedtime", getModifiedtime());
		attributes.put("nguoinhanid", getNguoinhanid());
		attributes.put("nguoixulyid", getNguoixulyid());
		attributes.put("ngayxuly", getNgayxuly());
		attributes.put("status", getStatus());
		attributes.put("language", getLanguage());
		attributes.put("version", getVersion());
		attributes.put("urlimagesmall", getUrlimagesmall());
		attributes.put("luotxem", getLuotxem());
		attributes.put("isnoibat", getIsnoibat());
		attributes.put("articleid", getArticleid());
		attributes.put("noidungxuly", getNoidungxuly());
		attributes.put("ngayxuatban", getNgayxuatban());
		attributes.put("ngayketthuc", getNgayketthuc());
		attributes.put("ishethang", getIshethang());
		attributes.put("nguontin", getNguontin());
		attributes.put("congtacvien", getCongtacvien());
		attributes.put("loaitintuc", getLoaitintuc());
		attributes.put("tukhoa", getTukhoa());
		attributes.put("sotinanh", getSotinanh());
		attributes.put("isformbinhluan", getIsformbinhluan());
		attributes.put("isviewbinhluan", getIsviewbinhluan());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long typeid = (Long)attributes.get("typeid");

		if (typeid != null) {
			setTypeid(typeid);
		}

		Long idnewactivity = (Long)attributes.get("idnewactivity");

		if (idnewactivity != null) {
			setIdnewactivity(idnewactivity);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String info = (String)attributes.get("info");

		if (info != null) {
			setInfo(info);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long createdby = (Long)attributes.get("createdby");

		if (createdby != null) {
			setCreatedby(createdby);
		}

		Date createdtime = (Date)attributes.get("createdtime");

		if (createdtime != null) {
			setCreatedtime(createdtime);
		}

		Long modifiedby = (Long)attributes.get("modifiedby");

		if (modifiedby != null) {
			setModifiedby(modifiedby);
		}

		Date modifiedtime = (Date)attributes.get("modifiedtime");

		if (modifiedtime != null) {
			setModifiedtime(modifiedtime);
		}

		Long nguoinhanid = (Long)attributes.get("nguoinhanid");

		if (nguoinhanid != null) {
			setNguoinhanid(nguoinhanid);
		}

		Long nguoixulyid = (Long)attributes.get("nguoixulyid");

		if (nguoixulyid != null) {
			setNguoixulyid(nguoixulyid);
		}

		Date ngayxuly = (Date)attributes.get("ngayxuly");

		if (ngayxuly != null) {
			setNgayxuly(ngayxuly);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String urlimagesmall = (String)attributes.get("urlimagesmall");

		if (urlimagesmall != null) {
			setUrlimagesmall(urlimagesmall);
		}

		Long luotxem = (Long)attributes.get("luotxem");

		if (luotxem != null) {
			setLuotxem(luotxem);
		}

		Long isnoibat = (Long)attributes.get("isnoibat");

		if (isnoibat != null) {
			setIsnoibat(isnoibat);
		}

		Long articleid = (Long)attributes.get("articleid");

		if (articleid != null) {
			setArticleid(articleid);
		}

		String noidungxuly = (String)attributes.get("noidungxuly");

		if (noidungxuly != null) {
			setNoidungxuly(noidungxuly);
		}

		Date ngayxuatban = (Date)attributes.get("ngayxuatban");

		if (ngayxuatban != null) {
			setNgayxuatban(ngayxuatban);
		}

		Date ngayketthuc = (Date)attributes.get("ngayketthuc");

		if (ngayketthuc != null) {
			setNgayketthuc(ngayketthuc);
		}

		Long ishethang = (Long)attributes.get("ishethang");

		if (ishethang != null) {
			setIshethang(ishethang);
		}

		Long nguontin = (Long)attributes.get("nguontin");

		if (nguontin != null) {
			setNguontin(nguontin);
		}

		String congtacvien = (String)attributes.get("congtacvien");

		if (congtacvien != null) {
			setCongtacvien(congtacvien);
		}

		Integer loaitintuc = (Integer)attributes.get("loaitintuc");

		if (loaitintuc != null) {
			setLoaitintuc(loaitintuc);
		}

		String tukhoa = (String)attributes.get("tukhoa");

		if (tukhoa != null) {
			setTukhoa(tukhoa);
		}

		Integer sotinanh = (Integer)attributes.get("sotinanh");

		if (sotinanh != null) {
			setSotinanh(sotinanh);
		}

		Integer isformbinhluan = (Integer)attributes.get("isformbinhluan");

		if (isformbinhluan != null) {
			setIsformbinhluan(isformbinhluan);
		}

		Integer isviewbinhluan = (Integer)attributes.get("isviewbinhluan");

		if (isviewbinhluan != null) {
			setIsviewbinhluan(isviewbinhluan);
		}
	}

	/**
	 * Returns the articleid of this news_ log.
	 *
	 * @return the articleid of this news_ log
	 */
	@Override
	public long getArticleid() {
		return model.getArticleid();
	}

	/**
	 * Returns the company ID of this news_ log.
	 *
	 * @return the company ID of this news_ log
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the congtacvien of this news_ log.
	 *
	 * @return the congtacvien of this news_ log
	 */
	@Override
	public String getCongtacvien() {
		return model.getCongtacvien();
	}

	/**
	 * Returns the content of this news_ log.
	 *
	 * @return the content of this news_ log
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the createdby of this news_ log.
	 *
	 * @return the createdby of this news_ log
	 */
	@Override
	public long getCreatedby() {
		return model.getCreatedby();
	}

	/**
	 * Returns the createdtime of this news_ log.
	 *
	 * @return the createdtime of this news_ log
	 */
	@Override
	public Date getCreatedtime() {
		return model.getCreatedtime();
	}

	/**
	 * Returns the group ID of this news_ log.
	 *
	 * @return the group ID of this news_ log
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this news_ log.
	 *
	 * @return the ID of this news_ log
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the idnewactivity of this news_ log.
	 *
	 * @return the idnewactivity of this news_ log
	 */
	@Override
	public long getIdnewactivity() {
		return model.getIdnewactivity();
	}

	/**
	 * Returns the info of this news_ log.
	 *
	 * @return the info of this news_ log
	 */
	@Override
	public String getInfo() {
		return model.getInfo();
	}

	/**
	 * Returns the isformbinhluan of this news_ log.
	 *
	 * @return the isformbinhluan of this news_ log
	 */
	@Override
	public int getIsformbinhluan() {
		return model.getIsformbinhluan();
	}

	/**
	 * Returns the ishethang of this news_ log.
	 *
	 * @return the ishethang of this news_ log
	 */
	@Override
	public long getIshethang() {
		return model.getIshethang();
	}

	/**
	 * Returns the isnoibat of this news_ log.
	 *
	 * @return the isnoibat of this news_ log
	 */
	@Override
	public long getIsnoibat() {
		return model.getIsnoibat();
	}

	/**
	 * Returns the isviewbinhluan of this news_ log.
	 *
	 * @return the isviewbinhluan of this news_ log
	 */
	@Override
	public int getIsviewbinhluan() {
		return model.getIsviewbinhluan();
	}

	/**
	 * Returns the language of this news_ log.
	 *
	 * @return the language of this news_ log
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the loaitintuc of this news_ log.
	 *
	 * @return the loaitintuc of this news_ log
	 */
	@Override
	public int getLoaitintuc() {
		return model.getLoaitintuc();
	}

	/**
	 * Returns the luotxem of this news_ log.
	 *
	 * @return the luotxem of this news_ log
	 */
	@Override
	public long getLuotxem() {
		return model.getLuotxem();
	}

	/**
	 * Returns the modifiedby of this news_ log.
	 *
	 * @return the modifiedby of this news_ log
	 */
	@Override
	public long getModifiedby() {
		return model.getModifiedby();
	}

	/**
	 * Returns the modifiedtime of this news_ log.
	 *
	 * @return the modifiedtime of this news_ log
	 */
	@Override
	public Date getModifiedtime() {
		return model.getModifiedtime();
	}

	/**
	 * Returns the ngayketthuc of this news_ log.
	 *
	 * @return the ngayketthuc of this news_ log
	 */
	@Override
	public Date getNgayketthuc() {
		return model.getNgayketthuc();
	}

	/**
	 * Returns the ngayxuatban of this news_ log.
	 *
	 * @return the ngayxuatban of this news_ log
	 */
	@Override
	public Date getNgayxuatban() {
		return model.getNgayxuatban();
	}

	/**
	 * Returns the ngayxuly of this news_ log.
	 *
	 * @return the ngayxuly of this news_ log
	 */
	@Override
	public Date getNgayxuly() {
		return model.getNgayxuly();
	}

	/**
	 * Returns the nguoinhanid of this news_ log.
	 *
	 * @return the nguoinhanid of this news_ log
	 */
	@Override
	public long getNguoinhanid() {
		return model.getNguoinhanid();
	}

	/**
	 * Returns the nguoixulyid of this news_ log.
	 *
	 * @return the nguoixulyid of this news_ log
	 */
	@Override
	public long getNguoixulyid() {
		return model.getNguoixulyid();
	}

	/**
	 * Returns the nguontin of this news_ log.
	 *
	 * @return the nguontin of this news_ log
	 */
	@Override
	public long getNguontin() {
		return model.getNguontin();
	}

	/**
	 * Returns the noidungxuly of this news_ log.
	 *
	 * @return the noidungxuly of this news_ log
	 */
	@Override
	public String getNoidungxuly() {
		return model.getNoidungxuly();
	}

	/**
	 * Returns the primary key of this news_ log.
	 *
	 * @return the primary key of this news_ log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sotinanh of this news_ log.
	 *
	 * @return the sotinanh of this news_ log
	 */
	@Override
	public int getSotinanh() {
		return model.getSotinanh();
	}

	/**
	 * Returns the status of this news_ log.
	 *
	 * @return the status of this news_ log
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this news_ log.
	 *
	 * @return the title of this news_ log
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the tukhoa of this news_ log.
	 *
	 * @return the tukhoa of this news_ log
	 */
	@Override
	public String getTukhoa() {
		return model.getTukhoa();
	}

	/**
	 * Returns the typeid of this news_ log.
	 *
	 * @return the typeid of this news_ log
	 */
	@Override
	public long getTypeid() {
		return model.getTypeid();
	}

	/**
	 * Returns the urlimagesmall of this news_ log.
	 *
	 * @return the urlimagesmall of this news_ log
	 */
	@Override
	public String getUrlimagesmall() {
		return model.getUrlimagesmall();
	}

	/**
	 * Returns the version of this news_ log.
	 *
	 * @return the version of this news_ log
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the articleid of this news_ log.
	 *
	 * @param articleid the articleid of this news_ log
	 */
	@Override
	public void setArticleid(long articleid) {
		model.setArticleid(articleid);
	}

	/**
	 * Sets the company ID of this news_ log.
	 *
	 * @param companyId the company ID of this news_ log
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the congtacvien of this news_ log.
	 *
	 * @param congtacvien the congtacvien of this news_ log
	 */
	@Override
	public void setCongtacvien(String congtacvien) {
		model.setCongtacvien(congtacvien);
	}

	/**
	 * Sets the content of this news_ log.
	 *
	 * @param content the content of this news_ log
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the createdby of this news_ log.
	 *
	 * @param createdby the createdby of this news_ log
	 */
	@Override
	public void setCreatedby(long createdby) {
		model.setCreatedby(createdby);
	}

	/**
	 * Sets the createdtime of this news_ log.
	 *
	 * @param createdtime the createdtime of this news_ log
	 */
	@Override
	public void setCreatedtime(Date createdtime) {
		model.setCreatedtime(createdtime);
	}

	/**
	 * Sets the group ID of this news_ log.
	 *
	 * @param groupId the group ID of this news_ log
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this news_ log.
	 *
	 * @param id the ID of this news_ log
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the idnewactivity of this news_ log.
	 *
	 * @param idnewactivity the idnewactivity of this news_ log
	 */
	@Override
	public void setIdnewactivity(long idnewactivity) {
		model.setIdnewactivity(idnewactivity);
	}

	/**
	 * Sets the info of this news_ log.
	 *
	 * @param info the info of this news_ log
	 */
	@Override
	public void setInfo(String info) {
		model.setInfo(info);
	}

	/**
	 * Sets the isformbinhluan of this news_ log.
	 *
	 * @param isformbinhluan the isformbinhluan of this news_ log
	 */
	@Override
	public void setIsformbinhluan(int isformbinhluan) {
		model.setIsformbinhluan(isformbinhluan);
	}

	/**
	 * Sets the ishethang of this news_ log.
	 *
	 * @param ishethang the ishethang of this news_ log
	 */
	@Override
	public void setIshethang(long ishethang) {
		model.setIshethang(ishethang);
	}

	/**
	 * Sets the isnoibat of this news_ log.
	 *
	 * @param isnoibat the isnoibat of this news_ log
	 */
	@Override
	public void setIsnoibat(long isnoibat) {
		model.setIsnoibat(isnoibat);
	}

	/**
	 * Sets the isviewbinhluan of this news_ log.
	 *
	 * @param isviewbinhluan the isviewbinhluan of this news_ log
	 */
	@Override
	public void setIsviewbinhluan(int isviewbinhluan) {
		model.setIsviewbinhluan(isviewbinhluan);
	}

	/**
	 * Sets the language of this news_ log.
	 *
	 * @param language the language of this news_ log
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the loaitintuc of this news_ log.
	 *
	 * @param loaitintuc the loaitintuc of this news_ log
	 */
	@Override
	public void setLoaitintuc(int loaitintuc) {
		model.setLoaitintuc(loaitintuc);
	}

	/**
	 * Sets the luotxem of this news_ log.
	 *
	 * @param luotxem the luotxem of this news_ log
	 */
	@Override
	public void setLuotxem(long luotxem) {
		model.setLuotxem(luotxem);
	}

	/**
	 * Sets the modifiedby of this news_ log.
	 *
	 * @param modifiedby the modifiedby of this news_ log
	 */
	@Override
	public void setModifiedby(long modifiedby) {
		model.setModifiedby(modifiedby);
	}

	/**
	 * Sets the modifiedtime of this news_ log.
	 *
	 * @param modifiedtime the modifiedtime of this news_ log
	 */
	@Override
	public void setModifiedtime(Date modifiedtime) {
		model.setModifiedtime(modifiedtime);
	}

	/**
	 * Sets the ngayketthuc of this news_ log.
	 *
	 * @param ngayketthuc the ngayketthuc of this news_ log
	 */
	@Override
	public void setNgayketthuc(Date ngayketthuc) {
		model.setNgayketthuc(ngayketthuc);
	}

	/**
	 * Sets the ngayxuatban of this news_ log.
	 *
	 * @param ngayxuatban the ngayxuatban of this news_ log
	 */
	@Override
	public void setNgayxuatban(Date ngayxuatban) {
		model.setNgayxuatban(ngayxuatban);
	}

	/**
	 * Sets the ngayxuly of this news_ log.
	 *
	 * @param ngayxuly the ngayxuly of this news_ log
	 */
	@Override
	public void setNgayxuly(Date ngayxuly) {
		model.setNgayxuly(ngayxuly);
	}

	/**
	 * Sets the nguoinhanid of this news_ log.
	 *
	 * @param nguoinhanid the nguoinhanid of this news_ log
	 */
	@Override
	public void setNguoinhanid(long nguoinhanid) {
		model.setNguoinhanid(nguoinhanid);
	}

	/**
	 * Sets the nguoixulyid of this news_ log.
	 *
	 * @param nguoixulyid the nguoixulyid of this news_ log
	 */
	@Override
	public void setNguoixulyid(long nguoixulyid) {
		model.setNguoixulyid(nguoixulyid);
	}

	/**
	 * Sets the nguontin of this news_ log.
	 *
	 * @param nguontin the nguontin of this news_ log
	 */
	@Override
	public void setNguontin(long nguontin) {
		model.setNguontin(nguontin);
	}

	/**
	 * Sets the noidungxuly of this news_ log.
	 *
	 * @param noidungxuly the noidungxuly of this news_ log
	 */
	@Override
	public void setNoidungxuly(String noidungxuly) {
		model.setNoidungxuly(noidungxuly);
	}

	/**
	 * Sets the primary key of this news_ log.
	 *
	 * @param primaryKey the primary key of this news_ log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sotinanh of this news_ log.
	 *
	 * @param sotinanh the sotinanh of this news_ log
	 */
	@Override
	public void setSotinanh(int sotinanh) {
		model.setSotinanh(sotinanh);
	}

	/**
	 * Sets the status of this news_ log.
	 *
	 * @param status the status of this news_ log
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the title of this news_ log.
	 *
	 * @param title the title of this news_ log
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the tukhoa of this news_ log.
	 *
	 * @param tukhoa the tukhoa of this news_ log
	 */
	@Override
	public void setTukhoa(String tukhoa) {
		model.setTukhoa(tukhoa);
	}

	/**
	 * Sets the typeid of this news_ log.
	 *
	 * @param typeid the typeid of this news_ log
	 */
	@Override
	public void setTypeid(long typeid) {
		model.setTypeid(typeid);
	}

	/**
	 * Sets the urlimagesmall of this news_ log.
	 *
	 * @param urlimagesmall the urlimagesmall of this news_ log
	 */
	@Override
	public void setUrlimagesmall(String urlimagesmall) {
		model.setUrlimagesmall(urlimagesmall);
	}

	/**
	 * Sets the version of this news_ log.
	 *
	 * @param version the version of this news_ log
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	@Override
	protected News_LogWrapper wrap(News_Log news_Log) {
		return new News_LogWrapper(news_Log);
	}

}