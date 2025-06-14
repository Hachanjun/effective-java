package me.whiteship.chapter02.item14;

import me.whiteship.chapter02.item10.Point;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Comparator.comparingInt;

// PhoneNumber를 비교할 수 있게 만든다. (91-92쪽)
// Comparable<T> 제네릭 인터페이스
public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
    private final short areaCode, prefix, lineNum;

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix   = rangeCheck(prefix,   999, "프리픽스");
        this.lineNum  = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    /**
     * 이 전화번호의 문자열 표현을 반환한다.
     * 이 문자열은 "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다.
     * XXX는 지역 코드, YYY는 프리픽스, ZZZZ는 가입자 번호다.
     * 각각의 대문자는 10진수 숫자 하나를 나타낸다.
     *
     * 전화번호의 각 부분의 값이 너무 작아서 자릿수를 채울 수 없다면,
     * 앞에서부터 0으로 채워나간다. 예컨대 가입자 번호가 123이라면
     * 전화번호의 마지막 네 문자는 "0123"이 된다.
     */
    @Override public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    // 코드 14-2 기본 타입 필드가 여럿일 때의 비교자 (91쪽)
    @Override
    public int compareTo(PhoneNumber pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if (result == 0)  {
            result = Short.compare(prefix, pn.prefix);
            if (result == 0)
                result = Short.compare(lineNum, pn.lineNum);
        }
        return result;
    }

    // 코드 14-3 비교자 생성 메서드를 활용한 비교자 (92쪽)
    // Comparator라는 인터페이스가 제공하는 static 메소드를 활용해서 Comparator 인스턴스를 만들 수 있다.
    // 코드 읽기가 편한다. 성능이 느려진다.
    private static final Comparator<PhoneNumber> COMPARATOR =
    		// Comparator 인터페이스에 선언되어 있는 comparingInt
    		// static 메소드로 선언한 이후에는 default 메소드에 접근할 수 있다.
            comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.getPrefix())
                    .thenComparingInt(pn -> pn.lineNum);

//    일반적인 구현 방법
//    @Override
//    public int compareTo(PhoneNumber pn) {
//        return COMPARATOR.compare(this, pn);
//    }

    private static PhoneNumber randomPhoneNumber() {
        Random rnd = ThreadLocalRandom.current();
        return new PhoneNumber((short) rnd.nextInt(1000),
                               (short) rnd.nextInt(1000),
                               (short) rnd.nextInt(10000));
    }

    public static void main(String[] args) {
        Set<PhoneNumber> s = new TreeSet<>();
        for (int i = 0; i < 10; i++)
            s.add(randomPhoneNumber());
        System.out.println(s);
    }

}
