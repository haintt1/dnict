create table cms_lienhe_canbo (
	canboId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	ten VARCHAR(75) null,
	chucVu VARCHAR(75) null,
	phongban_id LONG,
	sdt VARCHAR(75) null,
	email VARCHAR(75) null,
	tinhTrang LONG,
	sapXep INTEGER,
	daXoa LONG,
	ngayTao DATE null,
	ngaySua DATE null
);

create table cms_lienhe_phongban (
	phongbanId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	ten VARCHAR(75) null,
	moTa VARCHAR(75) null,
	tochuc_id LONG,
	tinhTrang LONG,
	sapXep INTEGER,
	daXoa LONG,
	ngayTao DATE null,
	ngaySua DATE null
);

create table cms_lienhe_tochuc (
	tochucId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	ten VARCHAR(75) null,
	moTa VARCHAR(75) null,
	tinhTrang LONG,
	sapXep INTEGER,
	daXoa LONG,
	ngayTao DATE null,
	ngaySua DATE null
);