package com.user.registration.mapper;

import com.user.registration.dto.UserDTO;
import com.user.registration.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}
