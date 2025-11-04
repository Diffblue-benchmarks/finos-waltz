package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableUserAttestationPermissionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Builder#from(UserAttestationPermission)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUserAttestationPermission.Builder builderResult = ImmutableUserAttestationPermission.builder();
    UserAttestationPermission instance = mock(UserAttestationPermission.class);
    when(instance.qualifierReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).subjectKind();
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Builder#from(UserAttestationPermission)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUserAttestationPermission.Builder builderResult = ImmutableUserAttestationPermission.builder();
    UserAttestationPermission instance = mock(UserAttestationPermission.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult);
    when(instance.hasPermission()).thenReturn(true);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableUserAttestationPermission.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).hasPermission();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).subjectKind();
    ImmutableUserAttestationPermission buildResult = builderResult.build();
    assertEquals(EntityKind.ALL, buildResult.parentKind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.hasPermission());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Builder#from(UserAttestationPermission)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUserAttestationPermission.Builder builderResult = ImmutableUserAttestationPermission.builder();
    UserAttestationPermission instance = mock(UserAttestationPermission.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.qualifierReference()).thenReturn(emptyResult);
    when(instance.hasPermission()).thenReturn(true);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableUserAttestationPermission.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).hasPermission();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).subjectKind();
    ImmutableUserAttestationPermission buildResult = builderResult.build();
    assertEquals(EntityKind.ALL, buildResult.parentKind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.hasPermission());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Builder#hasPermission(boolean)}
   */
  @Test
  void testBuilderHasPermission() {
    // Arrange
    ImmutableUserAttestationPermission.Builder builderResult = ImmutableUserAttestationPermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.hasPermission(true));
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Builder#hasPermission(boolean)}
   */
  @Test
  void testBuilderHasPermission2() {
    // Arrange
    ImmutableUserAttestationPermission.Builder builderResult = ImmutableUserAttestationPermission.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.hasPermission(true));
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Builder#parentKind(EntityKind)}
   */
  @Test
  void testBuilderParentKind() {
    // Arrange
    ImmutableUserAttestationPermission.Builder builderResult = ImmutableUserAttestationPermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Builder#parentKind(EntityKind)}
   */
  @Test
  void testBuilderParentKind2() {
    // Arrange
    ImmutableUserAttestationPermission.Builder builderResult = ImmutableUserAttestationPermission.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.parentKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutableUserAttestationPermission.Builder builderResult = ImmutableUserAttestationPermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind2() {
    // Arrange
    ImmutableUserAttestationPermission.Builder builderResult = ImmutableUserAttestationPermission.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission#copyOf(UserAttestationPermission)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UserAttestationPermission instance = mock(UserAttestationPermission.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult);
    when(instance.hasPermission()).thenReturn(true);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableUserAttestationPermission actualCopyOfResult = ImmutableUserAttestationPermission.copyOf(instance);

    // Assert
    verify(instance).hasPermission();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).subjectKind();
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.hasPermission());
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission#copyOf(UserAttestationPermission)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    UserAttestationPermission instance = mock(UserAttestationPermission.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.qualifierReference()).thenReturn(emptyResult);
    when(instance.hasPermission()).thenReturn(true);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableUserAttestationPermission actualCopyOfResult = ImmutableUserAttestationPermission.copyOf(instance);

    // Assert
    verify(instance).hasPermission();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).subjectKind();
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.hasPermission());
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission#copyOf(UserAttestationPermission)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    UserAttestationPermission instance = mock(UserAttestationPermission.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult);
    when(instance.hasPermission()).thenReturn(false);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableUserAttestationPermission actualCopyOfResult = ImmutableUserAttestationPermission.copyOf(instance);

    // Assert
    verify(instance).hasPermission();
    verify(instance).parentKind();
    verify(instance).qualifierReference();
    verify(instance).subjectKind();
    assertEquals(EntityKind.ALL, actualCopyOfResult.parentKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertFalse(actualCopyOfResult.hasPermission());
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission#fromJson(ImmutableUserAttestationPermission.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUserAttestationPermission.Json json = new ImmutableUserAttestationPermission.Json();
    json.setParentKind(EntityKind.ALL);
    json.setSubjectKind(EntityKind.ALL);

    // Act
    ImmutableUserAttestationPermission actualFromJsonResult = ImmutableUserAttestationPermission.fromJson(json);

    // Assert
    assertEquals(EntityKind.ALL, actualFromJsonResult.parentKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertFalse(actualFromJsonResult.hasPermission());
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Json#hasPermission()}
   */
  @Test
  void testJsonHasPermission() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUserAttestationPermission.Json()).hasPermission());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableUserAttestationPermission.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableUserAttestationPermission.Json actualJson = new ImmutableUserAttestationPermission.Json();

    // Assert
    assertNull(actualJson.parentKind);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.qualifierReference.isPresent());
    assertFalse(actualJson.hasPermission);
    assertFalse(actualJson.hasPermissionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Json#parentKind()}
   */
  @Test
  void testJsonParentKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUserAttestationPermission.Json()).parentKind());
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Json#qualifierReference()}
   */
  @Test
  void testJsonQualifierReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUserAttestationPermission.Json()).qualifierReference());
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Json#setHasPermission(boolean)}
   */
  @Test
  void testJsonSetHasPermission() {
    // Arrange
    ImmutableUserAttestationPermission.Json json = new ImmutableUserAttestationPermission.Json();

    // Act
    json.setHasPermission(true);

    // Assert
    assertTrue(json.hasPermission);
    assertTrue(json.hasPermissionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Json#setHasPermission(boolean)}
   */
  @Test
  void testJsonSetHasPermission2() {
    // Arrange
    ImmutableUserAttestationPermission.Json json = new ImmutableUserAttestationPermission.Json();
    Optional<EntityReference> qualifierReference = Optional.of(mock(EntityReference.class));
    json.setQualifierReference(qualifierReference);

    // Act
    json.setHasPermission(true);

    // Assert
    assertTrue(json.hasPermission);
    assertTrue(json.hasPermissionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableUserAttestationPermission.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUserAttestationPermission.Json()).subjectKind());
  }
}
