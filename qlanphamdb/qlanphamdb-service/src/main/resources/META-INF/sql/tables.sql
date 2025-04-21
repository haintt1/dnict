create table cw_AnPham_Activity (
	companyId LONG,
	groupId LONG,
	id_ LONG not null primary key,
	deCuongId LONG,
	anPhamId LONG,
	startuserid LONG,
	enduserid LONG,
	contentrequest VARCHAR(75) null,
	statusofarticle INTEGER
);

create table cw_AnPham_CongTacVien (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	hoTen VARCHAR(75) null,
	email VARCHAR(75) null,
	thongTin VARCHAR(75) null,
	status INTEGER,
	orders LONG,
	delete_status INTEGER
);

create table cw_AnPham_DeCuong (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	ten VARCHAR(75) null,
	moTa VARCHAR(75) null,
	loaiId LONG,
	noiDung VARCHAR(75) null,
	phienBan LONG,
	nguoiTao LONG,
	ngayTao DATE null,
	nguoiSua LONG,
	ngaySua DATE null,
	nguoiNhan LONG,
	nguoiXuLy LONG,
	ngayXuLy DATE null,
	language VARCHAR(75) null,
	status INTEGER,
	orders LONG,
	delete_status INTEGER
);

create table cw_AnPham_DinhKemFile (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	ten VARCHAR(75) null,
	url VARCHAR(75) null,
	Object LONG,
	ObjectId LONG,
	luotTai LONG,
	ghiChu VARCHAR(75) null,
	delete_status INTEGER,
	status INTEGER
);

create table cw_AnPham_Loai (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	ten VARCHAR(75) null,
	status INTEGER,
	orders LONG,
	delete_status INTEGER
);

create table cw_AnPham_Logs (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	activityId LONG,
	ten VARCHAR(75) null,
	slug VARCHAR(75) null,
	moTa VARCHAR(75) null,
	anhDaiDien VARCHAR(75) null,
	loaiId LONG,
	deCuongId LONG,
	noiDung VARCHAR(75) null,
	tuKhoa VARCHAR(75) null,
	phienBan LONG,
	luotXem LONG,
	anPhamId LONG,
	noiDungLog VARCHAR(75) null,
	nguoiTao LONG,
	ngayTao DATE null,
	nguoiSua LONG,
	ngaySua DATE null,
	nguoiNhan LONG,
	nguoiXuLy LONG,
	ngayXuLy DATE null,
	language VARCHAR(75) null,
	loaiTin INTEGER,
	isFormHienBinhLuan INTEGER,
	isFormViewBinhLuan INTEGER,
	status INTEGER,
	orders LONG,
	delete_status INTEGER
);

create table cw_AnPham_PhanCong (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	loaiId LONG,
	deCuongId LONG,
	ctvId LONG,
	noiDung VARCHAR(75) null,
	ghiChu VARCHAR(75) null,
	ngaybatdau DATE null,
	ngayketthuc DATE null,
	status INTEGER,
	is_gui INTEGER
);

create table cw_AnPham_TapChi (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	ten VARCHAR(75) null,
	slug VARCHAR(75) null,
	moTa VARCHAR(75) null,
	anhDaiDien VARCHAR(75) null,
	loaiId LONG,
	deCuongId LONG,
	noiDung VARCHAR(75) null,
	tuKhoa VARCHAR(75) null,
	phienBan LONG,
	luotXem LONG,
	nguoiTao LONG,
	ngayTao DATE null,
	nguoiSua LONG,
	ngaySua DATE null,
	nguoiNhan LONG,
	nguoiXuLy LONG,
	ngayXuLy DATE null,
	language VARCHAR(75) null,
	loaiTin INTEGER,
	isFormHienBinhLuan INTEGER,
	isFormViewBinhLuan INTEGER,
	status INTEGER,
	orders LONG,
	delete_status INTEGER
);

create table cw_eMagazine (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	ten VARCHAR(75) null,
	slug VARCHAR(75) null,
	moTa VARCHAR(75) null,
	anhDaiDien VARCHAR(75) null,
	mauChuDao VARCHAR(75) null,
	hinhNen VARCHAR(75) null,
	templateId LONG,
	noiDung VARCHAR(75) null,
	tuKhoa VARCHAR(75) null,
	phienBan LONG,
	luotXem LONG,
	nguoiTao LONG,
	ngayTao DATE null,
	nguoiSua LONG,
	ngaySua DATE null,
	nguoiNhan LONG,
	nguoiXuLy LONG,
	ngayXuLy DATE null,
	language VARCHAR(75) null,
	isFormHienBinhLuan INTEGER,
	isFormViewBinhLuan INTEGER,
	status INTEGER,
	orders LONG,
	delete_status INTEGER
);

create table cw_eMagazine_Logs (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	ten VARCHAR(75) null,
	slug VARCHAR(75) null,
	moTa VARCHAR(75) null,
	anhDaiDien VARCHAR(75) null,
	mauChuDao VARCHAR(75) null,
	hinhNen VARCHAR(75) null,
	templateId LONG,
	noiDung VARCHAR(75) null,
	tuKhoa VARCHAR(75) null,
	phienBan LONG,
	luotXem LONG,
	nguoiTao LONG,
	ngayTao DATE null,
	nguoiSua LONG,
	ngaySua DATE null,
	nguoiNhan LONG,
	nguoiXuLy LONG,
	ngayXuLy DATE null,
	language VARCHAR(75) null,
	isFormHienBinhLuan INTEGER,
	isFormViewBinhLuan INTEGER,
	status INTEGER,
	orders LONG,
	delete_status INTEGER
);

create table cw_eMagazine_template (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	ten VARCHAR(75) null,
	noidung VARCHAR(75) null,
	status INTEGER
);