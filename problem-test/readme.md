통신 플로우
------------------------------------
/api/problemTest/carManagement (problemtest 서비스) (자동차 생성) POST 파라미터 - { "category_type_list" : [ // 카테고리 리스트 1, 4 ], "company_code" : 1, // 회사 코드 "model_name" : "코나", // 모델 명 "created_year": 2024, // 생산 년도 "rental_yn": true // 대여 가능 여부 }

/api/problemTest/carManagement (problemtest 서비스) (자동차 조회) GET 파라미터 - @RequestParam(value = "company_code", required = false) Integer companyCode (회사 코드 (회사 테이블의 코드 자동차 테이블의 company_code랑 매핑)) @RequestParam(value = "rental_yn", required = false) Boolean rentalYn (대여 가능 여부) @RequestParam(value = "category_code_list", required = false) List categoryCodeList (카테고리 코드 리스트) @RequestParam(value = "start_year", required = false) Integer startYear (검색 날짜 시작) @RequestParam(value = "end_year", required = false) Integer endYear (검색 날짜 끝)

/api/problemTest/carManagement/{자동차 인덱스 번호} (problemtest 서비스) (자동차 수정) PUT 파라미터 - { "category_type_list" : [ 1, 5 ], "company_code" : 1, "model_name" : "코나", "created_year": 2023, "rental_yn": true }