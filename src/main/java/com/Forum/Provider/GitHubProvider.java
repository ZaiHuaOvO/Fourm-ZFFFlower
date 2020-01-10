package com.Forum.Provider;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.Forum.Dto.AccesstokenDTO;
import com.Forum.Dto.GitHubUser;
import com.alibaba.fastjson.JSON;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *	@Author	  ZFFFlower  ——2020年1月9日
 *	
 * 	处理GitHub传过来的数据
 */
@Component
public class GitHubProvider {
	public String getAccessToken(AccesstokenDTO accesstokenDTO) {
		MediaType mediaType = MediaType.get("application/json; charset=utf-8");
		OkHttpClient client = new OkHttpClient();

	RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accesstokenDTO) );
	  Request request = new Request.Builder()
	      .url("https://github.com/login/oauth/access_token")
	      .post(body)
	      .build();
	  try(Response response = client.newCall(request).execute()) {
			String string = response.body().string();
			
			//	将获取到的字符串截断获取
			String[] split = string.split("&");
			String tokenstr = split[0];
			String token = tokenstr.split("=")[1];
			return token;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return null;
	}
	
	public GitHubUser getUser(String accessToken) {
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder()
			      .url("https://api.github.com/user?access_token=e68cfce5a5bd6b869bc41f74125e9f3598caf078")
			      .build();
		try {
			Response response = client.newCall(request).execute();
			String string = response.body().string();
			GitHubUser githubUser = JSON.parseObject(string,GitHubUser.class);
			return githubUser;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
