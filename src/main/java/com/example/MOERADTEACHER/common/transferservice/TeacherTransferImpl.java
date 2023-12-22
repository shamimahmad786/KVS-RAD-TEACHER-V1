package com.example.MOERADTEACHER.common.transferservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MOERADTEACHER.common.modal.TeacherFormStatus;
import com.example.MOERADTEACHER.common.repository.TeacherFormStatusRepository;
import com.example.MOERADTEACHER.common.transfermodel.TeacherTransferDetails;
import com.example.MOERADTEACHER.common.transferrepository.TeacherTransferRepository;
import com.example.MOERADTEACHER.common.util.NativeRepository;

@Service
@Transactional
public class TeacherTransferImpl {

	@Autowired
	TeacherTransferRepository teacherTransferRepository;
	
	@Autowired
	NativeRepository nativeRepository;
	
	@Autowired
	TeacherFormStatusRepository  teacherFormStatusRepository;
	
	
	public TeacherTransferDetails saveTransferDCTCPoints(TeacherTransferDetails data) throws Exception {
		try {
//			if(data.getTcSaveYn() !=null && (data.getTcSaveYn()==1 || data.getDcSaveYn()==1)) {
//		     System.out.println("TC save--->"+data.getTcSaveYn());
//				nativeRepository.updateQueries(" update teacher_transfer_profile set transfer_status=1 , transfer_id='"+data.getTransferId()+"' where teacher_id="+data.getTeacherId());
//				nativeRepository.updateQueries(" update public.teacher_profile set verify_flag='TTS'  where teacher_id="+data.getTeacherId());
//				nativeRepository.updateQueries(" update public.teacher_form_status set final_status='TTS'  where teacher_id="+data.getTeacherId());
//			}
			
			TeacherFormStatus tObj=teacherFormStatusRepository.findAllByTeacherId(data.getTeacherId());
			tObj.setForm4Status("1");
			teacherFormStatusRepository.save(tObj);
		    return teacherTransferRepository.saveAndFlush(data);
		}catch(Exception ex) {
//			nativeRepository.updateQueries(" update teacher_transfer_profile set transfer_status=0 , transfer_id='' where teacher_id="+data.getTeacherId());
			ex.printStackTrace();
		}
		return null;
	}
	
	public TeacherTransferDetails getTcDcPointByTeacherId(Integer teacherId) {
		return teacherTransferRepository.findAllByTeacherId(teacherId);
	}
	
	
	public TeacherTransferDetails getTcDcPointByTeacherIdAndInitYear(Integer teacherId,String inityear) {
	
		System.out.println("call data---->"+teacherTransferRepository.findAllByTeacherIdAndInityear(teacherId,inityear));
		return teacherTransferRepository.findAllByTeacherIdAndInityear(teacherId,inityear);
	}
}
