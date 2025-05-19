package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.MockDictionary;
import org.junit.jupiter.api.Test;

class SpellCheckerTest {

    @Test
    void isValid() {
    	// SpellChecker가 사용하는 의존 객체를 주입
    	// 장점 : SpellChecker 코드를 그대로 사용하면서도 다른(테스트) Dictionary로 교체 가능하다. -> 의존 객체 주입을 사용하는 가장 큰 장점
    	// 코드의 재사용성으로 인해 유연해진다.
    	// SpellChecker spellChecker = new SpellChecker(new DefaltDictionary);
    	
    	// Supplier<Dictionary> 사용 방법
    	// SpellChecker spellChecker = () -> new DefaultDictionary();
    	
    	// 메서드 레퍼런스 방법
        SpellChecker spellChecker = new SpellChecker(MockDictionary::new);
        spellChecker.isValid("test");
    }
}