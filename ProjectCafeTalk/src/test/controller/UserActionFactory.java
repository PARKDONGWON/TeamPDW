package test.controller;

<<<<<<< HEAD
import test.action.HomeAction;
=======
import free.cafe.action.FreeCafeCommentInsertAction;
import free.cafe.action.FreeCafeDeleteAction;
import free.cafe.action.FreeCafeDetailAction;
import free.cafe.action.FreeCafeInsertAction;
import free.cafe.action.FreeCafeInsertFormAction;
import free.cafe.action.FreeCafeListAction;
import free.cafe.action.FreeCafeUpdateAction;
import free.cafe.action.FreeCafeUpdateFormAction;
import main.home.action.MainHomeAction;
>>>>>>> PDW
import test.notice.action.NoticeCommentInsertAction;
import test.notice.action.NoticeDeleteAction;
import test.notice.action.NoticeDetailAction;
import test.notice.action.NoticeInsertAction;
import test.notice.action.NoticeInsertFormAction;
import test.notice.action.NoticeListAction;
import test.notice.action.NoticeUpdateAction;
import test.notice.action.NoticeUpdateFormAction;
import test.users.action.LoginAction;
import test.users.action.LoginFormAction;
import test.users.action.LogoutAction;
import test.users.action.SignupAction;
import test.users.action.SignupFormAction;
import test.users.action.UsersDeleteAction;
import test.users.action.UsersInfoAction;
import test.users.action.UsersUpdateAction;
import test.users.action.UsersUpdateFormAction;

public class UserActionFactory {
	private static UserActionFactory factory;
	private UserActionFactory(){}
	//자신의 참조값을 리턴해주는 메소드
	public static UserActionFactory getInstance(){
		if(factory==null){
			factory=new UserActionFactory();
		}
		return factory;
	}
	// 요청처리를 할 Action 객체를 리턴해주는 메소드
	public Action action(String command) {
		Action action=null;
<<<<<<< HEAD
		if(command.equals("/home")) {
			action=new HomeAction();
=======
		if(command.equals("/free")) {
			action=new MainHomeAction();
>>>>>>> PDW
		}else if(command.equals("/users/signup_form")) {
			action=new SignupFormAction();
		}else if(command.equals("/users/signup")) {
			action=new SignupAction();
		}else if(command.equals("/users/login_form")) {
			action=new LoginFormAction();
		}else if(command.equals("/users/login")) {
			action=new LoginAction();
		}else if(command.equals("/users/logout")) {
			action=new LogoutAction();
		}else if(command.equals("/users/private/info")) {
			action=new UsersInfoAction();
		}else if(command.equals("/users/private/updateform")) {
			action=new UsersUpdateFormAction();
		}else if(command.equals("/users/private/update")) {
			action=new UsersUpdateAction();
		}else if(command.equals("/users/private/delete")) {
			action=new UsersDeleteAction();
		}else if(command.equals("/notice/noticelist")) {
			action=new NoticeListAction();
		}else if(command.equals("/notice/private/adminNoticeList")) {
			action=new NoticeListAction();
		}else if(command.equals("/notice/private/adminNoticeInsertForm")){
			action=new NoticeInsertFormAction();
		}else if(command.equals("/notice/private/noticeInsert")) {
			action=new NoticeInsertAction();
		}else if(command.equals("/notice/noticeDetail")) {
			action=new NoticeDetailAction();
		}else if(command.equals("/notice/private/adminNoticeDelete")) {
			action=new NoticeDeleteAction();
		}else if(command.equals("/notice/private/adminNoticeUpdateForm")) {
			action = new NoticeUpdateFormAction();
		}else if(command.equals("/notice/private/noticeUpdate")) {
			action = new NoticeUpdateAction();
		}else if(command.equals("/notice/comment_insert")) {
			action = new NoticeCommentInsertAction();
<<<<<<< HEAD
=======
		}else if(command.equals("/freecafe/freelist")) {
			action=new FreeCafeListAction();
		}else if(command.equals("/freecafe/private/insert")) {
			action=new FreeCafeInsertAction();
		}else if(command.equals("/freecafe/private/insertform")) {
			action=new FreeCafeInsertFormAction();
		}else if(command.equals("/freecafe/private/updateform")) {
			action=new FreeCafeUpdateFormAction();
		}else if(command.equals("/freecafe/update")) {
			action=new FreeCafeUpdateAction();
		}else if(command.equals("/freecafe/delete")) {
			action=new FreeCafeDeleteAction();
		}else if(command.equals("/freecafe/detail")) {
			action=new FreeCafeDetailAction();
		}else if(command.equals("/freecafe/comment_insert")) {
			action=new FreeCafeCommentInsertAction();
>>>>>>> PDW
		}
		return action;
	}
}












