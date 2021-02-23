package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 강의위치
 * 자바ORM표준 JAP프로그래밍-기본편
 * 02.JPA시작
 *
 * @Entity는 JPA를 사용하는 클래스구나 하는 선언이므로 꼭 있어야함.
 */
@Entity
//관례상 아무것도 선언을 안하면 클래스명과 동일한 member 테이블에 매핑이 되는데,
//그걸 바꾸려면 다음과 같이 선언하면 됨.
// @Table(name="테이블명 매핑")
public class Member {

    // @Id는 primary key를 의미. 이거는 선언해줘야함.
    @Id
    // 컬럼명을 선언하지 않으면 동일한 이름의 컬럼에 매핑되는데, 그게 싫으면 다음과 같이 선언해주면 된다.
    //@Column(name="매핑할 컬럼")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
