package com.ma.dao;

import java.util.List;

import com.ma.entrty.User;
import com.ma.entrty.UserVo;

public interface userMappper {
	List getfindall();
	void  getinsert(User user);
	//用包装类作为参数 
	void  getinsert2(UserVo vo);
	int getcount();
	List getList(List list);
	void getdelete(int[]array);
	

}
