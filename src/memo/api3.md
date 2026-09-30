# 날짜와 시간



# Calendar 클래스
 - 추상 클래스 이므로 getInstance()를 통해 구현된 객체를 얻어야 한다.
    Calendar cal = new Calendar();  // 에러!! 추상클래스는 인스턴스를 생성할 수 없다.

    // OK, getInstance() 메서드는 Calendar클래스를 구현한 클래스의 인스턴스를 반환한다.
    Calendar cal = Calendar.getInstance();


예제
・get()으로 날짜와 시간 필드 가져오기 - int get(int field)

Calendar cal = Calendar.getInstance();  // 현재 날짜와 시간으로 셋팅됨
int thisYear = cal.get(Calendar.YEAR);  // 올해가 몇년인지 알아낸다.
int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);   // 이 달의 마지막날


[자바 Calendar 클래스에 정의된 필드 정리]

* 주요 필드명 및 설명
- YEAR: 년
- MONTH: 월 (0부터 시작하므로 1월은 0, 12월은 11을 나타냄)
- WEEK_OF_YEAR: 1월1일 ~ 지금까지 (해당 연도의 몇 번째 주인지)
- WEEK_OF_MONTH: 그 달의 몇 번째 주
- DATE: 일
- DAY_OF_MONTH: 그 달의 몇 번째일
- DAY_OF_YEAR: 그 해의 몇 번째일
- DAY_OF_WEEK: 요일
- DAY_OF_WEEK_IN_MONTH: 그 달의 몇 번째 요일

[자바 Calendar 클래스 시간 관련 필드 정리]

* 주요 필드명 및 설명
- HOUR: 시간 (0~11 범위로 표현)
- HOUR_OF_DAY: 시간 (0~23 범위의 24시간 형식)
- MINUTE: 분
- SECOND: 초
- MILLISECOND: 천분의 일초 (밀리초)
- ZONE_OFFSET: GMT 기준 시차 (천분의 일초 단위로 표현)
- AM_PM: 오전 또는 오후