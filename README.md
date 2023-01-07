## 슬기로운 대학생활 spring boot 기반 간단한 template 구현 프로젝트  

* jdk 17 
* gradle
* intellij

### DB 
#### db =  mysql
- src/resources/application,properties 에서 username, password 설정 
- db 는 board.sql로 가져오기
  - 회원테이블 구현 아직 안되어있어서 따로 추가필요
  - 외래키도 연결 안해놓았음
  - cli -> board.sql 디렉토리에서 
  - mysql -u 아이디 -p /board.sql + Enter
  - 비밀번호 입력 + 엔터

### 프로젝트 
    - intellij 에서 get from VCS 로 불러오거나 
    - 다운 받아서 build.gradle 클릭 

### jdk
- jdk 17 로 설정 되어있는데 8 이나 11 쓰고 싶으면, 
  - build.gradle 에서 sourceCompatibility = '쓰고싶은 jdk 버전' 변경하고 
  - intellij 기준 project structure 에서 sdk language,level 쓰고싶은 jdk 버전으로 변경

