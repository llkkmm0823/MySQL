-- 02_DML.sql

-- 세개의 테이블에 각 필드의 자료형과 제약사항에 맞게 각 10개의 레코드를 insert

--booklist

insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('좀비아이',2020,12000,2500,'all');
insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('일곱해의 마지막',2020,12150,2000,'all');
insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('봉제인형 살인사건',2020,12000,2500,'13');
insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('쇼코의 미소',2019,10800,2500,'18');
insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('가면산장 살인사건',2018,13320,1500,'13');
insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('나미야잡화점의 기적',2017,13320,2000,'18');
insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('유튜브 영상편집',2020,20700,2500,'all');
insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('이것이 자바다',2017,30000,3000,'18');
insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('JSP웹프로그래밍',2016,25000,2500,'13');
insert into scott.booklist(subject,makeyear,inprice,rentprice,grade) values('오라클데이터베이스',2020,30000,3000,'all');


--memberlist

insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('홍길동','010-1111-2222','80/06/18',240,40,'F');
insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('홍길서','010-2222-3333','90/02/19',340,35,'M');
insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('홍길남','010-3333-4444','00/12/14',440,22,'F');
insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('홍길북','010-4444-5555','97/11/01',540,27,'M');
insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('추신수','010-6666-7777','84/07/07',240,28,'M');
insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('류현진','010-8888-9999','83/08/08',142,27,'M');
insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('손흥민','010-0000-1111','84/06/14',330,31,'M');
insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('이청용','010-1212-1212','84/12/04',250,25,'F');
insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('이영표','010-2323-2323','84/07/28',100,33,'F');
insert into scott.memberlist(name,phone,birthday,bpoint,age,gender)
values('최지만','010-3434-3434','84/04/12',20,29,'F');


--rentlist 
insert into scott.rentlist(bnum,mnum,discount)values(1,1,100);
insert into scott.rentlist(bnum,mnum,discount)values(1,10,100);
insert into scott.rentlist(bnum,mnum,discount)values(2,9,100);
insert into scott.rentlist(bnum,mnum,discount)values(3,8,100);
insert into scott.rentlist(bnum,mnum,discount)values(4,7,100);
insert into scott.rentlist(bnum,mnum,discount)values(5,6,100);
insert into scott.rentlist(bnum,mnum,discount)values(6,5,100);
insert into scott.rentlist(bnum,mnum,discount)values(7,4,100);
insert into scott.rentlist(bnum,mnum,discount)values(8,3,100);
insert into scott.rentlist(bnum,mnum,discount)values(9,2,100);
insert into scott.rentlist(bnum,mnum,discount)values(10,1,100);


select*from scott.booklist;
select*from scott.memberlist;
select*from scott.rentlist;


