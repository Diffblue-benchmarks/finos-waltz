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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.attestation.ImmutableUserAttestationPermission.Builder;
import org.finos.waltz.model.attestation.ImmutableUserAttestationPermission.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUserAttestationPermissionDiffblueTest {
  /**
   * Test Builder {@link Builder#from(UserAttestationPermission)}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserAttestationPermission)}
   */
  @Test
  @DisplayName("Test Builder from(UserAttestationPermission); given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserAttestationPermission)"})
  void testBuilderFrom_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();
    UserAttestationPermission instance = mock(UserAttestationPermission.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.qualifierReference()).thenReturn(emptyResult);
    when(instance.hasPermission()).thenReturn(true);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(UserAttestationPermission)}.
   * <ul>
   *   <li>Given {@link Optional} with {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserAttestationPermission)}
   */
  @Test
  @DisplayName("Test Builder from(UserAttestationPermission); given Optional with EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserAttestationPermission)"})
  void testBuilderFrom_givenOptionalWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();
    UserAttestationPermission instance = mock(UserAttestationPermission.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult);
    when(instance.hasPermission()).thenReturn(true);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(UserAttestationPermission)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserAttestationPermission)}
   */
  @Test
  @DisplayName("Test Builder from(UserAttestationPermission); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserAttestationPermission)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();
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
   * Test Builder {@link Builder#hasPermission(boolean)}.
   * <p>
   * Method under test: {@link Builder#hasPermission(boolean)}
   */
  @Test
  @DisplayName("Test Builder hasPermission(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.hasPermission(boolean)"})
  void testBuilderHasPermission() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.hasPermission(true));
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
    Builder builderResult = ImmutableUserAttestationPermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#qualifierReference(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#qualifierReference(Optional)}
   */
  @Test
  @DisplayName("Test Builder qualifierReference(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.qualifierReference(Optional)"})
  void testBuilderQualifierReferenceWithOptional() {
    // Arrange
    Builder builderResult = ImmutableUserAttestationPermission.builder();
    Optional<? extends EntityReference> qualifierReference = Optional.of(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.qualifierReference(qualifierReference));
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
    Builder builderResult = ImmutableUserAttestationPermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Test Json {@link Json#hasPermission()}.
   * <p>
   * Method under test: {@link Json#hasPermission()}
   */
  @Test
  @DisplayName("Test Json hasPermission()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.hasPermission()"})
  void testJsonHasPermission() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).hasPermission());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.parentKind);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.qualifierReference.isPresent());
    assertFalse(actualJson.hasPermission);
    assertFalse(actualJson.hasPermissionIsSet);
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
   * Test Json {@link Json#qualifierReference()}.
   * <p>
   * Method under test: {@link Json#qualifierReference()}
   */
  @Test
  @DisplayName("Test Json qualifierReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.qualifierReference()"})
  void testJsonQualifierReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).qualifierReference());
  }

  /**
   * Test Json {@link Json#setHasPermission(boolean)}.
   * <p>
   * Method under test: {@link Json#setHasPermission(boolean)}
   */
  @Test
  @DisplayName("Test Json setHasPermission(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setHasPermission(boolean)"})
  void testJsonSetHasPermission() {
    // Arrange
    Json json = new Json();

    // Act
    json.setHasPermission(true);

    // Assert
    assertTrue(json.hasPermission);
    assertTrue(json.hasPermissionIsSet);
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
