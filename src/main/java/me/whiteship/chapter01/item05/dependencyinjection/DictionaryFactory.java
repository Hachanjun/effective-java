package me.whiteship.chapter01.item05.dependencyinjection;

import me.whiteship.chapter01.item05.DefaultDictionary;

// 팩토리 메서드 패턴
public class DictionaryFactory {
    public static DefaultDictionary get() {
        return new DefaultDictionary();
    }
}
