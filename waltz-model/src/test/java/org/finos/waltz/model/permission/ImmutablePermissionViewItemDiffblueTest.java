package org.finos.waltz.model.permission;

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

class ImmutablePermissionViewItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePermissionViewItem#builder()}
   *   <li>{@link ImmutablePermissionViewItem#qualifier(EntityReference)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePermissionViewItem.Builder actualBuilderResult = ImmutablePermissionViewItem.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.qualifier(null));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#from(PermissionViewItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();
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
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#from(PermissionViewItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();
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
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#from(PermissionViewItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();
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
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#from(PermissionViewItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();
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
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#from(PermissionViewItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();
    PermissionViewItem instance = mock(PermissionViewItem.class);
    when(instance.involvementKind()).thenReturn(mock(EntityReference.class));
    when(instance.permissionGroup()).thenReturn(mock(EntityReference.class));
    when(instance.involvementGroup()).thenReturn(mock(EntityReference.class));
    when(instance.qualifier()).thenReturn(null);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePermissionViewItem.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#involvementGroup(EntityReference)}
   */
  @Test
  void testBuilderInvolvementGroup() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementGroup(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#involvementKind(EntityReference)}
   */
  @Test
  void testBuilderInvolvementKind() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKind(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation2() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();
    builderResult.qualifier(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#parentKind(EntityKind)}
   */
  @Test
  void testBuilderParentKind() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#parentKind(EntityKind)}
   */
  @Test
  void testBuilderParentKind2() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();
    builderResult.qualifier(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.parentKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#permissionGroup(EntityReference)}
   */
  @Test
  void testBuilderPermissionGroup() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.permissionGroup(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind2() {
    // Arrange
    ImmutablePermissionViewItem.Builder builderResult = ImmutablePermissionViewItem.builder();
    builderResult.qualifier(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem#copyOf(PermissionViewItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PermissionViewItem instance = mock(PermissionViewItem.class);
    when(instance.involvementKind()).thenReturn(mock(EntityReference.class));
    when(instance.permissionGroup()).thenReturn(mock(EntityReference.class));
    when(instance.involvementGroup()).thenReturn(mock(EntityReference.class));
    when(instance.qualifier()).thenReturn(null);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePermissionViewItem actualCopyOfResult = ImmutablePermissionViewItem.copyOf(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKind();
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).permissionGroup();
    verify(instance).qualifier();
    verify(instance).subjectKind();
    assertNull(actualCopyOfResult.qualifier());
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
  }

  /**
   * Method under test:
   * {@link ImmutablePermissionViewItem#copyOf(PermissionViewItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PermissionViewItem instance = mock(PermissionViewItem.class);
    when(instance.involvementKind()).thenReturn(mock(EntityReference.class));
    when(instance.permissionGroup()).thenReturn(mock(EntityReference.class));
    when(instance.involvementGroup()).thenReturn(mock(EntityReference.class));
    when(instance.qualifier()).thenReturn(mock(EntityReference.class));
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePermissionViewItem actualCopyOfResult = ImmutablePermissionViewItem.copyOf(instance);

    // Assert
    verify(instance).involvementGroup();
    verify(instance).involvementKind();
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).permissionGroup();
    verify(instance).qualifier();
    verify(instance).subjectKind();
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutablePermissionViewItem.Json}
   *   <li>
   * {@link ImmutablePermissionViewItem.Json#setInvolvementGroup(EntityReference)}
   *   <li>
   * {@link ImmutablePermissionViewItem.Json#setInvolvementKind(EntityReference)}
   *   <li>{@link ImmutablePermissionViewItem.Json#setOperation(Operation)}
   *   <li>{@link ImmutablePermissionViewItem.Json#setParentKind(EntityKind)}
   *   <li>
   * {@link ImmutablePermissionViewItem.Json#setPermissionGroup(EntityReference)}
   *   <li>{@link ImmutablePermissionViewItem.Json#setQualifier(EntityReference)}
   *   <li>{@link ImmutablePermissionViewItem.Json#setSubjectKind(EntityKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutablePermissionViewItem.Json actualJson = new ImmutablePermissionViewItem.Json();
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
   * Method under test:
   * {@link ImmutablePermissionViewItem.Json#involvementGroup()}
   */
  @Test
  void testJsonInvolvementGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePermissionViewItem.Json()).involvementGroup());
  }

  /**
   * Method under test: {@link ImmutablePermissionViewItem.Json#involvementKind()}
   */
  @Test
  void testJsonInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermissionViewItem.Json()).involvementKind());
  }

  /**
   * Method under test: {@link ImmutablePermissionViewItem.Json#operation()}
   */
  @Test
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermissionViewItem.Json()).operation());
  }

  /**
   * Method under test: {@link ImmutablePermissionViewItem.Json#parentKind()}
   */
  @Test
  void testJsonParentKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermissionViewItem.Json()).parentKind());
  }

  /**
   * Method under test: {@link ImmutablePermissionViewItem.Json#permissionGroup()}
   */
  @Test
  void testJsonPermissionGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermissionViewItem.Json()).permissionGroup());
  }

  /**
   * Method under test: {@link ImmutablePermissionViewItem.Json#qualifier()}
   */
  @Test
  void testJsonQualifier() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermissionViewItem.Json()).qualifier());
  }

  /**
   * Method under test: {@link ImmutablePermissionViewItem.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermissionViewItem.Json()).subjectKind());
  }
}
