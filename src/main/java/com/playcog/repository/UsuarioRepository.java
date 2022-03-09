package com.playcog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.playcog.entity.UsuarioEntity;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer>{

	@Override
	public List<UsuarioEntity> findAll();//jpql
	
	public UsuarioEntity findById(int id);
}
