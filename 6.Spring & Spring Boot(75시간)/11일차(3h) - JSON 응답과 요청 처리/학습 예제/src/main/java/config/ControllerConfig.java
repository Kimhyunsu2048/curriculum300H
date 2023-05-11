package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import spring.MemberRegisterService;
import survey.SurveyController;
import controller.LoginController;
import spring.AuthService;
import controller.LogoutController; 
import controller.ChangePwdController;
import spring.ChangePasswordService;
import controller.MemberDetailController;
import controller.MemberListController;
import spring.MemberDao;
import controller.RestMemberController;
import controller.ApiExceptionAdvice;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public RegisterController registerController() {
		RegisterController controller =  new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}
	
	@Bean
	public LoginController lgoinController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
	
	@Bean
	public MemberListController memberListController() {
		MemberListController controller = new MemberListController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public MemberDetailController memberDetailController() {
		MemberDetailController controller = new MemberDetailController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public RestMemberController restApi() {
		RestMemberController cont = new  RestMemberController();
		cont.setMemberDao(memberDao);
		cont.setRegisterService(memberRegSvc);
		return cont;
	}
	
	@Bean
	public ApiExceptionAdvice apiExceptionAdvice() {
		return new ApiExceptionAdvice();
	}
}