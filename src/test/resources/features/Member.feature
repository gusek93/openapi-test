Feature: 멤버를 조회, 생성, 수정, 삭제 할수 있다.

    Scenario Outline: 클라이언트가 GET /member를 호출한다
        When 클라이언트가 전체 멤버 목록을 요청한다
        Then status 코드 "<status>"을 수신한다
        And n"<n>"개의 member를 수신한다
        Examples:
            | status | n |
            | 200    | 1 |


    Scenario Outline: 특정 멤버 조회
        When 조회할 멤버의 ID "<id>" 입력 받는다
        Then 특정멤버 status 코드 "<status>"을 수신한다
        And member 정보를 수신한다
        Examples:
            | id | status
            | 1  | 200
#
#    Scenario Outline: 멤버 생성
#        When 생성할멤버 정보 "<name>"
#        Then status 코드 "<status>"을 수신한다
#        And member "<name>" 정보를 수신한다
#        Examples:
#            | name  | status |
#            | testA | 200 |

