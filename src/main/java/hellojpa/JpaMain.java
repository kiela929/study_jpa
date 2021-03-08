package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        /**
         * 강의위치
         * 자바ORM표준 JAP프로그래밍-기본편
         * 02.JPA시작
         *
         * <JPA 구동 방식>
         * 1. META-INF/persistenca.xml 의 설정정보가 가장 처음으로 읽힘
         * 2. EntityManagerFactory라는 녀석이 여러개의 EntityManager를 생성해줌.
         * 이때의 EntityManager은 persistence.xml에서 생성한 것들을 읽어옴.
         *
         * <EntityManagerFactory와 EntityManager의 차이점>
         * EntityManagerFactory는 웹 애플리케이션이 올라온다면 DB당 딱 하나만 생성되어야하는것.
         * EntityManager는 요청이 올때마다 썼다가(선언) 버리도록(close) 동작되는것
         *
         * 그러므로 EntityManager는 쓰레드간에 공유가 절대 되면 안됨!!!!
         * 사용하고 버려야하는 것이지 공유가 된다면 장애가 일어남.
         *
         * 반드시 JPA의 모든 데이터 변경은 트렌젝션 안에서 실행되어야함.
         * RDB는 트렌젝션안에서 사용하도록 설계가 되어있음. 선언하지 않아도 되는것은 내부적으로 잘 돌아가기 때문
          */

        // EntityManagerFactory는 로딩시점에 딱 하나만 만들어 놓아야함.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 그리고 EntityManager는 CRUD가 일어날때마다 선언하여 닫아서 사용. 이것은 트랜젝션 단위로 사용.
        EntityManager em = emf.createEntityManager();

        // JPA에서 트랜젝션은 정말 중요함. 즉, 트랜젝션없이 사용할 수 없음.
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜젝션 시작

        // code가 들어감.


        try{
            // insert
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // select
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember="+findMember.getId());
//            System.out.println("findMember="+findMember.getName());

            //delete
//            Member findMember1 = em.find(Member.class, 1L);
//            em.remove(findMember1);

            //update
            /**
             * 트랜젝션이 커밋되는 순간에 조회해서 가져온 객체를 컬렉션처럼 들고있다가
             * set함수를 통해 값이 바뀐 객체가 있으면 update문을 자동적으로 날려줌.
              */
//            Member findMember2 = em.find(Member.class, 1L);
//            findMember2.setName("HelloJPA");

            /**
             * 영속성관리-내부 동작 방식 편
             * 영속성 컨텍스트 2
             *
             * 영속성성
            */

            // 영속
            Member member1 = new Member()
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            //entity manager를 닫아주는 것은 굉장히 중요함.
            em.close();
        }
        emf.close();

    }
}
