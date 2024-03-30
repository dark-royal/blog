package org.example.data.repositories.servicesTest;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.requests.LoginUserRequest;
import org.example.dtos.requests.LogoutUserRequest;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServiceTest {
    @Autowired
    private RegisterUserRequest registerUserRequest;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginUserRequest loginUserRequest;
    @Autowired
    private LogoutUserRequest logoutUserRequest;

    @BeforeEach
    public void initializer() {
        registerUserRequest = new RegisterUserRequest();
        loginUserRequest = new LoginUserRequest();
        logoutUserRequest = new LogoutUserRequest();
        userRepository.deleteAll();
    }

    @Test
    public void registerUser() {
        User user = new User();

        registerUserRequest.setFirstName("praise");
        registerUserRequest.setLastName("oyewole");
        registerUserRequest.setUsername("dark royal");
        registerUserRequest.setPassword("israel");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());
    }

    @Test
    public void login() {
        User user = new User();
        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("praise");
        registerUserRequest.setLastName("oyewole");
        registerUserRequest.setUsername("dark royal");
        registerUserRequest.setPassword("israel");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());
        loginUserRequest.setUsername("dark royal");
        loginUserRequest.setPassword("israel");
        userService.loginUser(loginUserRequest);
        assertTrue(user.isLoginStatus());

    }

    @Test
    public void userCan_register_login_andlogout() {
        User user = new User();
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertEquals(1, userService.count());
        loginUserRequest.setUsername("username");
        loginUserRequest.setPassword("password");
        userService.loginUser(loginUserRequest);
        assertTrue(user.isLoginStatus());
        userService.logoutUser(logoutUserRequest);
        assertFalse(user.isLoginStatus());
    }

//    @Test
//    public void testUserCannotLoginWithIncorrectUsernameOrPassword(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username1");
//        loginRequest.setPassword("password");
//        assertThrows(DiaryNotFoundException.class,()->diaryService.login(loginRequest));
//
//
//    }
//    @Test
//    public void test_user_cannot_login_while_not_registered_throw_diary_not_found_exception(){
//        loginRequest.setUsername(loginRequest.getUsername());
//        loginRequest.setPassword(loginRequest.getPassword());
//        assertThrows(DiaryNotFoundException.class,()->diaryService.login(loginRequest));
//
//    }
//
//    @Test
//    public void userCan_register_login_andlogout_with_incorrect_username() {
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        assertThrows(DiaryNotFoundException.class,()->diaryService.logout("username1"));
//        assertTrue(diary.setLogStatus(true));
//    }
//
//    @Test
//    public void userCanRegister_Login_createEntry(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1,diaryService.count());
//
//
//    }
//
//    @Test
//    public void userCanRegister_Login_createEntry_andCanUpdateTheEntry() {
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        Entry entyr1 = diaryService.createEntry(createEntryRequest);
//        assertEquals(1, diaryService.count());
//        updateEntryRequest.setTitle("semicolon");
//        updateEntryRequest.setBody("change");
//        diaryService.updateEntry(updateEntryRequest);
//        //System.out.println(STR."\{updateRequest.getId()} nothing");
//        assertEquals("semicolon", diaryService.updateEntry(updateEntryRequest));
//        assertEquals("change",diaryService.updateEntry(updateEntryRequest));
//
//
//    }
//
//    @Test
//    public void userCanRegister_login_createEntry_findEntry(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1,diaryService.count());
//        Entry entry = diaryService.findEntry("semicolon");
//        assertEquals(entry,diaryService.findEntry("semicolon"));
//
//
//    }
//
//    @Test
//    public void userCanRegister_login_createEntry_deleteEntry(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1,diaryService.count());
//        Entry entry = diaryService.findEntry("semicolon");
//        assertEquals(entry,diaryService.findEntry("semicolon"));
//        diaryService.deleteEntry("semicolon");
//        assertEquals(0,diaryService.countEntries());
//
//    }
//
//    @Test
//    public void userCanRegister_login_createEntry_findEntryWithIncorrectPassword(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1,diaryService.count());
//        assertThrows(EntryNotFoundException.class,()->diaryService.findEntry("semicoloni"));
//
//
//    }
//
//    @Test
//    public void userCanRegister_login_createEntry_findEntry_deleteEntryWithIncorrectPassword() {
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1, diaryService.count());
//        Entry entry = diaryService.findEntry("semicolon");
//        assertEquals(entry, diaryService.findEntry("semicolon"));
//        assertThrows(EntryNotFoundException.class,()->diaryService.deleteEntry("semicoloni"));
//    }
//




}
