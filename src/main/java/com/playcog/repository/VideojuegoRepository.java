package com.playcog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.playcog.entity.VideojuegoEntity;

public interface VideojuegoRepository extends CrudRepository<VideojuegoEntity, Integer>{
	
	@Override
	public List<VideojuegoEntity> findAll();//jpql
	
	public VideojuegoEntity findById(int id);

}
