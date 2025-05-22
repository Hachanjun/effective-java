package me.whiteship.chapter01.item07.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ChannelTest {

    @Test
    void npe() {
        Channel channel = new Channel();
        Optional<MemberShip> optional = channel.defaultMemberShip();
        // optional.hello(); -> 이렇게 사용 못 함
        // hello()는 Optional에서 가지고 있는 메소드가 아니기 때문에 Optional에서 꺼내야지만 MemberShip을 쓸 수가 있고 메소드를 호출할 수 있다.
        // 아래와 같이 작성하면 문제가 생길 수 있다. 비어있는 것에서 꺼내려고 하면 에러 발생
        // MemberShip memberShip = optional.get();
        // 그래서 Optional에서 제공하는 메서드를 활용해야한다.
        optional.ifPresent(MemberShip::hello);
    }

}