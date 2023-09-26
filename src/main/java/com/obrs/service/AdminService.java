package com.obrs.service;

import com.obrs.dto.AdminDto;
import com.obrs.dto.UserDto;
import com.obrs.entity.Admin;
import com.obrs.entity.User;

public interface AdminService {
        Admin addAdmin(AdminDto admindto);
		Admin loginAdmin(AdminDto adminDto);
}
