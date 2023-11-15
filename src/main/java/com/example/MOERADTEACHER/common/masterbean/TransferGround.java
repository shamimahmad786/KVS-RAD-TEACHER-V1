package com.example.MOERADTEACHER.common.masterbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_transfer_under_cat", schema = "master")
public class TransferGround {
@Id
public Integer	id;
@Column(name="categories_name")
public String	categoriesName;
@Column(name="categories_id")
public Integer	categoriesId;
@Column(name="categories_value")
public Integer   categoriesValue;
@Column(name="inityear")
public String	inityear;
}
