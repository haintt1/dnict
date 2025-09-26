create table lcq_lichcoquan (
	lichCongtacId LONG not null primary key,
	companyId LONG,
	userId LONG,
	content VARCHAR(75) null,
	createDate DATE null,
	tungay DATE null,
	denngay DATE null,
	trangthai INTEGER,
	banhanh INTEGER,
	tuan INTEGER,
	nam INTEGER
);