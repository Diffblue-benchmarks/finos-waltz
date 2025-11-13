package org.finos.waltz.service.user_agent_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.user_agent_info.UserAgentInfoDao;
import org.finos.waltz.model.user_agent_info.ImmutableUserAgentInfo;
import org.finos.waltz.model.user_agent_info.UserAgentInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserAgentInfoServiceDiffblueTest {
  /**
   * Test {@link UserAgentInfoService#save(UserAgentInfo)}.
   *
   * <ul>
   *   <li>Given {@link UserAgentInfoDao} {@link UserAgentInfoDao#save(UserAgentInfo)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UserAgentInfoService#save(UserAgentInfo)}
   */
  @Test
  @DisplayName(
      "Test save(UserAgentInfo); given UserAgentInfoDao save(UserAgentInfo) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserAgentInfoService.save(UserAgentInfo)"})
  void testSave_givenUserAgentInfoDaoSaveReturnOne_thenReturnOne() {
    // Arrange
    UserAgentInfoDao userAgentInfoDao = mock(UserAgentInfoDao.class);
    when(userAgentInfoDao.save(Mockito.<UserAgentInfo>any())).thenReturn(1);
    UserAgentInfoService userAgentInfoService = new UserAgentInfoService(userAgentInfoDao);

    // Act
    int actualSaveResult =
        userAgentInfoService.save(
            ImmutableUserAgentInfo.builder()
                .ipAddress("42 Main St")
                .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
                .operatingSystem("Operating System")
                .resolution("Resolution")
                .userAgent("User Agent")
                .userName("janedoe")
                .build());

    // Assert
    verify(userAgentInfoDao).save(isA(UserAgentInfo.class));
    assertEquals(1, actualSaveResult);
  }

  /**
   * Test {@link UserAgentInfoService#findLoginsForUser(String, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserAgentInfoService#findLoginsForUser(String, int)}
   */
  @Test
  @DisplayName("Test findLoginsForUser(String, int); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserAgentInfoService.findLoginsForUser(String, int)"})
  void testFindLoginsForUser_thenReturnEmpty() {
    // Arrange
    UserAgentInfoDao userAgentInfoDao = mock(UserAgentInfoDao.class);
    when(userAgentInfoDao.findLoginsForUser(Mockito.<String>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<UserAgentInfo> actualFindLoginsForUserResult =
        new UserAgentInfoService(userAgentInfoDao).findLoginsForUser("janedoe", 1);

    // Assert
    verify(userAgentInfoDao).findLoginsForUser("janedoe", 1);
    assertTrue(actualFindLoginsForUserResult.isEmpty());
  }
}
