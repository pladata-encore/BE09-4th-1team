# ✅ 프로젝트 기획서
---

## **1. 프로젝트 개요**

본 프로젝트는 사용자들의 피드백을 효율적으로 수렴하고 관리하며, 필요한 경우 전문가와의 상담 예약을 지원하기 위한 '사용자 건의 게시판 및 상담 예약 시스템' 구축을 목표로 합니다. 기존에는 사용자의 의견을 통합적으로 관리하고 처리하는 시스템과 상담 예약 시스템이 분리되어 있거나 부족하여, 중요한 건의 사항들이 누락되거나 처리 과정이 불투명하고, 상담 예약 과정이 번거롭다는 문제점이 있었습니다.

이에 따라, 사용자 친화적인 인터페이스를 통해 자유롭게 의견을 제안하고, 운영진이 이를 체계적으로 검토하고 답변하며, 사용자가 필요시 편리하게 상담을 예약할 수 있는 통합 시스템을 개발함으로써 다음과 같은 목적을 달성하고자 합니다.

## **3. Target**

- **일반 사용자 (수강생)**
PlayData 수강생
- **관리자 (매니저 역할)**
매니저가 건의된 게시물을 관리하고
삼담 예약 리스트를 관리한다.

## **2. Skill Stack**
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

# MSA 아키텍처 

<img width="3796" height="1099" alt="MSA 아키텍처" src="https://github.com/user-attachments/assets/8ac483a8-293b-47d1-8a03-49d77d225195" />
