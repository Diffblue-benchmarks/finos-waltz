package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.junit.jupiter.api.Test;

class ImmutableCheckPermissionCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCheckPermissionCommand#builder()}
   *   <li>{@link ImmutableCheckPermissionCommand#qualifierId(Long)}
   *   <li>{@link ImmutableCheckPermissionCommand#qualifierKind(EntityKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableCheckPermissionCommand.Builder actualQualifierIdResult = ImmutableCheckPermissionCommand.builder()
        .qualifierId(1L);

    // Assert
    assertSame(actualQualifierIdResult, actualQualifierIdResult.qualifierKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand.Builder#from(CheckPermissionCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCheckPermissionCommand.Builder builderResult = ImmutableCheckPermissionCommand.builder();
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.parentEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.user()).thenReturn("User");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentEntityRef();
    verify(instance).user();
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand.Builder#from(CheckPermissionCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCheckPermissionCommand.Builder builderResult = ImmutableCheckPermissionCommand.builder();
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.qualifierId()).thenReturn(1L);
    when(instance.qualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.parentEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.user()).thenReturn("User");

    // Act
    ImmutableCheckPermissionCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentEntityRef();
    verify(instance).qualifierId();
    verify(instance).qualifierKind();
    verify(instance).subjectKind();
    verify(instance).user();
    ImmutableCheckPermissionCommand buildResult = builderResult.build();
    assertEquals("User", buildResult.user());
    assertEquals(1L, buildResult.qualifierId().longValue());
    assertEquals(EntityKind.ALL, buildResult.qualifierKind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand.Builder#from(CheckPermissionCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCheckPermissionCommand.Builder builderResult = ImmutableCheckPermissionCommand.builder();
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.qualifierKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.parentEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.user()).thenReturn("User");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).operation();
    verify(instance).parentEntityRef();
    verify(instance).qualifierKind();
    verify(instance).subjectKind();
    verify(instance).user();
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand.Builder#from(CheckPermissionCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableCheckPermissionCommand.Builder builderResult = ImmutableCheckPermissionCommand.builder();
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.qualifierId()).thenReturn(null);
    when(instance.qualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.parentEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.user()).thenReturn("User");

    // Act
    ImmutableCheckPermissionCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentEntityRef();
    verify(instance).qualifierId();
    verify(instance).qualifierKind();
    verify(instance).subjectKind();
    verify(instance).user();
    ImmutableCheckPermissionCommand buildResult = builderResult.build();
    assertEquals("User", buildResult.user());
    assertNull(buildResult.qualifierId());
    assertEquals(EntityKind.ALL, buildResult.qualifierKind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand.Builder#from(CheckPermissionCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableCheckPermissionCommand.Builder builderResult = ImmutableCheckPermissionCommand.builder();
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.qualifierId()).thenReturn(1L);
    when(instance.qualifierKind()).thenReturn(null);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.parentEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.user()).thenReturn("User");

    // Act
    ImmutableCheckPermissionCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentEntityRef();
    verify(instance).qualifierId();
    verify(instance).qualifierKind();
    verify(instance).subjectKind();
    verify(instance).user();
    ImmutableCheckPermissionCommand buildResult = builderResult.build();
    assertEquals("User", buildResult.user());
    assertNull(buildResult.qualifierKind());
    assertEquals(1L, buildResult.qualifierId().longValue());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    ImmutableCheckPermissionCommand.Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand.Builder#parentEntityRef(EntityReference)}
   */
  @Test
  void testBuilderParentEntityRef() {
    // Arrange
    ImmutableCheckPermissionCommand.Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntityRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutableCheckPermissionCommand.Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand.Builder#user(String)}
   */
  @Test
  void testBuilderUser() {
    // Arrange
    ImmutableCheckPermissionCommand.Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.user("User"));
  }

  /**
   * Method under test:
   * {@link ImmutableCheckPermissionCommand#copyOf(CheckPermissionCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.qualifierId()).thenReturn(1L);
    when(instance.qualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.parentEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.user()).thenReturn("User");

    // Act
    ImmutableCheckPermissionCommand actualCopyOfResult = ImmutableCheckPermissionCommand.copyOf(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentEntityRef();
    verify(instance).qualifierId();
    verify(instance).qualifierKind();
    verify(instance).subjectKind();
    verify(instance).user();
    assertEquals("User", actualCopyOfResult.user());
    assertEquals(1L, actualCopyOfResult.qualifierId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.qualifierKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
  }
}
