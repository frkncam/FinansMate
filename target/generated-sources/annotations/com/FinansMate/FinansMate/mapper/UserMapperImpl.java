package com.FinansMate.FinansMate.mapper;

import com.FinansMate.FinansMate.dto.user.RegisterRequest;
import com.FinansMate.FinansMate.model.MyUser;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-03T23:10:20+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public MyUser userRequestToUser(RegisterRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        MyUser myUser = new MyUser();

        myUser.setUsername( userRequest.getUsername() );
        myUser.setEmail( userRequest.getEmail() );
        myUser.setPassword( userRequest.getPassword() );

        return myUser;
    }
}
