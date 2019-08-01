package co.grandcircus.CoffeeShopApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.CoffeeShopApp.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByEmailAndPassword(String email, String password);
}