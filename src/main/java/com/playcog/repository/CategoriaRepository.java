package com.playcog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.playcog.entity.CategoriaEntity;

public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Integer>{

	@Override
	public List<CategoriaEntity> findAll();//jpql
	
	public CategoriaEntity findById(int id);
}
