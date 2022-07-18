-- 建立 Emp 資料表
create table if not exists emp (
	eid int not null auto_increment, -- 主鍵
	ename varchar(30) not null unique, -- 員工姓名
	age int, -- 員工年齡
	createtime timestamp default current_timestamp, -- 建檔時間
	primary key(eid)
);

-- 建立 Job 資料表
create table if not exists job (
	jid int not null auto_increment, -- 主鍵
	jname varchar(50) not null, -- 工作名稱
	eid int, -- 員工 id
	primary key(jid),
	foreign key(eid) references emp(eid) -- 外鍵關聯
);


-- 每一個有工作指派的員工之工作列表
select e.ename , j.jname 
from emp e, job j
where e.eid = j.eid 
order by e.ename;

-- 每一個員工有幾項工作(交集) - 1 ?
select e.ename, count(j.jname) as total
from emp e inner join job j on e.eid = j.eid 
group by e.ename
order by e.ename;

-- 每一個員工有幾項工作(交集) - 2 ?
select e.ename, count(j.jname) as total
from emp e, job j
where e.eid = j.eid 
group by e.ename
order by e.ename;

-- 每一個員工有幾項工作(left join 向左關聯) - 3 ?
select e.ename, count(j.jname) as total
from emp e left join job j on e.eid = j.eid 
group by e.ename
order by e.ename;

-- 沒有工作的員工
select e.ename
from emp e left join job j on e.eid = j.eid 
where j.eid is null;

-- 沒有員工的工作
select j.jname
from emp e right join job j on e.eid = j.eid 
where j.eid  is null;

select j.jname
from job j
where j.eid is null;

-- tx 交易資料表
-- book (書籍資料), stock (庫存資料), wallet (客戶雲端錢包)
-- 建立 book (書籍資料) 表
create table if not exists book(
	bid integer not null auto_increment,
	bname varchar(20) not null,
	price integer default 0,
	ct timestamp default current_timestamp,
	primary key (bid)
); 

-- 建立 stock (庫存資料) 表
create table if not exists stock(
	sid integer not null auto_increment,
	bid integer not null, -- book 的 bid
	amount integer default 0,
	primary key (sid),
	foreign key(bid) references book(bid) -- 外鍵關聯
);

-- 建立 wallet (客戶雲端錢包) 表
create table if not exists wallet(
	wid integer not null auto_increment,
	wname varchar(20) not null,
	money integer default 0,
	primary key (wid)
);