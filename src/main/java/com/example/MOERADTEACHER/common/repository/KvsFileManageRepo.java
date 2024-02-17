package com.example.MOERADTEACHER.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MOERADTEACHER.common.modal.KvsControllerOffice;
import com.example.MOERADTEACHER.common.modal.KvsFileManage;

public interface KvsFileManageRepo extends JpaRepository<KvsFileManage, String> {

}
