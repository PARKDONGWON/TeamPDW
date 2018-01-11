package test.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.notice.dto.NoticeCommentDto;

public class NoticeCommentDao {
	private static NoticeCommentDao dao;
	private static SqlSessionFactory factory;
	private NoticeCommentDao(){}
	//자신의 참조값을 리턴해주는 static 맴버 메소드 
	public static NoticeCommentDao getInstance(){
		if(dao==null){
			dao=new NoticeCommentDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	// ref_group 번호를 이용해서 덧글 목록을 리턴하는 메소드
	public List<NoticeCommentDto> getList(int ref_group){
		SqlSession session=null;
		List<NoticeCommentDto> list=null;
		try {
			session=factory.openSession();
			list=session.selectList("noticeComment.getList", ref_group);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	
	public void insert(NoticeCommentDto dto){
		SqlSession session=factory.openSession(true);
		try{
			session.insert("noticeComment.insert", dto);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public int getSequence(){
		SqlSession session=factory.openSession();
		int num=0;
		try{
			num=session.selectOne("noticeComment.getSequence");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return num;
	}	
}
