package org.finos.waltz.service.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupSubscriptionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppGroupSubscription.Builder#appGroup(AppGroup)}
   */
  @Test
  void testBuilderAppGroup() {
    // Arrange
    ImmutableAppGroupSubscription.Builder builderResult = ImmutableAppGroupSubscription.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appGroup(mock(AppGroup.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupSubscription.Builder#from(AppGroupSubscription)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppGroupSubscription.Builder builderResult = ImmutableAppGroupSubscription.builder();
    AppGroupSubscription instance = mock(AppGroupSubscription.class);
    when(instance.role()).thenReturn(AppGroupMemberRole.VIEWER);
    when(instance.appGroup()).thenReturn(mock(AppGroup.class));

    // Act
    ImmutableAppGroupSubscription.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).role();
    assertEquals(AppGroupMemberRole.VIEWER, actualFromResult.build().role());
    assertEquals(AppGroupMemberRole.VIEWER, builderResult.build().role());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupSubscription.Builder#from(AppGroupSubscription)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppGroupSubscription.Builder builderResult = ImmutableAppGroupSubscription.builder();
    AppGroupSubscription instance = mock(AppGroupSubscription.class);
    when(instance.role()).thenThrow(new IllegalStateException("instance"));
    when(instance.appGroup()).thenReturn(mock(AppGroup.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appGroup();
    verify(instance).role();
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupSubscription.Builder#role(AppGroupMemberRole)}
   */
  @Test
  void testBuilderRole() {
    // Arrange
    ImmutableAppGroupSubscription.Builder builderResult = ImmutableAppGroupSubscription.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.role(AppGroupMemberRole.VIEWER));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupSubscription#copyOf(AppGroupSubscription)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppGroupSubscription instance = mock(AppGroupSubscription.class);
    when(instance.role()).thenReturn(AppGroupMemberRole.VIEWER);
    when(instance.appGroup()).thenReturn(mock(AppGroup.class));

    // Act
    ImmutableAppGroupSubscription actualCopyOfResult = ImmutableAppGroupSubscription.copyOf(instance);

    // Assert
    verify(instance).appGroup();
    verify(instance).role();
    assertEquals(AppGroupMemberRole.VIEWER, actualCopyOfResult.role());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupSubscription#fromJson(ImmutableAppGroupSubscription.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppGroupSubscription.Json json = new ImmutableAppGroupSubscription.Json();
    json.setAppGroup(mock(AppGroup.class));
    json.setRole(AppGroupMemberRole.VIEWER);

    // Act
    ImmutableAppGroupSubscription actualFromJsonResult = ImmutableAppGroupSubscription.fromJson(json);

    // Assert
    assertEquals(AppGroupMemberRole.VIEWER, actualFromJsonResult.role());
    AppGroup expectedAppGroupResult = json.appGroup;
    assertSame(expectedAppGroupResult, actualFromJsonResult.appGroup());
  }

  /**
   * Method under test: {@link ImmutableAppGroupSubscription.Json#appGroup()}
   */
  @Test
  void testJsonAppGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupSubscription.Json()).appGroup());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAppGroupSubscription.Json}
   *   <li>{@link ImmutableAppGroupSubscription.Json#setAppGroup(AppGroup)}
   *   <li>{@link ImmutableAppGroupSubscription.Json#setRole(AppGroupMemberRole)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAppGroupSubscription.Json actualJson = new ImmutableAppGroupSubscription.Json();
    actualJson.setAppGroup(mock(AppGroup.class));
    actualJson.setRole(AppGroupMemberRole.VIEWER);

    // Assert
    assertEquals(AppGroupMemberRole.VIEWER, actualJson.role);
  }

  /**
   * Method under test: {@link ImmutableAppGroupSubscription.Json#role()}
   */
  @Test
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupSubscription.Json()).role());
  }
}
