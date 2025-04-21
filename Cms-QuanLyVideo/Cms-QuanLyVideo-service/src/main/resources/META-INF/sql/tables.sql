create table Cms_quanlyvideo_chude (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	ten VARCHAR(75) null,
	moTa VARCHAR(75) null,
	trangThai LONG,
	daXoa LONG,
	ngayTao DATE null,
	ngaySua DATE null
);

create table cms_quanlyvideo_chudevideo (
	id_ LONG not null primary key,
	chude_id LONG,
	video_id LONG
);

create table cms_quanlyvideo_video (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	ten VARCHAR(75) null,
	moTa VARCHAR(75) null,
	noiDung VARCHAR(75) null,
	duongDan VARCHAR(75) null,
	luotXem LONG,
	luotThich LONG,
	tuKhoa VARCHAR(75) null,
	choBinhLuan LONG,
	trangThai LONG,
	daXoa LONG,
	ngayTao DATE null,
	ngaySua DATE null
);