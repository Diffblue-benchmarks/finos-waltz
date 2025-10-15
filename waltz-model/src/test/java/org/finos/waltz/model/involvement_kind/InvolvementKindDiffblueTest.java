package org.finos.waltz.model.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InvolvementKindDiffblueTest {
  /**
   * Test {@link InvolvementKind#kind()}.
   *
   * <p>Method under test: {@link InvolvementKind#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind InvolvementKind.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .kind());
  }

  /**
   * Test {@link InvolvementKind#userSelectable()}.
   *
   * <p>Method under test: {@link InvolvementKind#userSelectable()}
   */
  @Test
  @DisplayName("Test userSelectable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKind.userSelectable()"})
  void testUserSelectable() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .userSelectable());
  }

  /**
   * Test {@link InvolvementKind#transitive()}.
   *
   * <p>Method under test: {@link InvolvementKind#transitive()}
   */
  @Test
  @DisplayName("Test transitive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKind.transitive()"})
  void testTransitive() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .transitive());
  }
}
