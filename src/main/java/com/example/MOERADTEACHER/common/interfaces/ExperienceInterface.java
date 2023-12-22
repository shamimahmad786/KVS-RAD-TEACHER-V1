package com.example.MOERADTEACHER.common.interfaces;

import java.util.List;
import java.util.Map;

import com.example.MOERADTEACHER.common.bean.ExperienceBean;
import com.example.MOERADTEACHER.common.modal.TeacherExperience;

public interface ExperienceInterface {
	List<TeacherExperience> saveExperience(List<TeacherExperience> data);
	TeacherExperience saveExperience(TeacherExperience data);
	List<ExperienceBean> getExperienceByTeacherId(Integer data);
	 Map<String,Object> deleteByWorkExperienceId(Integer id);
	 TeacherExperience saveWorkExperienceV2(TeacherExperience data);
	 List<TeacherExperience> getExperienceByTeacherIdV2(Integer data);
}
