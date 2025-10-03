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

import vn.dnict.tintuc.model.News_Log;

/**
 * The cache model class for representing News_Log in entity cache.
 *
 * @author dnict
 * @generated
 */
public class News_LogCacheModel
	implements CacheModel<News_Log>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof News_LogCacheModel)) {
			return false;
		}

		News_LogCacheModel news_LogCacheModel = (News_LogCacheModel)object;

		if (id == news_LogCacheModel.id) {
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
		StringBundler sb = new StringBundler(67);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", id=");
		sb.append(id);
		sb.append(", typeid=");
		sb.append(typeid);
		sb.append(", idnewactivity=");
		sb.append(idnewactivity);
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
		sb.append(", urlimagesmall=");
		sb.append(urlimagesmall);
		sb.append(", luotxem=");
		sb.append(luotxem);
		sb.append(", isnoibat=");
		sb.append(isnoibat);
		sb.append(", articleid=");
		sb.append(articleid);
		sb.append(", noidungxuly=");
		sb.append(noidungxuly);
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
	public News_Log toEntityModel() {
		News_LogImpl news_LogImpl = new News_LogImpl();

		news_LogImpl.setCompanyId(companyId);
		news_LogImpl.setGroupId(groupId);
		news_LogImpl.setId(id);
		news_LogImpl.setTypeid(typeid);
		news_LogImpl.setIdnewactivity(idnewactivity);

		if (title == null) {
			news_LogImpl.setTitle("");
		}
		else {
			news_LogImpl.setTitle(title);
		}

		if (info == null) {
			news_LogImpl.setInfo("");
		}
		else {
			news_LogImpl.setInfo(info);
		}

		if (content == null) {
			news_LogImpl.setContent("");
		}
		else {
			news_LogImpl.setContent(content);
		}

		news_LogImpl.setCreatedby(createdby);

		if (createdtime == Long.MIN_VALUE) {
			news_LogImpl.setCreatedtime(null);
		}
		else {
			news_LogImpl.setCreatedtime(new Date(createdtime));
		}

		news_LogImpl.setModifiedby(modifiedby);

		if (modifiedtime == Long.MIN_VALUE) {
			news_LogImpl.setModifiedtime(null);
		}
		else {
			news_LogImpl.setModifiedtime(new Date(modifiedtime));
		}

		news_LogImpl.setNguoinhanid(nguoinhanid);
		news_LogImpl.setNguoixulyid(nguoixulyid);

		if (ngayxuly == Long.MIN_VALUE) {
			news_LogImpl.setNgayxuly(null);
		}
		else {
			news_LogImpl.setNgayxuly(new Date(ngayxuly));
		}

		news_LogImpl.setStatus(status);

		if (language == null) {
			news_LogImpl.setLanguage("");
		}
		else {
			news_LogImpl.setLanguage(language);
		}

		news_LogImpl.setVersion(version);

		if (urlimagesmall == null) {
			news_LogImpl.setUrlimagesmall("");
		}
		else {
			news_LogImpl.setUrlimagesmall(urlimagesmall);
		}

		news_LogImpl.setLuotxem(luotxem);
		news_LogImpl.setIsnoibat(isnoibat);
		news_LogImpl.setArticleid(articleid);

		if (noidungxuly == null) {
			news_LogImpl.setNoidungxuly("");
		}
		else {
			news_LogImpl.setNoidungxuly(noidungxuly);
		}

		if (ngayxuatban == Long.MIN_VALUE) {
			news_LogImpl.setNgayxuatban(null);
		}
		else {
			news_LogImpl.setNgayxuatban(new Date(ngayxuatban));
		}

		if (ngayketthuc == Long.MIN_VALUE) {
			news_LogImpl.setNgayketthuc(null);
		}
		else {
			news_LogImpl.setNgayketthuc(new Date(ngayketthuc));
		}

		news_LogImpl.setIshethang(ishethang);
		news_LogImpl.setNguontin(nguontin);

		if (congtacvien == null) {
			news_LogImpl.setCongtacvien("");
		}
		else {
			news_LogImpl.setCongtacvien(congtacvien);
		}

		news_LogImpl.setLoaitintuc(loaitintuc);

		if (tukhoa == null) {
			news_LogImpl.setTukhoa("");
		}
		else {
			news_LogImpl.setTukhoa(tukhoa);
		}

		news_LogImpl.setSotinanh(sotinanh);
		news_LogImpl.setIsformbinhluan(isformbinhluan);
		news_LogImpl.setIsviewbinhluan(isviewbinhluan);

		news_LogImpl.resetOriginalValues();

		return news_LogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		id = objectInput.readLong();

		typeid = objectInput.readLong();

		idnewactivity = objectInput.readLong();
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
		urlimagesmall = objectInput.readUTF();

		luotxem = objectInput.readLong();

		isnoibat = objectInput.readLong();

		articleid = objectInput.readLong();
		noidungxuly = (String)objectInput.readObject();
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
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(id);

		objectOutput.writeLong(typeid);

		objectOutput.writeLong(idnewactivity);

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

		if (urlimagesmall == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(urlimagesmall);
		}

		objectOutput.writeLong(luotxem);

		objectOutput.writeLong(isnoibat);

		objectOutput.writeLong(articleid);

		if (noidungxuly == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(noidungxuly);
		}

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

	public long companyId;
	public long groupId;
	public long id;
	public long typeid;
	public long idnewactivity;
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
	public String urlimagesmall;
	public long luotxem;
	public long isnoibat;
	public long articleid;
	public String noidungxuly;
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