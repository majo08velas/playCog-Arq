package com.playcog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.playcog.entity.ProgresoEntity;
import com.playcog.entity.VideojuegoEntity;

public interface ProgresoRepository extends CrudRepository<ProgresoEntity, Integer>{

	@Override
	public List<ProgresoEntity> findAll();//jpql
	
	public ProgresoEntity findById(int id);
}
