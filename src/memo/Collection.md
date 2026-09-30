# 컬렉션 프레임웍

▶컬렉션(collection)
 - 여러 객체(데이터)를 모아 놓은 것을 의미

▶프레임워크(framework)
 - 표준화, 정형화된 체계적인 프로그래밍 방식

▶컬렉션 프레임워크(collections framework)
 - 컬렉션(여러, 다수의 객체)을 다루기 위한 표준화된 프로그래밍 방식
 - 컬렉션을 쉽고 편리하게 다룰 수 있는(저장, 삭제, 검색, 정렬) 다양한 클래스를 제공

▶컬렉션 클래스(collection class)
 - 다수의 데이터를 저장할 수 있는 클래스(예, Vector, ArrayList, HashSet)



# 컬렉션 프레임웍의 핵심 인터페이스(List / Set / Map)

List - `순서가 있는 데이터의 집합`. 데이터의 `중복을 허용`한다.
예) `대기자 명단`
구현 클래스 : ArrayList, LinkedList, Stack, Vector 등

Set - `순서를 유지하지 않는 데이터의 집합`. 데이터의 `중복을 허용하지 않는다.`
예) 양의 정수 집합, 소수의 집합
구현 클래스 : HashSet, TreeSet 등

Map - `키(key)와 값(value)의 쌍(pair)으로` 이루어진 데이터의 집합
    순서는 유지되지 않으며, `키는 중복을 허용하지 않고, 값은 중복을 허용`한다.
예) 우편번호, 지역번호(전화번호), id와 password
구현 클래스 : HashMap, TreeMap, Hashtable, Properties 등

