package org.finos.waltz.model.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.app_group.ImmutableAppGroupMember.Builder;
import org.finos.waltz.model.app_group.ImmutableAppGroupMember.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupMemberDiffblueTest {
  /**
   * Test Builder {@link Builder#from(AppGroupMember)}.
   * <ul>
   *   <li>Given {@code VIEWER}.</li>
   *   <li>Then builder build userId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupMember)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupMember); given 'VIEWER'; then builder build userId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupMember)"})
  void testBuilderFrom_givenViewer_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAppGroupMember.builder();
    AppGroupMember instance = mock(AppGroupMember.class);
    when(instance.role()).thenReturn(AppGroupMemberRole.VIEWER);
    when(instance.userId()).thenReturn("42");
    when(instance.groupId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(AppGroupMember)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupMember)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupMember); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupMember)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAppGroupMember.builder();
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
   * Test Builder {@link Builder#groupId(long)}.
   * <p>
   * Method under test: {@link Builder#groupId(long)}
   */
  @Test
  @DisplayName("Test Builder groupId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.groupId(long)"})
  void testBuilderGroupId() {
    // Arrange
    Builder builderResult = ImmutableAppGroupMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.groupId(1L));
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
    Builder builderResult = ImmutableAppGroupMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.role(AppGroupMemberRole.VIEWER));
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   * <p>
   * Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId() {
    // Arrange
    Builder builderResult = ImmutableAppGroupMember.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRole(AppGroupMemberRole)}
   *   <li>{@link Json#setUserId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRole(AppGroupMemberRole)", "void Json.setUserId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRole(AppGroupMemberRole.VIEWER);
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(0L, actualJson.groupId);
    assertEquals(AppGroupMemberRole.VIEWER, actualJson.role);
    assertFalse(actualJson.groupIdIsSet);
  }

  /**
   * Test Json {@link Json#groupId()}.
   * <p>
   * Method under test: {@link Json#groupId()}
   */
  @Test
  @DisplayName("Test Json groupId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.groupId()"})
  void testJsonGroupId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).groupId());
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

  /**
   * Test Json {@link Json#setGroupId(long)}.
   * <p>
   * Method under test: {@link Json#setGroupId(long)}
   */
  @Test
  @DisplayName("Test Json setGroupId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setGroupId(long)"})
  void testJsonSetGroupId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setGroupId(1L);

    // Assert
    assertEquals(1L, json.groupId);
    assertTrue(json.groupIdIsSet);
  }

  /**
   * Test Json {@link Json#userId()}.
   * <p>
   * Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userId());
  }
}
