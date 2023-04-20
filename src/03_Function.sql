--03_Function.sql

--숫자 관련 함수
--abs(숫자) - 절댓값 계산
--ceiling(숫자) - 값보다 큰 정수 중 가장 작은 수
--floor(숫자) - 값보다 작은 정수 중 가장 큰 수 [ 실수를 무조건 버림 (음수일 경우 제외) ] 
--round(숫자,자릿수) - 소수점 자릿수만큼 남기고 아래서 반올림
--truncate(숫자,자릿수)-round와 같은 동작이지만 반올림이 아닌 버림
--pow(x,y)-x의 y자승
--mod(x,y) - x를 y로 나눈 나머지 계산
--greatest(x,y,z...) - 주어진 숫자 중에서 가장 큰 숫자
--least(x,y,z...)- 주어진 숫자 중에서 가장 작은 숫자


--문자 관련 함수
--ascii( 문자 ) - 해당 문자의 아스키 코드 값
--concat(문자열1, 문자열2, 문자열 3......) - 주어진 문자열들 이어붙이기 연산
--insert(문자열, 시작위치, 길이, 바꿀 문자열) - 문자열의 시작위치부터 길이만큼 바꿀 문자열로 대치
--replace(문자열, 기본문자열, 바꿀 문자열) - 문자열 안에 이는 기본 문자열을 바꿀 문자열로 대치
--INSTR('문자열','찾는문자열')-  문자열 중 찾는 문자열의 위치값을 출력
--LEFT('문자열',개수)-문자열 중 왼쪽에서 개수만큼을 추출
--RIGHT('문자열',개수)-문자열 중 오른쪽에서 개수만큼을 추출
--MID('문자열',시작위치,개수)- 문자열 중 시작 위치부터 개수만큼 출력
--SUBSTRING('문자열',시작위치,개수)- 문자열 중 시작위치부터 개수만큼 출력
--LTRIM('문자열') -문자열중 왼쪽의 공백을 없앰
--RTRIM('문자열')-문자열중 오른쪽의 공백을 없앰
--TRIM('문자열')- 양쪽 모두의 공백을 없앰
--LCASE('문자열') or LOWER('문자열') -소문자로 바꿈
--UCASE('문자열')or UPPER('문자열') -대문자로 바꿈
--REVERSE('문자열') - 문자열을 반대로 나열


--집계함수 (그룹함수)
--count(필드명) - null값이 아닌 레코드의 수를 구함
--sum(필드명) - 필드명의 합계를 구함
--avg(필드명)  - 각각의 그룹 안에서 필드명의 평균값을 구함
--max(필드명) - 최댓값 구함
--min(필드명) - 최솟값 구함

--날짜관련 함수
--now() - 현재 날짜와 시간(datetime 형식)
--curdate() or current_date() - 현재 날짜(date형식)
--curtime() or current_time() - 현재 시간(time형식)
--date_add(날짜, interval 기준값 더할 숫자) 날짜에서 기준값만큼 더함
--기준값 : YEAR, MONTH , DAY, HOUR, MINUTE, SECOND
select date_add(now(),INTERVAL 3 YEAR)from dual;

--date_sub(날짜, interval 기준값 뺼 숫자) 날짜에서 기준값만큼 뺌
--기준값 : YEAR, MONTH , DAY, HOUR, MINUTE, SECOND
select date_sub(now(),INTERVAL 3 day)from dual;


--year(날짜) - 날짜의 연도 출력
--month(날짜) - 날짜의 월 출력
--monthname - 날짜의 월을 영어로 출력
--dayname(날짜) - 날짜의 요일을 영어로 출력
--dayofmonth(날짜) - 날짜의 월별 일자 출력
--dayofweek(날짜) - 날짜의 주별 일자 출력 ( 1.일요일, 2.월요일 ...)
--weekday(날짜) - 날짜의 주별 일자 출력 (0. 월요일, 1. 화요일...)
--dayofyear(날짜) - 1년을 기준으로 한 날짜까지의 일 수
--week(날짜) - 1년 중 몇 번째 주인지 출력
--from_days(날짜) - 00년 00월 00일부터 일 수 만큼 경과한 날의 날짜 출력
--to_days(날짜) - 00년 00월 00일부터 날짜까지의 일자 수 출력
--date_format(날짜,'형식') - 날짜를 형식에 맞게 출력

--오라클의 to_char(SYSDATE,'YYYYMMDD') 날짜 -> 문자
--오라클의 to_date('20230420','YYYYMMDD') 문자 -> 날짜

--Mysql
--date_format(now(),'%Y%m%d')
--str_to_date('20211013','%Y%m%d')

select date_format(now(),'%Y%m%d') from dual;
select str_to_date('20211013','%Y%m%d') from dual;

--%a		일(Sun~Sat)				
--%c		월(0~12)					
--%d		일(01~31)					
--%f		Microseconds(000000 to 999999)							
--%H	시간(00~23)								
--%I		시간(00~12)								
--%j		Day of the year(001 to 366)							
--%k		시간(0~23)								
--%M	월(January~December)								
--%p		AM or PM							
--%r		시간(12시)을 hh:mm:ss AM/PM형식으로							
--%S	초(00~59)								
--%T		시간(24시)을 hh:mm:ss 형식으로		

--%b		월(Jan ~ Dec)
--%D	일(1st,2nd...)
--%e
--%h
--%i
--%l		
--%m	월(1~12)
--%s		초(00~59)









