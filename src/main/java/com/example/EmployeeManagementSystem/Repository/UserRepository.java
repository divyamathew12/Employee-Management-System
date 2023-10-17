//package com.example.EmployeeManagementSystem.Repository;
//
//import com.example.EmployeeManagementSystem.Entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends JpaRepository<User , Integer> {
//    Optional<User> findByEmail(String email);
//
//    Optional<User> findByUsername(String username);
//    @Query("SELECT u FROM User u WHERE u.username = :username")
//    public User getUserByUsername(@Param("username") String username);
//
//}
