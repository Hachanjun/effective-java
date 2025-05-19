package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.Dictionary;

import java.util.List;
import java.util.function.Supplier;

// 의존성 주입일 경우에는 모든 코드를 재사용 할 수 있다.
// 전제 : Dictionary가 인터페이스여야 한다.
public class SpellChecker {

    private final Dictionary dictionary;

    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    // 자원을 바로 받는게 아니라 자원을 만들어주는 Factory를 통해서 자원을 가져오는 방법으로 중간 단계를 조금 더 추상화
    //public SpellChecker(DictionaryFactory dictionaryFactory) {
    //	 this.dictionary = dictionaryFactory.get();
    //}
    
    // 한정적 와일드 카드 타입 사용
    // Dictionary 하위 타입도 받을 수 있기 때문에
    // 구체적인 타입(DefaultDictionary)로 작성하게 된다면 같은 Dictionary 타입이라 하더라도 다른 타입을 주입할 수가 없다 
    // public SpellChecker(Supplier<? extends Dictionary> dictionarySupplier) {
    //	 this.dictionary = dictionarySupplier.get();
    // }

    // Supplier 받는 인자는 없고 리턴만 있는 함수
    public SpellChecker(Supplier<Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
