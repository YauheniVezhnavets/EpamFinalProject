package com.epam.web.service;

import com.epam.web.dao.DaoException;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.UserDao;
import com.epam.web.entities.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserServiceTest {


    private static UserDao mockDao;
    private static UserService userService;
    private static User mockUser;
    private final static Long MOCK_ID = 1L;


    @BeforeClass
    public static void loginShouldReturn() throws DaoException {

        mockDao = Mockito.mock(UserDao.class);
        DaoHelper mockDaoHelper = Mockito.mock(DaoHelper.class);
        DaoHelperFactory mockDaoHelperFactory = Mockito.mock(DaoHelperFactory.class);
        when(mockDaoHelperFactory.create())
                .thenReturn(mockDaoHelper);
        when(mockDaoHelper.createUserDao())
                .thenReturn(mockDao);
        userService = new UserService(mockDaoHelperFactory);

        mockUser = Mockito.mock(User.class);

    }


    @Test
    public void testGetAll() throws DaoException, ServiceException {
        //given
        when(mockDao.getAll())
                .thenReturn(new ArrayList<>());
        //when
        List<User> userList = userService.getAllUsers();
        //then
        Assert.assertNotNull(userList);
    }

}


