package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.junit.jupiter.api.Test;

class ImmutablePermissionDiffblueTest {
  /**
   * Method under test: {@link ImmutablePermission.Builder#from(Permission)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();
    Permission instance = mock(Permission.class);
    when(instance.qualifierReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).subjectKind();
  }

  /**
   * Method under test: {@link ImmutablePermission.Builder#from(Permission)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();
    Permission instance = mock(Permission.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult);
    ImmutableRequiredInvolvementsResult.Json json = new ImmutableRequiredInvolvementsResult.Json();
    when(instance.requiredInvolvementsResult()).thenReturn(json);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutablePermission.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).requiredInvolvementsResult();
    verify(instance).subjectKind();
    ImmutablePermission buildResult = builderResult.build();
    assertEquals(EntityKind.ALL, buildResult.parentKind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(json, buildResult.requiredInvolvementsResult());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePermission.Builder#from(Permission)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();
    Permission instance = mock(Permission.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.qualifierReference()).thenReturn(emptyResult);
    ImmutableRequiredInvolvementsResult.Json json = new ImmutableRequiredInvolvementsResult.Json();
    when(instance.requiredInvolvementsResult()).thenReturn(json);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutablePermission.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).requiredInvolvementsResult();
    verify(instance).subjectKind();
    ImmutablePermission buildResult = builderResult.build();
    assertEquals(EntityKind.ALL, buildResult.parentKind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(json, buildResult.requiredInvolvementsResult());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePermission.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test: {@link ImmutablePermission.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation2() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test: {@link ImmutablePermission.Builder#parentKind(EntityKind)}
   */
  @Test
  void testBuilderParentKind() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutablePermission.Builder#parentKind(EntityKind)}
   */
  @Test
  void testBuilderParentKind2() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.parentKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutablePermission.Builder#requiredInvolvementsResult(RequiredInvolvementsResult)}
   */
  @Test
  void testBuilderRequiredInvolvementsResult() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.requiredInvolvementsResult(new ImmutableRequiredInvolvementsResult.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePermission.Builder#requiredInvolvementsResult(RequiredInvolvementsResult)}
   */
  @Test
  void testBuilderRequiredInvolvementsResult2() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.requiredInvolvementsResult(new ImmutableRequiredInvolvementsResult.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePermission.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutablePermission.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind2() {
    // Arrange
    ImmutablePermission.Builder builderResult = ImmutablePermission.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutablePermission#copyOf(Permission)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Permission instance = mock(Permission.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult);
    ImmutableRequiredInvolvementsResult.Json json = new ImmutableRequiredInvolvementsResult.Json();
    when(instance.requiredInvolvementsResult()).thenReturn(json);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutablePermission actualCopyOfResult = ImmutablePermission.copyOf(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).requiredInvolvementsResult();
    verify(instance).subjectKind();
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertSame(json, actualCopyOfResult.requiredInvolvementsResult());
  }

  /**
   * Method under test: {@link ImmutablePermission#copyOf(Permission)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Permission instance = mock(Permission.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.qualifierReference()).thenReturn(emptyResult);
    ImmutableRequiredInvolvementsResult.Json json = new ImmutableRequiredInvolvementsResult.Json();
    when(instance.requiredInvolvementsResult()).thenReturn(json);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    ImmutablePermission actualCopyOfResult = ImmutablePermission.copyOf(instance);

    // Assert
    verify(instance).operation();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).requiredInvolvementsResult();
    verify(instance).subjectKind();
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertSame(json, actualCopyOfResult.requiredInvolvementsResult());
  }

  /**
   * Method under test:
   * {@link ImmutablePermission#fromJson(ImmutablePermission.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePermission.Json json = new ImmutablePermission.Json();
    json.setOperation(Operation.ADD);
    json.setParentKind(EntityKind.ALL);
    json.setSubjectKind(EntityKind.ALL);
    json.setQualifierReference(null);
    ImmutableRequiredInvolvementsResult.Json requiredInvolvementsResult = new ImmutableRequiredInvolvementsResult.Json();
    json.setRequiredInvolvementsResult(requiredInvolvementsResult);

    // Act
    ImmutablePermission actualFromJsonResult = ImmutablePermission.fromJson(json);

    // Assert
    assertEquals(EntityKind.ALL, actualFromJsonResult.parentKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(Operation.ADD, actualFromJsonResult.operation());
    assertSame(requiredInvolvementsResult, actualFromJsonResult.requiredInvolvementsResult());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePermission.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePermission.Json actualJson = new ImmutablePermission.Json();

    // Assert
    assertNull(actualJson.parentKind);
    assertNull(actualJson.subjectKind);
    assertNull(actualJson.operation);
    assertNull(actualJson.requiredInvolvementsResult);
    assertFalse(actualJson.qualifierReference.isPresent());
  }

  /**
   * Method under test: {@link ImmutablePermission.Json#operation()}
   */
  @Test
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermission.Json()).operation());
  }

  /**
   * Method under test: {@link ImmutablePermission.Json#parentKind()}
   */
  @Test
  void testJsonParentKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermission.Json()).parentKind());
  }

  /**
   * Method under test: {@link ImmutablePermission.Json#qualifierReference()}
   */
  @Test
  void testJsonQualifierReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermission.Json()).qualifierReference());
  }

  /**
   * Method under test:
   * {@link ImmutablePermission.Json#requiredInvolvementsResult()}
   */
  @Test
  void testJsonRequiredInvolvementsResult() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePermission.Json()).requiredInvolvementsResult());
  }

  /**
   * Method under test: {@link ImmutablePermission.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePermission.Json()).subjectKind());
  }
}
