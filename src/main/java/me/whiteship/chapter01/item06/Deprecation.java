package me.whiteship.chapter01.item06;

public class Deprecation {

    /**
	 * 애노테이션 프로세서
     * @deprecated in favor of
     * {@link #Deprecation(String)}
     */
	// forRemoval = true 자바 9 버전부터
    @Deprecated(forRemoval = true, since = "1.2")
    public Deprecation() {
    }

    private String name;

    public Deprecation(String name) {
        this.name = name;
    }
}
