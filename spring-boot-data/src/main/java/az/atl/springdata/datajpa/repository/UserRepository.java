package az.atl.springdata.datajpa.repository;

import az.atl.springdata.datajpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.id=1")//JPQL
    User getUSerByIdOne();

    @Query(value="select * from users u where u.id=2",nativeQuery = true)//Native query
    User getUSerByIdtwo();


    User findByEmail(String email);

    Page<User> findAll(Pageable pageable);

    @Query("select u from User u")
    Page<User> findAllUsersWithPage(Pageable pageable);

    @Query("select u from User u where u.id=?1")
    User findByUserId(int id);

    @Query("SELECT u FROM User u WHERE  u.name = :name and  u.surname=:surname")
    User findUserByStatusAndNameNamedParams( @Param("name") String name, @Param("surname") String surname);


}
