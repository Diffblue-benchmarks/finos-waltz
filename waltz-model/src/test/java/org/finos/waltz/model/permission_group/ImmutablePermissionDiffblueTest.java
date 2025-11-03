package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.permission_group.ImmutablePermission.Builder;
import org.finos.waltz.model.permission_group.ImmutablePermission.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePermissionDiffblueTest {
  /**
   * Test Builder {@link Builder#from(Permission)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Permission} {@link Permission#qualifierReference()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Permission)}
   */
  @Test
  @DisplayName("Test Builder from(Permission); given empty; when Permission qualifierReference() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Permission)"})
  void testBuilderFrom_givenEmpty_whenPermissionQualifierReferenceReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePermission.builder();
    Permission instance = mock(Permission.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.qualifierReference()).thenReturn(emptyResult);
    ImmutableRequiredInvolvementsResult.Json json = new ImmutableRequiredInvolvementsResult.Json();
    when(instance.requiredInvolvementsResult()).thenReturn(json);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Permission)}.
   * <ul>
   *   <li>Given {@link Optional} with {@link EntityReference}.</li>
   *   <li>Then builder build parentKind is {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Permission)}
   */
  @Test
  @DisplayName("Test Builder from(Permission); given Optional with EntityReference; then builder build parentKind is 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Permission)"})
  void testBuilderFrom_givenOptionalWithEntityReference_thenBuilderBuildParentKindIsAll() {
    // Arrange
    Builder builderResult = ImmutablePermission.builder();
    Permission instance = mock(Permission.class);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult);
    ImmutableRequiredInvolvementsResult.Json json = new ImmutableRequiredInvolvementsResult.Json();
    when(instance.requiredInvolvementsResult()).thenReturn(json);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.parentKind()).thenReturn(EntityKind.ALL);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(Permission)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Permission)}
   */
  @Test
  @DisplayName("Test Builder from(Permission); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Permission)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePermission.builder();
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
    Builder builderResult = ImmutablePermission.builder();

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
    Builder builderResult = ImmutablePermission.builder();

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
    Builder builderResult = ImmutablePermission.builder();
    Optional<? extends EntityReference> qualifierReference = Optional.of(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.qualifierReference(qualifierReference));
  }

  /**
   * Test Builder {@link Builder#requiredInvolvementsResult(RequiredInvolvementsResult)}.
   * <ul>
   *   <li>When {@link ImmutableRequiredInvolvementsResult.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#requiredInvolvementsResult(RequiredInvolvementsResult)}
   */
  @Test
  @DisplayName("Test Builder requiredInvolvementsResult(RequiredInvolvementsResult); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.requiredInvolvementsResult(RequiredInvolvementsResult)"})
  void testBuilderRequiredInvolvementsResult_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.requiredInvolvementsResult(new ImmutableRequiredInvolvementsResult.Json()));
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
    Builder builderResult = ImmutablePermission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
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
    assertNull(actualJson.operation);
    assertNull(actualJson.requiredInvolvementsResult);
    assertFalse(actualJson.qualifierReference.isPresent());
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
   * Test Json {@link Json#requiredInvolvementsResult()}.
   * <p>
   * Method under test: {@link Json#requiredInvolvementsResult()}
   */
  @Test
  @DisplayName("Test Json requiredInvolvementsResult()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RequiredInvolvementsResult Json.requiredInvolvementsResult()"})
  void testJsonRequiredInvolvementsResult() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).requiredInvolvementsResult());
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
