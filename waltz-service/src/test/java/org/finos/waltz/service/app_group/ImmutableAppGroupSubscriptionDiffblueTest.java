package org.finos.waltz.service.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.finos.waltz.service.app_group.ImmutableAppGroupSubscription.Builder;
import org.finos.waltz.service.app_group.ImmutableAppGroupSubscription.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupSubscriptionDiffblueTest {
  /**
   * Test Builder {@link Builder#appGroup(AppGroup)}.
   * <p>
   * Method under test: {@link Builder#appGroup(AppGroup)}
   */
  @Test
  @DisplayName("Test Builder appGroup(AppGroup)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appGroup(AppGroup)"})
  void testBuilderAppGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appGroup(mock(AppGroup.class)));
  }

  /**
   * Test Builder {@link Builder#from(AppGroupSubscription)}.
   * <ul>
   *   <li>Given {@code VIEWER}.</li>
   *   <li>Then builder build role is {@code VIEWER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupSubscription)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupSubscription); given 'VIEWER'; then builder build role is 'VIEWER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupSubscription)"})
  void testBuilderFrom_givenViewer_thenBuilderBuildRoleIsViewer() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    AppGroupSubscription instance = mock(AppGroupSubscription.class);
    when(instance.role()).thenReturn(AppGroupMemberRole.VIEWER);
    when(instance.appGroup()).thenReturn(mock(AppGroup.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).role();
    assertEquals(AppGroupMemberRole.VIEWER, builderResult.build().role());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroupSubscription)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupSubscription)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupSubscription); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupSubscription)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();
    AppGroupSubscription instance = mock(AppGroupSubscription.class);
    when(instance.role()).thenThrow(new IllegalStateException("instance"));
    when(instance.appGroup()).thenReturn(mock(AppGroup.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appGroup();
    verify(instance).role();
  }

  /**
   * Test Builder {@link Builder#role(AppGroupMemberRole)}.
   * <p>
   * Method under test: {@link Builder#role(AppGroupMemberRole)}
   */
  @Test
  @DisplayName("Test Builder role(AppGroupMemberRole)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.role(AppGroupMemberRole)"})
  void testBuilderRole() {
    // Arrange
    Builder builderResult = ImmutableAppGroupSubscription.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.role(AppGroupMemberRole.VIEWER));
  }

  /**
   * Test Json {@link Json#appGroup()}.
   * <p>
   * Method under test: {@link Json#appGroup()}
   */
  @Test
  @DisplayName("Test Json appGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AppGroup Json.appGroup()"})
  void testJsonAppGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appGroup());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAppGroup(AppGroup)}
   *   <li>{@link Json#setRole(AppGroupMemberRole)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAppGroup(AppGroup)", "void Json.setRole(AppGroupMemberRole)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAppGroup(mock(AppGroup.class));
    actualJson.setRole(AppGroupMemberRole.VIEWER);

    // Assert
    assertEquals(AppGroupMemberRole.VIEWER, actualJson.role);
  }

  /**
   * Test Json {@link Json#role()}.
   * <p>
   * Method under test: {@link Json#role()}
   */
  @Test
  @DisplayName("Test Json role()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AppGroupMemberRole Json.role()"})
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).role());
  }
}
