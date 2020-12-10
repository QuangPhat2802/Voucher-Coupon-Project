create schema coupon;
use coupon;

create table customer (
	customer_phone int(20) not null primary key,
    customer_name varchar(50) not null 
);

create table voucher(
	voucher_code varchar(20) not null primary key,
    voucher_name varchar(100) not null,
    description varchar(100) not null,
    quantity 	int(11) not null,
    discount	int(11)	 not null,
    maxPriceDiscount double not null,
    minPrice	double	not null,
    startDate	date	not null,
    endDate		date	not null,
    status		int(11)	not null
);

create table orders(
	orders_ID	int(11) not null auto_increment,
    price	double  not null,
    customer_phone	int(11),
    voucher_code	varchar(45),
    primary key(orders_ID),
    constraint orders_fk foreign key (customer_phone) references customer(customer_phone)
);

create table customer_voucher
(
	id_CustomerVoucher int(11) not null auto_increment,
    customer_phone 	int(20) not null,
    voucher_code	varchar(20) not null,
    primary key(id_CustomerVoucher),
    constraint phone_fk foreign key (customer_phone) references customer(customer_phone),
    constraint voucherCode_fk foreign key (voucher_code) references voucher(voucher_code)
);

insert into customer values 
( 98, 'dao'),
(123123, 'quang'),
( 11112222, 'phat'),
( 123456789, 'tuan'),
( 737286892, 'khoa'),
( 987654321, 'phat'),
( 1234567891, 'sang');

insert into voucher values 
('NGVN2011', 'NGAY NHA GIAO VIET NAM', 'GIAM 10% CHO DON 100K', 1, 10, 20000, 100000, '2020-11-11', '2020-12-11', 0),
('QA29', 'QUOC KHANH', 'GIAM 15% CHO DON 100K', 1, 15, 30000, 100000, '2020-10-10', '2020-10-30', 0),
('QA2s9', 'QUOC KHANH', 'GIAM 15% CHO DON 50K', 1, 15, 15000, 50000, '2020-10-10', '2020-10-30', 1),
('QK29', 'QUOC KHANH', 'GIAM 10% CHO DON 100K', 15, 15, 15000, 50000, '2020-10-10', '2020-10-20', 0),
('SNDMX', 'SINH NHAT DIEN MAY XANH', 'GIAM 10% CHO DON 50K', 10, 10, 10000, 50000, '2020-10-10', '2020-10-25', 0);


-- join 2 bang
select * from customer_voucher join voucher on customer_voucher.voucher_code = voucher.voucher_code where 
(voucher.minPrice >= 100000 and voucher.status = 0)