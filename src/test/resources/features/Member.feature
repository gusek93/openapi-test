Feature: 맴버를 조회, 생성, 수정, 삭제 할수 있다.

    Scenario Outline: 클라이언트가 GET /member를 호출한다
        When 클라이언트가 전체 맴버 목록을 요청한다
        Then status 코드 "<status>"을 수신한다
        And n"<n>"개의 company를 수신한다
        Examples:
            | status | n  |
            | 200    | 17 |


    Scenario Outline: 특정 멤버 조회
        When 조회할 회사의 ID "<id>" 입력 받는다
        Then status 코드 "<status>"을 수신한다
        And member 정보를 수신한다
        Examples:
            | id | status
            | 1  | 200
