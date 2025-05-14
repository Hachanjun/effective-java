package me.whiteship.chapter01.item02.builder;

import lombok.Builder;

// 코드 2-3 빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다. (17~18쪽)
// 단점 : 코드가 어렵다. 필드가 중복이 된다. 필수적인 필드와 선택적 필드들이 혼재해 생성자의 매개변수가 많이 늘어날 경우 사용한다.
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    // 리턴 타입이 Builder 타입을 경우 .으로 연결하기 때문에 유연하고 자바 빈즈 보다 안정적이다. 
    // .build()를 호출해 사용 가능하다.
    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27).build();
    }

    public static class Builder {
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 - 기본값으로 초기화한다.
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;

        // 필수 매개변수들은 생성자
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        // 자바 빈즈 setter와 동일한 역할
        // 리턴은 void가 아닌 Builder 타입을 리턴(setter와 가장 큰 차이점)
        public Builder calories(int val)
        { calories = val;      return this; }
        public Builder fat(int val)
        { fat = val;           return this; }
        public Builder sodium(int val)
        { sodium = val;        return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val;  return this; }

        // 최종적으로 빌드
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }    
}

// 코드를 줄이는 방법(lombok)
// NutritionFactsBuilder() 해당 클래스는 @Builder 애노테이션이 만들어준다. 해당 애노테이션을 사용하면서 lombok이 제공하는 애노테이션 프로세서가 만들어준다. 
// 애노테이션 프로세서 : 애노테이션 자체로는 아무런 기능이 없지만(주석과도 같다) 컴파일 하는 시점에 코드를 조작할 수 있는 기능을 제공해준다. 
// 컴파일 시 lombok이 조작해 NutritionFactsBuilder()를 만들어 준다.
// 단점 1. : 기본적으로 모든 파라미터를 받는 기본 생성자가 생성된다. -> @AllArgsConstructor(access = AccessLevel.PRIVATE) 해당 애노테이션 추가 시 빌더를 통해서만 개발이 가능하다.
// 단점 2. : 필수 값을 지정해 줄 수 없다.
//@Builder 이름을 넘겨주고 싶을 경우에는 @Builder(builderClassName = "Builder")
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//public class NutritionFacts {
//    private final int servingSize;
//    private final int servings;
//    private final int calories;
//    private final int fat;
//    private final int sodium;
//    private final int carbohydrate;
//
//    // 리턴 타입이 Builder 타입을 경우 .으로 연결하기 때문에 유연하고 자바 빈즈 보다 안정적이다. 
//    // .build()를 호출해 사용 가능하다.
//    public static void main(String[] args) {
//        NutritionFacts nutritionFacts = new NutritionFactsBuilder()
//        		.servingSize(100)
//        		.servings(10)
//        		.build();
//    }
//    
//}
