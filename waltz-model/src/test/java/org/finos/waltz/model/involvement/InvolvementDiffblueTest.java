package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.involvement.ImmutableInvolvement.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InvolvementDiffblueTest {
  /**
   * Test {@link Involvement#isReadOnly()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Involvement#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Involvement.isReadOnly()"})
  void testIsReadOnly_thenReturnTrue() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertTrue(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build()
            .isReadOnly());
  }

  /**
   * Test {@link Involvement#provenance()}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link Involvement#provenance()}
   */
  @Test
  @DisplayName("Test provenance(); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Involvement.provenance()"})
  void testProvenance_thenReturnProvenance() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertEquals(
        "Provenance",
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link Involvement#mkInvolvement(EntityReference, String, int, String, boolean)}.
   *
   * <ul>
   *   <li>Then return ReadOnly.
   * </ul>
   *
   * <p>Method under test: {@link Involvement#mkInvolvement(EntityReference, String, int, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mkInvolvement(EntityReference, String, int, String, boolean); then return ReadOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Involvement Involvement.mkInvolvement(EntityReference, String, int, String, boolean)"
  })
  void testMkInvolvement_thenReturnReadOnly() {
    // Arrange
    ImmutableEntityReference entityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Involvement actualMkInvolvementResult =
        Involvement.mkInvolvement(entityRef, "42", 1, "Provenance", true);

    // Assert
    assertTrue(actualMkInvolvementResult instanceof ImmutableInvolvement);
    assertEquals("42", actualMkInvolvementResult.employeeId());
    assertEquals("Provenance", actualMkInvolvementResult.provenance());
    assertEquals(1L, actualMkInvolvementResult.kindId());
    assertTrue(actualMkInvolvementResult.isReadOnly());
    assertSame(entityRef, actualMkInvolvementResult.entityReference());
  }

  /**
   * Test {@link Involvement#mkInvolvement(EntityReference, String, int, String, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return not ReadOnly.
   * </ul>
   *
   * <p>Method under test: {@link Involvement#mkInvolvement(EntityReference, String, int, String,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mkInvolvement(EntityReference, String, int, String, boolean); when 'false'; then return not ReadOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Involvement Involvement.mkInvolvement(EntityReference, String, int, String, boolean)"
  })
  void testMkInvolvement_whenFalse_thenReturnNotReadOnly() {
    // Arrange
    ImmutableEntityReference entityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Involvement actualMkInvolvementResult =
        Involvement.mkInvolvement(entityRef, "42", 1, "Provenance", false);

    // Assert
    assertTrue(actualMkInvolvementResult instanceof ImmutableInvolvement);
    assertEquals("42", actualMkInvolvementResult.employeeId());
    assertEquals("Provenance", actualMkInvolvementResult.provenance());
    assertEquals(1L, actualMkInvolvementResult.kindId());
    assertFalse(actualMkInvolvementResult.isReadOnly());
    assertSame(entityRef, actualMkInvolvementResult.entityReference());
  }
}
