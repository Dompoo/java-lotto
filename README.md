# 기능 구현 목록

## 입력
- [ ] 구입금액을 입력받는다.
  - [ ] 숫자 형식이어야 한다.
- [ ] 당첨번호를 입력받는다.
  - [ ] ,로 분리되어야 한다.
  - [ ] 분리된 각 문자는 숫자 형식이어야 한다.
- [ ] 보너스번호를 입력받는다.
  - [ ] 숫자 형식이어야 한다.

## 투입 금액
- [x] 1000원 단위어야 한다.

## 로또볼
- [x] 주어진 개수만큼 중복없이 생성된다.
- [x] 각 로또 숫자는 1~45 숫자 이내여야 한다.

## 로또
- [x] 투입 금액만큼 로또를 구매한다.
  - [x] 로또의 내부 로또볼은 중복되면 안된다.

## 당첨로또
- [x] 정해진 숫자와 보너스 번호로 생성된다.
- [ ] 로또와 비교하여 등수를 알 수 있다.

## 당첨
- [x] 각 등수의 조건과 등수별 당첨 금액을 저장한다.
- [x] 일치 개수, 보너스볼 일치 개수를 통해 당첨 여부를 판단한다.

# 프로그래밍 요구 사항

- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍했는가?
- [ ] 들여쓰기(indent)를 2단계 이하로 허용했는가?
- [ ] else 예약어를 쓰지 않았는가?
- [ ] 메소드가 한가지 일만 담당하도록 구현했는가?
- [ ] 클래스를 작게 유지하기 위해 노력했는가?

# 좋은 코드를 위한 체크 사항

- [ ] 모든 원시값과 문자열을 포장했는가?
- [ ] 콜렉션에 대해 일급 콜렉션을 적용했는가?
- [ ] 3개 이상의 인스턴스 변수를 가진 클래스를 구현하지 않았는가?
- [ ] 도메인 객체를 getter/setter 없이 구현했는가?
- [ ] 메소드의 인자 수를 3개 이하로 제한했는가?
- [ ] 코드 한 줄에 점(.)을 하나만 허용했는가?
