package me.whiteship.chapter01.item07.optional;

import java.util.Optional;
import java.util.OptionalLong;

public class Channel {

    private int numOfSubscribers;

    // 파라미터에 Optional을 사용하는 것은 의미가 없다. -> 어차피 null 체크를 해야한다.
    // Optional은 파라미터 타입에서 사용하는 것이 아닌 return 타입에서 사용하라고 만든 것
    // Optional로 컬렉션을 감싸지 말라
    // ex) Optional<List>, Optional<Set> -> List, Set 등등은 이미 비어있는지 확인할 수 있는 메서드가 존재한다.
    public Optional<MemberShip> defaultMemberShip() {
    	// Optional<int> -> 사용할 수 없다. 기본 타입은 제네릭 타입으로 사용할 수 없다.
    	// 이럴 경우  OptionalInt, OptionalLong을 사용하면 된다.
        if (this.numOfSubscribers < 2000) {
        	// 리턴을 Optional로 했을 경우 null을 리턴하는 짓은 하지말자. 그럼 Optional을 사용하는 의미가 없다. (또 null 체크를 해야함)
            return Optional.empty();
        } else {
            return Optional.of(new MemberShip());
        }
    }
}
