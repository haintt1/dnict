create table cw_quangcao_banner (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	nguoitao LONG,
	ten VARCHAR(75) null,
	duongdan VARCHAR(75) null,
	lienket VARCHAR(75) null,
	nhomKH LONG,
	vitriQC LONG,
	ngaytao DATE null,
	ngayketthuc DATE null,
	daxoa INTEGER,
	trangthai INTEGER,
	trangthaisudung INTEGER,
	ngaysua DATE null
);

create table cw_quangcao_nhomkhachhang (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	nguoitao LONG,
	ten VARCHAR(75) null,
	nguoidaidien VARCHAR(75) null,
	logo VARCHAR(75) null,
	mota VARCHAR(75) null,
	diachi VARCHAR(75) null,
	sdt VARCHAR(75) null,
	email VARCHAR(75) null,
	ngaytao DATE null,
	daxoa INTEGER,
	trangthai INTEGER,
	ngaysua DATE null
);

create table cw_quangcao_vitridanhmuc (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	nguoitao LONG,
	ten VARCHAR(75) null,
	cssClass VARCHAR(75) null,
	kichthuoc VARCHAR(75) null,
	ngaytao DATE null,
	daxoa INTEGER,
	trangthai INTEGER,
	ngaysua DATE null
);