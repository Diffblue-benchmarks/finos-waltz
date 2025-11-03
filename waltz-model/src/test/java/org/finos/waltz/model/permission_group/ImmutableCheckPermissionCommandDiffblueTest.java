package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.permission_group.ImmutableCheckPermissionCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCheckPermissionCommandDiffblueTest {
  /**
   * Test {@link ImmutableCheckPermissionCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCheckPermissionCommand#builder()}
   *   <li>{@link ImmutableCheckPermissionCommand#qualifierId(Long)}
   *   <li>{@link ImmutableCheckPermissionCommand#qualifierKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCheckPermissionCommand Builder.build()", "Builder Builder.qualifierId(Long)",
      "Builder Builder.qualifierKind(EntityKind)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualQualifierIdResult = ImmutableCheckPermissionCommand.builder().qualifierId(1L);

    // Assert
    assertSame(actualQualifierIdResult, actualQualifierIdResult.qualifierKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#from(CheckPermissionCommand)}.
   * <p>
   * Method under test: {@link Builder#from(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CheckPermissionCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CheckPermissionCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.parentEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.user()).thenReturn("User");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentEntityRef();
    verify(instance).user();
  }

  /**
   * Test Builder {@link Builder#from(CheckPermissionCommand)}.
   * <p>
   * Method under test: {@link Builder#from(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CheckPermissionCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CheckPermissionCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();
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
   * Test Builder {@link Builder#from(CheckPermissionCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return build qualifierId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CheckPermissionCommand); given one; then return build qualifierId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CheckPermissionCommand)"})
  void testBuilderFrom_givenOne_thenReturnBuildQualifierIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.qualifierId()).thenReturn(1L);
    when(instance.qualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.parentEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.user()).thenReturn("User");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentEntityRef();
    verify(instance).qualifierId();
    verify(instance).qualifierKind();
    verify(instance).subjectKind();
    verify(instance).user();
    ImmutableCheckPermissionCommand buildResult = actualFromResult.build();
    assertEquals(1L, buildResult.qualifierId().longValue());
    ImmutableCheckPermissionCommand buildResult2 = builderResult.build();
    assertEquals(1L, buildResult2.qualifierId().longValue());
    assertEquals(EntityKind.ALL, buildResult.qualifierKind());
    assertEquals(EntityKind.ALL, buildResult2.qualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(CheckPermissionCommand)}.
   * <ul>
   *   <li>Then return build qualifierId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CheckPermissionCommand); then return build qualifierId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CheckPermissionCommand)"})
  void testBuilderFrom_thenReturnBuildQualifierIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.qualifierId()).thenReturn(null);
    when(instance.qualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.parentEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.user()).thenReturn("User");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentEntityRef();
    verify(instance).qualifierId();
    verify(instance).qualifierKind();
    verify(instance).subjectKind();
    verify(instance).user();
    ImmutableCheckPermissionCommand buildResult = actualFromResult.build();
    assertNull(buildResult.qualifierId());
    ImmutableCheckPermissionCommand buildResult2 = builderResult.build();
    assertNull(buildResult2.qualifierId());
    assertEquals(EntityKind.ALL, buildResult.qualifierKind());
    assertEquals(EntityKind.ALL, buildResult2.qualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(CheckPermissionCommand)}.
   * <ul>
   *   <li>Then return build qualifierKind is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CheckPermissionCommand); then return build qualifierKind is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CheckPermissionCommand)"})
  void testBuilderFrom_thenReturnBuildQualifierKindIsNull() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();
    CheckPermissionCommand instance = mock(CheckPermissionCommand.class);
    when(instance.qualifierId()).thenReturn(1L);
    when(instance.qualifierKind()).thenReturn(null);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.parentEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.user()).thenReturn("User");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentEntityRef();
    verify(instance).qualifierId();
    verify(instance).qualifierKind();
    verify(instance).subjectKind();
    verify(instance).user();
    ImmutableCheckPermissionCommand buildResult = actualFromResult.build();
    assertNull(buildResult.qualifierKind());
    ImmutableCheckPermissionCommand buildResult2 = builderResult.build();
    assertNull(buildResult2.qualifierKind());
    assertEquals(1L, buildResult.qualifierId().longValue());
    assertEquals(1L, buildResult2.qualifierId().longValue());
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   * <p>
   * Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Test Builder {@link Builder#parentEntityRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentEntityRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentEntityRef(EntityReference)"})
  void testBuilderParentEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntityRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#subjectKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#subjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder subjectKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.subjectKind(EntityKind)"})
  void testBuilderSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#user(String)}.
   * <p>
   * Method under test: {@link Builder#user(String)}
   */
  @Test
  @DisplayName("Test Builder user(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.user(String)"})
  void testBuilderUser() {
    // Arrange
    Builder builderResult = ImmutableCheckPermissionCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.user("User"));
  }
}
