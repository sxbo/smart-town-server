package com.fs.smartTown.modules.dataRegister.dao;

import com.fs.smartTown.modules.dataRegister.entity.FarmProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmProductRepository extends JpaRepository<FarmProduct, Integer>{
    List<FarmProduct> findAllByTypeId(Integer type);
}
