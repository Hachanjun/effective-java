package me.whiteship.chapter02.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 코드 10-1 잘못된 코드 - 대칭성 위배! (54-55쪽)
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

//     대칭성 위배!
    @Override public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s);
        if (o instanceof String)  // 한 방향으로만 작동한다! 다른 타입을 비교하면 안 된다.
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    // 문제 시연 (55쪽)
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
//        CaseInsensitiveString cis2 = new CaseInsensitiveString("polish");
        String polish = "polish"; // String은 CaseInsensitiveString 클래스 존재 자체를 모른다.
        System.out.println(cis.equals(polish)); // 이건 true
//        System.out.println(cis2.equals(cis)); // 대칭성 오류, 둘이 다르다.

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        // 이건 false
        System.out.println(list.contains(polish));
    }

    // 수정한 equals 메서드 (56쪽)
    // 본인이 CaseInsensitiveString 이거면 CaseInsensitiveString만 비교해야 한다. 다른 타입을 비교하면 안 된다.
//    @Override public boolean equals(Object o) {
//        return o instanceof CaseInsensitiveString &&
//                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
//    }
}
