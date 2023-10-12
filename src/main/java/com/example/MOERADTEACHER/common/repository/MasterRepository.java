package com.example.MOERADTEACHER.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.modal.Master;
@Repository
public interface MasterRepository  extends JpaRepository<Master, Integer>{

	Master findAllByExtcall(String extcall);
}
