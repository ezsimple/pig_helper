# Old PigPlan Helper

### 2020년 운영중인 LPP(Legacy PigPlan) 지원을 위해 구현되었습니다
- 이지팜에서만 접속 가능 합니다.
- 피그플랜 운영팀 지원을 위해 제작 되었습니다.

### 개발환경 정보
- springboot (spring5)
- java8 (64bit)
- oracle 연동
- mybatis 지원

### 설치
- git clone http://gitlab.pigplan.com/egg/pig_helper.git 
- "File>Import>Projects from Folder or Archive" with Eclipse

### 개발
- boot Dashboard with eclipse
- open config>Spring Boot탭> profile => local 추가
 
### 빌드
- mvn clean package -DskipTests=true

### 실행
- java -Dspring.profiles.active=local -jar target/pigHelper-*.war
