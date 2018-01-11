package free.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import free.cafe.dto.FreeCafeDto;
import test.mybatis.SqlMapConfig;

public class FreeCafeDao {
	private static FreeCafeDao dao;
	private static SqlSessionFactory factory;
	private FreeCafeDao(){}
	public static FreeCafeDao getInstance(){
		if(dao==null){
			dao=new FreeCafeDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
		
	//전체 글의 갯수를 리턴하는 메소드
	public int getCount(FreeCafeDto dto) {
		SqlSession session=null;
		int count=0;
		try {
			session=factory.openSession();
			count=session.selectOne("freecafe.getCount", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count;
	}
	
	//글정보를 수정하는 메소드
	public void update(FreeCafeDto dto) {
		SqlSession session=null;
		try {
			session=factory.openSession(true);
			session.update("freecafe.update", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//글정보를 삭제하는 메소드
	public void delete(int num) {
		SqlSession session=null;
		try {
			session=factory.openSession(true);
			session.delete("freecafe.delete", num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//글정보를 리턴해주는 메소드
	public FreeCafeDto getData(FreeCafeDto dto) {
		SqlSession session=null;
		FreeCafeDto resultDto=null;
		try {
			session=factory.openSession();

			resultDto=session.selectOne("freecafe.getData", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return resultDto;
	}
	
	//조회수를 1 증가 시키는 메소드
	public void increaselikeCount(int num) {
		SqlSession session=null;
		try {
			session=factory.openSession(true);
			session.update("freecafe.increaseLikeCount", num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}	
	}
	
	//글목록을 리턴해주는 메소드
	/*
	 *  인자로 전달된 FreeCafeDto 에는 startRowNum 과 endRowNum 이 
	 *  들어 있다. 이값을 이용해서 SELECT 한다. 
	 */
	public List<FreeCafeDto> getList(FreeCafeDto dto){
		SqlSession session=null;
		List<FreeCafeDto> list=null;
		try {
			session=factory.openSession();
			/*
			 *  Mapper 의 namespace : freecafe
			 *  sql id : getList
			 *  parameterType : FreeCafeDto
			 *  resultType : FreeCafeDto
			 */
			list=session.selectList("freecafe.getList", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	//글정보를 저장하는 메소드 
	public void insert(FreeCafeDto dto) {
		SqlSession session=null;
		try {
			session=factory.openSession(true);
			session.insert("freecafe.insert", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}























