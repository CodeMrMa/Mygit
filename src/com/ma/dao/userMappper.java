package com.ma.dao;

import java.util.List;

import com.ma.entrty.User;
import com.ma.entrty.UserVo;

public interface userMappper {
	List getfindall();
	void  getinsert(User user);
	//�ð�װ����Ϊ���� 
	void  getinsert2(UserVo vo);
	int getcount();
	List getList(List list);
	void getdelete(int[]array);
	

}
