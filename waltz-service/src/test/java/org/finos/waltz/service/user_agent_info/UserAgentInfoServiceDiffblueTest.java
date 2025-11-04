package org.finos.waltz.service.user_agent_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.user_agent_info.UserAgentInfoDao;
import org.finos.waltz.model.user_agent_info.UserAgentInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserAgentInfoServiceDiffblueTest {
  /**
   * Method under test: {@link UserAgentInfoService#save(UserAgentInfo)}
   */
  @Test
  void testSave() {
    // Arrange
    UserAgentInfoDao userAgentInfoDao = mock(UserAgentInfoDao.class);
    when(userAgentInfoDao.save(Mockito.<UserAgentInfo>any())).thenReturn(1);

    // Act
    int actualSaveResult = (new UserAgentInfoService(userAgentInfoDao)).save(mock(UserAgentInfo.class));

    // Assert
    verify(userAgentInfoDao).save(isA(UserAgentInfo.class));
    assertEquals(1, actualSaveResult);
  }

  /**
   * Method under test:
   * {@link UserAgentInfoService#findLoginsForUser(String, int)}
   */
  @Test
  void testFindLoginsForUser() {
    // Arrange
    UserAgentInfoDao userAgentInfoDao = mock(UserAgentInfoDao.class);
    ArrayList<UserAgentInfo> userAgentInfoList = new ArrayList<>();
    when(userAgentInfoDao.findLoginsForUser(Mockito.<String>any(), anyInt())).thenReturn(userAgentInfoList);

    // Act
    List<UserAgentInfo> actualFindLoginsForUserResult = (new UserAgentInfoService(userAgentInfoDao))
        .findLoginsForUser("janedoe", 1);

    // Assert
    verify(userAgentInfoDao).findLoginsForUser(eq("janedoe"), eq(1));
    assertTrue(actualFindLoginsForUserResult.isEmpty());
    assertSame(userAgentInfoList, actualFindLoginsForUserResult);
  }
}
