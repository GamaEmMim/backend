package br.com.ruavarejo.backend.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruavarejo.backend.annotation.Post;

@RestController
public class AdminController {
	@Autowired
	private AdminDTOToAdminConverter adminConverter;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminRepository adminRepository;
	
	@Post("/admin")
	public void createAdmin(@Valid @RequestBody AdminDTO adminDTO){
		Admin admin = adminConverter.convert(adminDTO);
		if (adminService.isUserAvailable(adminDTO)){
			adminRepository.save(admin);
		}
	}

}
