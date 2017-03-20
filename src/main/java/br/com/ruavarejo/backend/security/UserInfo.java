package br.com.ruavarejo.backend.security;

import br.com.ruavarejo.backend.annotation.WebComponent;

@WebComponent
public class UserInfo {
	private String ipAddress;

	@Deprecated
	public UserInfo(){
	}
	
	public String getIpAddress(){
		return this.ipAddress;
	}
	
	public void setIpAddress(String ipAddress){
		this.ipAddress = ipAddress;
	}
}
