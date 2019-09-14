			package com.ma.utils;
			
			import java.io.IOException;
	import java.io.InputStream;
	import java.util.ArrayList;
	import java.util.List;
			
	
			import org.apache.ibatis.io.Resources;
			import org.apache.ibatis.session.SqlSession;
			import org.apache.ibatis.session.SqlSessionFactory;
			import org.apache.ibatis.session.SqlSessionFactoryBuilder;
			import org.apache.naming.resources.Resource;
			import org.junit.Before;
			import org.junit.Test;
			
	
			import com.ma.dao.userMappper;
	import com.ma.entrty.User;
	import com.ma.entrty.UserVo;
			
			public class Text {
			SqlSessionFactory sessionFactory=null;
			@Before
				 
			public  void  init() throws IOException{
				SqlSessionFactoryBuilder sessionFactoryBuilder=new SqlSessionFactoryBuilder();
				InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
				sessionFactory=sessionFactoryBuilder.build(resourceAsStream);
				
				  }
			
			@Test
			public  void  info(){
				SqlSession openSession = sessionFactory.openSession();
				userMappper user= openSession.getMapper(userMappper.class);
				List<User> list = user.getfindall();
				for(User user1:list){
					System.out.println(user1.getUsername());
				}
				
				
				
				
			}
			@Test
			public void  info1(){
				SqlSession openSession = sessionFactory.openSession();
				userMappper u= openSession.getMapper(userMappper.class);
				User user=new User();
				user.setPass("789");
				user.setUsername("andy");
				u.getinsert(user);
				openSession.commit();
				System.out.println(user.getId());
				openSession.close();
				
			}
			
			//使用包装类进行参数转递
			@Test
			public void  info2(){
				SqlSession openSession = sessionFactory.openSession();
				userMappper u= openSession.getMapper(userMappper.class);
				User user=new User();
				user.setPass("456");
				user.setUsername("andy");
				UserVo vo=new  UserVo();
				vo.setUser(user);
				u.getinsert2(vo);
				openSession.commit();
				openSession.close();
				
			}
			@Test
			public  void gecount(){
				SqlSession openSession = sessionFactory.openSession();
				userMappper u= openSession.getMapper(userMappper.class);
				int unm=u.getcount();
				System.out.println(unm);
			}
			@Test
			public  void getlist(){
				SqlSession openSession = sessionFactory.openSession();
				userMappper u= openSession.getMapper(userMappper.class);
				List list=new ArrayList();
				list.add(1);
				list.add(2);
				list.add(3);
				
				List list1 = u.getList(list);
				System.out.println(list1.size());
				}
			@Test
			public  void getdelete(){
				SqlSession openSession = sessionFactory.openSession();
				userMappper u= openSession.getMapper(userMappper.class);
				int[]array={1,2,3};
				
			 u.getdelete(array);	
			 openSession.commit();
			 openSession.close();
				}
			}
