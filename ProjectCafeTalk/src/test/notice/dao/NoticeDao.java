package test.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.notice.dto.NoticeDto;

public class NoticeDao {
	private static NoticeDao dao;
	private static SqlSessionFactory factory;
	private NoticeDao() {}
	
	public static NoticeDao getInstance() {
		if(dao==null) {
			dao=new NoticeDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	//게시판 페이지를 위한 글의 갯수 리턴메소드
	public int getCount(NoticeDto dto) {
		SqlSession session = null;
		int count=0;
		try {
			session=factory.openSession();
			count=session.selectOne("notice.getCount", dto);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count;
	}
	
	//게시판을 클릭할때마다 조회수를 올리는 메소드
	public void ViewCount(int num) {
		SqlSession session = null;
		try {
			session=factory.openSession(true);
			session.update("notice.ViewCount", num);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//공지사항 업데이트 하는 메소드
	public void update(NoticeDto dto) {
		SqlSession session = null;
		try {
			session=factory.openSession(true);
			session.update("notice.update", dto);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//공지사항 삭제 하는 메소드
	public void delete(int num) {
		SqlSession session = null;
		try {
			session=factory.openSession(true);
			session.delete("notice.delete", num);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	
	//공지사항 목록을 보여주는 메소드
	public List<NoticeDto> getList(NoticeDto dto) {
		SqlSession session = null;
		List<NoticeDto> list = null;
		try {
			session=factory.openSession();
			list=session.selectList("notice.getList", dto);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	//공지사항 입력
	public void insert(NoticeDto dto) {
		SqlSession session = null;
		try {
			session=factory.openSession(true);
			session.insert("notice.insert", dto);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//공지사항 디테일
	public NoticeDto getData(NoticeDto dto) {
		SqlSession session = null;
		NoticeDto resultDto = null;
		try {
			session = factory.openSession();
			resultDto = session.selectOne("notice.getData", dto);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return resultDto;
	}
	
}
