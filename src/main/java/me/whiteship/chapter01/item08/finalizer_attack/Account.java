package me.whiteship.chapter01.item08.finalizer_attack;

import java.math.BigDecimal;

// 상속을 지원할 필요가 없으면 final로 하면 finallizer 공격을 막을 수 있다.
// 상속을 허용해야 하는 경우에는 finalize()를 재정의한다.(final) -> 오버라이드를 허용하지 않는 메소드가 된다.
public class Account {

    private String accountId;

    public Account(String accountId) {
        this.accountId = accountId;

        if (accountId.equals("푸틴")) {
            throw new IllegalArgumentException("푸틴은 계정을 막습니다.");
        }
    }

    public void transfer(BigDecimal amount, String to) {
        System.out.printf("transfer %f from %s to %s\n", amount, accountId, to);
    }

    @Override
    protected final void finalize() throws Throwable {
    	// TODO Auto-generated method stub
    }
}
