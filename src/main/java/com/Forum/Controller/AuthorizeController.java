package com.Forum.Controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Forum.Dto.AccesstokenDTO;
import com.Forum.Dto.GitHubUser;
import com.Forum.Model.User;
import com.Forum.Provider.GitHubProvider;
import com.Forum.mapper.UserMapper;
import com.Forum.mapper.UserMapperimpl;

/**
 *	@Author	  ZFFFlower  ——2020年1月9日
 *	
 * 	GitHub第三方登录时，验证Client_id和Client_secret
 * 	在https://api.github.com/user?access_token=e68cfce5a5bd6b869bc41f74125e9f3598caf078中获取用户信息
 */
@Controller
public class AuthorizeController{
	
	@Autowired
	private GitHubProvider gitHubProvider;

	@Value("${github.client.id}")
	private String clientId;
	
	@Value("${github.client.secret}")
	private String clientSecret;
	
	@Value("${github.redirect.uri}")
	private String redirectUri;
	
	@Autowired
	private UserMapperimpl userMapper;
	
	@GetMapping("/callback")
	public String callback(@RequestParam(name="code") String code,
							@RequestParam(name="state") String state,
							HttpServletRequest request
			) {
		AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
		accesstokenDTO.setCode(code);
		accesstokenDTO.setRedirect_uri("redirectUri");
		accesstokenDTO.setClient_id(clientId);
		accesstokenDTO.setClient_secret(clientSecret);
		accesstokenDTO.setState(state);
		String accessToken = gitHubProvider.getAccessToken(accesstokenDTO);
		GitHubUser githubUser = gitHubProvider.getUser(accessToken);
		if(githubUser != null) {
			//	登录成功，写cookie和session 
			User user = new User();
			user.setToken(UUID.randomUUID().toString());
			user.setName(githubUser.getName());
			user.setAccountId(String.valueOf(githubUser.getId()));
			user.setQmtCreate(System.currentTimeMillis());
			user.setQmtModified(user.getQmtCreate());
			userMapper.insert(user);
			request.getSession().setAttribute("user", githubUser);
			return "redirect:/";	//	去掉地址后缀
		}else {
			//	登录失败，重新登录
			return "redirect:/";
		}
	}
}
	