# Eggplan ETL 분석

### ETL쿼리의 JSON_ARRAYAGG, JSON_OBJECT 4K 문제점 분석
- [egg_etl_local](http://gitlab.pigplanxe.co.kr/egg/egg_etl_local) 개발환경과 연동 필수
- 개발 완료후, ETL팀으로 이관 합니다.
- 표준 Type B에 한해 std-idx 를 추가합니다. (ps-idx-v2-, broiler-idx-v2-, snap-idx-v2-, std-idx-v2-)
- 종계, 육계, snap의 ETL 쿼리는 [cj-chickenyard-statistics/sql/curl](http://gitlab.pigplan.com/bearrundr/cj-chickenyard-statistics) 을 기준으로 합니다.
- 주기적으로 ORACLE -> ES 로 ETL정보를 전달 합니다. (_bulk API 방식) 
- Egg ETL은 airflow를 사용하지 않습니다.

### 개발환경 정보
- springboot (spring5)
- java8 (64bit)
- oracle, elasticsearch 연동
- mybatis, scheduler 지원

### 설치
- git clone http://gitlab.pigplan.com/egg/egg_etl_anal.git 
- "File>Import>Projects from Folder or Archive" with Eclipse

### 개발
- boot Dashboard with eclipse
- open config>Spring Boot탭> profile => local 추가
 
### 빌드
- mvn clean package -DskipTests=true

### 실행
- java -Dspring.profiles.active=local -jar target/Egg-ETL-*.war
