create table cw_capbanhanh (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	status INTEGER
);

create table cw_coquanbanhanh (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	status INTEGER
);

create table cw_dinhkemfile (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	ten VARCHAR(75) null,
	url VARCHAR(75) null,
	Object LONG,
	ObjectId LONG,
	ghichu VARCHAR(75) null,
	daxoa INTEGER,
	trangthai INTEGER
);

create table cw_linhvucvanban (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	status INTEGER
);

create table cw_loaivanban (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	status INTEGER
);

create table cw_vanbanphapquy (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	sohieu VARCHAR(75) null,
	trichyeu VARCHAR(75) null,
	noidung VARCHAR(75) null,
	ngay_banhanh DATE null,
	ngay_hieuluc DATE null,
	ngay_hethieuluc DATE null,
	ngay_xuatban DATE null,
	id_linhvuc LONG,
	id_loaivanban LONG,
	id_capbanhanh LONG,
	id_coquanbanhanh LONG,
	nguoiky VARCHAR(75) null,
	status INTEGER,
	type_ VARCHAR(75) null
);