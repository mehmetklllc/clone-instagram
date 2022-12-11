package com.instagram;

import com.instagram.dto.UserCreateRequestDto;
import com.instagram.entities.User;
import com.instagram.mapper.UserMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CloneinstagramjavaApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("test");
    }


    @Test
    public void shouldMapUserDtoToUser() {
        //given
        UserCreateRequestDto userCreateRequestDto = new UserCreateRequestDto();
        userCreateRequestDto.setUsername("Ediz");
        userCreateRequestDto.setDisplayName("Edzey");
        userCreateRequestDto.setPassword("password");

        //when
        User user = UserMapper.USER_INSTANCE.userDtoToUser( userCreateRequestDto );

        //then

        Assertions.assertThat( user ).isNotNull();
        Assertions.assertThat( user.getUsername() ).isEqualTo( "Ediz" );
        Assertions.assertThat( user.getDisplayName() ).isEqualTo( "Edzey");
        Assertions.assertThat( user.getPassword() ).isNotEmpty();
    }
    @Test
    void repeatTest(){
        System.out.println("Repeat Test Running");
    }

    @Test
    void repeatTestınstagram(){
        System.out.println("Repeat Test Instagram Running");
    }

}
