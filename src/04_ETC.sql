--04_ETC.sql
--command 창에서 운영되는 mysql프로그램 접속

--mysql -h localhost -u root -p
--h는 호스트 u는 사용자 p는 비밀번호 의미

--my sql 종료는 quit or exit

--Schema 생성
create schema scott default character set utf8mb4;

--사용하려는 스키마로 이동
use scott;

--현재 스키마의 테이블들 보기
show tables;

--테이블의 구조 보기
desc 테이블이름;


--Limit
--몇개를 볼건지
--select로 데이터 조회할 때 조회할 레코드의 갯수를 조절 제한 할 수 있음
select*from memberlist order by membernum desc limit 5;
--회원 정보 조회하여 5개의 레코드만 리턴

--OFFSET
--몇번쨰부터 볼건지
--select로 데이터 조회할 때, 맨 위에서부터 offset에 지정한 순서까지는 뛰어넘고 그 다음부터 리턴
select*from memberlist order by membernum desc limit 10 offset 5;
--6번째 데이터 부터 10개의 레코드 리턴 - 개수 모자를 경우 있는 개수까지만 리턴


--limit 와 offset의 동시 사용
select*from memberlist order by membernum desc limit 5 offset 5;
--6번째 데이터 부터 5개의 레코드 리턴

--offset과 limit는 게시판이나 상품 진열 시에 페이지를 표시하기 위한 용도로 가장 많이 사용됨





