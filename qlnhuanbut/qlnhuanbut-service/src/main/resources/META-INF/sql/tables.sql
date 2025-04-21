create table cw_nhuanbut_dinhmuc (
	id_ LONG not null primary key,
	loaidinhmuc INTEGER,
	gia VARCHAR(75) null
);

create table cw_nhuanbut_hesoloaiAP (
	id_ LONG not null primary key,
	loaiId LONG,
	minheso VARCHAR(75) null,
	maxheso VARCHAR(75) null
);

create table cw_nhuanbut_hesotheloai (
	id_ LONG not null primary key,
	typeId LONG,
	minheso VARCHAR(75) null,
	maxheso VARCHAR(75) null
);

create table cw_nhuanbut_thongke (
	id_ LONG not null primary key,
	nguoixuly LONG,
	newarticleId LONG,
	anphamId LONG,
	heso VARCHAR(75) null,
	tongtien DOUBLE,
	status INTEGER,
	ngaytao DATE null,
	ngaysua DATE null
);