package com.yongpeng.dev.cdit.Repository;

import com.yongpeng.dev.cdit.DTO.UserDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yongpeng.dev.cdit.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("select new com.yongpeng.dev.cdit.DTO.UserDTO(u.name, u.salary) from User u where u.salary >= :min and u.salary <= :max")
  List<UserDTO> findByMinMaxAmountRange(@Param("min") double min,
                                          @Param("max") double  max);
}
