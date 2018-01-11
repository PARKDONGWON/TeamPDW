package test.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.users.dto.UsersDto;

public class UsersDao {
	private static UsersDao dao;
	private static SqlSessionFactory factory;
	private UsersDao(){}
	public static UsersDao getInstance(){
		if(dao==null){
			dao=new UsersDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	//회원정보를 삭제하는 메소드
	public void delete(String id) {
		SqlSession session=null;
		try {
			//auto commit 되는 SqlSession 객체 얻어오기 
			session=factory.openSession(true);
			/*
			 *  Mapper 의 namespace : users
			 *  Mapper 안에 sql 문의 id : delete
			 *  parameterType : String 
			 */
			session.delete("users.delete", id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	//회원정보를 수정하는 메소드
	public void update(UsersDto dto) {
		SqlSession session=null;
		try {
			session=factory.openSession(true);
			session.update("users.update", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	//회원 한명의 정보를 리턴해주는 메소드
	public UsersDto getData(String id) {
		SqlSession session=null;
		UsersDto dto=null;
		try {
			session=factory.openSession();
			/*
			 *  Mapper 의 namespace : users
			 *  Mapper 안에 sql id : getData
			 *  parameterType : String 
			 *  resultType : UsersDto
			 */
			dto=session.selectOne("users.getData", id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	//아이디 비밀번호가 유효한지 여부를 리턴하는 메소드
	public boolean isValid(UsersDto dto) {
		SqlSession session=null;
		String id=null;
		try {
			session=factory.openSession();
			/*
			 *  parameterType : UsersDto
			 *  resultType : String 
			 */
			id=session.selectOne("users.isValid", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// id 가 null 이면 아이디 혹은 비밀번호가 틀린것이다.
		if(id==null) {
			return false;
		}else {
			return true;
		}
	}
	//회원정보를 저장하는 메소드
	public void insert(UsersDto dto) {
		SqlSession session=null;
		try {
			session=factory.openSession(true);
			session.insert("users.insert", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}






















