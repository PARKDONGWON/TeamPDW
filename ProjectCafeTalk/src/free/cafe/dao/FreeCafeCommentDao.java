package free.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import free.cafe.dto.FreeCafeCommentDto;
import test.mybatis.SqlMapConfig;

public class FreeCafeCommentDao {
	private static FreeCafeCommentDao dao;
	private static SqlSessionFactory factory;
	private FreeCafeCommentDao(){}
	//자신의 참조값을 리턴해주는 static 맴버 메소드 
	public static FreeCafeCommentDao getInstance(){
		if(dao==null){
			dao=new FreeCafeCommentDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	// ref_group 번호를 이용해서 덧글 목록을 리턴하는 메소드
	public List<FreeCafeCommentDto> getList(int ref_group){
		SqlSession session=null;
		List<FreeCafeCommentDto> list=null;
		try {
			session=factory.openSession();
			/*
			 *  Mapper namespace : cafeComment
			 *  sql id : getList
			 *  parameterType : int
			 *  resultType : CafeCommentDto
			 */
			list=session.selectList("freecafeComment.getList", ref_group);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	//새 덧글을 저장하는 메소드
	public void insert(FreeCafeCommentDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.insert("freecafeComment.insert", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	//새 덧글의 글번호(sequence) 값을 얻어내서 리턴해주는 메소드
	public int getSequence(){
		SqlSession session=factory.openSession();
		int num=0;
		try{
			num=session.selectOne("freecafeComment.getSequence");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return num;
	}	
	
}






