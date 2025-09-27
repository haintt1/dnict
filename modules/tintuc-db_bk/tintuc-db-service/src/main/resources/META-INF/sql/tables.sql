create table cw_News_Activity (
	companyId LONG,
	groupId LONG,
	id_ LONG not null primary key,
	articleid LONG,
	startuserid LONG,
	enduserid LONG,
	contentrequest TEXT null,
	statusofarticle INTEGER
);

create table cw_News_Article (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	typeid LONG,
	title TEXT null,
	info STRING null,
	content TEXT null,
	createdby LONG,
	createdtime DATE null,
	modifiedby LONG,
	modifiedtime DATE null,
	nguoinhanid LONG,
	nguoixulyid LONG,
	ngayxuly DATE null,
	status INTEGER,
	language VARCHAR(75) null,
	version LONG,
	delete_status INTEGER,
	urlimagesmall TEXT null,
	luotxem LONG,
	isnoibat LONG,
	ngayxuatban DATE null,
	ngayketthuc DATE null,
	ishethang LONG,
	nguontin LONG,
	congtacvien STRING null,
	loaitintuc INTEGER,
	tukhoa VARCHAR(75) null,
	sotinanh INTEGER,
	isformbinhluan INTEGER,
	isviewbinhluan INTEGER
);

create table cw_News_Article2Category (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	newcategoryId LONG,
	newarticleId LONG
);

create table cw_News_AttachFile (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	ten STRING null,
	url TEXT null,
	Object LONG,
	ObjectId LONG,
	ghichu STRING null,
	daxoa INTEGER,
	trangthai INTEGER
);

create table cw_News_BinhLuan (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	newarticleId LONG,
	hoTen VARCHAR(75) null,
	noiDung VARCHAR(75) null,
	ngayBinhLuan DATE null,
	status INTEGER,
	orders INTEGER,
	delete_status INTEGER
);

create table cw_News_Categories (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name STRING null,
	language VARCHAR(75) null,
	status INTEGER,
	orders INTEGER,
	idlibcat LONG,
	delete_status INTEGER
);

create table cw_News_Log (
	companyId LONG,
	groupId LONG,
	id_ LONG not null primary key,
	typeid LONG,
	idnewactivity LONG,
	title TEXT null,
	info STRING null,
	content TEXT null,
	createdby LONG,
	createdtime DATE null,
	modifiedby LONG,
	modifiedtime DATE null,
	nguoinhanid LONG,
	nguoixulyid LONG,
	ngayxuly DATE null,
	status INTEGER,
	language VARCHAR(75) null,
	version LONG,
	urlimagesmall TEXT null,
	luotxem LONG,
	isnoibat LONG,
	articleid LONG,
	noidungxuly TEXT null,
	ngayxuatban DATE null,
	ngayketthuc DATE null,
	ishethang LONG,
	nguontin LONG,
	congtacvien STRING null,
	loaitintuc INTEGER,
	tukhoa VARCHAR(75) null,
	sotinanh INTEGER,
	isformbinhluan INTEGER,
	isviewbinhluan INTEGER
);

create table cw_News_NguonTin (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name STRING null,
	status INTEGER,
	orders INTEGER,
	delete_status INTEGER
);

create table cw_News_Subcategories (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name STRING null,
	language VARCHAR(75) null,
	status INTEGER,
	orders INTEGER,
	delete_status INTEGER
);

create table cw_News_Type (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name STRING null,
	language VARCHAR(75) null,
	status INTEGER,
	orders INTEGER,
	delete_status INTEGER
);

create table cw_News_role (
	companyId LONG,
	groupId LONG,
	id_ LONG not null primary key,
	userid LONG,
	role_add INTEGER,
	role_edit INTEGER,
	role_public INTEGER,
	category_active_role TEXT null
);