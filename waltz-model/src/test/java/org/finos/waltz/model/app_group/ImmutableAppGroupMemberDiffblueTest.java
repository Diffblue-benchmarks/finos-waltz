package org.finos.waltz.model.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupMemberDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppGroupMember.Builder#from(AppGroupMember)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppGroupMember.Builder builderResult = ImmutableAppGroupMember.builder();
    AppGroupMember instance = mock(AppGroupMember.class);
    when(instance.role()).thenReturn(AppGroupMemberRole.VIEWER);
    when(instance.userId()).thenReturn("42");
    when(instance.groupId()).thenReturn(1L);

    // Act
    ImmutableAppGroupMember.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).groupId();
    verify(instance).role();
    verify(instance).userId();
    ImmutableAppGroupMember buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals(1L, buildResult.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, buildResult.role());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupMember.Builder#from(AppGroupMember)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppGroupMember.Builder builderResult = ImmutableAppGroupMember.builder();
    AppGroupMember instance = mock(AppGroupMember.class);
    when(instance.role()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");
    when(instance.groupId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).groupId();
    verify(instance).role();
    verify(instance).userId();
  }

  /**
   * Method under test: {@link ImmutableAppGroupMember.Builder#groupId(long)}
   */
  @Test
  void testBuilderGroupId() {
    // Arrange
    ImmutableAppGroupMember.Builder builderResult = ImmutableAppGroupMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.groupId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupMember.Builder#role(AppGroupMemberRole)}
   */
  @Test
  void testBuilderRole() {
    // Arrange
    ImmutableAppGroupMember.Builder builderResult = ImmutableAppGroupMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.role(AppGroupMemberRole.VIEWER));
  }

  /**
   * Method under test: {@link ImmutableAppGroupMember.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableAppGroupMember.Builder builderResult = ImmutableAppGroupMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Method under test: {@link ImmutableAppGroupMember#copyOf(AppGroupMember)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppGroupMember instance = mock(AppGroupMember.class);
    when(instance.role()).thenReturn(AppGroupMemberRole.VIEWER);
    when(instance.userId()).thenReturn("42");
    when(instance.groupId()).thenReturn(1L);

    // Act
    ImmutableAppGroupMember actualCopyOfResult = ImmutableAppGroupMember.copyOf(instance);

    // Assert
    verify(instance).groupId();
    verify(instance).role();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(1L, actualCopyOfResult.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, actualCopyOfResult.role());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAppGroupMember.Json}
   *   <li>{@link ImmutableAppGroupMember.Json#setRole(AppGroupMemberRole)}
   *   <li>{@link ImmutableAppGroupMember.Json#setUserId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAppGroupMember.Json actualJson = new ImmutableAppGroupMember.Json();
    actualJson.setRole(AppGroupMemberRole.VIEWER);
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(0L, actualJson.groupId);
    assertEquals(AppGroupMemberRole.VIEWER, actualJson.role);
    assertFalse(actualJson.groupIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAppGroupMember.Json#groupId()}
   */
  @Test
  void testJsonGroupId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupMember.Json()).groupId());
  }

  /**
   * Method under test: {@link ImmutableAppGroupMember.Json#role()}
   */
  @Test
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupMember.Json()).role());
  }

  /**
   * Method under test: {@link ImmutableAppGroupMember.Json#setGroupId(long)}
   */
  @Test
  void testJsonSetGroupId() {
    // Arrange
    ImmutableAppGroupMember.Json json = new ImmutableAppGroupMember.Json();

    // Act
    json.setGroupId(1L);

    // Assert
    assertEquals(1L, json.groupId);
    assertTrue(json.groupIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAppGroupMember.Json#userId()}
   */
  @Test
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppGroupMember.Json()).userId());
  }
}
