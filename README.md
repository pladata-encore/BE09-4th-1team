# ✅ 프로젝트 기획서
---

## **1. 프로젝트 개요**

본 프로젝트는 사용자들의 피드백을 효율적으로 수렴하고 관리하며, 필요한 경우 전문가와의 상담 예약을 지원하기 위한 '사용자 건의 게시판 및 상담 예약 시스템' 구축을 목표로 합니다. 기존에는 사용자의 의견을 통합적으로 관리하고 처리하는 시스템과 상담 예약 시스템이 분리되어 있거나 부족하여, 중요한 건의 사항들이 누락되거나 처리 과정이 불투명하고, 상담 예약 과정이 번거롭다는 문제점이 있었습니다.

이에 따라, 사용자 친화적인 인터페이스를 통해 자유롭게 의견을 제안하고, 운영진이 이를 체계적으로 검토하고 답변하며, 사용자가 필요시 편리하게 상담을 예약할 수 있는 통합 시스템을 개발함으로써 다음과 같은 목적을 달성하고자 합니다.

## **2. Target**

- **일반 사용자 (수강생)**
PlayData 수강생
- **관리자 (매니저 역할)**
매니저가 건의된 게시물을 관리하고
삼담 예약 리스트를 관리한다.

## **3. Skill Stack**
- **Back-end**
    - Java 17 - 안정성과 최신 문법 지원을 위한 언어 선택
    - Spring Boot 3.4.6 - RESTFUL API 개발을 위한 핵심 프레임워크
    - Spring Security  - 인증 및 권한 부여 기능 구현
    - Spring DATA JPA - ORM 기반 데이터베이스 연동
    - MySQL - 주요 데이터 저장용 RDBMS
    - JWT - 사용자 인증을 위한 토큰 기반 인증
    - ModelMapper - DTO 변환을 위한 객체 매핑 도구
- **Front-end**
    - Next.js
    - Figma
- **Microservices & Infra**
    - Spring Cloud Gateway - API Gateway 역할 수행
    - Spring Cloud Netflix Eureka - 서비스 등록 및 디스커버리
    - Spring Boot Actuator - 어플리케이션 모니터링
    - Lombok - 코드 간결화를 위한 어노테이션 활용
- **API 문서화**
    - Springdoc OpenAPI (Swagger) - 자동 API 문서화 및 테스트 UI 제공
- **DEV Tools & etc**
    - IntelliJ IDEA - Main Developement Tool
    - Gradle - Build Tool
    - Git - Version management Tool


---

## **4. 개발 방식 및 전략**

- **Domain - Driven Design**
    - 각 Service 는 명확한 Domain 책임을 기준으로 분리되어 독립적인 기능을 수행합니다.
- **RESTFUL API 설계 원칙 준수**
    - HTTP method 와 URI 구조를 명확하게 정의하여 일관성 있는 API 제공
- **JWT 기반 인증 및 인가**
    - 인증은 User Service에서 JWT 토큰을 발급하고, 각 Service 에서는 해당 토큰을 검증하여 사용자 권한을 판단합니다.
- **Spring Cloud Gateway 도입**
    - Gateway에서 모든 요청을 통제하여 각 마이크로서비스로 안전하게 전달하고, 인증 필터를 통해 사용자 검증을 사전 수행합니다.
- **Git Flow 전략 기반 협업**
    - main, develop, feature 브랜치 전략을 통해 안정적인 배포 및 기능 개발을 병행
- **무중단 배포 고려한 Service 구조**
    - 각 Service는 Eureka를 통해 동적으로 등록 및 탐색되며, 장애 발생 시 빠른 대체가 가능하도록 구성


---

## 담당 기능
| 담당자 이름     | 담당 서버               | 담당 기능 요약                              |
| ---------- | ------------------- | ------------------------------------- |
| **박경빈**  | Gateway Service     | 요청 라우팅, 인증 토큰 전달                      |
|    **박경빈, 이지용(수정)**        | User Service        | 회원가입, 로그인, 사용자 정보 조회/수정, 관리자 회원 정보 조회 |
| **이지용**  | Post Service        | 방 등록, 수정, 삭제, 전체 조회, 상세 조회, 여러 방 조회   |
| **이정아**  | Comment Service | 예약 생성, 예약된 날짜 조회, 예약 내역 조회, 예약 취소     |
| **배기열**  | Consulting Service      | 후기 등록, 수정, 삭제, 조회                     |
| **박범석** | Consulting Service     | 결제 요청, 결제 완료 처리, 결제 정보 조회                |


# 요구사항 정의서 

https://docs.google.com/spreadsheets/d/18heKIvtCEeLmmqbgbxwCm-M8fHrgas_MCLrR1lYweRU/edit?gid=0#gid=0


# 스토리 보드, 엔티티 등등
https://www.figma.com/board/SdLq0ZnkC8uMk8ojWZTLyJ/PLAYDATA-BE09-4th-Team1?node-id=0-1&t=jJXrL4LDV5KICbHE-1

# UI/UX 디자인
https://www.figma.com/design/OtgkvyPrx8EjbmuAway58b/PLAYDATA-BE09-4th-Team1?node-id=0-1&t=9zzYje6fjI8ofRYD-1


# 테스트 케이스 및 결과서
# Post Service

테스트케이스

| TC ID | 서비스 | 기능 | 권한 | 시나리오 설명 | 입력값 예시 | 예상 응답 내용 | HTTP 코드 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| TC-POST-001 | post-service | 건의 게시물 생성 | `student` | 건의 게시물 생성 | title, content | 생성됨 | `200 OK` |
| TC-POST-002 | post-service | 건의 게시물 수정 | `student` | 건의 게시물 수정 | postId, title, content | 수정됨 | `200 OK` |
| TC-POST-003 | post-service | 건의 게시물 삭제 | `student` | 건의 게시물 삭제 | postId | 삭제됨 | `200 OK` |
| TC-POST-004 | post-service | 건의 게시물 조회 | `student` | 건의 게시물 조회 | - | 게시물 조회됨 | `200 OK` |
| TC-POST-005 | post-service | 건의 게시물 좋아요 | `student` | 건의 게시물 좋아요 | postid | 좋아요 적용됨 | `200 OK` |
| TC-POST-006 | post-service | 건의 게시물 싫어요 | `student` | 건의 게시물 싫어요 | postid | 싫어요 적용됨 | `200 OK` |
| TC-POST-007 | post-service | 답변 게시물 생성 | `manager` | 답변 게시물 생성 | title, content, postId | 생성됨 | `200 OK` |
| TC-POST-008 | post-service | 답변 게시물 수정 | `manager` | 답변 게시물 수정 | postId, title, content | 수정됨 | `200 OK` |
| TC-POST-009 | post-service | 답변 게시물 삭제 | `manager` | 답변 게시물 삭제 | postId | 삭제됨 | `200 OK` |
| TC-POST-010 | post-service | 답변 게시물 조회 | `manager` | 답변 게시물 조회 | - | 게시물 조회됨 | `200 OK` |
| TC-POST-011 | post-service | 답변 게시물 좋아요 | `manager` | 답변 게시물 좋아요 | postid | 좋아요 적용됨 | `200 OK` |
| TC-POST-012 | post-service | 답변 게시물 싫어요 | `manager` | 답변 게시물 싫어요 | postid | 싫어요 적용됨 | `200 OK` |

# Comment Service

| TC ID | 서비스 | 기능 | 권한 | 시나리오 설명 | 입력값 예시 | 예상 응답 내용 | HTTP 코드 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| TC-COMMENT-001 | comment-service | 댓글 생성 | `STUDENT`, `MANAGER` | 댓글 작성 | 게시글 ID, 내용 | 생성된 댓글 정보 | `201 Created` |
| TC-COMMENT-002 | comment-service | 댓글 조회 | `STUDENT`, `MANAGER` | 댓글 조회 | 게시글 ID, page 번호 | 페이지에 해당하는 댓글 정보 리스트 | `200 OK` |
| TC-COMMENT-003 | comment-service | 댓글 수정 | `STUDENT`, `MANAGER` | 댓글 수정 | 댓글 ID, 수정 내용 | 수정된 댓글 정보 | `200 OK` |
| TC-COMMENT-004 | comment-service | 댓글 삭제 | `STUDENT`, `MANAGER` | 댓글 삭제 | 댓글 ID | - | `204 No Content` |
| TC-COMMENT-005 | comment-service | 댓글 리액션 업데잍트 | `STUDENT`, `MANAGER` | 댓글 리액션 업데이트(좋아요/싫어요/취소) | 댓글 ID, 리액션 타입(*LIKE,UNLIKE*,*NONE*) | 리액션 업데이트된 댓글 정보 반환 | `200 OK` |
| TC-COMMENT-006 | comment-service | 게시글 댓글 총 개수 조회 | `STUDENT`, `MANAGER` | 게시글 댓글 총 개수 조회 | 게시글 ID | 게시글 댓글 총 개수 | `200 OK` |

# Consulting Service

| TC ID | 서비스 | 기능 | 권한 | 시나리오 설명 | 입력값 예시 | 예상 응답 내용 | HTTP코드 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| TC-CONSULTING-001 | consulting-service | 예약 생성 | `STUDENT` | 매니저 생성, 날짜, 시간 선택 | 학생 ID | 생성된 예약 내용 정보 | `201 Created` |
| TC-CONSULTING-002 | consulting-service | 예약 조회 | `STUDENT`, `MANAGER` | 예약 날짜와 시간을 조회 | 학생, 매니저의 ID | 해당 ID에 맞는 예약 정보 | `200 OK` |
| TC-CONSULTING-003 | consulting-service | 예약 수정 | `STUDENT` | 기존 예약 날짜와 시간을 수정 | 학생 ID | 수정된 예약 정보  | `200 OK` |
| TC-CONSULTING-004 | consulting-service | 예약 승인 | `MANAGER` | 승인 대기 중인 예약을 승인 | 학생, 매니저의 ID | 승인 대기 중인 예약 정보 | `200 OK` |
| TC-CONSULTING-005 | consulting-service | 예약 삭제 | `STUDENT`, `MANAGER` | 승인 대기 중인 예약 삭제 | 학생, 매니저의 ID | 승인 대기 중인 예약 정보 |  |
| TC-CONSULTING-006 | consulting-service |  |  |  |  |  |  |
| TC-CONSULTING-007 | consulting-service |  |  |  |  |  |  |

# User Service

| TC ID | 서비스 | 기능 | 권한 | 시나리오 설명 | 입력값 예시 | 예상 응답 내용 | HTTP코드 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| TC-USER-001 | user-service | 매니저 로그인 | `MANAGER` | 매니저 로그인 시도 | 매니저 아이디,
비밀번호 | 정상적으로 로그인됨 | `200 OK` |
| TC-USER-003 | user-service | 매니저 로그아웃 | `MANAGER` | 매니저 로그아웃 시도 | - | 정상적으로 로그아웃됨 | `200 OK` |
| TC-USER-002 | user-service | 학생 로그인 | `STUDENT` | 학생 로그인 시도 | 학생 아이디,
비밀번호 | 정상적으로 로그인됨 | `200 OK` |
| TC-USER-001 | user-service | 학생 로그아웃 | `STUDENT` | 학생 로그아웃 시도 | - | 정상적으로 로그아웃 됨 | `200 OK` |
| TC-USER-005 | user-service | 매니저 비밀번호 변경 | `MANAGER` | 매니저 비밀번호 변경 시도 | 기존 비밀번호, 
새 비밀번호 | 정상적으로 비밀번호 변경됨 | `200 OK` |
| TC-USER-006 | user-service | 학생 비밀번호 변경 | `STUDENT` | 학생 비밀번호 변경 시도 | 기존 비밀번호, 
새 비밀번호 | 정상적으로 비밀번호 변경됨 | `200 OK` |
| TC-USER-007 | user-service | 매니저 이름 변경 | `MANAGER` | 매니저 이름 변경 시도 | 기존 비밀번호, 새 이름 | 정상적으로 이름이 변경됨 | `200 OK` |
| TC-USER-008 | user-service | 매니저 학생 이름 변경 | `STUDENT` | 학생 이름 변경 시도 | 기존 비밀번호, 새 이름 | 정상적으로 이름이 변경됨 | `200 OK` |
| TC-USER-009 | user-service | 매니저 이메일 변경 | `MANAGER` | 매니저 이메일 변경 시도 | 기존 비밀번호, 새 이메일 | 정상적으로 이메일이 변경됨 | `200 OK` |
| TC-USER-010 | user-service | 학생 이메일 변경 | `STUDENT` | 학생 이메일 변경 시도 | 기존 비밀번호, 새 이메일 | 정상적으로 이메일이 변경됨 | `200 OK` |
| TC-USER-011 | user-service | 매니저 프로필 조회 | `MANAGER` | 본인 프로필 정보 조회 | 토큰 내 사용자 ID | 사용자 프로필 정보 반환 | `200 OK` |
| TC-USER-012 | user-service | 학생 프로필 조회 | `STUDENT` | 본인 프로필 정보 조회 | 토큰 내 사용자 ID | 사용자 프로필 정보 반환 | `200 OK` |
| TC-USER-013 | user-service | 사용자 ID로 조회 | `MANAGER` | 사용자  ID로 학생 조회 | PathVariable ID | 해당 ID의 사용자 정보 반환 | `200 OK` |
| TC-USER-014 | user-service | 사용자 ID로 조회 | `STUDENT` | (학생이 타인 조회 시도) | PathVariable ID | 권한 없음 또는 에러 반환 | `403 Forbidden` |
| TC-USER-015 | user-service | 매니저 목록 조회 | `MANAGER` | 전체 매니저 목록 조회 | - | 간단한 매니저 정보 리스트 반환 | `200 OK` |
| TC-USER-016 | user-service | 프로필 이미지 업로드 | `MANAGER` | 프로필 페이지에서 프로필 이미지 변경 시도 | MultipartFile(Image) | 업로드된 이미지 URL 반환 | `200 OK` |
| TC-USER-017 | user-service | 프로필 이미지 업로드 | `STUDENT` | 학생이 프로필 이미지 업로드 시도 | MultipartFile(Image) | 접근권한 없음 | `403 Forbidden` |
| TC-USER-018 | user-service | 프로필 이미지 삭제 | `MANAGER` | 프로필 페이지에서 매니저가 이미지 삭제 시도 | - | 업로드된 이미지의  URL이 지워지고 기본 이미지로 대체 표시됨 | `200 OK` |
| TC-USER-019 | use-service | 프로필 이미지 삭제 | `STUDENT` | 학생이 프로필 이미지 삭제 시도 | - | 접근권한 없음 | `403 Forbidden` |
| TC-USER-020 | user-service | 전체 학생 목록 조회 | `MANAGER` | 매니저가 모든 학생 계정 목록을 조회 | - | 학생 목록 리스트 반환 | `200 OK` |
| TC-USER-021 | user-service | 전체 학생 목록 조회 | `STUDENT` | 학생이 학생 목록 조회 시도 | - | 접근 권한 없음 | `403 Forbidden` |
| TC-USER-022 | user-service | 학생 비밀번호 초기화 (username 기반) | `MANAGER` | 존재하는 학생 username으로 비밀번호 초기화 요청 | username: "student01" | 비밀번호 초기화 후 이메일 전송 완료 메시지 | `200 OK` |
| TC-USER-023 | user-service | 학생 비밀번호 초기화 (username 기반) | `MANAGER` | 존재하지 않는 username으로 초기화 요청 | username: "unknown123" | "Student Not Found" 예외 반환 | `400 Bad Request` |
| TC-USER-024 | user-service | 학생 비밀번호 초기화 (username 기반) | `MANAGER` | 매니저 계정으로 초기화 시도 | username: "manager01" | "Only students can be reset" 메시지 반환 | `400 Bad Request` |
| TC-USER-025 | user-service | 학생 계정 생성 | `MANAGER` | 새로운 학생 계정을 등록 | email, username, password, name 등 | 생성된 User 객체 반환 | `200 OK` |
| TC-USER-026 | user-service | 학생 계정 생성 | `STUDENT` | 학생이 계정 생성 요청 시도 | CreateUserRequest | 접근 권한 없음 | `403 Forbidden` |
| TC-USER-027 | user-service | 학생 계정 정지 | `MANAGER` | 특정 학생 ID 정지 요청 | PathVariable ID | 성공적으로 정지됨 | `200 OK` |
| TC-USER-028 | user-service | 학생 계정 정지 | `MANAGER` | 존재하지 않는 ID로 정지 요청 | id: 9999 | 예외 또는 에러 메시지 반환 | `404 Not Found` |
| TC-USER-029 | user-service | 학생 계정 정지 해제 | `MANAGER` | 특정 학생 ID 정지 해제 요청 | PathVariable ID | 성공적으로 정지 해제됨 | `200 OK` |
| TC-USER-030 | user-service | 학생 비밀번호 초기화 (ID 기반) | `MANAGER` | 특정 학생 ID로 비밀번호 초기화 | PathVariable ID | 성공적으로 초기화됨 | `200 OK` |

# 테스트 케이스 결과서

## post-service

| TC ID | 서비스 | 기능 | 권한 | 시나리오 설명 | 입력값 예시 | 예상 응답 내용 | HTTP 코드 | 테스트 결과 | 비고 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| TC-POST-001 | post-service | 건의 게시물 생성 | student | 건의 게시물 생성 | title, content | 생성됨 | 200 OK | 성공 |  |
| TC-POST-002 | post-service | 건의 게시물 수정 | student | 건의 게시물 수정 | postId, title, content | 수정됨 | 200 OK | 성공 |  |
| TC-POST-003 | post-service | 건의 게시물 삭제 | student | 건의 게시물 삭제 | postId | 삭제됨 | 200 OK | 성공 |  |
| TC-POST-004 | post-service | 건의 게시물 조회 | student | 건의 게시물 조회 | - | 게시물 조회됨 | 200 OK | 성공 |  |
| TC-POST-005 | post-service | 건의 게시물 좋아요 | student | 건의 게시물 좋아요 | postId | 좋아요 적용됨 | 200 OK | 성공 |  |
| TC-POST-006 | post-service | 건의 게시물 싫어요 | student | 건의 게시물 싫어요 | postId | 싫어요 적용됨 | 200 OK | 성공 |  |
| TC-POST-007 | post-service | 답변 게시물 생성 | manager | 답변 게시물 생성 | title, content, postId | 생성됨 | 200 OK | 성공 |  |
| TC-POST-008 | post-service | 답변 게시물 수정 | manager | 답변 게시물 수정 | postId, title, content | 수정됨 | 200 OK | 성공 |  |
| TC-POST-009 | post-service | 답변 게시물 삭제 | manager | 답변 게시물 삭제 | postId | 삭제됨 | 200 OK | 성공 |  |
| TC-POST-010 | post-service | 답변 게시물 조회 | manager | 답변 게시물 조회 | - | 게시물 조회됨 | 200 OK | 성공 |  |
| TC-POST-011 | post-service | 답변 게시물 좋아요 | manager | 답변 게시물 좋아요 | postId | 좋아요 적용됨 | 200 OK | 성공 |  |
| TC-POST-012 | post-service | 답변 게시물 싫어요 | manager | 답변 게시물 싫어요 | postId | 싫어요 적용됨 | 200 OK | 성공 |  |

# Comment Service

| TC ID | 서비스 | 기능 | 권한 | 시나리오 설명 | 입력값 예시 | 예상 응답 내용 | HTTP 코드 | 테스트 결과 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| TC-COMMENT-001 | comment-service | 댓글 생성 | `STUDENT`, `MANAGER` | 댓글 작성 | 게시글 ID, 내용 | 생성된 댓글 정보 | `201 Created` | 성공 |
| TC-COMMENT-002 | comment-service | 댓글 조회 | `STUDENT`, `MANAGER` | 댓글 조회 | 게시글 ID, page 번호 | 페이지에 해당하는 댓글 정보 리스트 | `200 OK` | 성공 |
| TC-COMMENT-003 | comment-service | 댓글 수정 | `STUDENT`, `MANAGER` | 댓글 수정 | 댓글 ID, 수정 내용 | 수정된 댓글 정보 | `200 OK` | 성공 |
| TC-COMMENT-004 | comment-service | 댓글 삭제 | `STUDENT`, `MANAGER` | 댓글 삭제 | 댓글 ID | - | `204 No Content` | 성공 |
| TC-COMMENT-005 | comment-service | 댓글 리액션 업데잍트 | `STUDENT`, `MANAGER` | 댓글 리액션 업데이트(좋아요/싫어요/취소) | 댓글 ID, 리액션 타입(*LIKE,UNLIKE*,*NONE*) | 리액션 업데이트된 댓글 정보 반환 | `200 OK` | 성공 |
| TC-COMMENT-006 | comment-service | 게시글 댓글 총 개수 조회 | `STUDENT`, `MANAGER` | 게시글 댓글 총 개수 조회 | 게시글 ID | 게시글 댓글 총 개수 | `200 OK` | 성공 |

# Consulting Service

| TC ID | 서비스 | 기능 | 권한 | 시나리오 설명 | 입력값 예시 | 예상 응답 내용 | HTTP코드 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| TC-CONSULTING-001 | consulting-service | 예약 생성 | `STUDENT` | 매니저 생성, 날짜, 시간 선택 | 학생, 매니저의 ID | 생성된 예약 내용 정보 | `201 Created` |
| TC-CONSULTING-002 | consulting-service | 예약 조회 | `STUDENT`, `MANAGER` | 예약 날짜와 시간을 조회 | 학생, 매니저의 ID | 해당 ID에 맞는 예약 정보 | `200 OK` |
| TC-CONSULTING-003 | consulting-service | 예약 수정 | `STUDENT` | 기존 예약 날짜와 시간을 수정 | 학생 ID | 수정된 예약 정보  | `200 OK` |
| TC-CONSULTING-004 | consulting-service | 예약 승인 | `MANAGER` | 승인 대기 중인 예약을 승인 | 학생, 매니저의 ID | 승인 대기 중인 예약 정보 | `200 OK` |
| TC-CONSULTING-005 | consulting-service | 예약 삭제 | `STUDENT`, `MANAGER` | 승인 대기 중인 예약 삭제 | 학생, 매니저의 ID | 승인 대기 중인 예약 정보 |  |
|  |  |  |  |  |  |  |  |
|  |  |  |  |  |  |  |  |

# post-service

| TC ID | 서비스 | 기능 | 권한 | 시나리오 설명 | 입력값 예시 | 예상 응답 내용 | HTTP 코드 | 테스트 결과 | 비고 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| TC-USER-001 | user-service | 매니저 로그인 | `MANAGER` | 매니저 로그인 시도 | 매니저 아이디,
비밀번호 | 정상적으로 로그인됨 | `200 OK` | 성공 |  |
| TC-USER-003 | user-service | 매니저 로그아웃 | `MANAGER` | 매니저 로그아웃 시도 | - | 정상적으로 로그아웃됨 | `200 OK` | 성공 |  |
| TC-USER-002 | user-service | 학생 로그인 | `STUDENT` | 학생 로그인 시도 | 학생 아이디,
비밀번호 | 정상적으로 로그인됨 | `200 OK` | 성공 |  |
| TC-USER-001 | user-service | 학생 로그아웃 | `STUDENT` | 학생 로그아웃 시도 | - | 정상적으로 로그아웃 됨 | `200 OK` | 성공 |  |
| TC-USER-005 | user-service | 매니저 비밀번호 변경 | `MANAGER` | 매니저 비밀번호 변경 시도 | 기존 비밀번호, 
새 비밀번호 | 정상적으로 비밀번호 변경됨 | `200 OK` | 성공 |  |
| TC-USER-006 | user-service | 학생 비밀번호 변경 | `STUDENT` | 학생 비밀번호 변경 시도 | 기존 비밀번호, 
새 비밀번호 | 정상적으로 비밀번호 변경됨 | `200 OK` | 성공 |  |
| TC-USER-007 | user-service | 매니저 이름 변경 | `MANAGER` | 매니저 이름 변경 시도 | 기존 비밀번호, 새 이름 | 정상적으로 이름이 변경됨 | `200 OK` | 성공 |  |
| TC-USER-008 | user-service | 매니저 학생 이름 변경 | `STUDENT` | 학생 이름 변경 시도 | 기존 비밀번호, 새 이름 | 정상적으로 이름이 변경됨 | `200 OK` | 성공 |  |
| TC-USER-009 | user-service | 매니저 이메일 변경 | `MANAGER` | 매니저 이메일 변경 시도 | 기존 비밀번호, 새 이메일 | 정상적으로 이메일이 변경됨 | `200 OK` | 성공 |  |
| TC-USER-010 | user-service | 학생 이메일 변경 | `STUDENT` | 학생 이메일 변경 시도 | 기존 비밀번호, 새 이메일 | 정상적으로 이메일이 변경됨 | `200 OK` | 성공 |  |
| TC-USER-011 | user-service | 매니저 프로필 조회 | `MANAGER` | 본인 프로필 정보 조회 | 토큰 내 사용자 ID | 사용자 프로필 정보 반환 | `200 OK` | 성공 |  |
| TC-USER-012 | user-service | 학생 프로필 조회 | `STUDENT` | 본인 프로필 정보 조회 | 토큰 내 사용자 ID | 사용자 프로필 정보 반환 | `200 OK` | 성공 |  |
| TC-USER-013 | user-service | 사용자 ID로 조회 | `MANAGER` | 사용자  ID로 학생 조회 | PathVariable ID | 해당 ID의 사용자 정보 반환 | `200 OK` | 성공 |  |
| TC-USER-014 | user-service | 사용자 ID로 조회 | `STUDENT` | (학생이 타인 조회 시도) | PathVariable ID | 권한 없음 또는 에러 반환 | `403 Forbidden` | 성공 |  |
| TC-USER-015 | user-service | 매니저 목록 조회 | `MANAGER` | 전체 매니저 목록 조회 | - | 간단한 매니저 정보 리스트 반환 | `200 OK` | 성공 |  |
| TC-USER-016 | user-service | 프로필 이미지 업로드 | `MANAGER` | 프로필 페이지에서 프로필 이미지 변경 시도 | MultipartFile(Image) | 업로드된 이미지 URL 반환 | `200 OK` | 성공 |  |
| TC-USER-017 | user-service | 프로필 이미지 업로드 | `STUDENT` | 학생이 프로필 이미지 업로드 시도 | MultipartFile(Image) | 접근권한 없음 | `403 Forbidden` | 성공 |  |
| TC-USER-018 | user-service | 프로필 이미지 삭제 | `MANAGER` | 프로필 페이지에서 매니저가 이미지 삭제 시도 | - | 업로드된 이미지의  URL이 지워지고 기본 이미지로 대체 표시됨 | `200 OK` | 성공 |  |
| TC-USER-019 | use-service | 프로필 이미지 삭제 | `STUDENT` | 학생이 프로필 이미지 삭제 시도 | - | 접근권한 없음 | `403 Forbidden` | 성공 |  |
| TC-USER-020 | user-service | 전체 학생 목록 조회 | `MANAGER` | 매니저가 모든 학생 계정 목록을 조회 | - | 학생 목록 리스트 반환 | `200 OK` | 성공 |  |
| TC-USER-021 | user-service | 전체 학생 목록 조회 | `STUDENT` | 학생이 학생 목록 조회 시도 | - | 접근 권한 없음 | `403 Forbidden` | 성공 |  |
| TC-USER-022 | user-service | 학생 비밀번호 초기화 (username 기반) | `MANAGER` | 존재하는 학생 username으로 비밀번호 초기화 요청 | username: "student01" | 비밀번호 초기화 후 이메일 전송 완료 메시지 | `200 OK` | 보류 |  |
| TC-USER-023 | user-service | 학생 비밀번호 초기화 (username 기반) | `MANAGER` | 존재하지 않는 username으로 초기화 요청 | username: "unknown123" | "Student Not Found" 예외 반환 | `400 Bad Request` | 보류 |  |
| TC-USER-024 | user-service | 학생 비밀번호 초기화 (username 기반) | `MANAGER` | 매니저 계정으로 초기화 시도 | username: "manager01" | "Only students can be reset" 메시지 반환 | `400 Bad Request` | 보류 |  |
| TC-USER-025 | user-service | 학생 계정 생성 | `MANAGER` | 새로운 학생 계정을 등록 | email, username, password, name 등 | 생성된 User 객체 반환 | `200 OK` | 보류 |  |
| TC-USER-026 | user-service | 학생 계정 생성 | `STUDENT` | 학생이 계정 생성 요청 시도 | CreateUserRequest | 접근 권한 없음 | `403 Forbidden` | 보류 |  |
| TC-USER-027 | user-service | 학생 계정 정지 | `MANAGER` | 특정 학생 ID 정지 요청 | PathVariable ID | 성공적으로 정지됨 | `200 OK` | 보류 |  |
| TC-USER-028 | user-service | 학생 계정 정지 | `MANAGER` | 존재하지 않는 ID로 정지 요청 | id: 9999 | 예외 또는 에러 메시지 반환 | `404 Not Found` | 보류 |  |
| TC-USER-029 | user-service | 학생 계정 정지 해제 | `MANAGER` | 특정 학생 ID 정지 해제 요청 | PathVariable ID | 성공적으로 정지 해제됨 | `200 OK` | 보류 |  |
| TC-USER-030 | user-service | 학생 비밀번호 초기화 (ID 기반) | `MANAGER` | 특정 학생 ID로 비밀번호 초기화 | PathVariable ID | 성공적으로 초기화됨 | `200 OK` | 보류 |  |
# MSA 아키텍처 

<img width="3796" height="1099" alt="MSA 아키텍처" src="https://github.com/user-attachments/assets/8ac483a8-293b-47d1-8a03-49d77d225195" />

# 회고 
- 이지용
    - 이번 프로젝트를 진행하면서 프론트, 백엔드를 연동해보면서 전체적인 프로젝트 구조에 대해서 이해하게 되었고 CI/CD 파이프 라인을 직접 구현해보면서 CI/CD에 대한 이해도가 높아졌던 것 같고, 의사소통과 일정관리의 중요성 또한 중요하다는 것을 느꼇다.
- 박경빈
    - 이번 프로젝트는 프론트엔드와 백엔드를 분리하여 개발하고, CI/CD 파이프라인을 통해 자동 배포까지 경험해볼 수 있는 소중한 기회였습니다. 아직 익숙하지 않은 부분이 많아 개발 과정에서 크고 작은 오류와 버그로 인해 일정이 지연되고 일부 기능은 완성하지 못했지만, 그럼에도 불구하고 전체적인 개발 프로세스를 직접 겪어볼 수 있어 매우 의미 있는 시간이었습니다. 비록 프로젝트는 이번에 마무리되지만, 앞으로 시간을 내어 더욱 고도화해 나갈 계획입니다.
- 이정아
    - 댓글 컴포넌트를 구현하고, 좋아요/싫어요 기능을 포함해 백엔드 API와 처음으로 연동해보았다. 실제 데이터를 주고받으며 동작하는 걸 확인했을 때 큰 성취감을 느꼈고, 프론트와 백의 연결 구조에 대한 이해도 함께 높일 수 있는 경험이었다. 아쉽게도 CI/CD 배포까지는 시간 내에 구현하지 못했지만, 추가로 학습하여 다음 프로젝트에는 꼭 적용해볼 예정이다.
- 배기열
    - 배기열: Postman을 통해 지금까지 작동 시 오류가 발생하는 경우가 많았는데 , 해당 프로젝트를 통해 오류가 나지 않고 잘 동작하는 것을 보며 신기했다.
    - 생각보다 단순하기도 하고 복잡하기도 했으며, 기존 백엔드와 다른 느낌이 많이 들어 해당 용어가 무엇인지, 어떻게 인증, 인가를 하는지 찾는데 오래 걸렸다.
- 박범석
이번 프로젝트에서는 예약 조회, 삭제, 변경 기능을 백엔드와 프론트엔드 API로 연동하여 구현했습니다.
API 연동이 핵심이었던 만큼, 예약 생성 기능을 담당한 팀원, 사용자(User) 기능을 맡은 팀원과의 소통이 매우 중요했습니다.의견을 주고받으며 서로 부족한 부분을 보완해나갔고, 비록 모든 기능을 완벽하게 구현하진 못했지만 협업을 통해 문제를 해결해가는 과정에서 개발에 대한 흥미와 자신감이 더욱 커졌습니다.
