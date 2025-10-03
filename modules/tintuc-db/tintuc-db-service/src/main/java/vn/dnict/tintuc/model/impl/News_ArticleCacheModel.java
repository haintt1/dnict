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

package vn.dnict.tintuc.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import vn.dnict.tintuc.model.News_Article;

/**
 * The cache model class for representing News_Article in entity cache.
 *
 * @author dnict
 * @generated
 */
public class News_ArticleCacheModel
	implements CacheModel<News_Article>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof News_ArticleCacheModel)) {
			return false;
		}

		News_ArticleCacheModel news_ArticleCacheModel =
			(News_ArticleCacheModel)object;

		if (id == news_ArticleCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", typeid=");
		sb.append(typeid);
		sb.append(", title=");
		sb.append(title);
		sb.append(", info=");
		sb.append(info);
		sb.append(", content=");
		sb.append(content);
		sb.append(", createdby=");
		sb.append(createdby);
		sb.append(", createdtime=");
		sb.append(createdtime);
		sb.append(", modifiedby=");
		sb.append(modifiedby);
		sb.append(", modifiedtime=");
		sb.append(modifiedtime);
		sb.append(", nguoinhanid=");
		sb.append(nguoinhanid);
		sb.append(", nguoixulyid=");
		sb.append(nguoixulyid);
		sb.append(", ngayxuly=");
		sb.append(ngayxuly);
		sb.append(", status=");
		sb.append(status);
		sb.append(", language=");
		sb.append(language);
		sb.append(", version=");
		sb.append(version);
		sb.append(", delete_status=");
		sb.append(delete_status);
		sb.append(", urlimagesmall=");
		sb.append(urlimagesmall);
		sb.append(", luotxem=");
		sb.append(luotxem);
		sb.append(", isnoibat=");
		sb.append(isnoibat);
		sb.append(", ngayxuatban=");
		sb.append(ngayxuatban);
		sb.append(", ngayketthuc=");
		sb.append(ngayketthuc);
		sb.append(", ishethang=");
		sb.append(ishethang);
		sb.append(", nguontin=");
		sb.append(nguontin);
		sb.append(", congtacvien=");
		sb.append(congtacvien);
		sb.append(", loaitintuc=");
		sb.append(loaitintuc);
		sb.append(", tukhoa=");
		sb.append(tukhoa);
		sb.append(", sotinanh=");
		sb.append(sotinanh);
		sb.append(", isformbinhluan=");
		sb.append(isformbinhluan);
		sb.append(", isviewbinhluan=");
		sb.append(isviewbinhluan);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public News_Article toEntityModel() {
		News_ArticleImpl news_ArticleImpl = new News_ArticleImpl();

		news_ArticleImpl.setId(id);
		news_ArticleImpl.setCompanyId(companyId);
		news_ArticleImpl.setGroupId(groupId);
		news_ArticleImpl.setTypeid(typeid);

		if (title == null) {
			news_ArticleImpl.setTitle("");
		}
		else {
			news_ArticleImpl.setTitle(title);
		}

		if (info == null) {
			news_ArticleImpl.setInfo("");
		}
		else {
			news_ArticleImpl.setInfo(info);
		}

		if (content == null) {
			news_ArticleImpl.setContent("");
		}
		else {
			news_ArticleImpl.setContent(content);
		}

		news_ArticleImpl.setCreatedby(createdby);

		if (createdtime == Long.MIN_VALUE) {
			news_ArticleImpl.setCreatedtime(null);
		}
		else {
			news_ArticleImpl.setCreatedtime(new Date(createdtime));
		}

		news_ArticleImpl.setModifiedby(modifiedby);

		if (modifiedtime == Long.MIN_VALUE) {
			news_ArticleImpl.setModifiedtime(null);
		}
		else {
			news_ArticleImpl.setModifiedtime(new Date(modifiedtime));
		}

		news_ArticleImpl.setNguoinhanid(nguoinhanid);
		news_ArticleImpl.setNguoixulyid(nguoixulyid);

		if (ngayxuly == Long.MIN_VALUE) {
			news_ArticleImpl.setNgayxuly(null);
		}
		else {
			news_ArticleImpl.setNgayxuly(new Date(ngayxuly));
		}

		news_ArticleImpl.setStatus(status);

		if (language == null) {
			news_ArticleImpl.setLanguage("");
		}
		else {
			news_ArticleImpl.setLanguage(language);
		}

		news_ArticleImpl.setVersion(version);
		news_ArticleImpl.setDelete_status(delete_status);

		if (urlimagesmall == null) {
			news_ArticleImpl.setUrlimagesmall("");
		}
		else {
			news_ArticleImpl.setUrlimagesmall(urlimagesmall);
		}

		news_ArticleImpl.setLuotxem(luotxem);
		news_ArticleImpl.setIsnoibat(isnoibat);

		if (ngayxuatban == Long.MIN_VALUE) {
			news_ArticleImpl.setNgayxuatban(null);
		}
		else {
			news_ArticleImpl.setNgayxuatban(new Date(ngayxuatban));
		}

		if (ngayketthuc == Long.MIN_VALUE) {
			news_ArticleImpl.setNgayketthuc(null);
		}
		else {
			news_ArticleImpl.setNgayketthuc(new Date(ngayketthuc));
		}

		news_ArticleImpl.setIshethang(ishethang);
		news_ArticleImpl.setNguontin(nguontin);

		if (congtacvien == null) {
			news_ArticleImpl.setCongtacvien("");
		}
		else {
			news_ArticleImpl.setCongtacvien(congtacvien);
		}

		news_ArticleImpl.setLoaitintuc(loaitintuc);

		if (tukhoa == null) {
			news_ArticleImpl.setTukhoa("");
		}
		else {
			news_ArticleImpl.setTukhoa(tukhoa);
		}

		news_ArticleImpl.setSotinanh(sotinanh);
		news_ArticleImpl.setIsformbinhluan(isformbinhluan);
		news_ArticleImpl.setIsviewbinhluan(isviewbinhluan);

		news_ArticleImpl.resetOriginalValues();

		return news_ArticleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		typeid = objectInput.readLong();
		title = (String)objectInput.readObject();
		info = objectInput.readUTF();
		content = (String)objectInput.readObject();

		createdby = objectInput.readLong();
		createdtime = objectInput.readLong();

		modifiedby = objectInput.readLong();
		modifiedtime = objectInput.readLong();

		nguoinhanid = objectInput.readLong();

		nguoixulyid = objectInput.readLong();
		ngayxuly = objectInput.readLong();

		status = objectInput.readInt();
		language = objectInput.readUTF();

		version = objectInput.readLong();

		delete_status = objectInput.readInt();
		urlimagesmall = objectInput.readUTF();

		luotxem = objectInput.readLong();

		isnoibat = objectInput.readLong();
		ngayxuatban = objectInput.readLong();
		ngayketthuc = objectInput.readLong();

		ishethang = objectInput.readLong();

		nguontin = objectInput.readLong();
		congtacvien = objectInput.readUTF();

		loaitintuc = objectInput.readInt();
		tukhoa = objectInput.readUTF();

		sotinanh = objectInput.readInt();

		isformbinhluan = objectInput.readInt();

		isviewbinhluan = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(typeid);

		if (title == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(title);
		}

		if (info == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(info);
		}

		if (content == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(content);
		}

		objectOutput.writeLong(createdby);
		objectOutput.writeLong(createdtime);

		objectOutput.writeLong(modifiedby);
		objectOutput.writeLong(modifiedtime);

		objectOutput.writeLong(nguoinhanid);

		objectOutput.writeLong(nguoixulyid);
		objectOutput.writeLong(ngayxuly);

		objectOutput.writeInt(status);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeLong(version);

		objectOutput.writeInt(delete_status);

		if (urlimagesmall == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(urlimagesmall);
		}

		objectOutput.writeLong(luotxem);

		objectOutput.writeLong(isnoibat);
		objectOutput.writeLong(ngayxuatban);
		objectOutput.writeLong(ngayketthuc);

		objectOutput.writeLong(ishethang);

		objectOutput.writeLong(nguontin);

		if (congtacvien == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(congtacvien);
		}

		objectOutput.writeInt(loaitintuc);

		if (tukhoa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tukhoa);
		}

		objectOutput.writeInt(sotinanh);

		objectOutput.writeInt(isformbinhluan);

		objectOutput.writeInt(isviewbinhluan);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long typeid;
	public String title;
	public String info;
	public String content;
	public long createdby;
	public long createdtime;
	public long modifiedby;
	public long modifiedtime;
	public long nguoinhanid;
	public long nguoixulyid;
	public long ngayxuly;
	public int status;
	public String language;
	public long version;
	public int delete_status;
	public String urlimagesmall;
	public long luotxem;
	public long isnoibat;
	public long ngayxuatban;
	public long ngayketthuc;
	public long ishethang;
	public long nguontin;
	public String congtacvien;
	public int loaitintuc;
	public String tukhoa;
	public int sotinanh;
	public int isformbinhluan;
	public int isviewbinhluan;

}