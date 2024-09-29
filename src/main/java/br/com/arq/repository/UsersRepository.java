package br.com.arq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arq.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
	
	public Users findByEmail(String email); //login

}