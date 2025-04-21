create table cw_gopy (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	tencoquan VARCHAR(75) null,
	phone VARCHAR(75) null,
	email VARCHAR(75) null,
	title VARCHAR(75) null,
	content VARCHAR(75) null,
	answer VARCHAR(75) null,
	ngay_guigopy DATE null,
	ngay_traloigopy DATE null,
	typeForm INTEGER,
	is_traloi INTEGER,
	is_pheduyet INTEGER
);

create table cw_gopy_dinhkemfile (
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
	status INTEGER
);

create table cw_gopy_emailTemplate (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	ten VARCHAR(75) null,
	noidung VARCHAR(75) null,
	loai INTEGER
);

create table cw_gopy_mailthongbao (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	ten VARCHAR(75) null,
	phone VARCHAR(75) null,
	email VARCHAR(75) null
);

create table cw_mailthongbao (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	ten VARCHAR(75) null,
	phone VARCHAR(75) null,
	email VARCHAR(75) null
);