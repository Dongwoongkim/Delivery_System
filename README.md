# Delivery-System / Toy Project

프레임워크 : Spring

데이터베이스 : H2

DB Access : JDBC, JPA, Spring Data JPA, Querydsl 

뷰 템플릿 : thymeleaf

## **도메인**

1. Item - itemID, itemName, price, quantity  ✓
2. Member - id, password, name ✓
    1. Manager 
    2. User - + address, + phoneNum, 결제 수단
3. Order
    1. Item : (itemId, itemName, price, quantity) 
    2. User : Id, password, name, address, phoneNum
    3. state

## Repository

- Member
    - MemberRepository - JPA
- Item
    - ItemRepository - JPA
    - ItemQueryRepository - Querydsl
- Order
    - OrderRepository - JPA
    - OrderQueryRepository - Querydsl

## **Web**

1. Home -로그인 , 회원가입 (O)  ✓
2. 회원가입 Form ✓
    1. 중복 아이디 검증 ✓ 
    2. ID, NAME, PASSWORD Empty 검증 ✓
3. 로그인 Form  ✓
4. 로그인 후 - **관리자** / **상품 관리** , **로그아웃** , **검색** - 상품이름(itemName), 상품가격 (maxPrice), 주문 관리 
    1. 상품 관리 
        
        ✓ 상품 삭제 : 리포지토리 데이터 전체 삭제 및  PK 초기화
        
        ✓ 상품 추가 : 검증 적용 및 DB 삽입(Spring DATA JPA) 
        
        상품 검색 : Querydsl 적용  (itemName, maxPrice)
        
    2. ✓ 로그아웃 : 세션 삭제 후 LoginHome → 초기화면 리다이렉션 
    3. 주문 관리 : 주문 내역 확인, 주문 내역 검색, 주문 내역 업데이트 ( 배송상태만 업데이트 가능 )  
        1. 주문 내역 확인 :
        2. 주문 내역 검색 :
        3. 주문 내역 업데이트 : 배송상태
5. 로그인 후 - **회원** / 상품 조회, 로그아웃, 검색, 상품 주문,
    1. 상품 조회 : itemRepository → Item Table 조회
    2. 로그아웃 : 세션 삭제 후 LoginHome → 초기화면 리다이렉션
    3. 상품 검색 : Querydsl (itemName, maxPrice)
    4. 상품 주문 : Item Table data → Order Table에 삽입

## **Apply**

- 메시지 ✓ , 국제화 ✓ (영어)
- 로그인 - 세션 / 회원 (O) ✓
- 로그인 검증 ✓
- 필터 ✓  - 로그인 하지 않은 사용자가 특정 URI 접근시 login 페이지로 이동 및 로그인 성공 시 URI 리다이렉션
- 인터셉터 적용 - 로그인 하지 않은 사용자가 특정 URI 접근시 login 페이지로 이동 및 로그인 성공 시 URI 리다이렉션
- 필요한 경우 예외 처리 , 예외 추상화-변환기 사용(Repository → RuntimeEx → Service )

1. 인터셉터 적용 
2. 관리자 상품 검색 추가
3. Order 도메인, 테이블 생성
4. 관리자 loginHome에 주문 관리 추가
    1. 주문 내역확인, 주문내역 검색, 주문내역 업데이트 추가
