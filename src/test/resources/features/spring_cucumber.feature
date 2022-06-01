Feature: member crud
    Scenario: 클라이언트가 GET /member를 호출한다
        When 클라이언트가 member호출한다

    Scenario: 클라이언트가 POST /member를 생성한다
        Given 클라이언트가 Member를 추가한다
        When 클라이언트가 Member 생성을 요청한다

    Scenario: 클라이언트가 PUT /member를 수정한다
        Given 클라이언트가 Member를 수정한다
        When 클라이언트가 Member 수정을 요청한다
        Then 클라이언트가 Member 수정이 됬는지 검증한다

    Scenario: 클라이언트가 Delete /member를 수정한다
        When 클라이언트가 Member 삭제 요청한다
#        Then 클라이언트가 Member 삭제 됬는지 검증한다
