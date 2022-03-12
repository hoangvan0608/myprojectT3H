package vn.t3h.java2109.services.Impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.AccountDTO;
import vn.t3h.java2109.dto.RoleDTO;
import vn.t3h.java2109.model.RoleEntity;
import vn.t3h.java2109.repository.RoleRepository;
import vn.t3h.java2109.services.IRoleService;
import vn.t3h.java2109.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements IRoleService {


    @Autowired
    RoleRepository repository;

    @Autowired
    ModelMapper modelMapper;
    public List<RoleDTO> getAllRoles(){
        List<RoleEntity> roles = repository.findAll();
        return modelMapper.map(roles, new TypeToken<List<RoleDTO>>(){}.getType());
    }


}
