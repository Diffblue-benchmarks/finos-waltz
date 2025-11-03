package org.finos.waltz.model.permission;

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
import org.finos.waltz.model.permission.ImmutablePermissionViewItem.Builder;
import org.finos.waltz.model.permission.ImmutablePermissionViewItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePermissionViewItemDiffblueTest {
  /**
   * Test {@link ImmutablePermissionViewItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePermissionViewItem#builder()}
   *   <li>{@link ImmutablePermissionViewItem#qualifier(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePermissionViewItem Builder.build()", "Builder Builder.qualifier(EntityReference)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutablePermissionViewItem.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.qualifier(null));
  }

  /**
   * Test Builder {@link Builder#from(PermissionViewItem)}.
   * <p>
   * Method under test: {@link Builder#from(PermissionViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PermissionViewItem)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PermissionViewItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();
    PermissionViewItem instance = mock(PermissionViewItem.class);
    when(instance.permissionGroup()).thenThrow(new IllegalStateException("instance"));
    when(instance.involvementGroup()).thenReturn(mock(EntityReference.class));
    when(instance.qualifier()).thenReturn(null);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvementGroup();
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).permissionGroup();
    verify(instance).qualifier();
    verify(instance).subjectKind();
  }

  /**
   * Test Builder {@link Builder#from(PermissionViewItem)}.
   * <p>
   * Method under test: {@link Builder#from(PermissionViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PermissionViewItem)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PermissionViewItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();
    PermissionViewItem instance = mock(PermissionViewItem.class);
    when(instance.involvementKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.permissionGroup()).thenReturn(mock(EntityReference.class));
    when(instance.involvementGroup()).thenReturn(mock(EntityReference.class));
    when(instance.qualifier()).thenReturn(null);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvementGroup();
    verify(instance).involvementKind();
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).permissionGroup();
    verify(instance).qualifier();
    verify(instance).subjectKind();
  }

  /**
   * Test Builder {@link Builder#from(PermissionViewItem)}.
   * <ul>
   *   <li>Then builder build qualifier is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PermissionViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PermissionViewItem); then builder build qualifier is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PermissionViewItem)"})
  void testBuilderFrom_thenBuilderBuildQualifierIsNull() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();
    PermissionViewItem instance = mock(PermissionViewItem.class);
    when(instance.involvementKind()).thenReturn(mock(EntityReference.class));
    when(instance.permissionGroup()).thenReturn(mock(EntityReference.class));
    when(instance.involvementGroup()).thenReturn(mock(EntityReference.class));
    when(instance.qualifier()).thenReturn(null);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKind();
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).permissionGroup();
    verify(instance).qualifier();
    verify(instance).subjectKind();
    ImmutablePermissionViewItem buildResult = builderResult.build();
    assertNull(buildResult.qualifier());
    assertEquals(EntityKind.ALL, buildResult.parentKind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PermissionViewItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PermissionViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PermissionViewItem); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PermissionViewItem)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();
    PermissionViewItem instance = mock(PermissionViewItem.class);
    when(instance.involvementGroup()).thenThrow(new IllegalStateException("instance"));
    when(instance.qualifier()).thenReturn(null);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvementGroup();
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).qualifier();
    verify(instance).subjectKind();
  }

  /**
   * Test Builder {@link Builder#from(PermissionViewItem)}.
   * <ul>
   *   <li>When {@link PermissionViewItem} {@link PermissionViewItem#qualifier()} return {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PermissionViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PermissionViewItem); when PermissionViewItem qualifier() return EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PermissionViewItem)"})
  void testBuilderFrom_whenPermissionViewItemQualifierReturnEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();
    PermissionViewItem instance = mock(PermissionViewItem.class);
    when(instance.involvementGroup()).thenThrow(new IllegalStateException("instance"));
    when(instance.qualifier()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).involvementGroup();
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).qualifier();
    verify(instance).subjectKind();
  }

  /**
   * Test Builder {@link Builder#involvementGroup(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvementGroup(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder involvementGroup(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementGroup(EntityReference)"})
  void testBuilderInvolvementGroup_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementGroup(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#involvementKind(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#involvementKind(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder involvementKind(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.involvementKind(EntityReference)"})
  void testBuilderInvolvementKind_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKind(mock(EntityReference.class)));
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
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Test Builder {@link Builder#parentKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#parentKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder parentKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentKind(EntityKind)"})
  void testBuilderParentKind() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#permissionGroup(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#permissionGroup(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder permissionGroup(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.permissionGroup(EntityReference)"})
  void testBuilderPermissionGroup_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.permissionGroup(mock(EntityReference.class)));
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
    Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setInvolvementGroup(EntityReference)}
   *   <li>{@link Json#setInvolvementKind(EntityReference)}
   *   <li>{@link Json#setOperation(Operation)}
   *   <li>{@link Json#setParentKind(EntityKind)}
   *   <li>{@link Json#setPermissionGroup(EntityReference)}
   *   <li>{@link Json#setQualifier(EntityReference)}
   *   <li>{@link Json#setSubjectKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setInvolvementGroup(EntityReference)",
      "void Json.setInvolvementKind(EntityReference)", "void Json.setOperation(Operation)",
      "void Json.setParentKind(EntityKind)", "void Json.setPermissionGroup(EntityReference)",
      "void Json.setQualifier(EntityReference)", "void Json.setSubjectKind(EntityKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setInvolvementGroup(null);
    actualJson.setInvolvementKind(null);
    actualJson.setOperation(Operation.ADD);
    actualJson.setParentKind(EntityKind.ALL);
    actualJson.setPermissionGroup(null);
    actualJson.setQualifier(null);
    actualJson.setSubjectKind(EntityKind.ALL);

    // Assert
    assertNull(actualJson.involvementGroup);
    assertNull(actualJson.involvementKind);
    assertNull(actualJson.permissionGroup);
    assertNull(actualJson.qualifier);
    assertEquals(EntityKind.ALL, actualJson.parentKind);
    assertEquals(EntityKind.ALL, actualJson.subjectKind);
    assertEquals(Operation.ADD, actualJson.operation);
  }

  /**
   * Test Json {@link Json#involvementGroup()}.
   * <p>
   * Method under test: {@link Json#involvementGroup()}
   */
  @Test
  @DisplayName("Test Json involvementGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.involvementGroup()"})
  void testJsonInvolvementGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).involvementGroup());
  }

  /**
   * Test Json {@link Json#involvementKind()}.
   * <p>
   * Method under test: {@link Json#involvementKind()}
   */
  @Test
  @DisplayName("Test Json involvementKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.involvementKind()"})
  void testJsonInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).involvementKind());
  }

  /**
   * Test Json {@link Json#operation()}.
   * <p>
   * Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operation());
  }

  /**
   * Test Json {@link Json#parentKind()}.
   * <p>
   * Method under test: {@link Json#parentKind()}
   */
  @Test
  @DisplayName("Test Json parentKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.parentKind()"})
  void testJsonParentKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentKind());
  }

  /**
   * Test Json {@link Json#permissionGroup()}.
   * <p>
   * Method under test: {@link Json#permissionGroup()}
   */
  @Test
  @DisplayName("Test Json permissionGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.permissionGroup()"})
  void testJsonPermissionGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).permissionGroup());
  }

  /**
   * Test Json {@link Json#qualifier()}.
   * <p>
   * Method under test: {@link Json#qualifier()}
   */
  @Test
  @DisplayName("Test Json qualifier()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.qualifier()"})
  void testJsonQualifier() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).qualifier());
  }

  /**
   * Test Json {@link Json#subjectKind()}.
   * <p>
   * Method under test: {@link Json#subjectKind()}
   */
  @Test
  @DisplayName("Test Json subjectKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.subjectKind()"})
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).subjectKind());
  }
}
