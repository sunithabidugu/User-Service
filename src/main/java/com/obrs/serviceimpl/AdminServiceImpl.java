package com.obrs.serviceimpl;

import com.obrs.dto.AdminDto;
import com.obrs.entity.Admin;
import com.obrs.exception.AdminNotFoundException;
import com.obrs.exception.CustomerNotFoundException;
import com.obrs.repository.AdminRepository;
import com.obrs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
    private  AdminRepository adminRepository;

    @Override
    public Admin addAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setAdminId(adminDto.getAdminId());
        admin.setAdminName(adminDto.getAdminName());
        admin.setPassword(adminDto.getPassword()); 
        adminRepository.save(admin);
        return admin;
    }

    @Override
    public Admin loginAdmin(AdminDto adminDto) {
        Admin admin = adminRepository.findByAdminName(adminDto.getAdminName());

        if (admin == null || !adminDto.getPassword().equals(admin.getPassword())) {
            throw new AdminNotFoundException("Invalid admin credentials");
        }

        return admin;
    }
}
