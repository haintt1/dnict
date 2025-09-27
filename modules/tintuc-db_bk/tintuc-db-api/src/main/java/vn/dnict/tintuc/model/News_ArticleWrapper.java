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
 * This class is a wrapper for {@link News_Article}.
 * </p>
 *
 * @author dnict
 * @see News_Article
 * @generated
 */
public class News_ArticleWrapper
	extends BaseModelWrapper<News_Article>
	implements ModelWrapper<News_Article>, News_Article {

	public News_ArticleWrapper(News_Article news_Article) {
		super(news_Article);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("typeid", getTypeid());
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
		attributes.put("delete_status", getDelete_status());
		attributes.put("urlimagesmall", getUrlimagesmall());
		attributes.put("luotxem", getLuotxem());
		attributes.put("isnoibat", getIsnoibat());
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
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long typeid = (Long)attributes.get("typeid");

		if (typeid != null) {
			setTypeid(typeid);
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

		Integer delete_status = (Integer)attributes.get("delete_status");

		if (delete_status != null) {
			setDelete_status(delete_status);
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
	 * Returns the company ID of this news_ article.
	 *
	 * @return the company ID of this news_ article
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the congtacvien of this news_ article.
	 *
	 * @return the congtacvien of this news_ article
	 */
	@Override
	public String getCongtacvien() {
		return model.getCongtacvien();
	}

	/**
	 * Returns the content of this news_ article.
	 *
	 * @return the content of this news_ article
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the createdby of this news_ article.
	 *
	 * @return the createdby of this news_ article
	 */
	@Override
	public long getCreatedby() {
		return model.getCreatedby();
	}

	/**
	 * Returns the createdtime of this news_ article.
	 *
	 * @return the createdtime of this news_ article
	 */
	@Override
	public Date getCreatedtime() {
		return model.getCreatedtime();
	}

	/**
	 * Returns the delete_status of this news_ article.
	 *
	 * @return the delete_status of this news_ article
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the group ID of this news_ article.
	 *
	 * @return the group ID of this news_ article
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this news_ article.
	 *
	 * @return the ID of this news_ article
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the info of this news_ article.
	 *
	 * @return the info of this news_ article
	 */
	@Override
	public String getInfo() {
		return model.getInfo();
	}

	/**
	 * Returns the isformbinhluan of this news_ article.
	 *
	 * @return the isformbinhluan of this news_ article
	 */
	@Override
	public int getIsformbinhluan() {
		return model.getIsformbinhluan();
	}

	/**
	 * Returns the ishethang of this news_ article.
	 *
	 * @return the ishethang of this news_ article
	 */
	@Override
	public long getIshethang() {
		return model.getIshethang();
	}

	/**
	 * Returns the isnoibat of this news_ article.
	 *
	 * @return the isnoibat of this news_ article
	 */
	@Override
	public long getIsnoibat() {
		return model.getIsnoibat();
	}

	/**
	 * Returns the isviewbinhluan of this news_ article.
	 *
	 * @return the isviewbinhluan of this news_ article
	 */
	@Override
	public int getIsviewbinhluan() {
		return model.getIsviewbinhluan();
	}

	/**
	 * Returns the language of this news_ article.
	 *
	 * @return the language of this news_ article
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the loaitintuc of this news_ article.
	 *
	 * @return the loaitintuc of this news_ article
	 */
	@Override
	public int getLoaitintuc() {
		return model.getLoaitintuc();
	}

	/**
	 * Returns the luotxem of this news_ article.
	 *
	 * @return the luotxem of this news_ article
	 */
	@Override
	public long getLuotxem() {
		return model.getLuotxem();
	}

	/**
	 * Returns the modifiedby of this news_ article.
	 *
	 * @return the modifiedby of this news_ article
	 */
	@Override
	public long getModifiedby() {
		return model.getModifiedby();
	}

	/**
	 * Returns the modifiedtime of this news_ article.
	 *
	 * @return the modifiedtime of this news_ article
	 */
	@Override
	public Date getModifiedtime() {
		return model.getModifiedtime();
	}

	/**
	 * Returns the ngayketthuc of this news_ article.
	 *
	 * @return the ngayketthuc of this news_ article
	 */
	@Override
	public Date getNgayketthuc() {
		return model.getNgayketthuc();
	}

	/**
	 * Returns the ngayxuatban of this news_ article.
	 *
	 * @return the ngayxuatban of this news_ article
	 */
	@Override
	public Date getNgayxuatban() {
		return model.getNgayxuatban();
	}

	/**
	 * Returns the ngayxuly of this news_ article.
	 *
	 * @return the ngayxuly of this news_ article
	 */
	@Override
	public Date getNgayxuly() {
		return model.getNgayxuly();
	}

	/**
	 * Returns the nguoinhanid of this news_ article.
	 *
	 * @return the nguoinhanid of this news_ article
	 */
	@Override
	public long getNguoinhanid() {
		return model.getNguoinhanid();
	}

	/**
	 * Returns the nguoixulyid of this news_ article.
	 *
	 * @return the nguoixulyid of this news_ article
	 */
	@Override
	public long getNguoixulyid() {
		return model.getNguoixulyid();
	}

	/**
	 * Returns the nguontin of this news_ article.
	 *
	 * @return the nguontin of this news_ article
	 */
	@Override
	public long getNguontin() {
		return model.getNguontin();
	}

	/**
	 * Returns the primary key of this news_ article.
	 *
	 * @return the primary key of this news_ article
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sotinanh of this news_ article.
	 *
	 * @return the sotinanh of this news_ article
	 */
	@Override
	public int getSotinanh() {
		return model.getSotinanh();
	}

	/**
	 * Returns the status of this news_ article.
	 *
	 * @return the status of this news_ article
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this news_ article.
	 *
	 * @return the title of this news_ article
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the tukhoa of this news_ article.
	 *
	 * @return the tukhoa of this news_ article
	 */
	@Override
	public String getTukhoa() {
		return model.getTukhoa();
	}

	/**
	 * Returns the typeid of this news_ article.
	 *
	 * @return the typeid of this news_ article
	 */
	@Override
	public long getTypeid() {
		return model.getTypeid();
	}

	/**
	 * Returns the urlimagesmall of this news_ article.
	 *
	 * @return the urlimagesmall of this news_ article
	 */
	@Override
	public String getUrlimagesmall() {
		return model.getUrlimagesmall();
	}

	/**
	 * Returns the version of this news_ article.
	 *
	 * @return the version of this news_ article
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
	 * Sets the company ID of this news_ article.
	 *
	 * @param companyId the company ID of this news_ article
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the congtacvien of this news_ article.
	 *
	 * @param congtacvien the congtacvien of this news_ article
	 */
	@Override
	public void setCongtacvien(String congtacvien) {
		model.setCongtacvien(congtacvien);
	}

	/**
	 * Sets the content of this news_ article.
	 *
	 * @param content the content of this news_ article
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the createdby of this news_ article.
	 *
	 * @param createdby the createdby of this news_ article
	 */
	@Override
	public void setCreatedby(long createdby) {
		model.setCreatedby(createdby);
	}

	/**
	 * Sets the createdtime of this news_ article.
	 *
	 * @param createdtime the createdtime of this news_ article
	 */
	@Override
	public void setCreatedtime(Date createdtime) {
		model.setCreatedtime(createdtime);
	}

	/**
	 * Sets the delete_status of this news_ article.
	 *
	 * @param delete_status the delete_status of this news_ article
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the group ID of this news_ article.
	 *
	 * @param groupId the group ID of this news_ article
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this news_ article.
	 *
	 * @param id the ID of this news_ article
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the info of this news_ article.
	 *
	 * @param info the info of this news_ article
	 */
	@Override
	public void setInfo(String info) {
		model.setInfo(info);
	}

	/**
	 * Sets the isformbinhluan of this news_ article.
	 *
	 * @param isformbinhluan the isformbinhluan of this news_ article
	 */
	@Override
	public void setIsformbinhluan(int isformbinhluan) {
		model.setIsformbinhluan(isformbinhluan);
	}

	/**
	 * Sets the ishethang of this news_ article.
	 *
	 * @param ishethang the ishethang of this news_ article
	 */
	@Override
	public void setIshethang(long ishethang) {
		model.setIshethang(ishethang);
	}

	/**
	 * Sets the isnoibat of this news_ article.
	 *
	 * @param isnoibat the isnoibat of this news_ article
	 */
	@Override
	public void setIsnoibat(long isnoibat) {
		model.setIsnoibat(isnoibat);
	}

	/**
	 * Sets the isviewbinhluan of this news_ article.
	 *
	 * @param isviewbinhluan the isviewbinhluan of this news_ article
	 */
	@Override
	public void setIsviewbinhluan(int isviewbinhluan) {
		model.setIsviewbinhluan(isviewbinhluan);
	}

	/**
	 * Sets the language of this news_ article.
	 *
	 * @param language the language of this news_ article
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the loaitintuc of this news_ article.
	 *
	 * @param loaitintuc the loaitintuc of this news_ article
	 */
	@Override
	public void setLoaitintuc(int loaitintuc) {
		model.setLoaitintuc(loaitintuc);
	}

	/**
	 * Sets the luotxem of this news_ article.
	 *
	 * @param luotxem the luotxem of this news_ article
	 */
	@Override
	public void setLuotxem(long luotxem) {
		model.setLuotxem(luotxem);
	}

	/**
	 * Sets the modifiedby of this news_ article.
	 *
	 * @param modifiedby the modifiedby of this news_ article
	 */
	@Override
	public void setModifiedby(long modifiedby) {
		model.setModifiedby(modifiedby);
	}

	/**
	 * Sets the modifiedtime of this news_ article.
	 *
	 * @param modifiedtime the modifiedtime of this news_ article
	 */
	@Override
	public void setModifiedtime(Date modifiedtime) {
		model.setModifiedtime(modifiedtime);
	}

	/**
	 * Sets the ngayketthuc of this news_ article.
	 *
	 * @param ngayketthuc the ngayketthuc of this news_ article
	 */
	@Override
	public void setNgayketthuc(Date ngayketthuc) {
		model.setNgayketthuc(ngayketthuc);
	}

	/**
	 * Sets the ngayxuatban of this news_ article.
	 *
	 * @param ngayxuatban the ngayxuatban of this news_ article
	 */
	@Override
	public void setNgayxuatban(Date ngayxuatban) {
		model.setNgayxuatban(ngayxuatban);
	}

	/**
	 * Sets the ngayxuly of this news_ article.
	 *
	 * @param ngayxuly the ngayxuly of this news_ article
	 */
	@Override
	public void setNgayxuly(Date ngayxuly) {
		model.setNgayxuly(ngayxuly);
	}

	/**
	 * Sets the nguoinhanid of this news_ article.
	 *
	 * @param nguoinhanid the nguoinhanid of this news_ article
	 */
	@Override
	public void setNguoinhanid(long nguoinhanid) {
		model.setNguoinhanid(nguoinhanid);
	}

	/**
	 * Sets the nguoixulyid of this news_ article.
	 *
	 * @param nguoixulyid the nguoixulyid of this news_ article
	 */
	@Override
	public void setNguoixulyid(long nguoixulyid) {
		model.setNguoixulyid(nguoixulyid);
	}

	/**
	 * Sets the nguontin of this news_ article.
	 *
	 * @param nguontin the nguontin of this news_ article
	 */
	@Override
	public void setNguontin(long nguontin) {
		model.setNguontin(nguontin);
	}

	/**
	 * Sets the primary key of this news_ article.
	 *
	 * @param primaryKey the primary key of this news_ article
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sotinanh of this news_ article.
	 *
	 * @param sotinanh the sotinanh of this news_ article
	 */
	@Override
	public void setSotinanh(int sotinanh) {
		model.setSotinanh(sotinanh);
	}

	/**
	 * Sets the status of this news_ article.
	 *
	 * @param status the status of this news_ article
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the title of this news_ article.
	 *
	 * @param title the title of this news_ article
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the tukhoa of this news_ article.
	 *
	 * @param tukhoa the tukhoa of this news_ article
	 */
	@Override
	public void setTukhoa(String tukhoa) {
		model.setTukhoa(tukhoa);
	}

	/**
	 * Sets the typeid of this news_ article.
	 *
	 * @param typeid the typeid of this news_ article
	 */
	@Override
	public void setTypeid(long typeid) {
		model.setTypeid(typeid);
	}

	/**
	 * Sets the urlimagesmall of this news_ article.
	 *
	 * @param urlimagesmall the urlimagesmall of this news_ article
	 */
	@Override
	public void setUrlimagesmall(String urlimagesmall) {
		model.setUrlimagesmall(urlimagesmall);
	}

	/**
	 * Sets the version of this news_ article.
	 *
	 * @param version the version of this news_ article
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	@Override
	protected News_ArticleWrapper wrap(News_Article news_Article) {
		return new News_ArticleWrapper(news_Article);
	}

}